package Boundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.OrderLogic;
import entity.Business;
import entity.Coupon;
import entity.HealthBusiness;
import entity.Label;
import entity.ParkingStop;
import entity.VIPBusiness;

import javax.swing.JTextArea;
import javax.imageio.event.IIOReadProgressListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;

public class businessInPath {
	int j=0;
	JTextArea labals = new JTextArea();
	JTextArea copuns = new JTextArea();
	HashMap<VIPBusiness, ArrayList<Coupon>> vipAndCoupon=null;
	HashMap<HealthBusiness, ArrayList<Label>> healthBusinessAndLabel=null;
	
	public businessInPath(ArrayList<Business> businesses) {

		JFrame frame = new JFrame("Veiw Business");
		JPanel panel = new JPanel();

		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JTextArea businessDetails = new JTextArea();
		businessDetails.setBounds(70, 60, 458, 97);
		panel.add(businessDetails);

		
		labals.setBounds(70, 296, 465, 97);
		panel.add(labals);

	
		copuns.setBounds(70, 184, 465, 76);
		panel.add(copuns);

		JButton nextButton = new JButton("next Business");
		nextButton.setBounds(305, 399, 156, 23);
		panel.add(nextButton);

		JButton beforeButton = new JButton("pre Business");
		beforeButton.setBounds(136, 399, 145, 23);
		panel.add(beforeButton);


		
		
		JLabel lblBusinessInNext = new JLabel("Business in next station :");
		lblBusinessInNext.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBusinessInNext.setBounds(197, 11, 181, 14);
		panel.add(lblBusinessInNext);
		
		JLabel lblCoupons = new JLabel("coupons:");
		lblCoupons.	setBounds(80, 168, 62, 14);
		panel.add(lblCoupons);
		
		JLabel lblLabels = new JLabel("labels:");
		lblLabels.setBounds(80, 271, 79, 14);
		panel.add(lblLabels);
		
		JLabel lblBusinesDetails = new JLabel("busines details:");
		lblBusinesDetails.setBounds(70, 40, 89, 14);
		panel.add(lblBusinesDetails);
		
		ImageIcon picture = new ImageIcon("add pic","/src/but.jpg");
		
		//check it 
		JLabel lblThisIsVip = new JLabel("this is vip business");
		lblThisIsVip.setBounds(152, 168, 116, 14);
		panel.add(lblThisIsVip);
		lblThisIsVip.setVisible(false);
		
		JLabel lblThisIsHealth = new JLabel("this is health business");
		lblThisIsHealth.setBounds(148, 271, 133, 14);
		panel.add(lblThisIsHealth);
		lblThisIsHealth.setVisible(false);
		
		
		
		
		JButton btnShowPic = new JButton("get picture");
		btnShowPic.setBounds(538, 90, 94, 51);
		panel.add(btnShowPic);
		
		Icon icon=new ImageIcon("/src/but.jpg");
		JLabel picLabel= new JLabel(icon);
		
		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.setBounds(548, 271, 46, 14);
		panel.add(lblNewLabel);
		
		
		
		
		
		
	
	
		frame.setSize(700, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
			businessDetails.append(businesses.get(0).toString());
			if( !OrderLogic.getInstance().getCuponsAndVIPBusinessByPS(businesses.get(0).getCodeBusiness()).isEmpty()){
				vipAndCoupon= OrderLogic.getInstance().getCuponsAndVIPBusinessByPS(businesses.get(0).getCodeBusiness()); 
				ArrayList<Coupon> couponsText=null;
				
				for(VIPBusiness vip:vipAndCoupon.keySet()) {
					couponsText=vipAndCoupon.get(vip);
					copuns.insert("   lynk to video    "+vip.getVideo(),0);
					
				}
				if(vipAndCoupon.isEmpty())
					copuns.insert("no cupons",0);
				
				
				
				btnShowPic.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						JOptionPane.showMessageDialog(frame,icon);
					}
				});

				
				
				int i=0;
				
