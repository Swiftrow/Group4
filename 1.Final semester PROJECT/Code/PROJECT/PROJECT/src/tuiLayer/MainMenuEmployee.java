package tuiLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenuEmployee {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuEmployee window = new MainMenuEmployee();
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
	public MainMenuEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane();
		frame.setTitle("Main Menu Employee");
		frame.setBounds(100, 100, 350, 200);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setSize(100, 40);
		btnCustomer.setLocation(14, 37);
		frame.getContentPane().add(btnCustomer);
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerGUI();
			}
		});
		
		JButton btnLoan = new JButton("Loan");
		btnLoan.setIcon(null);
		btnLoan.setBounds(70, 94, 100, 40);
		frame.getContentPane().add(btnLoan);
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoanGUI();
			}
		});
		
		JButton btnSale = new JButton("Sale");
		btnSale.setBounds(124, 37, 100, 40);
		frame.getContentPane().add(btnSale);
		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SaleGUI();
			}
		});
		
		JButton btnItem = new JButton("Item");
		btnItem.setBounds(234, 37, 100, 40);
		frame.getContentPane().add(btnItem);
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ItemGUI();
			}
		});
		
		JButton btnContractor = new JButton("Contractor");
		btnContractor.setBounds(180, 94, 100, 40);
		frame.getContentPane().add(btnContractor);
		btnContractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ContractorGUI();
			}
		});
	}
	

}
