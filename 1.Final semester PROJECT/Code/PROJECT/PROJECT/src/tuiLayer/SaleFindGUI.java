package tuiLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modelLayer.Customer;
import modelLayer.Sell;
import controlLayer.SellCtr;

public class SaleFindGUI {

	private SellCtr sellCtr;
	private JFrame frame;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleFindGUI window = new SaleFindGUI();
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
	public SaleFindGUI() {
		sellCtr = new SellCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Sale Find");
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

					Sell sell = sellCtr.findSell(id);

					sell.getDate();
					sell.getCustomerName();
					sell.getCustomerId();
					sell.getBoughtItemInfo();
					sell.getTotalPrice();
					sell.discountPrice();

					JOptionPane.showMessageDialog(
							null,
							"Date: " + sell.getDate() + "\nCustomer name: "
									+ sell.getCustomerName()
									+ "\nCustomer ID : " + sell.getCustomerId()
									+ "\nBought Items: "
									+ sell.getBoughtItemInfo()
									+ "\nTotal Price: " + sell.getTotalPrice()
									+ "\nDiscount Price: "
									+ sell.discountPrice(), "Sale find",
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