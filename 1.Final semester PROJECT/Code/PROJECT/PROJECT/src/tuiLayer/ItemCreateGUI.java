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

public class ItemCreateGUI {

	private ItemCtr itemCtr;

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtType;
	private JTextField txtDescription;
	private JTextField txtBarcode;
	private JTextField txtMinStock;
	private JTextField txtMaxStock;
	private JTextField txtNoOfItems;
	private JTextField txtPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemCreateGUI window = new ItemCreateGUI();
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
	public ItemCreateGUI() {
		itemCtr = new ItemCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Item Creation");
		frame.setBounds(100, 100, 240, 460);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		txtName = new JTextField();
		txtName.setToolTipText("");
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText("Name");
		txtName.setOpaque(true);
		txtName.setBounds(37, 31, 149, 31);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtType = new JTextField();
		txtType.setText("Type");
		txtType.setHorizontalAlignment(SwingConstants.CENTER);
		txtType.setBounds(37, 73, 149, 31);
		frame.getContentPane().add(txtType);
		txtType.setColumns(10);

		txtDescription = new JTextField();
		txtDescription.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescription.setText("Description");
		txtDescription.setBounds(37, 115, 149, 31);
		frame.getContentPane().add(txtDescription);
		txtDescription.setColumns(10);

		txtBarcode = new JTextField();
		txtBarcode.setText("Barcode");
		txtBarcode.setHorizontalAlignment(SwingConstants.CENTER);
		txtBarcode.setColumns(10);
		txtBarcode.setBounds(37, 157, 149, 31);
		frame.getContentPane().add(txtBarcode);

		txtMinStock = new JTextField();
		txtMinStock.setText("Minumum Stock");
		txtMinStock.setHorizontalAlignment(SwingConstants.CENTER);
		txtMinStock.setColumns(10);
		txtMinStock.setBounds(37, 239, 149, 31);
		frame.getContentPane().add(txtMinStock);

		txtMaxStock = new JTextField();
		txtMaxStock.setText("Maximum Stock");
		txtMaxStock.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaxStock.setColumns(10);
		txtMaxStock.setBounds(37, 281, 149, 31);
		frame.getContentPane().add(txtMaxStock);

		txtNoOfItems = new JTextField();
		txtNoOfItems.setText("Number of items in stock");
		txtNoOfItems.setHorizontalAlignment(SwingConstants.CENTER);
		txtNoOfItems.setColumns(10);
		txtNoOfItems.setBounds(37, 323, 149, 31);
		frame.getContentPane().add(txtNoOfItems);

		txtPrice = new JTextField();
		txtPrice.setText("Price");
		txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrice.setColumns(10);
		txtPrice.setBounds(37, 199, 149, 31);
		frame.getContentPane().add(txtPrice);

		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(37, 365, 149, 31);
		frame.getContentPane().add(btnCreate);

		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = txtName.getText();
					String description = txtDescription.getText();
					String type = txtType.getText();
					int barcode = Integer.parseInt(txtBarcode.getText());
					int noInStock = Integer.parseInt(txtNoOfItems.getText());
					int minimumNo = Integer.parseInt(txtMinStock.getText());
					int maximumNo = Integer.parseInt(txtMaxStock.getText());
					int price = Integer.parseInt(txtPrice.getText());

					itemCtr.createItem(barcode, minimumNo, price, maximumNo,
							noInStock, name, description, type);
					JOptionPane.showMessageDialog(null, "Item with barcode "
							+ barcode + " successfully created!",
							"Item creation", JOptionPane.YES_NO_CANCEL_OPTION);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Incorrect values input! Try again.", "ERROR!!!",
							JOptionPane.CANCEL_OPTION);

				}

			}
		});

	}

}