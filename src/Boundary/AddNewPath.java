package Boundary;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ManageactivityControl;
import control.OrderLogic;
import entity.Level;
import entity.Manufacturer;
import entity.ParkingStop;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;

public class AddNewPath {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	public AddNewPath() {
		JFrame frame = new JFrame("Add new path");
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		frame.getContentPane().add(panel);  
		frame.setSize(500, 500);  
		frame.setLocationRelativeTo(null);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		frame.setVisible(true);
		panel.setLayout(null);



		textField = new JTextField();
		textField.setBounds(66, 72, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				List<ParkingStop> getParkingStop=OrderLogic.getInstance().getParkingStopInPath(textField.getText());

				Object[]pas=getParkingStop.toArray();

				JList list = new JList(pas);
				list.setBounds(240, 265, 400, 127);
				panel.add(list);
				getParkingStop=null; //?
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});









		JLabel lblNewLabel = new JLabel("Add new path and parking stop");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		lblNewLabel.setBounds(146, 11, 180, 35);
		panel.add(lblNewLabel);

		JLabel lblLevel = new JLabel("level:");
		lblLevel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		lblLevel.setBounds(66, 108, 86, 14);
		panel.add(lblLevel);

		//get level from enum
		Level [] levels=Level.values();
		List<String> levelArrayList=new ArrayList<String>();
		levelArrayList.add("choose level");
		for(Level le:levels) {
			levelArrayList.add(le+"");
		}
		Object[]lev=levelArrayList.toArray();


		JComboBox byLavel = new JComboBox(lev);
		byLavel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 15));
		byLavel.setBounds(66, 133, 86, 20);
		panel.add(byLavel);



		JLabel lblLenght = new JLabel("lenght (refresh this to update )");
		lblLenght.setBounds(15, 240, 163, 14);
		panel.add(lblLenght);

		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setText("0");
		textField_1.setColumns(10);
		textField_1.setBounds(66, 265, 86, 20);
		panel.add(textField_1);

		JLabel lblAddParkingStop = new JLabel("Add parking Stop to path");
		lblAddParkingStop.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		lblAddParkingStop.setBounds(229, 74, 157, 14);
		panel.add(lblAddParkingStop);










		ArrayList<ParkingStop> park=ManageactivityControl.getInstance().getAllParkingStop();
		List<Object> paArrayList=new ArrayList<Object>();

		for(ParkingStop pa:park) {
			paArrayList.add(pa.getCodeParkingStopString());
		}
		Object [] ps=paArrayList.toArray();

		JComboBox parkingStop = new JComboBox(ps);
		parkingStop.setBounds(251, 93, 103, 20);
		panel.add(parkingStop);


		JLabel lblParkingStopIn = new JLabel("parking Stop in this path:");
		lblParkingStopIn.setBounds(240, 229, 157, 14);
		panel.add(lblParkingStopIn);

		JButton addParkingStop = new JButton("Add");
		addParkingStop.setBounds(251, 187, 89, 23);
		panel.add(addParkingStop);

		JButton btnAddPath = new JButton("Add Path");
		btnAddPath.setBounds(66, 189, 89, 23);
		panel.add(btnAddPath);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(251, 158, 86, 20);
		panel.add(textField_2);





		addParkingStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int order=Integer.parseInt(textField_2.getText());
				try {
					ManageactivityControl.getInstance().addParkingStopToPath(textField.getText(),park.get(parkingStop.getSelectedIndex()).getCodeParkingStopString(),order );




					JOptionPane.showMessageDialog(frame,"the add parkingstop to path is succeeded");
				} 
				catch  (SQLException en){
					JOptionPane.showMessageDialog(frame,"the add parkingstop to path is not succeeded, can be the parking stop exsist");
				}
				catch (NumberFormatException eformat) {
					JOptionPane.showMessageDialog(frame,"the number of order is not valide");
				}
			}


		});



		JLabel lblEnterTheOrder = new JLabel("Enter the order in path :");
		lblEnterTheOrder.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		lblEnterTheOrder.setBounds(240, 137, 157, 14);
		panel.add(lblEnterTheOrder);

		JLabel lblNumberOfPath = new JLabel("number of path:");
		lblNumberOfPath.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		lblNumberOfPath.setBounds(66, 47, 128, 14);
		panel.add(lblNumberOfPath);

		JButton refresh = new JButton(">");
		refresh.setBounds(15, 264, 41, 23);
		panel.add(refresh);

		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String>psByOrder=ManageactivityControl.getInstance().getParkingStop(textField.getText());
				Double sum=0.0;

				for(int i=0;i<psByOrder.size()-1;i++) {
					try {

						sum=sum+ManageactivityControl.getInstance().getDistanceBetweenParkingStop(psByOrder.get(i),psByOrder.get(i+1));
						textField_1.setText(sum+"");
						ManageactivityControl.getInstance().updateLenghtPath(textField.getText(),sum);

					}


					catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(frame,"Not enough information to calculate");
					}

				}



				//System.out.println(sum);
			}
		});

		btnAddPath.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


				try {
					//5.0 Need a be calculte 
					Double toreDouble= Double.valueOf(textField_1.getText());
					ManageactivityControl.getInstance().addPath(textField.getText(),levels[byLavel.getSelectedIndex()-1],toreDouble);
					JOptionPane.showMessageDialog(frame,"the add vehicle is succeeded");
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(frame,"the add vehicle is not succeeded");
				}



			}
		});
		
		JButton btnPre = new JButton("previous");
		btnPre.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		btnPre.setBounds(106, 315, 89, 23);
		panel.add(btnPre);

		btnPre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				managmentActivity menu = new managmentActivity();

			}
		});

	}
}
