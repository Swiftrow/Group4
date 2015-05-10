package tuiLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class MainMenuLogin {

	private JFrame frame;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuLogin window = new MainMenuLogin();
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
	public MainMenuLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane();
		frame.setTitle("LOG IN");
		frame.setBounds(100, 100, 200, 200);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		
		JButton btnLogin = new JButton("LOG IN");
		btnLogin.setBounds(47, 83, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(47, 49, 89, 23);
		frame.getContentPane().add(passwordField);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					@SuppressWarnings("deprecation")
					String login = passwordField.getText();
					if(login.equals("manager")){
						new MainMenuManager();
					}
					else if(login.equals("employee")){
						new MainMenuEmployee();
					}
					else {
							JOptionPane.showMessageDialog(null, "Password incorrect. Try again!","Login unsuccesseful", JOptionPane.CANCEL_OPTION);
					}
					
				}catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Password broken. Contact Group 6 devs!","Login unsuccesseful", JOptionPane.YES_NO_CANCEL_OPTION);
				      
				    }
				
			}
		});
		
	}
}
