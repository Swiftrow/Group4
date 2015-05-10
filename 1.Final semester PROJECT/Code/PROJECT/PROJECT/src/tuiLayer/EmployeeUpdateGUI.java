package tuiLayer;

import modelLayer.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlLayer.*;

public class EmployeeUpdateGUI extends JFrame {

	private EmployeeCtr employeeCtr;
	private JFrame frame;
	private JTextField txtEmployeeId;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhoneNo;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeUpdateGUI window = new EmployeeUpdateGUI();
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
	public EmployeeUpdateGUI() {
		employeeCtr = new EmployeeCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Employee Update");
		frame.setBounds(100, 100, 240, 340);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		txtEmployeeId = new JTextField();
		txtEmployeeId.setToolTipText("");
		txtEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmployeeId.setText("Employee ID");
		txtEmployeeId.setOpaque(true);
		txtEmployeeId.setBounds(37, 31, 149, 31);
		frame.getContentPane().add(txtEmployeeId);
		txtEmployeeId.setColumns(10);

		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText("Name");
		txtName.setBounds(37, 73, 149, 31);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddress.setText("Address");
		txtAddress.setBounds(37, 115, 149, 31);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);

		txtPhoneNo = new JTextField();
		txtPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNo.setText("Phone Number");
		txtPhoneNo.setBounds(37, 115, 149, 31);
		frame.getContentPane().add(txtPhoneNo);
		txtPhoneNo.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setText("E-Mail");
		txtEmail.setBounds(37, 115, 149, 31);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(37, 232, 149, 31);
		frame.getContentPane().add(btnUpdate);

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int employeeId = Integer.parseInt(txtEmployeeId.getText());
					String name = txtName.getText();
					String address = txtAddress.getText();
					String phoneNo = txtPhoneNo.getText();
					String email = txtEmail.getText();

					employeeCtr.updateEmployee(employeeId, name, address,
							phoneNo, email);
					JOptionPane.showMessageDialog(null,
							"Employee successfully updated!",
							"Employee updater",
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
