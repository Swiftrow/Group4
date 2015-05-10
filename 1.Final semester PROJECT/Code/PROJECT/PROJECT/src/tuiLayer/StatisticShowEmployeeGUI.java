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

import modelLayer.Item;

public class StatisticShowEmployeeGUI {

	private JFrame frame;
	private JTextField txtEmployeeId;
	
	private EmployeeCtr employeeCtr;
	private LoanCtr loanCtr;
	private SellCtr sellCtr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticShowEmployeeGUI window = new StatisticShowEmployeeGUI();
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
	public StatisticShowEmployeeGUI() {
		sellCtr = new SellCtr();
        loanCtr = new LoanCtr();
        employeeCtr = new EmployeeCtr();
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
        frame.setTitle("Employee statistic");
        frame.setBounds(100, 100,240, 260);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		txtEmployeeId = new JTextField();
		txtEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmployeeId.setText("Employee ID");
		txtEmployeeId.setBounds(67, 63, 86, 20);
		frame.getContentPane().add(txtEmployeeId);
		txtEmployeeId.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.setBounds(64, 113, 89, 23);
		frame.getContentPane().add(btnFind);
		
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
				      int employeeId=Integer.parseInt(txtEmployeeId.getText());
				      
				      loanCtr.getTotalAmountLoans();
				      sellCtr.getTotalAmountSells();
				      
				      JOptionPane.showMessageDialog(null, "Total sales made by employee: " + employeeCtr.getNoOfSells(employeeId) + "\nTotal loans made by employee: "+ employeeCtr.getNoOfLoans(employeeId)+ "\nTotal money made by employee: "+ employeeCtr.getMoneyMade(employeeId),"Statistic for Employee", JOptionPane.YES_NO_CANCEL_OPTION);
				    }
				    catch (NumberFormatException ex) {
				    	JOptionPane.showMessageDialog(null,
								"Incorrect ID input! Try again.", "ERROR!!!",
								JOptionPane.CANCEL_OPTION);
				      
				    }
				 
			}
		});
	}

}