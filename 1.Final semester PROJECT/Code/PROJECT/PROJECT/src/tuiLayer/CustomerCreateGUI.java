package tuiLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modelLayer.Customer;
import controlLayer.CustomerCtr;

public class CustomerCreateGUI extends JFrame {

	private JFrame frame;
	private CustomerCtr customerCtr;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhoneNo;
	private JTextField txtEmail;
	private JTextField txtType;
	private Customer c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerCreateGUI window = new CustomerCreateGUI();
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
	public CustomerCreateGUI() {
		customerCtr = new CustomerCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Customer Creation");
		frame.setBounds(100, 100, 240, 340);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		txtName = new JTextField();
		txtName.setToolTipText("");
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText("Name");
		txtName.setOpaque(true);
		txtName.setBounds(37, 31, 149, 31);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setText("Address");
		txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddress.setBounds(37, 73, 149, 31);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);

		txtPhoneNo = new JTextField();
		txtPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNo.setText("Phone Number");
		txtPhoneNo.setBounds(37, 115, 149, 31);
		frame.getContentPane().add(txtPhoneNo);
		txtPhoneNo.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setText("E-mail");
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setColumns(10);
		txtEmail.setBounds(37, 157, 149, 31);
		frame.getContentPane().add(txtEmail);

		txtType = new JTextField();
		txtType.setText("Type");
		txtType.setHorizontalAlignment(SwingConstants.CENTER);
		txtType.setColumns(10);
		txtType.setBounds(37, 199, 149, 31);
		frame.getContentPane().add(txtType);

		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(37, 241, 149, 31);
		frame.getContentPane().add(btnCreate);

		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = txtName.getText();
					String address = txtAddress.getText();
					String phoneNo = txtPhoneNo.getText();
					String email = txtEmail.getText();
					String type = txtType.getText();

					if (type.equals("gold")) {
						int id=customerCtr.createCustomer(name, address, phoneNo,
								email, type);
						JOptionPane.showMessageDialog(null,
								"Customer with the id: "+id+" succesefully created!",
								"Customer creation",
								JOptionPane.YES_NO_CANCEL_OPTION);
					} else if (type.equals("silver")) {
						int id = customerCtr.createCustomer(name, address, phoneNo,
								email, type);
						JOptionPane.showMessageDialog(null,
								"Customer with the id: "+id+" succesefully created!",
								"Customer creation",
								JOptionPane.YES_NO_CANCEL_OPTION);
					} else if (type.equals("bronze")) {
						int id=customerCtr.createCustomer(name, address, phoneNo,
								email, type);

						JOptionPane.showMessageDialog(null,
								"Customer with the id: "+id+" succesefully created!",
								"Customer creation",
								JOptionPane.YES_NO_CANCEL_OPTION);

					} else {
						JOptionPane
								.showMessageDialog(
										null,
										"Incorrect type input! Try again (gold, silver or bronze).",
										"ERROR!!!", JOptionPane.CANCEL_OPTION);
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Incorrect ID input! Try again.", "ERROR!!!",
							JOptionPane.CANCEL_OPTION);

				}

			}
		});

	}

}
