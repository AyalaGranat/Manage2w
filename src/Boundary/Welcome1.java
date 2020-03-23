package Boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import com.healthmarketscience.jackcess.Cursor;

public class Welcome1 extends JFrame{
	
	public Welcome1() {


	JFrame frame = new JFrame(" Entry");  
	JPanel panel = new JPanel();
	
	frame.getContentPane().add(panel);  
	panel.setLayout(null);
	
	JButton btnNewButtonEmpl = new JButton("\u05DB\u05E0\u05D9\u05E1\u05D4 \u05DC\u05E2\u05D5\u05D1\u05D3\u05D9\u05DD ");
	btnNewButtonEmpl.setBounds(260, 170, 136, 48);
	panel.add(btnNewButtonEmpl);
	
	btnNewButtonEmpl.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			
			managmentActivity managmentActivity= new managmentActivity();
			frame.setVisible(false);
			
			
		}
	});
	
	
	
	JButton btnNewButtonUser = new JButton("\u05DB\u05E0\u05D9\u05E1\u05D4 \u05DC\u05DE\u05E9\u05EA\u05DE\u05E9\u05D9\u05DD");
	btnNewButtonUser.setBounds(88, 170, 141, 48);
	panel.add(btnNewButtonUser);
	
	
	btnNewButtonUser.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Welcome menu = new Welcome();
			frame.setVisible(false);
			
		}
	});
	
	JProgressBar progressBar = new JProgressBar();
	progressBar.setMaximum(1);
	progressBar.setValue(10);
	progressBar.setStringPainted(true);
	progressBar.setIndeterminate(true);
	progressBar.setBounds(164, 262, 146, 26);
	panel.add(progressBar);
	
	/*progressBar.setToolTipText("10");
	progressBar.addAncestorListener(new AncestorListener() {
		
		@Override
		public void ancestorRemoved(AncestorEvent event) {
			try {
				wait(HIDE_ON_CLOSE, 10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Override
		public void ancestorMoved(AncestorEvent event) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void ancestorAdded(AncestorEvent event) {
			// TODO Auto-generated method stub
			
		}
	});*/
	
	JLabel lblNewLabel = new JLabel("Welcome to Manage2W");
	lblNewLabel.setBackground(Color.WHITE);
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setIcon(null);
	lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 32));
	lblNewLabel.setBounds(111, 65, 247, 74);
	panel.add(lblNewLabel);
	
	
	
	JLabel lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Acer\\Desktop\\Manage2W\\src\\bicycle.jpg"));
	lblNewLabel_1.setBounds(10, 11, 464, 439);
	panel.add(lblNewLabel_1);
	frame.setSize(500, 500);  
	frame.setLocationRelativeTo(null);  
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	frame.setVisible(true);
	
	}
}
