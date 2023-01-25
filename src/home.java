import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import javax.swing.UIManager;
import java.awt.Canvas;

public class home extends JFrame {
	
	private Image img_logo = new ImageIcon(home.class.getResource("res/logoRefrigerator.jpeg")).getImage().getScaledInstance(300, 350, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public home() {
		setUndecorated(true);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JFrame temporary = this;

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
		});
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(31, 110, 286, 89);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Vegetables");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vegetables veg = new Vegetables();
				veg.setVisible(true);
				temporary.dispose();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setBounds(31, 209, 286, 89);
		contentPane.add(panel_1);
		
		JButton btnNewButton_2 = new JButton("Fruits");
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fruits fr = new Fruits();
				fr.setVisible(true);
				temporary.dispose();
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 165, 0));
		panel_2.setBounds(31, 308, 286, 89);
		contentPane.add(panel_2);
		
		JButton btnNewButton_1 = new JButton("Seasoning");
		panel_2.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Seasoning ss = new Seasoning();
			ss.setVisible(true);
			temporary.dispose();
		}
		});
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(138, 43, 226));
		panel_2_1.setBounds(31, 407, 286, 89);
		contentPane.add(panel_2_1);
		
		JButton btnNewButton_3 = new JButton("Meats");
		panel_2_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Meats mt = new Meats();
				mt.setVisible(true);
				temporary.dispose();
			}
		});
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(204, 204, 255));
		panel_2_2.setBounds(31, 506, 286, 89);
		contentPane.add(panel_2_2);
		
		JButton btnNewButton_4 = new JButton("Spices");
		panel_2_2.add(btnNewButton_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_3.setForeground(new Color(0, 255, 0));
		panel_3.setBackground(new Color(123, 104, 238));
		panel_3.setBounds(0, 31, 800, 69);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("HOME PAGE");
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblNewLabel_1 = new JLabel("REFRIGERATOR SIMULATOR");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(31, 10, 286, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(img_logo));
		lblNewLabel_3.setBounds(409, 144, 300, 352);
		contentPane.add(lblNewLabel_3);
		
		Label label = new Label("Hello user !");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(409, 110, 131, 21);
		contentPane.add(label);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(625, 569, 175, 21);
		contentPane.add(canvas);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Spices sp = new Spices();
				sp.setVisible(true);
				temporary.dispose();
			}
		});
	}
}
