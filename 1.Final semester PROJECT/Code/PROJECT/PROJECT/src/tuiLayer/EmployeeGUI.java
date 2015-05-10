package tuiLayer;

import java.util.*;

import controlLayer.*;
import modelLayer.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EmployeeGUI extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeGUI window = new EmployeeGUI();
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
	public EmployeeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		setTitle("Employee Menu");
		setBounds(100, 100, 460, 180);
		setLocationRelativeTo(null);
		setResizable(true);
		getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JButton btnEmployeeCreate = new JButton("Create Employee");
		btnEmployeeCreate.setBounds(10, 11, 200, 50);
		getContentPane().add(btnEmployeeCreate);
		btnEmployeeCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmployeeCreateGUI();
			}
		});
		{

			JButton btnEmployeeFind = new JButton("Find Employee");
			btnEmployeeFind.setBounds(234, 11, 200, 50);
			getContentPane().add(btnEmployeeFind);
			btnEmployeeFind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new EmployeeFindGUI();
				}
			});

			JButton btnUpdateEmployee = new JButton("Update Employee Status");
			btnUpdateEmployee.setBounds(234, 80, 200, 50);
			getContentPane().add(btnUpdateEmployee);
			btnUpdateEmployee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new EmployeeUpdateGUI();
				}
			});

			JButton btnDeleteEmployee = new JButton("Delete Employee");
			btnDeleteEmployee.setBounds(10, 80, 200, 50);
			getContentPane().add(btnDeleteEmployee);
			setVisible(true);
			btnDeleteEmployee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new EmployeeDeleteGUI();
				}
			});
		}

	}
}
