package Boundary;



import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import entity.Business;
import entity.Coupon;
import entity.HealthBusiness;
import entity.Label;
import entity.Level;
import entity.Manufacturer;
import entity.ParkingStop;
import entity.VIPBusiness;
import entity.typeVehicle;
import net.ucanaccess.jdbc.UcanaccessSQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTree;

import com.toedter.calendar.JDateChooser;

import control.ManageactivityControl;
import control.OrderLogic;

import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import datechooser.beans.DateChooserCombo;


public class AddNewCar {
	private JTextField textField_3;
	private JLabel lblNewLabel;
	private JLabel label;

	private JDateChooser dtcBirthDate;


	public AddNewCar() {

		JFrame frame = new JFrame("Add Vehicle");
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblAddNewVehicle = new JLabel("Add new vehicle ");
		lblAddNewVehicle.setBounds(223, 7, 180, 14);
		panel.add(lblAddNewVehicle);



		String numVehicleString=ManageactivityControl.getInstance().getlastvehicle();
		int numVehicleInt= Integer.valueOf(numVehicleString)+1;
		textField_3 = new JTextField(numVehicleInt+"");
		textField_3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		textField_3.setForeground(Color.BLACK);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(106, 66, 86, 20);
		panel.add(textField_3);


		lblNewLabel = new JLabel("last parking Stop");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblNewLabel.setBounds(106, 156, 108, 14);
		panel.add(lblNewLabel);

		label = new JLabel("Code Vehicle");
		label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		label.setBounds(106, 47, 86, 20);
		panel.add(label);

		typeVehicle [] types=typeVehicle.values();
		List<String> typeArrayList=new ArrayList<String>();
		typeArrayList.add("choose level");
		for(typeVehicle ty:types) {
			typeArrayList.add(ty+"");
		}

		Object[]lev=typeArrayList.toArray();
		JComboBox type = new JComboBox(types);
		type.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		type.setBounds(106, 122, 86, 20);
		panel.add(type);

		JLabel label_1 = new JLabel("Code Vehicle");
		label_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		label_1.setBounds(106, 97, 86, 14);
		panel.add(label_1);

		ArrayList<String> pas=ManageactivityControl.getInstance().getParkingstops();
		List<String> parkingArrayList=new ArrayList<String>();
		for(String ps :pas) {
			parkingArrayList.add(ps+"");
		}
		Object[]pss=parkingArrayList.toArray();

		JComboBox parkingStops = new JComboBox(pss);
		parkingStops.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		parkingStops.setBounds(106, 181, 86, 20);
		panel.add(parkingStops);


		JTextArea codeButtery1 = new JTextArea();
		codeButtery1.setBounds(366, 185, 119, 20);
		panel.add(codeButtery1);


		JCheckBox chckbxThisIsElectric = new JCheckBox("this is electric vehicle");
		chckbxThisIsElectric.setBounds(366, 65, 165, 23);
		panel.add(chckbxThisIsElectric);

		dtcBirthDate = new JDateChooser();

		dtcBirthDate.setBounds(366, 122, 165, 30);
		panel.add(dtcBirthDate);





		//manufacture
		ArrayList<Manufacturer> manun1=ManageactivityControl.getInstance().getMenufacturer();
		List<Object> manuArrayList=new ArrayList<Object>();

		for(Manufacturer man:manun1) {
			manuArrayList.add(man.getCodeManufacturer()+" "+man.getfNameManufacturer()+" "+man.getlNameManufacturer());
		}
		Object [] manu=manuArrayList.toArray();



		JComboBox manafcture = new JComboBox(manu);
		manafcture.setBounds(366, 242, 154, 20);
		panel.add(manafcture);



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

		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(144, 238, 144));
		btnAdd.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		btnAdd.setBounds(431, 316, 89, 23);
		panel.add(btnAdd);


		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				java.util.Date d11=dtcBirthDate.getDate();
				Date date21=null;
				date21= new java.sql.Date(d11.getTime()); 



				try {
					if(type.getSelectedItem().toString().equals(typeVehicle.BICYCLE.toString())) 
						ManageactivityControl.getInstance().addVehicle(numVehicleInt+"",typeVehicle.BICYCLE,parkingStops.getSelectedItem().toString());
					else if (type.getSelectedItem().toString().equals(typeVehicle.SCOOTER.toString()))
						ManageactivityControl.getInstance().addVehicle(numVehicleInt+"",typeVehicle.SCOOTER,parkingStops.getSelectedItem().toString());

					if(chckbxThisIsElectric.isSelected()) {
						ManageactivityControl.getInstance().addElectricVehicle(numVehicleInt+"", date21,codeButtery1.getText() , manun1.get(manafcture.getSelectedIndex()).getCodeManufacturer());

					}


				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(frame,"the add vehicle is not succeeded, please choose other code to path ");
				}



				JOptionPane.showMessageDialog(frame,"the add vehicle is succeeded");
				AddNewCar result= new AddNewCar();
				frame.setVisible(false);

			}
		});

		JLabel lblDateOfProduction = new JLabel("Code Buttery");
		lblDateOfProduction.setBounds(366, 150, 119, 20);
		panel.add(lblDateOfProduction);

		JLabel label_2 = new JLabel("Date of production");
		label_2.setBounds(376, 97, 119, 20);
		panel.add(label_2);

		JLabel lblManafucture = new JLabel("Manafucture");
		lblManafucture.setBounds(366, 208, 119, 20);
		panel.add(lblManafucture);


		frame.setSize(650, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);







	}
}
