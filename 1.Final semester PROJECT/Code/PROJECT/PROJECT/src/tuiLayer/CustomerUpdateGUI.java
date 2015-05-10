package tuiLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlLayer.CustomerCtr;

public class CustomerUpdateGUI {

	private JFrame frame;
	private CustomerCtr customerCtr;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhoneNo;
	private JTextField txtEmail;
	private JTextField txtType;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerUpdateGUI window = new CustomerUpdateGUI();
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
	public CustomerUpdateGUI() {
		customerCtr = new CustomerCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Customer Update");
		frame.setBounds(100, 100, 240, 340);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		txtName = new JTextField();
		txtName.setToolTipText("");
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText("Name");
		txtName.setOpaque(true);
		txtName.setBounds(37, 53, 149, 31);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setText("Address");
		txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddress.setBounds(37, 95, 149, 31);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);

		txtPhoneNo = new JTextField();
		txtPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNo.setText("Phone Number");
		txtPhoneNo.setBounds(37, 133, 149, 31);
		frame.getContentPane().add(txtPhoneNo);
		txtPhoneNo.setColumns(10);

		txtId = new JTextField();
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setText("ID");
		txtId.setBounds(37, 11, 149, 31);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setText("E-mail");
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setColumns(10);
		txtEmail.setBounds(37, 175, 149, 31);
		frame.getContentPane().add(txtEmail);

		txtType = new JTextField();
		txtType.setText("Type");
		txtType.setHorizontalAlignment(SwingConstants.CENTER);
		txtType.setColumns(10);
		txtType.setBounds(37, 217, 149, 31);
		frame.getContentPane().add(txtType);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(37, 259, 149, 31);
		frame.getContentPane().add(btnUpdate);

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int id = Integer.parseInt(txtId.getText());
					String name = txtName.getText();
					String address = txtAddress.getText();
					String phoneNo = txtPhoneNo.getText();
					String email = txtEmail.getText();
					String type = txtType.getText();

					if (type.equals("gold")) {
						customerCtr.updateCustomer(id, name, address, phoneNo,
								email, type);
						JOptionPane.showMessageDialog(null,
								"Customer succesefully updated!",
								"Customer update",
								JOptionPane.YES_NO_CANCEL_OPTION);
					} else if (type.equals("silver")) {
						customerCtr.updateCustomer(id, name, address, phoneNo,
								email, type);
						JOptionPane.showMessageDialog(null,
								"Customer succesefully updated!",
								"Customer update",
								JOptionPane.YES_NO_CANCEL_OPTION);
					} else if (type.equals("bronze")) {
						customerCtr.updateCustomer(id, name, address, phoneNo,
								email, type);
						JOptionPane.showMessageDialog(null,
								"Customer succesefully updated!",
								"Customer update",
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