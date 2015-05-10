package tuiLayer;

import controlLayer.*;
import modelLayer.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EmployeeCreateGUI extends JFrame {

	private JFrame frame;

	private EmployeeCtr employeeCtr;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhoneNo;
	private JTextField txtEmail;
	private JTextField txtEmployeeId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeCreateGUI window = new EmployeeCreateGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeCreateGUI() {
		employeeCtr = new EmployeeCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		setTitle("Employee Creation");
		setBounds(100, 100, 250, 320);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText("Name");
		txtName.setOpaque(true);
		txtName.setBounds(37, 17, 149, 31);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddress.setText("Address");
		txtAddress.setBounds(37, 59, 149, 31);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);

		txtPhoneNo = new JTextField();
		txtPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNo.setText("Phone Number");
		txtPhoneNo.setBounds(37, 101, 149, 31);
		getContentPane().add(txtPhoneNo);
		txtPhoneNo.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setText("Email");
		txtEmail.setBounds(37, 185, 149, 31);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		txtEmployeeId = new JTextField();
		txtEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmployeeId.setText("Employee ID");
		txtEmployeeId.setBounds(37, 143, 149, 31);
		getContentPane().add(txtEmployeeId);
		txtEmployeeId.setColumns(10);

		JButton btnCreate = new JButton("Submit");
		btnCreate.setBounds(37, 227, 149, 31);
		getContentPane().add(btnCreate);

		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String name = txtName.getText();
					String address = txtAddress.getText();
					String phoneNo = txtPhoneNo.getText();
					String email = txtEmail.getText();
					int EmployeeId = Integer.parseInt(txtEmployeeId.getText());
					employeeCtr.createEmployee(name, address, phoneNo, email,
							EmployeeId);
					JOptionPane.showMessageDialog(null,
							"Employee successfully created!",
							"Employee creation",
							JOptionPane.YES_NO_CANCEL_OPTION);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Incorrect ID input! Try again.", "ERROR!!!",
							JOptionPane.CANCEL_OPTION);

				}

			}
		});

	}

}
