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

import controlLayer.EmployeeCtr;

public class EmployeeDeleteGUI extends JFrame {

	private JFrame frame;
	private EmployeeCtr employeeCtr;
	private JTextField txtEmployeeId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDeleteGUI window = new EmployeeDeleteGUI();
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
	public EmployeeDeleteGUI() {
		employeeCtr = new EmployeeCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Employee Delete");
		frame.setBounds(100, 100, 240, 260);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		txtEmployeeId = new JTextField();
		txtEmployeeId.setText("Employee ID");
		txtEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmployeeId.setBounds(65, 45, 86, 20);
		frame.getContentPane().add(txtEmployeeId);
		txtEmployeeId.setColumns(10);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(65, 90, 89, 23);
		frame.getContentPane().add(btnDelete);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int employeeId = Integer.parseInt(txtEmployeeId.getText());
					System.out.println("Integer is: " + employeeId);
					employeeCtr.deleteEmployee(employeeId);
					JOptionPane.showMessageDialog(null,
							"Employee successfuly deleted!", "Employee delete",
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
