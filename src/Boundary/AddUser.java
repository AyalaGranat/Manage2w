package Boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import control.ManageactivityControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;

public class AddUser {
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_1;

	public AddUser() {

		JFrame frame = new JFrame("Veiw Path");  
		JPanel panel = new JPanel();

		frame.getContentPane().add(panel);  
		frame.setSize(500, 500);  
		frame.setLocationRelativeTo(null);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		frame.setVisible(true);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(80, 43, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(80, 146, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(80, 197, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(80, 243, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("charger");
		chckbxNewCheckBox.setBounds(69, 331, 97, 23);
		panel.add(chckbxNewCheckBox);
		
		textField_5 = new JTextField();
		textField_5.setBounds(80, 387, 86, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("phone");
		lblNewLabel.setBounds(80, 18, 46, 14);
		panel.add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(81, 90, 165, 30);
		panel.add(dateChooser);
		
		JLabel lblDateOfBirth = new JLabel("date of birth");
		lblDateOfBirth.setBounds(80, 74, 46, 14);
		panel.add(lblDateOfBirth);
		
		JLabel lblFname = new JLabel("fname");
		lblFname.setBounds(80, 121, 46, 14);
		panel.add(lblFname);
		
		JLabel lblLastName = new JLabel("last name");
		lblLastName.setBounds(80, 172, 46, 14);
		panel.add(lblLastName);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(80, 228, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblNewLabel_1 = new JLabel("pasword");
		lblNewLabel_1.setBounds(80, 362, 46, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ADD USER");
		btnNewButton.setBounds(259, 394, 89, 23);
		panel.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 293, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(80, 274, 46, 14);
		panel.add(lblNewLabel_2);
		
		btnNewButton.addActionListener(new ActionListener() {
			

			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				java.util.Date d11=dateChooser.getDate();
				Date date21=null;
				date21= new java.sql.Date(d11.getTime());
				String chooseString="";
				if(chckbxNewCheckBox.isSelected())
					chooseString="yes";
				else {
					chooseString="no";
				}
				try {
				ManageactivityControl.getInstance().addNewUser(textField.getText(),date21, textField_2.getText(),textField_3.getText(),textField_1.getText(),textField_4.getText(),chooseString,  textField_5.getText() );
				JOptionPane.showMessageDialog(frame,"the add user is succeeded");

				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(frame,"the add user is not succeeded, please choose other date of birth or phone");
				}
			}
		});
	}
}
