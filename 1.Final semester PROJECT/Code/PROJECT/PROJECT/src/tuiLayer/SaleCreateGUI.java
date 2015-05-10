package tuiLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlLayer.CustomerCtr;
import controlLayer.EmployeeCtr;
import controlLayer.ItemCtr;
import controlLayer.SellCtr;

public class SaleCreateGUI {

	private JFrame frame;
	private SellCtr sellCtr;
	private CustomerCtr customerCtr;
	private ItemCtr itemCtr;
	private EmployeeCtr employeeCtr;

	private JTextField txtDate;
	private JTextField txtIdc;
	private JTextField txtEmployeeId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleCreateGUI window = new SaleCreateGUI();
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
	public SaleCreateGUI() {
		sellCtr = new SellCtr();
		customerCtr = new CustomerCtr();
		itemCtr = new ItemCtr();
		employeeCtr = new EmployeeCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Sale Creation");
		frame.setBounds(100, 100, 240, 340);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		txtDate = new JTextField();
		txtDate.setToolTipText("");
		txtDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate.setText("Date");
		txtDate.setOpaque(true);
		txtDate.setBounds(37, 31, 149, 31);
		frame.getContentPane().add(txtDate);
		txtDate.setColumns(10);

		txtIdc = new JTextField();
		txtIdc.setText("Customer ID");
		txtIdc.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdc.setBounds(37, 73, 149, 31);
		frame.getContentPane().add(txtIdc);
		txtIdc.setColumns(10);

		txtEmployeeId = new JTextField();
		txtEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmployeeId.setText("Employee ID");
		txtEmployeeId.setBounds(37, 115, 149, 31);
		frame.getContentPane().add(txtEmployeeId);
		txtEmployeeId.setColumns(10);

		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(37, 259, 149, 31);
		frame.getContentPane().add(btnCreate);

		JButton btnAddItemTo = new JButton("Add item to sale");
		btnAddItemTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SaleAddItemToSaleGUI();
			}
		});
		btnAddItemTo.setBounds(37, 184, 149, 31);
		frame.getContentPane().add(btnAddItemTo);

		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String date = txtDate.getText();
					int idC = Integer.parseInt(txtIdc.getText());
					int employeeId = Integer.parseInt(txtEmployeeId.getText());

					sellCtr.createSell(date, customerCtr.findCustomer(idC),
							employeeCtr.findEmployee(employeeId));
					int idS = sellCtr.getId();
					JOptionPane.showMessageDialog(null, "Sale with id: " + idS
							+ " was created!", "Sale creation",
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