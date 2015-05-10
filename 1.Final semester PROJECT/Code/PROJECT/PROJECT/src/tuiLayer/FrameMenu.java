import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import tuiLayer.*;


public class FrameMenu {

	    private JFrame frmMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMenu window = new FrameMenu();
					window.frmMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameMenu() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setBounds(100, 100, 470, 200);
		frmMainMenu.setResizable(true);
		frmMainMenu.getContentPane().setLayout(null);
		frmMainMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerGUI();
			}
		});
			
			btnCustomer.setSize(100, 40);
			btnCustomer.setLocation(14, 37);
		
	

		
		frmMainMenu.getContentPane().add(btnCustomer, BorderLayout.SOUTH);
		
		JButton btnLoan = new JButton("Loan");
		btnLoan.setIcon(null);
		btnLoan.setBounds(70, 94, 100, 40);
		frmMainMenu.getContentPane().add(btnLoan);
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoanGUI();
			}
		});
		
		
		JButton btnSale = new JButton("Sale");
		btnSale.setBounds(124, 37, 100, 40);
		frmMainMenu.getContentPane().add(btnSale);
		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SaleGUI();
			}
		});
		
		
		JButton btnItem = new JButton("Item");
		btnItem.setBounds(234, 37, 100, 40);
		frmMainMenu.getContentPane().add(btnItem);
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ItemGUI();
			}
		});
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEmployee.setBounds(290, 94, 100, 40);
		frmMainMenu.getContentPane().add(btnEmployee);
		
		JButton btnStatistic = new JButton("Statistics");
		btnStatistic.setBounds(180, 94, 100, 40);
		frmMainMenu.getContentPane().add(btnStatistic);
		btnStatistic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StatisticGUI();
			}
		});
		
		
		JButton btnContractor = new JButton("Contractor");
		btnContractor.setBounds(344, 37, 100, 40);
		frmMainMenu.getContentPane().add(btnContractor);
		btnContractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ContractorGUI();
			}
		});

		}
}
