package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UpdateCheck extends JFrame {
	private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_Status;
	private JTextField txt_Date;
	private JTextField txt_Time;
	private JTextField txt_Payment;
	private Choice c1, c2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCheck frame = new UpdateCheck();
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

	public UpdateCheck() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 950, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUpdateCheckStatus = new JLabel("Check-In Details");
		lblUpdateCheckStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateCheckStatus.setBounds(124, 11, 222, 25);
		contentPane.add(lblUpdateCheckStatus);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(25, 88, 46, 14);

		JLabel lblNewLabel_1 = new JLabel("Room Number :");
		lblNewLabel_1.setBounds(25, 129, 107, 14);
		contentPane.add(lblNewLabel_1);

		txt_ID = new JTextField();
		txt_ID.setBounds(248, 126, 140, 20);
		contentPane.add(txt_ID);

		JLabel lblNewLabel_2 = new JLabel("Name : ");
		lblNewLabel_2.setBounds(25, 174, 97, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Checked-in :");
		lblNewLabel_3.setBounds(25, 216, 107, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Amount Paid  : ");
		lblNewLabel_4.setBounds(25, 261, 107, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Pending Amount  : ");
		lblNewLabel_5.setBounds(25, 302, 150, 14);
		contentPane.add(lblNewLabel_5);

		txt_Status = new JTextField();
		txt_Status.setBounds(248, 171, 140, 20);
		contentPane.add(txt_Status);
		txt_Status.setColumns(10);

		txt_Date = new JTextField();
		txt_Date.setBounds(248, 216, 140, 20);
		contentPane.add(txt_Date);
		txt_Date.setColumns(10);

		txt_Time = new JTextField();
		txt_Time.setBounds(248, 258, 140, 20);
		contentPane.add(txt_Time);
		txt_Time.setColumns(10);

		txt_Payment = new JTextField();
		txt_Payment.setBounds(248, 299, 140, 20);
		contentPane.add(txt_Payment);
		txt_Payment.setColumns(10);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					String s1 = c1.getSelectedItem();
					String s2 = txt_ID.getText(); // room_number;
					String s3 = txt_Status.getText(); // name
					String s4 = txt_Date.getText(); // status
					String s5 = txt_Time.getText(); // deposit

					// Read existing data
					BufferedReader reader = new BufferedReader(new FileReader("customer.txt"));
					Vector<Vector<String>> data = new Vector<Vector<String>>();
					String line;
					while ((line = reader.readLine()) != null) {
						Vector<String> row = new Vector<String>();
						String[] parts = line.split(",");
						for (String part : parts) {
							row.add(part);
						}
						data.add(row);
					}
					reader.close();

					// Update the data
					for (Vector<String> row : data) {
						if (row.get(0).equals(s1)) {
							row.set(1, s2); // Update room_number
							row.set(2, s3); // Update name
							row.set(3, s4); // Update status
							row.set(4, s5); // Update deposit
							break;
						}
					}

					// Write the updated data back to the file
					BufferedWriter writer = new BufferedWriter(new FileWriter("customer.txt"));
					for (Vector<String> row : data) {
						String lineToWrite = String.join(",", row);
						writer.write(lineToWrite);
						writer.newLine();
					}
					writer.close();

					JOptionPane.showMessageDialog(null, "Data Updated Successfully");
					new Reception().setVisible(true);
					setVisible(false);
				} catch (Exception ee) {
					System.out.println(ee);
				}
			}
		});
		btnUpdate.setBounds(168, 378, 89, 23);
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setForeground(Color.WHITE);
		contentPane.add(btnUpdate);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				setVisible(false);
			}
		});
		btnExit.setBounds(281, 378, 89, 23);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		JButton btnAdd = new JButton("Check");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s1 = c1.getSelectedItem();
					BufferedReader reader = new BufferedReader(new FileReader("customer.txt"));
					String line;
					while ((line = reader.readLine()) != null) {
						String[] parts = line.split(",");
						if (parts[0].equals(s1)) {
							txt_ID.setText(parts[1]); // Update room_number
							txt_Status.setText(parts[2]); // Update name
							txt_Date.setText(parts[3]); // Update status
							txt_Time.setText(parts[4]); // Update deposit
							break;
						}
					}
					reader.close();

					String total = "";

					String paid = txt_Time.getText();
					int pending = Integer.parseInt(total) - Integer.parseInt(paid);

					txt_Payment.setText(Integer.toString(pending));

				} catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(56, 378, 89, 23);
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setForeground(Color.WHITE);
		contentPane.add(btnAdd);

		getContentPane().setBackground(Color.WHITE);
	}
}
