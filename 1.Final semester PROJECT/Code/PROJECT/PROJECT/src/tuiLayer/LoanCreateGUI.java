package tuiLayer;

import controlLayer.*;
import modelLayer.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

public class LoanCreateGUI extends JFrame {

	private LoanCtr loanCtr;
	private EmployeeCtr employeeCtr;
	private CustomerCtr customerCtr;

	private JFrame frame;
	private JTextField txtIdC;
	private JTextField txtDate;
	private JTextField txtPeriod;
	private JTextField txtEmployeeId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanCreateGUI window = new LoanCreateGUI();
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
	public LoanCreateGUI() {
		loanCtr = new LoanCtr();
		employeeCtr = new EmployeeCtr();
		customerCtr = new CustomerCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Loan Creation");
		frame.setBounds(100, 100, 250, 320);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		txtIdC = new JTextField();
		txtIdC.setToolTipText("");
		txtIdC.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdC.setText("Customer ID");
		txtIdC.setOpaque(true);
		txtIdC.setBounds(26, 37, 181, 31);
		frame.getContentPane().add(txtIdC, BorderLayout.NORTH);
		txtIdC.setColumns(10);

		txtDate = new JTextField();
		txtDate.setText("Date");
		txtDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate.setBounds(26, 121, 181, 31);
		frame.getContentPane().add(txtDate);
		txtDate.setColumns(10);

		txtPeriod = new JTextField();
		txtPeriod.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeriod.setText("Period");
		txtPeriod.setBounds(26, 79, 181, 31);
		frame.getContentPane().add(txtPeriod);
		txtPeriod.setColumns(10);

		txtEmployeeId = new JTextField();
		txtEmployeeId.setText("Employee ID");
		txtEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmployeeId.setColumns(10);
		txtEmployeeId.setBounds(26, 163, 181, 31);
		frame.getContentPane().add(txtEmployeeId);

		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(60, 205, 110, 38);
		frame.getContentPane().add(btnCreate);

		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String date = txtDate.getText();
					String period = txtPeriod.getText();
					int idC = Integer.parseInt(txtIdC.getText());
					int employeeId = Integer.parseInt(txtEmployeeId.getText());

					int id = loanCtr.createLoan(date, period,
							customerCtr.findCustomer(idC),
							employeeCtr.findEmployee(employeeId));
					JOptionPane.showMessageDialog(null, "Loan with the id: "
							+ id + " successfully created!", "Loan creation",
							JOptionPane.YES_NO_CANCEL_OPTION);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Incorrect ID values input! Try again.",
							"ERROR!!!", JOptionPane.CANCEL_OPTION);

				}

			}
		});

	}

}
