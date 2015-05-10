package tuiLayer;
import modelLayer.*;
import controlLayer.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class SaleGUI {

	private JFrame frame;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleGUI window = new SaleGUI();
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
	public SaleGUI() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Sale Menu");
		frame.setBounds(100, 100, 460, 180);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		JButton btnCreateContractor = new JButton("Create Sale");
		btnCreateContractor.setBounds(10, 11, 200, 50);
		frame.getContentPane().add(btnCreateContractor);
		btnCreateContractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SaleCreateGUI();
			}
		});{

		
		JButton btnFindContractor = new JButton("Find Sale");
		btnFindContractor.setBounds(234, 11, 200, 50);
		frame.getContentPane().add(btnFindContractor);
		btnFindContractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SaleFindGUI();
			}
		});
		
		
		
		JButton btnDeleteContractor = new JButton("Delete Sale");
		btnDeleteContractor.setBounds(122, 80, 200, 50);
		frame.getContentPane().add(btnDeleteContractor);
		frame.setVisible(true);
        btnDeleteContractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SaleDeleteGUI();
			}
		});
		}
}
}