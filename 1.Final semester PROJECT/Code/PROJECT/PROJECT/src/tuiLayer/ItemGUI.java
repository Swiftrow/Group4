package tuiLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ItemGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemGUI window = new ItemGUI();
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
	public ItemGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Item Menu");
		frame.setBounds(100, 100, 460, 240);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JButton btnCreateItem = new JButton("Create Item");
		btnCreateItem.setBounds(10, 11, 200, 50);
		frame.getContentPane().add(btnCreateItem);
		btnCreateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ItemCreateGUI();
			}
		});
		{

			JButton btnFindItem = new JButton("Find Item");
			btnFindItem.setBounds(234, 11, 200, 50);
			frame.getContentPane().add(btnFindItem);
			btnFindItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ItemFindGUI();
				}
			});

			JButton btnUpdateItem = new JButton("Update Item");
			btnUpdateItem.setBounds(234, 80, 200, 50);
			frame.getContentPane().add(btnUpdateItem);
			btnUpdateItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ItemUpdateGUI();
				}
			});

			JButton btnDeleteItem = new JButton("Delete Item");
			btnDeleteItem.setBounds(10, 80, 200, 50);
			frame.getContentPane().add(btnDeleteItem);
			btnDeleteItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ItemDeleteGUI();
				}
			});

			JButton btnCheckStock = new JButton("Check Stock");
			btnCheckStock.setBounds(122, 140, 200, 50);
			frame.getContentPane().add(btnCheckStock);
			frame.setVisible(true);
			btnCheckStock.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ItemCheckStockGUI();
				}
			});
		}
	}
}
