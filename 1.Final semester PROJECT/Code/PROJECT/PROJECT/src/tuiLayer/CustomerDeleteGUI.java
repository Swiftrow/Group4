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

import controlLayer.CustomerCtr;

public class CustomerDeleteGUI extends JFrame {

	private JFrame frame;
	private CustomerCtr customerCtr;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerDeleteGUI window = new CustomerDeleteGUI();
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
	public CustomerDeleteGUI() {
		customerCtr = new CustomerCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Customer Delete");
		frame.setBounds(100, 100, 240, 260);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		txtId = new JTextField();
		txtId.setText("ID");
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setBounds(65, 45, 86, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(65, 90, 89, 23);
		frame.getContentPane().add(btnDelete);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int id = Integer.parseInt(txtId.getText());

					customerCtr.deleteCustomer(id);
					JOptionPane.showMessageDialog(null, "Customer with ID: "
							+ id + " was deleted.", "Customer delete",
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