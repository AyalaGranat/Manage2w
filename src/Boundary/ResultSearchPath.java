package Boundary;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.OrderLogic;
import entity.Business;
import entity.Label;
import entity.LabelInHealthBusiness;
import entity.Level;
import entity.ParkingStop;
import entity.Path;
import entity.Vehicle;

public class ResultSearchPath extends Frame{

	ParkingStop psToSend=null;
	Path pathToSend=null;
	public ResultSearchPath(ArrayList<Path> path) {



		JFrame frame = new JFrame("Veiw Path");  
		JPanel panel = new JPanel();

		frame.getContentPane().add(panel);  
		frame.setSize(700, 500);  
		frame.setLocationRelativeTo(null);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		frame.setVisible(true);
		panel.setLayout(null);

		JLabel choosePath=new JLabel("please choose path: ");
		panel.add(choosePath);
		choosePath.setBounds(10, 10, 200,50);

		List<String> labelArrayList=new ArrayList<String>();
		for(Path pa:path) {
			labelArrayList.add(pa.toString()+"");
		}
		Object[]lab=labelArrayList.toArray();



		JList labelLista=new JList(lab);
		labelLista.setVisibleRowCount(5);
		labelLista.setBounds(50, 50, 300, 150);
		labelLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel. add(new JScrollPane(labelLista));
		panel. add(labelLista);




		labelLista.addListSelectionListener(new ListSelectionListener() {


			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				Object[]prk=null;

				repaint();
				ArrayList<ParkingStop>ps=new ArrayList<ParkingStop>(OrderLogic.getInstance().getParkingStopInPath(path.get(labelLista.getSelectedIndex()).getCodePath()));

				List<String> parkingStopArrayList=new ArrayList<String>();
				for(ParkingStop Ps:ps) {
					parkingStopArrayList.add(Ps.toString()+"");
				}
				DefaultListModel model=new DefaultListModel();
				model.clear();
				prk=parkingStopArrayList.toArray();
				JList labelParkingStop=new JList(prk);

				labelParkingStop.setVisibleRowCount(5);
				labelParkingStop.setBounds(50,250 , 450, 150);
				labelParkingStop.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    
				panel.add(labelParkingStop);

				JLabel chooseparkingStpo=new JLabel("please choose parking stop: (maxsimaiz the screen if you dont see parkingstop)  ");
				panel.add(chooseparkingStpo);
				chooseparkingStpo.setBounds(50, 200, 500,50);
				chooseparkingStpo.setVisible(true);
				
				labelParkingStop.addListSelectionListener(new ListSelectionListener() {
					

					@Override
					public void valueChanged(ListSelectionEvent e) {
						

						psToSend= ps.get(labelParkingStop.getSelectedIndex());         
						pathToSend=path.get(labelLista.getSelectedIndex());

					}});		       


			}
		}); 

		JButton search = new JButton("search");
		search.setBounds(332, 410, 89, 23);
		panel.add(search);

		try {
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				OrderLogic.getInstance().getOrderParkingStopInPath(pathToSend.getCodePath()+"",psToSend.getCodeParkingStopString()+"");
				int nextPs=OrderLogic.getInstance().getOrderParkingStopInPath(pathToSend.getCodePath()+"",psToSend.getCodeParkingStopString()+"");
				try {

					ArrayList<Business> businessesToSend=(OrderLogic.getInstance().getBusinessByPS(pathToSend.getCodePath(),nextPs+1));
					if(businessesToSend.isEmpty()) {
						JOptionPane.showMessageDialog(frame,"not have next station or business please try again");

					}
					else {		
							
							businessInPath result= new businessInPath(businessesToSend);
							frame.setVisible(false);

						}}

				
				catch (NullPointerException e1) {
					System.out.println("hii");
					JOptionPane.showMessageDialog(frame,"not have next station or business");
				}



			}

		});

		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(frame,"please choose parking stop");
		}

	}
}
