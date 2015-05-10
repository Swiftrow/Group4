package tuiLayer;

import java.util.*;

import controlLayer.*;
import modelLayer.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LoanGUI extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanGUI window = new LoanGUI();
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
	public LoanGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	   	
		
		frame = new JFrame();
		setTitle("Loan Menu");
		setBounds(100, 100, 460, 240);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				
				JButton btnLoanCreate = new JButton("Create Loan");
				btnLoanCreate.setBounds(10, 11, 200, 50);
				getContentPane().add(btnLoanCreate);
				btnLoanCreate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new LoanCreateGUI();
					}
				});{

				
				JButton btnFindLoan = new JButton("Find Loan");
				btnFindLoan.setBounds(234, 11, 200, 50);
				getContentPane().add(btnFindLoan);
				btnFindLoan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new LoanFindGUI();
					}
				});
				
				JButton btnUpdateLoan = new JButton("Update Loan Status");
				btnUpdateLoan.setBounds(234, 80, 200, 50);
				getContentPane().add(btnUpdateLoan);
				btnUpdateLoan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new LoanUpdateGUI();
					}
				});
				
				JButton btnLoanAddItemToLoan = new JButton("Add item to loan");
				btnLoanAddItemToLoan.setBounds(123, 140, 200, 50);
				getContentPane().add(btnLoanAddItemToLoan);
				btnLoanAddItemToLoan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new LoanAddItemToLoanGUI();
					}
				});
				
				JButton btnDeleteLoan = new JButton("Delete Loan");
				btnDeleteLoan.setBounds(10, 80, 200, 50);
				getContentPane().add(btnDeleteLoan);
		        setVisible(true);
		        btnDeleteLoan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new LoanDeleteGUI();
					}
				});
		}
		
		}
	}
