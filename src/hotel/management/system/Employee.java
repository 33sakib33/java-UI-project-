package hotel.management.system;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
//import net.proteanit.sql.DbUtils;

public class Employee extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblJob;
	private JLabel lblName;
	private JLabel lblDepartment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void close() {
		this.dispose();
	}

	/**
	 * Create the frame.
	 *
	 * @throws SQLException
	 */
	public Employee() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(430, 200, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setBounds(0, 34, 1000, 450);
		contentPane.add(table);


		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Hardcoded data for testing
					Object[][] data = {
							{"1", "John Doe", "25", "Male", "IT"},
							{"2", "Jane Smith", "30", "Female", "Finance"},
							{"2", "Jane Smith", "30", "Female", "Finance"},
							{"2", "Jane Smith", "30", "Female", "Finance"},
							{"2", "Jane Smith", "30", "Female", "Finance"},
							{"2", "Jane Smith", "30", "Female", "Finance"},

							// Add more rows as needed
					};

					String[] columnNames = {"ID", "Name", "Age", "Gender", "Department"};

					// Create a TableModel with hardcoded data
					DefaultTableModel model = new DefaultTableModel(data, columnNames);

					// Set the table model
					table.setModel(model);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(350, 500, 120, 30);
		btnLoadData.setBackground(Color.BLACK);
		btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);

		// ... (rest of the code remains unchanged)

		getContentPane().setBackground(Color.WHITE);
	}
}
