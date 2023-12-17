package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CheckOut extends JFrame {
	private JPanel contentPane;
	private JTextField t1;
	private Choice c1;



	public void close() {
		this.dispose();
	}

	public CheckOut() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckOut.setBounds(70, 11, 140, 35);
		contentPane.add(lblCheckOut);

		JLabel lblName = new JLabel("Number :");
		lblName.setBounds(20, 85, 80, 14);
		contentPane.add(lblName);

		c1 = new Choice();
		try {
			// Read room numbers from the file
			ArrayList<String> roomNumbers = readRoomNumbersFromFile("rooms.txt");
			for (String roomNumber : roomNumbers) {
				c1.add(roomNumber.split(",")[0]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		c1.setBounds(130, 82, 150, 20);
		contentPane.add(c1);

		JButton l2 = new JButton();
		l2.setBounds(290, 82, 20, 20);
		add(l2);

		l2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Hi");
				try {
					String number = c1.getSelectedItem();
					t1.setText(number);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(20, 132, 86, 20);
		contentPane.add(lblRoomNumber);

		t1 = new JTextField();
		t1.setBounds(130, 132, 150, 20);
		contentPane.add(t1);

		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = c1.getSelectedItem();
				String s1 = t1.getText();

				// You can perform checkout actions here without the database

				JOptionPane.showMessageDialog(null, "Check Out Successful");
				// Example: new Reception().setVisible(true);
				setVisible(false);
			}
		});
		btnCheckOut.setBounds(50, 200, 100, 25);
		btnCheckOut.setBackground(Color.BLACK);
		btnCheckOut.setForeground(Color.WHITE);
		contentPane.add(btnCheckOut);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Example: new Reception().setVisible(true);
				setVisible(false);
			}
		});
		btnExit.setBounds(160, 200, 100, 25);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		getContentPane().setBackground(Color.WHITE);
	}

	private ArrayList<String> readRoomNumbersFromFile(String fileName) throws IOException {
		ArrayList<String> roomNumbers = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				roomNumbers.add(line);
			}
		}
		return roomNumbers;
	}
}
