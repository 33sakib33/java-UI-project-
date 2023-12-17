package hotel.management.system;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Employee extends JFrame {
	private JPanel contentPane;
	private JTable table;

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

	public Employee() {
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
					// Read data from the employees.txt file
					BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Name");
					model.addColumn("Age");
					model.addColumn("Gender");
					model.addColumn("Job");
					model.addColumn("Salary");
					model.addColumn("Phone");
					model.addColumn("Aadhar");
					model.addColumn("Email");

					String line;
					while ((line = reader.readLine()) != null) {
						String[] parts = line.split(",");
						model.addRow(parts);
					}

					reader.close();

					// Set the table model
					table.setModel(model);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(350, 500, 120, 30);
		btnLoadData.setBackground(Color.BLACK);
		btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);

		getContentPane().setBackground(Color.WHITE);
	}
}
