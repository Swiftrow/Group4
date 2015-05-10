package tuiLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;

public class ContractorGUI extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContractorGUI window = new ContractorGUI();
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
	public ContractorGUI() {

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		setTitle("Contractor Menu");
		setBounds(100, 100, 460, 180);
		setLocationRelativeTo(null);
		setResizable(true);
		getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JButton btnCreateContractor = new JButton("Create Contractor");
		btnCreateContractor.setBounds(10, 11, 200, 50);
		getContentPane().add(btnCreateContractor);
		btnCreateContractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ContractorCreateGUI();
			}
		});
		{

			JButton btnFindContractor = new JButton("Find Contractor");
			btnFindContractor.setBounds(234, 11, 200, 50);
			getContentPane().add(btnFindContractor);
			btnFindContractor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ContractorFindGUI();
				}
			});

			JButton btnUpdateContractor = new JButton("Update Contractor");
			btnUpdateContractor.setBounds(234, 80, 200, 50);
			getContentPane().add(btnUpdateContractor);
			btnUpdateContractor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ContractorUpdateGUI();
				}
			});

			JButton btnDeleteContractor = new JButton("Delete Contractor");
			btnDeleteContractor.setBounds(10, 80, 200, 50);
			getContentPane().add(btnDeleteContractor);
			setVisible(true);
			btnDeleteContractor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ContractorDeleteGUI();
				}
			});
		}

	}
}
