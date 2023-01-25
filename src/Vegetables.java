import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Color;
import javax.swing.JTextField;
import java.util.ArrayList;

import java.io.PrintWriter;
import javax.swing.UIManager;
import java.awt.Font;

public class Vegetables extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	private JTextField textField;
	static ArrayList<Data> list = new ArrayList<>();
	PrintWriter out;
   	String data;
    String search ;
	
	class vegetablesData{
		public String itemName;
		public int quantity;
		
		public vegetablesData(String itemName, int quantity) {
			this.itemName = itemName;
			this.quantity = quantity;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vegetables frame = new Vegetables();
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
	ArrayList<Data> item ;
	public Vegetables() {
		
		setUndecorated(true);
		dataHandler database = new dataHandler("veggie");
		list = database.GetDataFromFile();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBackground(new Color(240, 230, 140));
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 800, 600);
		contentPane.add(contentPane_1);
		contentPane_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(10, 569, 85, 21);
		btnNewButton_1.addActionListener(e->{
			this.dispose();
			home Home = new home();
			Home.setVisible(true);
		});
		contentPane_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Item Name : ");
		lblNewLabel_3.setBounds(454, 153, 85, 13);
		contentPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity : ");
		lblNewLabel_4.setBounds(456, 188, 123, 13);
		contentPane_1.add(lblNewLabel_4);
		
		JEditorPane itemName = new JEditorPane();
		itemName.setBounds(551, 153, 148, 19);
		contentPane_1.add(itemName);
		
		JEditorPane quantity = new JEditorPane();
		quantity.setBounds(551, 182, 148, 19);
		contentPane_1.add(quantity);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 113, 376, 446);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				itemName.setText(model.getValueAt(i, 0).toString());
				quantity.setText(model.getValueAt(i, 1).toString());
			}
		});
		table.setBackground(new Color(128, 255, 128));
	
		model = new DefaultTableModel();
		Object[] column = {"Name Item","Quantity"};
		String[] row = new String[2];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		new initialRun(model, list);
		scrollPane.setViewportView(table);
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("ha");
				if(itemName.getText().equals("") || quantity.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter Complete Information");
				}
				else
				{
				row[0] = itemName.getText();
				row[1] = quantity.getText();
				list.add(new Data(row[0], Integer.parseInt(row[1])));
				database.setData(list);
				database.UploadData();
				model.addRow(row);
				
				itemName.setText("");
				quantity.setText("");
				JOptionPane.showMessageDialog(null, "Add Successfully");
			}
			}});
		
		btnNewButton_2.setBounds(458, 240, 85, 21);
		contentPane_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				
				if(i>=0)
				{
					model.setValueAt(itemName.getText(), i, 0);
					model.setValueAt(quantity.getText(), i, 1);
					JOptionPane.showMessageDialog(null, "Updated Succesfully");
					list.set(i, new Data(itemName.getText(), Integer.parseInt(quantity.getText())));
					database.setData(list);
					database.UploadData();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Select a Row First");
				}
				
			}
		});
		btnNewButton_3.setBounds(614, 240, 85, 21);
		contentPane_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.addActionListener(new updater(table, model, "veggie"));
		btnNewButton_4.setBounds(458, 284, 85, 21);
		contentPane_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemName.setText("");
				quantity.setText("");
			}
		});
		btnNewButton_5.setBounds(614, 284, 85, 21);
		contentPane_1.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("Sort by");
		lblNewLabel_1.setBounds(454, 460, 45, 13);
		contentPane_1.add(lblNewLabel_1);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}});

		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Item Name");
		rdbtnNewRadioButton.setBounds(454, 493, 103, 21);
		rdbtnNewRadioButton.addItemListener(new ItemListener()

		//Sort Name
		{
			public void itemStateChanged(ItemEvent e) {
				int a = model.getRowCount(); 
				new SortingName(list);
				for(int i = 0 ; i < a ; i++)
					model.removeRow(0);
				for(Data b : list)
				{
					model.addRow(new Object[]{b.getName(), b.getQuan()});
				}
			}
		}
		);
		contentPane_1.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Quantity");
		rdbtnNewRadioButton_1.setBounds(582, 493, 103, 21);
		rdbtnNewRadioButton_1.addItemListener(new ItemListener()

		//Sort Quantity
		{
			public void itemStateChanged(ItemEvent e) {
				int a = model.getRowCount();
				new SortingQuantity(list);
				for(int i = 0 ; i < a ; i++)
					model.removeRow(0);
				for(Data b : list)
				{
					model.addRow(new Object[]{b.getName(), b.getQuan()});
				}
			}
		}
		);
		contentPane_1.add(rdbtnNewRadioButton_1);

		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBounds(551, 378, 148, 19);
		contentPane_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Search Item : ");
		lblNewLabel_2.setBounds(454, 381, 103, 13);
		contentPane_1.add(lblNewLabel_2);
		//
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(551, 416, 85, 21);
		btnNewButton.addActionListener(e->{
			ArrayList<Data> news = new SearchName().search(list, textField.getText());
			int counts = model.getRowCount();
			for(int i = 0 ; i < counts ; i++)
				model.removeRow(0);
			for(Data b : news)
				model.addRow(new Object[]{b.getName(), b.getQuan()});
		});
		contentPane_1.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.GREEN);
		panel_3.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_3.setBackground(new Color(123, 104, 238));
		panel_3.setBounds(0, 20, 800, 69);
		contentPane_1.add(panel_3);
		
		JLabel lblNewLabel_5 = new JLabel("VEGETABLES");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_3.add(lblNewLabel_5);
		
		
		
		}
	}
