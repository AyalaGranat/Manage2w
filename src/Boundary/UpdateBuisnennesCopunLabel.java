package Boundary;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import control.ManageactivityControl;
import control.OrderLogic;
import entity.Label;
import entity.Level;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Rectangle;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Button;
import java.awt.Color;
import java.awt.Scrollbar;
import java.awt.Canvas;
import javax.swing.border.LineBorder;

public class UpdateBuisnennesCopunLabel {
	private JTextField codeB;
	private JTextField textname;
	private JTextField textcity;
	private JTextField textStreet;
	private JTextField textNum;
	private JTextField textImage;
	private JTextField texDescription;
	private JLabel city;
	private JLabel street;
	private JLabel lblNum;
	private JLabel lblImage;
	private JLabel lblDescription;
	private JButton btnNewButton;
	private JCheckBox BoxvipBuisness;
	private JCheckBox healthBu;
	private JTextField video;
	private JLabel lblVideo;
	private JComboBox comboBox;
	private JLabel lblType;
	private JLabel lblCodeCopuns;
	private JTextField textField_8;
	private JLabel lblDescripshion;
	private JTextField textField_9;
	private JLabel lblStart;
	private JLabel lblEnd;
	private JButton btnAddCupon;
	private JButton btnAddBuisness;
	private JLabel lblAddLabelTo;
	private JComboBox comboBox_1;
	private JButton btnAddLabelTo;
	private JLabel lblAddLabel;
	private JTextField textField_12;
	private JLabel lblNameOfLabel;
	private JLabel lblColor;
	private JTextField textField_13;
	private JLabel lblAddCopun;
	JButton choosepicButton;
	String pathString="";
	private JButton btnNewButton_1;
	JDateChooser dtcBirthDate1;
	JDateChooser dateChooser;