				if(!couponsText.isEmpty()) {
					
				for(Coupon coupons:couponsText) {
					
				copuns.insert(coupons.toString()+"\n",i++);
				}
				
				copuns.insert("this it vip business\n", i++);
				}
				else {
					copuns.insert("no cupons",i++);
				}
			}
			
			if( !OrderLogic.getInstance().getLabelAndVHealthBusinessByPS(businesses.get(0).getCodeBusiness()).isEmpty()){
				healthBusinessAndLabel= OrderLogic.getInstance().getLabelAndVHealthBusinessByPS(businesses.get(0).getCodeBusiness());
				ArrayList<Label> labelsText=null;
				for(HealthBusiness lab:healthBusinessAndLabel.keySet()) {
					labelsText=healthBusinessAndLabel.get(lab);
				}

				int i=0;
				if(!labelsText.isEmpty()) {
				for(Label labelss:labelsText) {
					labals.insert(labelss.toString()+"\n",i++);
					
				}
				labals.insert("this it health business\n", i++);
				}
				else {
					labals.insert("no labels",i++);
				}

			}
			
		
		
	
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				j++;
				
				
				businessDetails.setText("");
				labals.setText("");
				copuns.setText("");
				
				try {
				businessDetails.append(businesses.get(j).toString());
				if( !OrderLogic.getInstance().getCuponsAndVIPBusinessByPS(businesses.get(j).getCodeBusiness()).isEmpty()){
					vipAndCoupon= OrderLogic.getInstance().getCuponsAndVIPBusinessByPS(businesses.get(j).getCodeBusiness()); 
					ArrayList<Coupon> couponsText=null;
					
					
					for(VIPBusiness cou:vipAndCoupon.keySet()) {
						couponsText=vipAndCoupon.get(cou);
						copuns.insert("  lynk to video"+cou.getVideo(),0);
						
						
					}

					int i=0;
					if(!couponsText.isEmpty()) {
						//copuns.insert("this it vip business", i++);
					for(Coupon coupons:couponsText) {
					copuns.insert(coupons.toString()+"\n",i++);
					
					
					}
					copuns.insert("this it vip business    \n", i++);
					}
					else {
						copuns.insert("no cupons",i++);
						
					}
				}
				
				if( !OrderLogic.getInstance().getLabelAndVHealthBusinessByPS(businesses.get(j).getCodeBusiness()).isEmpty()){
					healthBusinessAndLabel= OrderLogic.getInstance().getLabelAndVHealthBusinessByPS(businesses.get(j).getCodeBusiness());
					ArrayList<Label> labelsText=null;
					for(HealthBusiness lab:healthBusinessAndLabel.keySet()) {
						labelsText=healthBusinessAndLabel.get(lab);
					}

					int i=0;
					if(!labelsText.isEmpty()) {
					for(Label labelss:labelsText) {
						labals.insert(labelss.toString()+"\n",i++);
						
					}
					labals.insert("this it health business\n", i++);
					}
					else {
						labals.insert("no labels",i++);
					}

				}
				
			
			}
				catch (IndexOutOfBoundsException eout) {
					JOptionPane.showMessageDialog(frame,"not have any more busines");
				}
				}
		});
		
		
		beforeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				j--;
				
				
				businessDetails.setText("");
				labals.setText("");
				copuns.setText("");
				
				try {
				businessDetails.append(businesses.get(j).toString());
				if( !OrderLogic.getInstance().getCuponsAndVIPBusinessByPS(businesses.get(j).getCodeBusiness()).isEmpty()){
					vipAndCoupon= OrderLogic.getInstance().getCuponsAndVIPBusinessByPS(businesses.get(j).getCodeBusiness()); 
					ArrayList<Coupon> couponsText=null;
					Set<VIPBusiness> vipBusinessesinArrayList=vipAndCoupon.keySet();
					
					
					for(VIPBusiness cou:vipAndCoupon.keySet()) {
						couponsText=vipAndCoupon.get(cou);
						copuns.insert("  lynk to video   "+cou.getVideo(),0);
					}

					int i=0;
					if(!couponsText.isEmpty()) {
					for(Coupon coupons:couponsText) {
					copuns.insert(coupons.toString()+"\n",i++);
					}
					copuns.insert("this it vip business   \n", i++);
					}
					else {
						System.out.println("no copuns");
						String notext="no cupons";
						copuns.insert(notext,i++);
					}
				}
				int i=0;
				if( !OrderLogic.getInstance().getLabelAndVHealthBusinessByPS(businesses.get(j).getCodeBusiness()).isEmpty()){
					healthBusinessAndLabel= OrderLogic.getInstance().getLabelAndVHealthBusinessByPS(businesses.get(j).getCodeBusiness());
					ArrayList<Label> labelsText=null;
					for(HealthBusiness lab:healthBusinessAndLabel.keySet()) {
						labelsText=healthBusinessAndLabel.get(lab);
					}

					
					if(!labelsText.isEmpty()) {
					for(Label labelss:labelsText) {
						labals.insert(labelss.toString()+"\n",i++);
						
					}
					labals.insert("this it health business\n", i++);
					}
				}
					else {
						String notext="no label";
						labals.insert(notext,i++);
					}

				
				
			
			}
				catch (IndexOutOfBoundsException eout) {
					JOptionPane.showMessageDialog(frame,"not have any more busines");
				}
				}
		});
	
	}
}
