package tuiLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modelLayer.*;
import controlLayer.*;

public class CustomerFindGUI extends JFrame {

	private CustomerCtr customerCtr;
	private JFrame frame;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFindGUI window = new CustomerFindGUI();
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
	public CustomerFindGUI() {
		customerCtr = new CustomerCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Customer Find");
		frame.setBounds(100, 100, 240, 260);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		txtId = new JTextField();
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setText("ID");
		txtId.setBounds(67, 63, 86, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);

		JButton btnFind = new JButton("Find");
		btnFind.setBounds(64, 113, 89, 23);
		frame.getContentPane().add(btnFind);

		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int id = Integer.parseInt(txtId.getText());

					Customer c = customerCtr.findCustomer(id);

					c.getId();
					c.getName();
					c.getAddress();
					c.getEmail();
					c.getPhoneNo();
					c.getType();

					JOptionPane.showMessageDialog(null,
							"ID: " + c.getId() + "\nName: " + c.getName()
									+ "\nAddress: " + c.getAddress()
									+ "\nE-mail: " + c.getEmail()
									+ "\nPhone Number: " + c.getPhoneNo()
									+ "\nType: " + c.getType(),
							"Customer find", JOptionPane.YES_NO_CANCEL_OPTION);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Incorrect ID input! Try again.", "ERROR!!!",
							JOptionPane.CANCEL_OPTION);

				}

			}
		});

	}
}
