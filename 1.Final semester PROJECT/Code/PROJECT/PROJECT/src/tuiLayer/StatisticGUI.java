package tuiLayer;
import modelLayer.*;
import controlLayer.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StatisticGUI extends JFrame  {

	private JFrame frame;
	private SellCtr sellCtr;
	private LoanCtr loanCtr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticGUI window = new StatisticGUI();
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
	public StatisticGUI() {
		sellCtr = new SellCtr();
		loanCtr = new LoanCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Statistic Menu");
		frame.setBounds(100, 100, 460, 110);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnShowStatistic = new JButton("Show Statistic");
		btnShowStatistic.setBounds(10, 11, 200, 50);
		frame.getContentPane().add(btnShowStatistic);
		btnShowStatistic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a=sellCtr.getTotalAmountSells();
		        int b=loanCtr.getTotalAmountLoans();
		        JOptionPane.showMessageDialog(null, "Number of sells: " + sellCtr.getSellsNo()+ "\nNumber of loans: " + loanCtr.getLoansNo()+ "\nTotal money from sales: " + a+ "\nTotal money from loans: " + b+ "\nTotal amount of money: " + (a+b) ,"Statistics", JOptionPane.YES_NO_CANCEL_OPTION);
			}
		});{

		
		JButton btnShowEmployeeStatistic = new JButton("Show Statistic Employee");
		btnShowEmployeeStatistic.setBounds(234, 11, 200, 50);
		frame.getContentPane().add(btnShowEmployeeStatistic);
		btnShowEmployeeStatistic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StatisticShowEmployeeGUI();
			}
		});
	}

}
}
