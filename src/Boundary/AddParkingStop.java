package Boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ManageactivityControl;
import entity.typeVehicle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AddParkingStop {
	private JTextField textField;
	private JTextField city;
	private JTextField street;
	private JTextField coorX;
	private JTextField coorY;
	private JTextField capacity;

	public AddParkingStop() {



		JFrame frame = new JFrame("Add parking Stop");
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		String numPSString=ManageactivityControl.getInstance().getlastps();
		int numpsInt= Integer.valueOf(numPSString)+1;

		textField = new JTextField(numpsInt+"");
		textField.setBounds(50, 52, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		textField.setForeground(Color.BLACK);
		textField.setEditable(false);


		JButton btnPre = new JButton("previous");
		btnPre.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		btnPre.setBounds(106, 315, 89, 23);
		panel.add(btnPre);

		city = new JTextField();
		city.setBounds(50, 101, 86, 20);
		panel.add(city);
		city.setColumns(10);

		street = new JTextField();
		street.setBounds(50, 148, 86, 20);
		panel.add(street);
		street.setColumns(10);

		coorX = new JTextField();
		coorX.setBounds(50, 202, 86, 20);
		panel.add(coorX);
		coorX.setColumns(10);

		coorY = new JTextField();
		coorY.setBounds(229, 202, 86, 20);
		panel.add(coorY);
		coorY.setColumns(10);

		capacity = new JTextField();
		capacity.setBounds(50, 256, 86, 20);
		panel.add(capacity);
		capacity.setColumns(10);

		JLabel lblNumParkingStop = new JLabel("num Parking Stop:");
		lblNumParkingStop.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		lblNumParkingStop.setBounds(30, 27, 127, 23);
		panel.add(lblNumParkingStop);

		JLabel lblCity = new JLabel("city");
		lblCity.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		lblCity.setBounds(50, 83, 46, 14);
		panel.add(lblCity);

		JLabel lblStreet = new JLabel("street");
		lblStreet.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		lblStreet.setBounds(50, 132, 46, 14);
		panel.add(lblStreet);

		JLabel lblNewLabel = new JLabel("Coordinate X");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		lblNewLabel.setBounds(50, 179, 86, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Coordinate Y");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(229, 179, 86, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Capacity");
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(50, 233, 46, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Add Parking Stop");
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(277, 11, 113, 42);
		panel.add(lblNewLabel_3);

		btnPre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				managmentActivity menu = new managmentActivity();

			}
		});


		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		btnAdd.setBackground(new Color(144, 238, 144));
		btnAdd.setBounds(279, 316, 89, 23);
		panel.add(btnAdd);


		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {



				try {


					Double xDouble= Double.valueOf(coorX.getText());
					Double yDouble= Double.valueOf(coorY.getText());
					int capacity1= Integer.valueOf(capacity.getText());

					ManageactivityControl.getInstance().addParkingStop(numpsInt+"",city.getText(),street.getText(), xDouble, yDouble, capacity1);
					JOptionPane.showMessageDialog(frame,"The add parking stop is succeeded");
					//	AddParkingStop result= new AddParkingStop();
					//	frame.setVisible(false);
				}

				catch(NumberFormatException e3) {
					JOptionPane.showMessageDialog(frame,"One of your data is invalid");

				}

				catch (Exception e2) {
					JOptionPane.showMessageDialog(frame,"The add parking stop is not succeeded, please choose other code to path ");
				}




			}
		});




	}

}
