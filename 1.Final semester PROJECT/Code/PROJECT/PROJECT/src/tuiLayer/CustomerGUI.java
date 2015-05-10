package tuiLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CustomerGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerGUI window = new CustomerGUI();
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
	public CustomerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Customer Menu");
		frame.setBounds(100, 100, 460, 180);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JButton btnCreateContractor = new JButton("Create Customer");
		btnCreateContractor.setBounds(10, 11, 200, 50);
		frame.getContentPane().add(btnCreateContractor);
		btnCreateContractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerCreateGUI();
			}
		});
		{

			JButton btnFindContractor = new JButton("Find Customer");
			btnFindContractor.setBounds(234, 11, 200, 50);
			frame.getContentPane().add(btnFindContractor);
			btnFindContractor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CustomerFindGUI();
				}
			});

			JButton btnUpdateContractor = new JButton("Update Customer");
			btnUpdateContractor.setBounds(234, 80, 200, 50);
			frame.getContentPane().add(btnUpdateContractor);
			btnUpdateContractor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CustomerUpdateGUI();
				}
			});

			JButton btnDeleteContractor = new JButton("Delete Customer");
			btnDeleteContractor.setBounds(10, 80, 200, 50);
			frame.getContentPane().add(btnDeleteContractor);
			frame.setVisible(true);
			btnDeleteContractor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CustomerDeleteGUI();
				}
			});
		}
	}
}