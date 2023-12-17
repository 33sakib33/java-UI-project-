/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;



import java.awt.BorderLayout;
import java.awt.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PickUp extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTable table;
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PickUp frame = new PickUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PickUp() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPickUpService = new JLabel("Pick Up Service");
		lblPickUpService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPickUpService.setBounds(90, 11, 158, 25);
		contentPane.add(lblPickUpService);
		
		JLabel lblTypeOfCar = new JLabel("Type of Car");
		lblTypeOfCar.setBounds(32, 97, 89, 14);


                
		
		JLabel lblInfo = new JLabel("Name");
		lblInfo.setBounds(24, 208, 46, 14);
		contentPane.add(lblInfo);

		JButton btnRegister = new JButton("Display");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// Read data from a file (assuming you have a file named drivers.txt)
					BufferedReader reader = new BufferedReader(new FileReader("drivers.txt"));

					// Assuming the file format is: DriverID,Brand,Model,Age,Gender,Company,Brand,Available,Location
					String[] columnNames = {"Driver ID", "Brand", "Model", "Age", "Gender", "Company", "Brand", "Available", "Location"};

					// Create a DefaultTableModel
					DefaultTableModel model = new DefaultTableModel(null, columnNames);

					// Read lines from the file and add to the model
					String line;
					while ((line = reader.readLine()) != null) {
						String[] parts = line.split(",");
						model.addRow(parts);
					}

					// Set the table model
					table.setModel(model);

					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});


		btnRegister.setBounds(200, 500, 120, 30);
                btnRegister.setBackground(Color.BLACK);
                btnRegister.setForeground(Color.WHITE);
		contentPane.add(btnRegister);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(420, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		table = new JTable();
		table.setBounds(0, 233, 800, 250);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Age");
		lblNewLabel.setBounds(165, 208, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(264, 208, 46, 14);
		contentPane.add(lblGender);
		
		JLabel lblTypeOfDriver = new JLabel("Company");
		lblTypeOfDriver.setBounds(366, 208, 80, 14);
		contentPane.add(lblTypeOfDriver);
		
		JLabel lblDateOfThe = new JLabel("Brand");
		lblDateOfThe.setBounds(486, 208, 105, 14);
		contentPane.add(lblDateOfThe);
	
		JLabel lblAirport = new JLabel("Available");
		lblAirport.setBounds(600, 208, 86, 14);
		contentPane.add(lblAirport);
		
		JLabel lblAvailable = new JLabel("Location");
		lblAvailable.setBounds(700, 208, 73, 14);
		contentPane.add(lblAvailable);
                
                
                
                getContentPane().setBackground(Color.WHITE);
	}
}