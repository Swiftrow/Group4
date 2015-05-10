package tuiLayer;

import controlLayer.*;
import modelLayer.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlLayer.ContractorCtr;

public class ContractorCreateGUI extends JFrame {

	private JFrame frame;

	private ContractorCtr contractorCtr;
	private JTextField txtName;
	private JTextField txtId;
	private JTextField txtDeliveryTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContractorCreateGUI window = new ContractorCreateGUI();
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
	public ContractorCreateGUI() {
		contractorCtr = new ContractorCtr();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		setTitle("Contractor Creation");
		setBounds(100, 100, 240, 260);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		txtName = new JTextField();
		txtName.setToolTipText("");
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText("Name");
		txtName.setOpaque(true);
		txtName.setBounds(37, 31, 149, 31);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		txtId = new JTextField();
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setText("ID");
		txtId.setBounds(37, 73, 149, 31);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		txtDeliveryTime = new JTextField();
		txtDeliveryTime.setHorizontalAlignment(SwingConstants.CENTER);
		txtDeliveryTime.setText("Delivery Time");
		txtDeliveryTime.setBounds(37, 115, 149, 31);
		getContentPane().add(txtDeliveryTime);
		txtDeliveryTime.setColumns(10);

		JButton btnCreate = new JButton("Submit");
		btnCreate.setBounds(37, 157, 149, 31);
		getContentPane().add(btnCreate);

		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(txtId.getText());
					String name = txtName.getText();
					String deliveryTime = txtDeliveryTime.getText();

					contractorCtr.createContractor(id, name, deliveryTime);
					JOptionPane.showMessageDialog(null,
							"Contractor succesefully created!",
							"Contractor creation",
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
