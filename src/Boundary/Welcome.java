package Boundary;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Array;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.log4j.BasicConfigurator;
import org.omg.CORBA.PRIVATE_MEMBER;

import control.OrderLogic;
import entity.*;

public class Welcome extends Frame  {


	String currentChooseValueCity= "";
	String currentChooseValueLavel="";
	String currentChooseValueLabel="";
	String cuurentChooseRadioButtonString="";
	String chooseStringStreet="";
	JComboBox byStreet;

	public Welcome() {


		JFrame frame = new JFrame("Veiw Path");  
		JPanel panel = new JPanel();

		frame.getContentPane().add(panel);  
		frame.setSize(500, 500);  
		frame.setLocationRelativeTo(null);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		frame.setVisible(true);
		panel.setLayout(null);




		JLabel lblRentVehicle = new JLabel("View path");
		lblRentVehicle.setBounds(196, 34, 150, 14);
		panel.add(lblRentVehicle);



		JLabel lblChooseoption = new JLabel("Choose option to view at path:");
		lblChooseoption.setBounds(57, 106, 251, 14);
		panel.add(lblChooseoption);
		/**Radio Button**/
		JRadioButton lavelAndCity = new JRadioButton("by lavel and city");
		lavelAndCity.setBounds(271, 145, 150, 23);
		panel.add(lavelAndCity);
		/*rdbtnByName*/


		JRadioButton  labelAndCity = new JRadioButton("by label and city");
		labelAndCity.setBounds(57, 145, 176, 23);
		panel.add(labelAndCity);
		/*rdbtnByAddress*/

		ButtonGroup radioGroup=new ButtonGroup();
		radioGroup.add(labelAndCity);
		radioGroup.add(lavelAndCity);
		/**End Radio Button**/




		/**CHECK IT!!!!*/
		//get city/* 
		
		ArrayList<String> cities=OrderLogic.getInstance().getcities();
		List<String> cityArrayList=new ArrayList<String>();
		cityArrayList.add("choose city");
		cityArrayList.addAll(cities);
		Object[]citiesob=cityArrayList.toArray();


		JComboBox bycity= new JComboBox(citiesob);
		bycity.setBounds(281, 170, 95, 32);
		panel.add(bycity);
		bycity.setVisible(false);


		//get level from enum
		Level [] levels=Level.values();
		List<String> levelArrayList=new ArrayList<String>();
		levelArrayList.add("choose level");
		for(Level le:levels) {
			levelArrayList.add(le+"");
		}
		Object[]lev=levelArrayList.toArray();


		JComboBox byLavel = new JComboBox(lev);
		byLavel.setBounds(280, 213, 96, 50);
		panel.add(byLavel);
		byLavel.setVisible(false);


		//get labels
		ArrayList<Label> labels=OrderLogic.getInstance().getLabels();
		List<String> labelArrayList=new ArrayList<String>();
		labelArrayList.add("choose label");
		for(Label le:labels) {
			labelArrayList.add(le.getNameLabel()+"");
		}
		Object[]lab=labelArrayList.toArray();

		/* to try 
	       JList labelLista=new JList(lab);
	       labelLista.setVisibleRowCount(5);
	       labelLista.setBounds(50, 50, 300, 300);
	       labelLista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	       panel.add(new JScrollPane(labelLista));
	       panel.add(labelLista);
		 */

		JComboBox colabel = new JComboBox(lab);
		colabel.setBounds(68, 213, 116, 50);
		panel.add(colabel);

		JButton search = new JButton("search");
		search.setBounds(332, 362, 89, 23);
		panel.add(search);
		
		JLabel lblPassTheMouse = new JLabel("pass the mouse here for button");
		lblPassTheMouse.setBounds(218, 396, 226, 14);
		lblPassTheMouse.setVisible(true);
		panel.add(lblPassTheMouse);
		/*
		tryJlabel.addListSelectionListener(new ListSelectionListener() {
			
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
			}});	
			
		*/
		colabel.setVisible(false);



		lavelAndCity.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bycity.setVisible(true);
				byLavel.setVisible(true);
				colabel.setVisible(false);
				bycity.setBounds(281, 170, 95, 32);
				cuurentChooseRadioButtonString="rdbtnBylavelAndCity";
			}
		});


		labelAndCity.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(lab.toString());
				byLavel.setVisible(false);
				bycity.setVisible(true);
				colabel.setVisible(true);
				bycity.setBounds(70, 170, 95, 32);


				cuurentChooseRadioButtonString="rdbtnByLabelAndCity";
			}
		});


		bycity.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				currentChooseValueCity=bycity.getSelectedItem()+"";
				System.out.println(currentChooseValueCity);
			}
		});

		byLavel.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				currentChooseValueLavel=byLavel.getSelectedItem()+"";
				System.out.println(currentChooseValueLavel);
			}
		});

		colabel.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				currentChooseValueLabel=colabel.getSelectedItem()+"";
				System.out.println(currentChooseValueLabel);
			}
		});

	
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			/*	
				ArrayList<Path>toreturnArrayListsum=null;
				ArrayList<Path>toreturnArrayList=null;
				List<Object> labeltosend;
				labeltosend= tryJlabel.getSelectedValuesList();
				System.out.println("the chooses"+labeltosend);
				for(Object label:labeltosend) {
					String labelString=label.toString();
					System.out.println(labelString);
					toreturnArrayList= OrderLogic.getInstance().getPathArrayListByCityLabel(currentChooseValueCity, labelString);
					toreturnArrayListsum.addAll(toreturnArrayList);
System.out.println(toreturnArrayListsum);

				}
				System.out.println(toreturnArrayListsum);*/

				Level levelToSend=null;
				if (currentChooseValueLavel.equals("EASY")) {
					levelToSend=Level.EASY;
				}
				else if (currentChooseValueLavel.equals("HARD")) {
					levelToSend=Level.HARD;
				}
				else if (currentChooseValueLavel.equals("MEDIUM")) {
					levelToSend=Level.MEDIUM;
				}
				ArrayList<Path> returnArrayList=new ArrayList<Path>();
				if (cuurentChooseRadioButtonString.equals("rdbtnBylavelAndCity"))
				{
					returnArrayList =OrderLogic.getInstance().getPathArrayListByCityLevel(currentChooseValueCity,levelToSend);
					if(!returnArrayList.isEmpty()) {
					ResultSearchPath result= new ResultSearchPath(returnArrayList);
					frame.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(frame,"no path exsist, try again");
					}
				}
				else if(cuurentChooseRadioButtonString.equals("rdbtnByLabelAndCity")){
					returnArrayList= OrderLogic.getInstance().getPathArrayListByCityLabel(currentChooseValueCity, currentChooseValueLabel);
					if(!returnArrayList.isEmpty()) {
					ResultSearchPath result= new ResultSearchPath(returnArrayList);
					frame.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(frame,"no path exsist, try again");
					}
				}
			}

		});

	}
}
