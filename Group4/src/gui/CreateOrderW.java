package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateOrderW extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmCreateOrder;
	private final JLabel lblContactName = new JLabel("Contact Name:");
	private final JTextField txtContactName = new JTextField();
	private final JLabel lblAddress = new JLabel("Address:");
	private final JTextField txtAddress = new JTextField();
	private final JLabel lblCity = new JLabel("City:");
	private final JTextField txtCity = new JTextField();
	private final JLabel lblZipcode = new JLabel("Zipcode:");
	private final JTextField txtZipcode = new JTextField();
	private final JTextField txtPhone = new JTextField();
	private final JTextField txtEmail = new JTextField();
	private final JLabel lblPhone = new JLabel("Phone:");
	private final JLabel lblEmail = new JLabel("E-mail:");
	private final JTable table = new JTable();
	private final JLabel lblTotal = new JLabel("Total:");
	private final JTextField txtTotal = new JTextField();
	private final JButton btnAddProduct = new JButton("Add Product");
	private final JButton btnRemoveProduct = new JButton("Remove Product");
	private final JButton btnCheckout = new JButton("Checkout");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateOrderW window = new CreateOrderW();
					window.frmCreateOrder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateOrderW() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		txtTotal.setEditable(false);
		txtTotal.setBounds(493, 381, 86, 20);
		txtTotal.setColumns(10);
		txtAddress.setBounds(100, 36, 110, 20);
		txtAddress.setColumns(10);
		txtContactName.setBounds(100, 8, 110, 20);
		txtContactName.setColumns(10);
		frmCreateOrder = new JFrame();
		frmCreateOrder.setResizable(false);
		frmCreateOrder.setTitle("Create Order");
		frmCreateOrder.setBounds(100, 100, 630, 560);
		frmCreateOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateOrder.getContentPane().setLayout(null);
		lblContactName.setBounds(10, 14, 120, 14);
		
		frmCreateOrder.getContentPane().add(lblContactName);
		
		frmCreateOrder.getContentPane().add(txtContactName);
		lblAddress.setBounds(10, 42, 73, 14);
		
		frmCreateOrder.getContentPane().add(lblAddress);
		
		frmCreateOrder.getContentPane().add(txtAddress);
		lblCity.setBounds(10, 73, 73, 14);
		
		frmCreateOrder.getContentPane().add(lblCity);
		txtCity.setColumns(10);
		txtCity.setBounds(100, 67, 110, 20);
		
		frmCreateOrder.getContentPane().add(txtCity);
		lblZipcode.setBounds(10, 104, 73, 14);
		
		frmCreateOrder.getContentPane().add(lblZipcode);
		txtZipcode.setColumns(10);
		txtZipcode.setBounds(100, 98, 110, 20);
		
		frmCreateOrder.getContentPane().add(txtZipcode);
		txtPhone.setColumns(10);
		txtPhone.setBounds(100, 129, 110, 20);
		
		frmCreateOrder.getContentPane().add(txtPhone);
		txtEmail.setColumns(10);
		txtEmail.setBounds(100, 160, 110, 20);
		
		frmCreateOrder.getContentPane().add(txtEmail);
		lblPhone.setBounds(10, 135, 73, 14);
		
		frmCreateOrder.getContentPane().add(lblPhone);
		lblEmail.setBounds(10, 166, 60, 14);
		
		frmCreateOrder.getContentPane().add(lblEmail);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Barcode", "Name", "Quantity","Price/product" },
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			
			new String[] {
				"Barcode", "Name", "Quantity", "Price/Product"
			}
			
		));
		
		table.getColumnModel().getColumn(2).setPreferredWidth(55);
		table.setBounds(220, 14, 359, 353);
		
		frmCreateOrder.getContentPane().add(table);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotal.setBounds(451, 384, 46, 14);
		
		frmCreateOrder.getContentPane().add(lblTotal);
		
		frmCreateOrder.getContentPane().add(txtTotal);
		btnAddProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {   
				//AddProductW a = new AddProductW();
			}
		});
		btnAddProduct.setBounds(10, 472, 120, 30);
		
		frmCreateOrder.getContentPane().add(btnAddProduct);
		btnRemoveProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveProduct.setBounds(140, 472, 140, 30);
		
		frmCreateOrder.getContentPane().add(btnRemoveProduct);
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCheckout.setBounds(493, 472, 120, 30);
		
		frmCreateOrder.getContentPane().add(btnCheckout);
		
	}
	
}
