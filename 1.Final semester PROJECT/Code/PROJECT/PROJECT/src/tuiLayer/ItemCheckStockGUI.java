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

import controlLayer.ItemCtr;

public class ItemCheckStockGUI {

	private ItemCtr itemCtr;
	private JFrame frame;
	private JTextField txtBarcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemCheckStockGUI window = new ItemCheckStockGUI();
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
	public ItemCheckStockGUI() {
		itemCtr = new ItemCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Item stock");
		frame.setBounds(100, 100, 240, 260);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		txtBarcode = new JTextField();
		txtBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		txtBarcode.setText("ID");
		txtBarcode.setBounds(67, 63, 86, 20);
		frame.getContentPane().add(txtBarcode);
		txtBarcode.setColumns(10);

		JButton btnFind = new JButton("Find");
		btnFind.setBounds(64, 113, 89, 23);
		frame.getContentPane().add(btnFind);

		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int barcode = Integer.parseInt(txtBarcode.getText());

					JOptionPane.showMessageDialog(null,
							"There are " + itemCtr.getNoInStock(barcode)
									+ " items "
									+ itemCtr.findItem(barcode).getName()
									+ " in stock.", "Item Stock",
							JOptionPane.YES_NO_CANCEL_OPTION);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Incorrect BARCODE input! Try again.", "ERROR!!!",
							JOptionPane.CANCEL_OPTION);

				}

			}
		});
	}

}