package tuiLayer;

import modelLayer.OrderLineLoan;
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

public class LoanAddItemToLoanGUI {

	private JFrame frame;
	private JTextField txtBarcode;
	private JTextField txtQuantity;

	private LoanCtr loanCtr;
	private SellCtr sellCtr;
	private ItemCtr itemCtr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanAddItemToLoanGUI window = new LoanAddItemToLoanGUI();
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
	public LoanAddItemToLoanGUI() {
		sellCtr = new SellCtr();
		itemCtr = new ItemCtr();
		loanCtr = new LoanCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Add items to sell");
		frame.setBounds(100, 100, 240, 260);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		txtBarcode = new JTextField();
		txtBarcode.setText("Barcode");
		txtBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		txtBarcode.setBounds(65, 45, 86, 20);
		frame.getContentPane().add(txtBarcode);
		txtBarcode.setColumns(10);

		JButton btnDelete = new JButton("Submit");
		btnDelete.setBounds(65, 113, 89, 23);
		frame.getContentPane().add(btnDelete);

		txtQuantity = new JTextField();
		txtQuantity.setText("Quantity");
		txtQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(65, 76, 86, 20);
		frame.getContentPane().add(txtQuantity);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int barcode = Integer.parseInt(txtBarcode.getText());
					int quantity = Integer.parseInt(txtQuantity.getText());

					OrderLineLoan orderLineLoan = new OrderLineLoan(quantity,
							itemCtr.findItem(barcode));
					loanCtr.addItemToLoan(orderLineLoan);
					JOptionPane.showMessageDialog(null, "Item with barcode: "
							+ barcode + " was added." + "\nQuantity: "
							+ quantity, "Items added",
							JOptionPane.YES_NO_CANCEL_OPTION);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Incorrect values input! Try again.", "ERROR!!!",
							JOptionPane.CANCEL_OPTION);

				}

			}
		});
	}
}