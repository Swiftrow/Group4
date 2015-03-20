package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;


public class AddProductW {

	private JFrame frmAddProduct;
	private JTextField txtBarcode;
	private JTextField txtQuantity;
	private JButton btnAddToReceipt;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductW window = new AddProductW();
					window.frmAddProduct.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddProductW() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddProduct = new JFrame();
		frmAddProduct.setTitle("Add Product");
		frmAddProduct.setBounds(100, 100, 450, 300);
		frmAddProduct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddProduct.getContentPane().setLayout(null);
		
		txtBarcode = new JTextField();
		txtBarcode.setBounds(70, 17, 108, 20);
		frmAddProduct.getContentPane().add(txtBarcode);
		txtBarcode.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(70, 48, 108, 20);
		frmAddProduct.getContentPane().add(txtQuantity);
		
		btnAddToReceipt = new JButton("Add to recipt\r\n");
		btnAddToReceipt.setBounds(10, 88, 120, 31);
		frmAddProduct.getContentPane().add(btnAddToReceipt);
		
		JLabel lblBarcode = new JLabel("Barcode:");
		lblBarcode.setBounds(10, 19, 65, 17);
		frmAddProduct.getContentPane().add(lblBarcode);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(10, 51, 65, 14);
		frmAddProduct.getContentPane().add(lblQuantity);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(10, 219, 97, 31);
		frmAddProduct.getContentPane().add(btnFinish);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Barcode", "Name"},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Barcode", "Name"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setResizable(false);
		table.setEnabled(false);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(224, 17, 200, 232);
		frmAddProduct.getContentPane().add(table);
	}
}
