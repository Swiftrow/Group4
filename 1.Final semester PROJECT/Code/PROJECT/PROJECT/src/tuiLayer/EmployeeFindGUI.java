package tuiLayer;

import modelLayer.*;
import controlLayer.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EmployeeFindGUI extends JFrame {

	private EmployeeCtr employeeCtr;
	private JFrame frame;
	private JTextField txtId_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFindGUI window = new EmployeeFindGUI();
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
	public EmployeeFindGUI() {
		employeeCtr = new EmployeeCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Employee Find");
		frame.setBounds(100, 100, 240, 260);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		txtId_1 = new JTextField();
		txtId_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtId_1.setText("Employee ID");
		txtId_1.setBounds(76, 61, 86, 23);
		frame.getContentPane().add(txtId_1);
		txtId_1.setColumns(10);

		JButton btnFind = new JButton("Find Employee");
		btnFind.setBounds(60, 112, 123, 29);
		frame.getContentPane().add(btnFind);

		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int employeeId = Integer.parseInt(txtId_1.getText());

					Employee employee = employeeCtr.findEmployee(employeeId);

					employee.getId();
					employee.getAddress();
					employee.getEmail();
					employee.getPhoneNo();
					employee.getName();

					JOptionPane.showMessageDialog(null,
							"ID: " + employee.getId() + "\nAddress: "
									+ employee.getAddress() + "\nEmail: "
									+ employee.getEmail() + "\nPhone Number: "
									+ employee.getPhoneNo() + "\nName: "
									+ employee.getName(), "Employee find",
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