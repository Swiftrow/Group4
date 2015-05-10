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

public class ItemDeleteGUI {

	private JFrame frame;
	private JTextField txtBarcode;
	private ItemCtr itemCtr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemDeleteGUI window = new ItemDeleteGUI();
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
	public ItemDeleteGUI() {
		itemCtr = new ItemCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Item Delete");
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

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(65, 90, 89, 23);
		frame.getContentPane().add(btnDelete);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int barcode = Integer.parseInt(txtBarcode.getText());

					itemCtr.deleteItem(barcode);
					JOptionPane.showMessageDialog(null, "Item with barcode: "
							+ barcode + " was deleted.", "Contractor delete",
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