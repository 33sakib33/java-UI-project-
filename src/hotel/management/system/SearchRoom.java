package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchRoom extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JCheckBox checkRoom;
	private Choice c1;

	public SearchRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSearchForRoom = new JLabel("Search For Room");
		lblSearchForRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchForRoom.setBounds(250, 11, 186, 31);
		contentPane.add(lblSearchForRoom);

		JLabel lblRoomAvailable = new JLabel("Room Bed Type:");
		lblRoomAvailable.setBounds(50, 73, 96, 14);
		contentPane.add(lblRoomAvailable);

		JLabel lblRoomType = new JLabel("Room Number");
		lblRoomType.setBounds(23, 162, 96, 14);
		contentPane.add(lblRoomType);

		JLabel lblRoomAvailable_1 = new JLabel("Availability");
		lblRoomAvailable_1.setBounds(175, 162, 120, 14);
		contentPane.add(lblRoomAvailable_1);

		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setBounds(458, 162, 46, 14);
		contentPane.add(lblPrice_1);

		JLabel l1 = new JLabel("Bed Type");
		l1.setBounds(580, 162, 96, 14);
		contentPane.add(l1);

		checkRoom = new JCheckBox("Only display Available");
		checkRoom.setBounds(400, 69, 205, 23);
		checkRoom.setBackground(Color.WHITE);
		contentPane.add(checkRoom);

		c1 = new Choice();
		c1.add("Single Bed");
		c1.add("Double Bed");
		c1.setBounds(153, 70, 120, 20);
		contentPane.add(c1);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Read data from the file
					BufferedReader reader = new BufferedReader(new FileReader("rooms.txt"));
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Room Number");
					model.addColumn("Type");
					model.addColumn("Availability");
					model.addColumn("Price");
					model.addColumn("Bed Type");

					String line;
					while ((line = reader.readLine()) != null) {
						String[] parts = line.split(",");
						if (c1.getSelectedItem().equals(parts[4]) && (!checkRoom.isSelected() || "Available".equals(parts[1]))) {
							model.addRow(new Vector<String>(java.util.Arrays.asList(parts)));
						}
					}

					reader.close();

					// Set the model to the table
					table.setModel(model);

				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		btnSearch.setBounds(200, 400, 120, 30);
		btnSearch.setBackground(Color.BLACK);
		btnSearch.setForeground(Color.WHITE);
		contentPane.add(btnSearch);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				setVisible(false);
			}
		});
		btnExit.setBounds(380, 400, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		table = new JTable();
		table.setBounds(0, 187, 700, 300);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 187, 700, 300);
		contentPane.add(scrollPane);

		getContentPane().setBackground(Color.WHITE);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRoom frame = new SearchRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
