package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ReceiptW {

	private JFrame frmReceipt;
	private final JLabel lblName = new JLabel("Name:");
	private final JTextField txtName = new JTextField();
	private final JLabel lblAddress = new JLabel("Address:");
	private final JTextField txtAddress = new JTextField();
	private final JTextField txtCity = new JTextField();
	private final JLabel lblCity = new JLabel("City:");
	private final JLabel lblZipcode = new JLabel("Zipcode:");
	private final JTextField txtZipcode = new JTextField();
	private final JTextField txtPhone = new JTextField();
	private final JTextField txtEmail = new JTextField();
	private final JTextField txtTotal = new JTextField();
	private final JLabel lblPhone = new JLabel("Phone:");
	private final JLabel lblEmail = new JLabel("E-mail:");
	private final JLabel lblTotal = new JLabel("Total:");
	private final JButton btnEdit = new JButton("Edit");
	private final JButton btnSendInvoice = new JButton("Send Invoice");
	private final JButton btnPrint = new JButton("Print");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiptW window = new ReceiptW();
					window.frmReceipt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReceiptW() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		txtAddress.setEditable(false);
		txtAddress.setBounds(90, 39, 129, 20);
		txtAddress.setColumns(10);
		txtName.setEditable(false);
		txtName.setBounds(90, 11, 129, 20);
		txtName.setColumns(10);
		frmReceipt = new JFrame();
		frmReceipt.setResizable(false);
		frmReceipt.setTitle("Receipt");
		frmReceipt.setBounds(100, 100, 370, 300);
		frmReceipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReceipt.getContentPane().setLayout(null);
		lblName.setBounds(10, 17, 70, 14);
		
		frmReceipt.getContentPane().add(lblName);
		
		frmReceipt.getContentPane().add(txtName);
		lblAddress.setBounds(10, 45, 70, 14);
		
		frmReceipt.getContentPane().add(lblAddress);
		
		frmReceipt.getContentPane().add(txtAddress);
		txtCity.setEditable(false);
		txtCity.setColumns(10);
		txtCity.setBounds(90, 70, 129, 20);
		
		frmReceipt.getContentPane().add(txtCity);
		lblCity.setBounds(10, 76, 46, 14);
		
		frmReceipt.getContentPane().add(lblCity);
		lblZipcode.setBounds(10, 107, 70, 14);
		
		frmReceipt.getContentPane().add(lblZipcode);
		txtZipcode.setEditable(false);
		txtZipcode.setColumns(10);
		txtZipcode.setBounds(90, 101, 129, 20);
		
		frmReceipt.getContentPane().add(txtZipcode);
		txtPhone.setEditable(false);
		txtPhone.setColumns(10);
		txtPhone.setBounds(90, 129, 129, 20);
		
		frmReceipt.getContentPane().add(txtPhone);
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(90, 160, 129, 20);
		
		frmReceipt.getContentPane().add(txtEmail);
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(90, 191, 129, 20);
		
		frmReceipt.getContentPane().add(txtTotal);
		lblPhone.setBounds(10, 135, 46, 14);
		
		frmReceipt.getContentPane().add(lblPhone);
		lblEmail.setBounds(10, 166, 46, 14);
		
		frmReceipt.getContentPane().add(lblEmail);
		lblTotal.setBounds(10, 197, 46, 14);
		
		frmReceipt.getContentPane().add(lblTotal);
		btnEdit.setBounds(10, 237, 89, 23);
		
		frmReceipt.getContentPane().add(btnEdit);
		btnSendInvoice.setBounds(109, 237, 110, 23);
		
		frmReceipt.getContentPane().add(btnSendInvoice);
		btnPrint.setBounds(229, 237, 89, 23);
		
		frmReceipt.getContentPane().add(btnPrint);
	}

}
