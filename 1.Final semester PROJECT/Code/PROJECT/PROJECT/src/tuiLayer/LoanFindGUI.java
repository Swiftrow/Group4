package tuiLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlLayer.LoanCtr;

import javax.swing.JButton;

import modelLayer.Loan;

public class LoanFindGUI extends JFrame {

	private LoanCtr loanCtr;
	private JFrame frame;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanFindGUI window = new LoanFindGUI();
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
	public LoanFindGUI() {
		loanCtr = new LoanCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Loan Find");
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
					int idL = Integer.parseInt(txtId.getText());
					Loan loan = loanCtr.findLoan(idL);

					loan.getCustomerName();
					loan.getDate();
					loan.getPeriod();
					loan.getStatus();
					loan.getTotalPrice();
					loan.discountPrice();

					JOptionPane.showMessageDialog(
							null,
							"Customer's name: " + loan.getCustomerName()
									+ "\nDate: " + loan.getDate()
									+ "\nPeriod: " + loan.getPeriod()
									+ "\nStatus: " + loan.getStatus()
									+ "\nPrice WITHOUT discount: "
									+ loan.getTotalPrice()
									+ "\nPrice WITH discount: "
									+ loan.discountPrice(), "Loan find",
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