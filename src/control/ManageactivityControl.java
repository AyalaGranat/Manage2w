package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.log4j.BasicConfigurator;

import entity.Consts;
import entity.Level;
import entity.Manufacturer;
import entity.ParkingStop;
import entity.Path;
import entity.Vehicle;
import entity.typeVehicle;

public class ManageactivityControl {

	
	private static ManageactivityControl _instance;
	
	private ManageactivityControl() {
	}


	public static ManageactivityControl getInstance() {
		BasicConfigurator.configure();
		if (_instance == null)
			_instance = new ManageactivityControl();
		return _instance;
		
	}
	
	public ArrayList<String> getParkingstops() {
		ArrayList<String> results = new ArrayList<String>();
	
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SELECT_ALL_PARKINGSTOP_BY_NAME);
					ResultSet rs = stmt.executeQuery())
			
			{
				while (rs.next()) {
					int i = 1;
					
					String code= rs.getString(i++);
					results.add(code);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
	

	
	
	public ArrayList<ParkingStop> getAllParkingStop() {
		ArrayList<ParkingStop> results = new ArrayList<ParkingStop>();
	
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.	SELECT_ALL_PARKINGSTOP);
					ResultSet rs = stmt.executeQuery())
			
			{
				while (rs.next()) {
					int i = 1;
					
					String CodePS= rs.getString(i++);
					String City= rs.getString(i++);
					String Street= rs.getString(i++);
					Double CorX= rs.getDouble(i++);
					Double CorY= rs.getDouble(i++);
					Integer CapacityVehicle= rs.getInt(i++);
					
					results.add(new ParkingStop(CodePS, City,Street,CorX,CorY,CapacityVehicle)); 
					
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	public ArrayList<ParkingStop> getAlllabel() {
		ArrayList<ParkingStop> results = new ArrayList<ParkingStop>();
	
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.	SELECT_ALL_PARKINGSTOP);
					ResultSet rs = stmt.executeQuery())
			
			{
				while (rs.next()) {
					int i = 1;
					
					String CodePS= rs.getString(i++);
					String City= rs.getString(i++);
					String Street= rs.getString(i++);
					Double CorX= rs.getDouble(i++);
					Double CorY= rs.getDouble(i++);
					Integer CapacityVehicle= rs.getInt(i++);
					
					results.add(new ParkingStop(CodePS, City,Street,CorX,CorY,CapacityVehicle)); 
					
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	
	
	public ArrayList<ParkingStop> getParkingStops(String codeStringpath) {
		ArrayList<ParkingStop> results = new ArrayList<ParkingStop>();
	
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.	SELECT_ALL_PARKINGSTOP);
					ResultSet rs = stmt.executeQuery())
			
			{
				while (rs.next()) {
					int i = 1;
					
					String CodePS= rs.getString(i++);
					String City= rs.getString(i++);
					String Street= rs.getString(i++);
					Double CorX= rs.getDouble(i++);
					Double CorY= rs.getDouble(i++);
					Integer CapacityVehicle= rs.getInt(i++);
					
					results.add(new ParkingStop(CodePS, City,Street,CorX,CorY,CapacityVehicle)); 
					
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	
	
	
	public ArrayList<String> getParkingStop( String codePath) {
		ArrayList<String> results = new ArrayList<String>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.GET_PARKING_STOP_BY_ORDER);)
						{
					stmt.setString(1, codePath);	
					ResultSet rs = stmt.executeQuery();
					
				while (rs.next()) {
					int i = 1;
					
					String orderInPath= rs.getString(i++);
					results.add(orderInPath); 
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
}
	


	public ArrayList<String> updateLenghtPath( String codePath, Double lenght) {
		ArrayList<String> results = new ArrayList<String>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						CallableStatement stmt = conn.prepareCall(Consts.UPDATE_LENGHT_VEHICLE)) 
				
						{
					int i=1;
					stmt.setDouble (i, lenght);
					stmt.setString(2, codePath);	
			
		
					
					stmt.executeUpdate();
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
}
	
	public Double getDistanceBetweenParkingStop( String codeParkingstop1, String codeParkingstop2) {
		Double results =null;
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.GET_DISTANCE_BETWEEN_PS);)
						{
					stmt.setString(1, codeParkingstop1);	
					stmt.setString(2, codeParkingstop2);
					ResultSet rs = stmt.executeQuery();
					
				while (rs.next()) {
					int i = 1;
					
					Double dis= rs.getDouble(i++);
					results=dis;
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
}
	
	
	
	
	public ArrayList<Manufacturer> getMenufacturer() {
		ArrayList<Manufacturer> results = new ArrayList<Manufacturer>();
	
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.GET_MANUFACTURER);
					ResultSet rs = stmt.executeQuery())
			
			{
				while (rs.next()) {
					int i = 1;
					
					String code= rs.getString(i++);
					String fname= rs.getString(i++);
					String lastname= rs.getString(i++);
					String phone= rs.getString(i++);
					String email= rs.getString(i++);
					
					Manufacturer newmanu= new Manufacturer(code, fname, lastname, phone, email);
					
					
					results.add(newmanu);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	
	
	
	public String getlastvehicle() {
		String results = "";
	
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.GET_LAST_CODE_VEHICLE);
					ResultSet rs = stmt.executeQuery())
			
			{
				while(rs.next()) {
				
					int i = 1;
					String code= rs.getString(i++);
					results=code;
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	public String getlastBusiness() {
		String results = "";
	
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.GET_LAST_CODE_BUSINESS);
					ResultSet rs = stmt.executeQuery())
			
			{
				while(rs.next()) {
				
					int i = 1;
					String code= rs.getString(i++);
					results=code;
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	
	
	public String getlastps() {
		String results = "";
	
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.GET_LAST_CODE_PS);
					ResultSet rs = stmt.executeQuery())
			
			{
				while(rs.next()) {
				
					int i = 1;
					String code= rs.getString(i++);
					results=code;
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	
	public boolean addCoupon(String CodeBusiness,String CodeCoupon, String DescriptionCou,Date StartDateCou, Date EndDateCou) throws SQLException {
		try {
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.INSERT_CUPON)) {
				
				int i = 1;
				stmt.setString(i++, CodeBusiness);		
				stmt.setString(i++, CodeCoupon); 
				stmt.setString(i++, DescriptionCou); 
				stmt.setDate(i++, StartDateCou); 
				stmt.setDate(i++, EndDateCou); 
				stmt.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				throw e;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addNewUser(String phone,Date date, String fname,String lasname , String id, String email, String charger, String pasword) throws SQLException {
		try {
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.INSERT_USER)) {
				
				int i = 1;
				stmt.setString(i++, phone);		
				stmt.setDate(i++, date); 
				stmt.setString(i++, fname); 
				stmt.setString(i++, lasname); 
				stmt.setString(i++, id); 
				stmt.setString(i++, email); 
				stmt.setString(i++, charger); 
				stmt.setString(i++, pasword); 
				stmt.executeUpdate();
				return true;
				
			} catch (SQLException e1) {
				throw e1;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	public boolean addVehicle(String codeVehicle, typeVehicle typeVehicle, String lastPs) {
		try {
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.INSERT_VEHICLE)) {
				
				int i = 1;
				stmt.setString(i++, codeVehicle);
				String typeVehicleString="";
				
				if(typeVehicle.equals(typeVehicle.BICYCLE)) {
						typeVehicleString="Bicycle";
						}
				else if(typeVehicle.equals(typeVehicle.SCOOTER)) {
						typeVehicleString="Scooter";
				}
						
				stmt.setString(i++, typeVehicleString); 
				stmt.setString(i++, lastPs); 
				stmt.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addLabelToBuisness(String codebu, String type) {
		try {
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.INSERT_LABEL_BUSINESS)) {
				
				int i = 1;
				stmt.setString(i++, codebu);
				stmt.setString(i++, type); 
				stmt.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	public boolean addParkingStop(String codeps, String city, String street, Double CorX, Double CorY, int CapacityVehicle) {
		try {
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.INSERT_PARKINGSTOP)) {
				
				int i = 1;
				stmt.setString(i++, codeps);
				stmt.setString(i++, city); 
				stmt.setString(i++, street); 
				stmt.setDouble(i++, CorX); 
				stmt.setDouble(i++, CorY); 
				stmt.setInt(i++, CapacityVehicle); 
				
				stmt.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean addBusiness(String CodeBusiness, String NameBusiness, String City, String Street,String HouseNumber, String ImageBu,String DescriptionBu ) throws SQLException
	 {
		try {
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.INSERT_BUSINESS)) {
				
				int i = 1;
				stmt.setString(i++, CodeBusiness);
				stmt.setString(i++, NameBusiness); 
				stmt.setString(i++, City); 
				stmt.setString(i++, Street); 
				stmt.setString(i++, HouseNumber); 
				stmt.setString(i++, ImageBu); 
				stmt.setString(i++, DescriptionBu); 
	
				stmt.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				throw e;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	
	public boolean addvipBuisness(String codeVehicle, String video) {
		try {
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.VIP_BUSINESS)) {
				
				int i = 1;
				stmt.setString(i++, codeVehicle);
				stmt.setString(i++, video); 
				stmt.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean addLabel(String nameLabel, String color) {
		try {
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.INSERT_LABEL)) {
				
				int i = 1;
				stmt.setString(i++, nameLabel);
				stmt.setString(i++, color); 
				stmt.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	

	public boolean addhealthBuisness(String codeVehicle, String type) {
		try {
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.HEALTH_BUSINESS)) {
				
				int i = 1;
				stmt.setString(i++, codeVehicle);
				stmt.setString(i++, type); 
				stmt.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean addElectricVehicle(String codeVehicle, Date Date, String codeButtery, String manu) {
		try {
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.INSERT_ELECTRIC_VEHICLE)) {
				
				int i = 1;
				stmt.setString(i++, codeVehicle);
		//		java.sql.Date date1= Date;
				stmt.setDate(i++, Date);
				stmt.setString(i++, codeButtery); 
				stmt.setString(i++, manu); 
				stmt.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addPath(String codePath, Level level, Double lenght) throws SQLException {
		try {
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.INSERT_PATH)) {
				
				int i = 1;
				stmt.setString(i++, codePath);
				
				
			String levelToString="";
				if(level.toString().equals("EASY")) {
					levelToString="easy";
					
				}
				else	if(level.toString().equals("MEDIUM"))
					levelToString="medium";
				else	if(level.toString().equals("HARD"))
					levelToString="hard";
				
			//	stmt.setString(i++, level);
				stmt.setString(i++, levelToString);
				stmt.setDouble(i++,lenght);
				stmt.executeUpdate();
				
				return true;
				
			} catch (SQLException e) {
				//e.printStackTrace();
				throw e;
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		return false;
	}
	
	
	public boolean addParkingStopToPath(String codePath,String parkingStop, Integer order) throws SQLException {
		try {
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.INSERT_PARKINGSTOP_IN_PATH)) {
				
				int i = 1;
				stmt.setString(i++, codePath);
				stmt.setString(i++, parkingStop);
				stmt.setInt(i++,order);
				
				stmt.executeUpdate();
				
				return true;
				
			} catch (SQLException e) {
				//e.printStackTrace();
				throw e;
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		return false;
	}
	
	
	
}