	public UpdateBuisnennesCopunLabel() {

		JFrame frame = new JFrame("Add Buisness,Coupon And Label");
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblAddBuisnessCoupon = new JLabel("Add Buisness, Coupon And Label");
		lblAddBuisnessCoupon.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		lblAddBuisnessCoupon.setBounds(127, 11, 211, 14);
		panel.add(lblAddBuisnessCoupon);



		String numBuisnessString=ManageactivityControl.getInstance().getlastBusiness();
		int numBuisness= Integer.valueOf(numBuisnessString)+1;
		codeB = new JTextField(numBuisness+"");
		codeB.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		codeB.setEditable(false);
		codeB.setBounds(58, 53, 86, 20);
		panel.add(codeB);
		codeB.setColumns(10);

		textname = new JTextField();
		textname.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		textname.setBounds(58, 101, 86, 20);
		panel.add(textname);
		textname.setColumns(10);

		textcity = new JTextField();
		textcity.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		textcity.setBounds(58, 154, 86, 20);
		panel.add(textcity);
		textcity.setColumns(10);

		textStreet = new JTextField();
		textStreet.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		textStreet.setBounds(58, 200, 86, 20);
		panel.add(textStreet);
		textStreet.setColumns(10);

		textNum = new JTextField();
		textNum.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		textNum.setBounds(165, 200, 39, 20);
		panel.add(textNum);
		textNum.setColumns(10);
		
		//!!----+---
		dtcBirthDate1 = new JDateChooser();
		dtcBirthDate1.setBounds(337, 259, 132, 30);
		panel.add(dtcBirthDate1);

		/*	textImage = new JTextField();
		textImage.setBounds(58, 244, 86, 20);
		panel.add(textImage);
		textImage.setColumns(10);*/

		/*Button button = new Button("New button");
		button.setBounds(128, 226, 69, 19);
		panel.add(button);*/

		JLabel picJLabel=new JLabel("your pic");
		choosepicButton=new JButton("get picture");
		choosepicButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		panel.add(choosepicButton);
		choosepicButton.setBounds(128, 226, 124, 19);

		choosepicButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG & GIF Images", "jpg", "gif");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(getParent());
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					pathString= chooser.getSelectedFile().getPath();


					System.out.println("You chose to open this file: " +
							chooser.getSelectedFile().getName());
					System.out.println(pathString);
					Icon newicopIcon=new ImageIcon(pathString);
					picJLabel.setIcon(newicopIcon);
					picJLabel.setVisible(true);
					panel.add(picJLabel);
					picJLabel.setBounds(58, 244, 86, 20);


				}

			}
		});

		texDescription = new JTextField();
		texDescription.setBounds(58, 290, 194, 76);
		panel.add(texDescription);
		texDescription.setColumns(10);

		JLabel lblCodeBuisness = new JLabel("code buisness");
		lblCodeBuisness.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblCodeBuisness.setBounds(58, 36, 87, 14);
		panel.add(lblCodeBuisness);

		JLabel name = new JLabel("name");
		name.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		name.setBounds(58, 88, 46, 14);
		panel.add(name);

		city = new JLabel("city");
		city.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		city.setBounds(58, 142, 46, 14);
		panel.add(city);

		street = new JLabel("street");
		street.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		street.setBounds(58, 185, 46, 14);
		panel.add(street);

		lblNum = new JLabel("num");
		lblNum.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblNum.setBounds(165, 185, 46, 14);
		panel.add(lblNum);

		lblImage = new JLabel("image");
		lblImage.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblImage.setBounds(58, 231, 46, 14);
		panel.add(lblImage);

		lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblDescription.setBounds(58, 275, 97, 14);
		panel.add(lblDescription);

		frame.setSize(700, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);




		btnNewButton = new JButton("previous");
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		btnNewButton.setBounds(44, 489, 89, 23);
		panel.add(btnNewButton);

		BoxvipBuisness = new JCheckBox("vip Buisness");
		BoxvipBuisness.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		BoxvipBuisness.setBounds(31, 384, 97, 23);
		panel.add(BoxvipBuisness);

		healthBu = new JCheckBox("health Buisness");
		healthBu.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		healthBu.setBounds(31, 428, 113, 23);
		panel.add(healthBu);

		video = new JTextField();
		video.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		video.setEditable(false);
		video.setEnabled(false);
		video.setBounds(199, 384, 86, 20);
		panel.add(video);
		video.setColumns(10);

		lblVideo = new JLabel("video");
		lblVideo.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblVideo.setBounds(150, 388, 46, 14);
		panel.add(lblVideo);

		String[] type= {"culinary","sporty"};	

		comboBox = new JComboBox(type);
		comboBox.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		comboBox.setEnabled(false);
		comboBox.setBounds(199, 429, 86, 20);
		panel.add(comboBox);

		lblType = new JLabel("type");
		lblType.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblType.setBounds(150, 432, 46, 14);
		panel.add(lblType);

		lblCodeCopuns = new JLabel("code copuns");
		lblCodeCopuns.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblCodeCopuns.setBounds(337, 119, 87, 14);
		panel.add(lblCodeCopuns);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		textField_8.setColumns(10);
		textField_8.setBounds(337, 144, 86, 20);
		//	textField_8.setVisible(false);
		panel.add(textField_8);


		lblDescripshion = new JLabel("description");
		lblDescripshion.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblDescripshion.setBounds(337, 187, 87, 14);
		panel.add(lblDescripshion);

		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		textField_9.setColumns(10);
		textField_9.setBounds(338, 209, 86, 20);
		panel.add(textField_9);

		lblStart = new JLabel("start ");
		lblStart.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblStart.setBounds(337, 240, 87, 14);
		panel.add(lblStart);

		lblEnd = new JLabel("end");
		lblEnd.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblEnd.setBounds(337, 301, 87, 14);
		panel.add(lblEnd);

		ArrayList<Label> labels=OrderLogic.getInstance().getLabels();
		List<String> labelArrayList=new ArrayList<String>();
		for(Label le:labels) {
			labelArrayList.add(le.getNameLabel()+"");
		}
		Object[]lab=labelArrayList.toArray();

		JComboBox byLavel = new JComboBox(lab);
		byLavel.setEnabled(false);
		byLavel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		byLavel.setBounds(524, 145, 86, 20);
		panel.add(byLavel);

		btnAddCupon = new JButton("Add cupon");
		btnAddCupon.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		btnAddCupon.setBounds(337, 373, 124, 23);
		panel.add(btnAddCupon);
		
		btnAddCupon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				java.util.Date d11=dtcBirthDate1.getDate();
				Date date21=null;
				 date21= new java.sql.Date(d11.getTime()); 

				 java.util.Date d12=dateChooser.getDate();
					Date date3=null;
					date3= new java.sql.Date(d12.getTime()); 
				 try {
					 ManageactivityControl.getInstance().addCoupon(codeB.getText(),textField_8.getText(), textField_9.getText(), date21, date3);
				 }
				 catch (SQLException e4) {
					 
					 JOptionPane.showMessageDialog(frame," you must add the buisness first");
				 }
			}
		});

		BoxvipBuisness.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(BoxvipBuisness.isSelected()) {
					textField_8.setEnabled(true);
					textField_8.setEditable(true);
					video.setEditable(true);
					video.setEnabled(true);
				}
				else {
					textField_8.setEnabled(false);
					textField_8.setEditable(false);
					video.setEditable(false);
					video.setEnabled(false);
				}
			}
		});

		healthBu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(healthBu.isSelected()) {
				byLavel.setEnabled(true);
				comboBox.setEnabled(true);
				}
				else {
					byLavel.setEnabled(false);
					comboBox.setEnabled(false);
				}
			}
		});

		btnAddBuisness = new JButton("Add buisness");
		btnAddBuisness.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		btnAddBuisness.setBackground(new Color(144, 238, 144));


		btnAddBuisness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				try {
					ManageactivityControl.getInstance().addBusiness(codeB.getText(),textname.getText(),textcity.getText(), textStreet.getText(), textNum.getText(),pathString+"", texDescription.getText()   );
					if (BoxvipBuisness.isSelected()) {
						ManageactivityControl.getInstance().addvipBuisness(codeB.getText(),video.getText());


					}

					else if (healthBu.isSelected()) {
						ManageactivityControl.getInstance().addhealthBuisness(codeB.getText(),comboBox.getSelectedItem()+"");
						ManageactivityControl.getInstance().addLabelToBuisness(codeB.getText(),byLavel.getSelectedItem()+"" );
					}

					JOptionPane.showMessageDialog(frame,"the Buisness is add ");
				}
				catch (ClassCastException e3) {
					JOptionPane.showMessageDialog(frame,"one or more data is not ok ");
				}

				catch (Exception e3) {
					JOptionPane.showMessageDialog(frame,"the add vehicle is not succeeded ");
				}

			}
		});
		btnAddBuisness.setBounds(184, 489, 143, 23);
		panel.add(btnAddBuisness);

		lblAddLabelTo = new JLabel("Add label to buisness");
		lblAddLabelTo.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblAddLabelTo.setBounds(514, 120, 122, 14);
		panel.add(lblAddLabelTo);

		lblAddLabel = new JLabel("Add label");
		lblAddLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		lblAddLabel.setBounds(524, 287, 122, 14);
		panel.add(lblAddLabel);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(514, 340, 86, 20);
		panel.add(textField_12);

		lblNameOfLabel = new JLabel("name of label");
		lblNameOfLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblNameOfLabel.setBounds(514, 315, 122, 14);
		panel.add(lblNameOfLabel);

		lblColor = new JLabel("color");
		lblColor.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblColor.setBounds(514, 374, 122, 14);
		panel.add(lblColor);

		textField_13 = new JTextField();
		textField_13.setBounds(514, 402, 86, 20);
		panel.add(textField_13);
		textField_13.setColumns(10);
		
		
		lblAddCopun = new JLabel("Add copun");
		lblAddCopun.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblAddCopun.setBounds(323, 88, 122, 14);
		panel.add(lblAddCopun);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(65, 105, 225), 2, true));
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(485, 252, 189, 179);
		panel.add(panel_1);
		
		btnNewButton_1 = new JButton("Add Label");
		btnNewButton_1.setBounds(524, 442, 89, 23);
		panel.add(btnNewButton_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(337, 326, 132, 30);
		panel.add(dateChooser);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManageactivityControl.getInstance().addLabel(textField_12.getText(),textField_13.getText() );
				
			}
		});



		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				managmentActivity menu = new managmentActivity();

			}
		});



	}

	protected Component getParent() {
		// TODO Auto-generated method stub
		return null;
	}
}
