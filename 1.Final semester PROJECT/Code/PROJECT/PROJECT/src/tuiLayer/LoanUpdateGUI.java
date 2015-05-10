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

import controlLayer.LoanCtr;

public class LoanUpdateGUI {

	private LoanCtr loanCtr;

	private JFrame frame;
	private JTextField txtIdL;
	private JTextField txtStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanUpdateGUI window = new LoanUpdateGUI();
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
	public LoanUpdateGUI() {
		loanCtr = new LoanCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Loan updater");
		frame.setBounds(100, 100, 240, 300);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		txtIdL = new JTextField();
		txtIdL.setToolTipText("");
		txtIdL.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdL.setText("Loan ID");
		txtIdL.setOpaque(true);
		txtIdL.setBounds(37, 31, 149, 31);
		frame.getContentPane().add(txtIdL);
		txtIdL.setColumns(10);

		txtStatus = new JTextField();
		txtStatus.setText("Status");
		txtStatus.setHorizontalAlignment(SwingConstants.CENTER);
		txtStatus.setBounds(37, 73, 149, 31);
		frame.getContentPane().add(txtStatus);
		txtStatus.setColumns(10);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(37, 200, 149, 31);
		frame.getContentPane().add(btnUpdate);

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String status = txtStatus.getText();
					int idL = Integer.parseInt(txtIdL.getText());

					loanCtr.updateLoanStatus(idL, status);
					JOptionPane.showMessageDialog(null,
							"Loan succesefully updated!", "Loan updater",
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
