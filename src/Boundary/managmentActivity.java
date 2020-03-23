package Boundary;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import entity.Business;
import entity.Coupon;
import entity.HealthBusiness;
import entity.Label;
import entity.VIPBusiness;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class managmentActivity {


		
		JTextArea labals = new JTextArea();
		JTextArea copuns = new JTextArea();
		HashMap<VIPBusiness, ArrayList<Coupon>> vipAndCoupon=null;
		HashMap<HealthBusiness, ArrayList<Label>> healthBusinessAndLabel=null;
		
		public managmentActivity() {

			JFrame frame = new JFrame("Activity managment");
			JPanel panel = new JPanel();
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JButton btnNewButton = new JButton("Update copuns and label");
			btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					UpdateBuisnennesCopunLabel menu = new UpdateBuisnennesCopunLabel();
					frame.setVisible(false);
					
				}
			});
			btnNewButton.setBounds(379, 197, 191, 68);
			panel.add(btnNewButton);
			
			JButton btnAddANew = new JButton("Add a new Vehicle ");
			btnAddANew.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
			btnAddANew.setBounds(75, 86, 205, 68);
			panel.add(btnAddANew);
			
			btnAddANew.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					AddNewCar menu = new AddNewCar();
					frame.setVisible(false);
				}
			});
			
			JButton AddNewPath = new JButton("Add a new path");
			AddNewPath.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
			AddNewPath.setBounds(379, 86, 191, 68);
			panel.add(AddNewPath);
			
			
			AddNewPath.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					AddNewPath menu = new AddNewPath();
					frame.setVisible(false);
					
				}
			});
			
			JButton button_2 = new JButton("Add parking Stop");
			button_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
			button_2.setBounds(75, 197, 205, 68);
			panel.add(button_2);
			frame.setSize(800, 500);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
			button_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					AddParkingStop menu = new AddParkingStop();
					frame.setVisible(false);
				}
			});
			
			JButton btnPre = new JButton("previous");
			btnPre.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
			btnPre.setBounds(67, 401, 89, 23);
			panel.add(btnPre);
			
			JButton btnNewButton_1 = new JButton("Add distance betweern ps");
			btnNewButton_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
			btnNewButton_1.setBounds(379, 302, 192, 68);
			panel.add(btnNewButton_1);
			
			JLabel lblNewLabel_1 = new JLabel("Welcome To Management System ");
			lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 27));
			lblNewLabel_1.setBounds(178, 29, 302, 46);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Acer\\Desktop\\Manage2W\\resources\\2476011-623827-1600x900.jpeg"));
			lblNewLabel.setBounds(0, 0, 784, 461);
			panel.add(lblNewLabel);
			

			btnPre.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Welcome1 menu = new Welcome1();
					frame.setVisible(false);
					
				}
			});

		}
}
