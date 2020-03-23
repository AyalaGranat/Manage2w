		package control;
		import java.awt.RadialGradientPaint;
		import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.SSLEngineResult.Status;
		
		import org.apache.log4j.BasicConfigurator;

import entity.Business;
import entity.Consts;
import entity.Coupon;
import entity.HealthBusiness;
import entity.Label;
import entity.Level;
		
		import entity.ParkingStop;
		import entity.Path;
import entity.VIPBusiness;
import entity.Vehicle;
import entity.nextParkingStop;
import entity.parkingStopInPath;
		
		
		
		public class OrderLogic {
		
			private static OrderLogic _instance;
		
			private OrderLogic() {
			}
		
		
			public static OrderLogic getInstance() {
				BasicConfigurator.configure();
				if (_instance == null)
					_instance = new OrderLogic();
				return _instance;
				
			}
		/*GET */
			/**
			 * fetches all cities from DB file.
		     * @return ArrayList of vehicle.
			 */
			public ArrayList<String> getcities() {
				ArrayList<String> results = new ArrayList<String>();
				System.out.println("begin");
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
							PreparedStatement stmt = conn.prepareStatement(Consts.GET_CITIES);
							ResultSet rs = stmt.executeQuery())
					
					{
						while (rs.next()) {
							int i = 1;
							
							String city= rs.getString(i++);
							results.add(city);
							
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return results;
			}
			
		
			/**
			 * fetches all Labels from DB file.
		     * @return ArrayList of vehicle.
			 */
			public ArrayList<Label>getLabels() {
				ArrayList<Label> results = new ArrayList<Label>();
				System.out.println("begin");
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
							PreparedStatement stmt = conn.prepareStatement(Consts.GET_LABEL);
							ResultSet rs = stmt.executeQuery())
					
					{
						while (rs.next()) {
							int i = 1;
							
							String labelName= rs.getString(i++);
							String labelColor= rs.getString(i++);
							

							results.add(new Label(labelName, labelColor));
							
							
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return results;
			}
			
			/**
			 * fetches all ParkingStopInPath from DB file.
		     * @return ArrayList of ParkingStop.
			 */
			public ArrayList<ParkingStop> getParkingStopInPath(String codePath) {
				ArrayList<ParkingStop> results = new ArrayList<ParkingStop>();
					try {
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
								PreparedStatement stmt = conn.prepareStatement(Consts.GET_PARKINGSTOP_IN_PATH);)
								{
								stmt.setString(1, codePath);
								ResultSet rs = stmt.executeQuery();
								
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
			
			/**
			 * fetches all getOrederParkingStopInPath from DB file.
		     * @return ArrayList of ParkingStop.
			 */
			public Integer getOrderParkingStopInPath(String codeParkingStop, String codePath) {
				Integer results=null;
					try {
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
								PreparedStatement stmt = conn.prepareStatement(Consts.GET_ORDER_PARKINGSTOP_IN_PATH);)
								{
							stmt.setString(2, codePath);	
							stmt.setString(1, codeParkingStop);
							ResultSet rs = stmt.executeQuery();
							
						while (rs.next()) {
							int i = 1;
							
							Integer orderInPath= rs.getInt(i++);
							results=orderInPath; 
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return results;
		}
			
		
			
			
			/**
			 * fetches all path by city and level from DB file.
		     * @return ArrayList of vehicle.
			 */
			public ArrayList<Path> getPathArrayListByCityLevel(String city, Level level) {
				System.out.println(city+ level.toString()+"");
				ArrayList<Path> results = new ArrayList<Path>();
					try {
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
								PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_GET_PATH_BY_CITY_AND_LEVEL);)
								{
								stmt.setString(2, city);
								String levelToString="";
								if(level.toString().equals("EASY")) {
									levelToString="easy";
									System.out.println(" hi easy");
								}
								else	if(level.toString().equals("MEDIUM"))
									levelToString="medium";
								else	if(level.toString().equals("HARD"))
									levelToString="hard";

								stmt.setString(1, levelToString);
								ResultSet rs = stmt.executeQuery();
								
						while (rs.next()) {
							int i = 1;
							
							String codePath=rs.getString(i++);
							System.out.println(codePath);
							String leveltoenum=rs.getString(i++);
							System.out.println(leveltoenum);
							Integer lenghtPath=rs.getInt(i++);
							
							Level level2 = null;
							if(leveltoenum.equals("easy"))
								level2=entity.Level.EASY;
							else	if(leveltoenum.equals("medium"))
								level2=entity.Level.MEDIUM;
							else	if(leveltoenum.equals("hard"))
								level2=entity.Level.HARD;
							
							results.add(new Path(codePath, level2,lenghtPath)); 
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return results;
		}
			
			/**
			 * fetches all path by city and label from DB file.
		     * @return ArrayList of vehicle.
			 */
			public ArrayList<Path> getPathArrayListByCityLabel(String city, String nameLabel) {
				System.out.println("city and label"+city+ nameLabel+"");
				ArrayList<Path> results = new ArrayList<Path>();
					try {
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
								PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_GET_PATH_BY_CITY_AND_LABEL);)
								{
								stmt.setString(1, city);
								stmt.setString(2, nameLabel);
								ResultSet rs = stmt.executeQuery();
								
						while (rs.next()) {
							int i = 1;
							
							String codePath=rs.getString(i++);
							System.out.println(codePath);
							String leveltoenum=rs.getString(i++);
							System.out.println(leveltoenum);
							Integer lenghtPath=rs.getInt(i++);
							
							
							Level level2 = null;
							if(leveltoenum.equals("easy"))
								level2=entity.Level.EASY;
							else	if(leveltoenum.equals("medium"))
								level2=entity.Level.MEDIUM;
							else	if(leveltoenum.equals("hard"))
								level2=entity.Level.HARD;
							
							
							results.add(new Path(codePath, level2, lenghtPath));
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return results;
		}
			

			/**
			 * fetches get Business By PS from DB file.
		     * @return ArrayList of vehicle.
			 */
			public ArrayList<Business> getBusinessByPS(String path, Integer order) {
				 ArrayList<Business>   results = new  ArrayList<Business> () ;
					try {
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
								PreparedStatement stmt = conn.prepareStatement(Consts.GET_BUSSINES_IN_PS);)
								{
								stmt.setString(1, path);
								stmt.setInt(2, order);
								ResultSet rs = stmt.executeQuery();
								
						while (rs.next()) {
							int i = 1;
							String CodeBusiness=rs.getString(i++);
							String NameBusiness=rs.getString(i++);
							String city=rs.getString(i++);
							String Street=rs.getString(i++);
							String HouseNumber=rs.getString(i++);
							String image=rs.getString(i++);
							String DescriptionBu=rs.getString(i++);
							
						
							results.add(new Business(CodeBusiness,NameBusiness ,city,Street, HouseNumber,image,DescriptionBu));
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return results;
		}
		
			
			/**
			 * fetches get Business By PS from DB file.
		     * @return ArrayList of vehicle.
			 */
			public HashMap<VIPBusiness,ArrayList<Coupon>> getCuponsAndVIPBusinessByPS(String codebussines) {
				HashMap<VIPBusiness,ArrayList<Coupon>>  results = new HashMap<VIPBusiness,ArrayList<Coupon>> () ;
				ArrayList<Coupon> coupuns=new ArrayList<Coupon>();
					try {
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
								PreparedStatement stmt = conn.prepareStatement(Consts.GET_VIDEO_COPUNS_BY_BUSSINESS);)
								{
								stmt.setString(1, codebussines);
								
								ResultSet rs = stmt.executeQuery();
								
						while (rs.next()) {
							int i = 1;
							String CodeBusiness=rs.getString(i++);
							String NameBusiness=rs.getString(i++);
							String city=rs.getString(i++);
							String Street=rs.getString(i++);
							String HouseNumber=rs.getString(i++);
							String image=rs.getString(i++);
							String DescriptionBu=rs.getString(i++);
							String video=rs.getString(i++);
							String CodeCoupon=rs.getString(i++);
							String DescriptionCou=rs.getString(i++);
							Date StartDateCou=rs.getDate(i++);
							Date EndDateCou=rs.getDate(i++);
							
							
							coupuns.add(new Coupon(CodeBusiness, CodeCoupon, DescriptionCou, StartDateCou, EndDateCou));
							results.put(new VIPBusiness(CodeBusiness,NameBusiness ,city,Street, HouseNumber, image,DescriptionBu,video), coupuns);
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return results;
		}
			//להריץ
			/**
			 * fetches get Business By PS from DB file.
		     * @return ArrayList of vehicle.
			 */
			public HashMap<HealthBusiness,ArrayList<Label>> getLabelAndVHealthBusinessByPS(String codebussines) {
				HashMap<HealthBusiness,ArrayList<Label>>  results = new HashMap<HealthBusiness,ArrayList<Label>>() ;
				ArrayList<Label> labels=new ArrayList<Label>();
					try {
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
								PreparedStatement stmt = conn.prepareStatement(Consts.GET_VIDEO_LABEL_BY_HEALTH_BUSSINESS);)
								{
								stmt.setString(1, codebussines);
								
								ResultSet rs = stmt.executeQuery();
								
						while (rs.next()) {
							int i = 1;
							String CodeBusiness=rs.getString(i++);
							String NameBusiness=rs.getString(i++);
							String city=rs.getString(i++);
							String Street=rs.getString(i++);
							String HouseNumber=rs.getString(i++);
							String image=rs.getString(i++);
							String DescriptionBu=rs.getString(i++);
							String type=rs.getString(i++);
							String nameLabel=rs.getString(i++);
							String color=rs.getString(i++);
						
							
							labels.add(new Label(nameLabel,color));
							results.put(new HealthBusiness(CodeBusiness,NameBusiness ,city,Street, HouseNumber, image,DescriptionBu,type),labels);
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return results;
		}
		
			
			public static void main(String [ ] args)
			{
			     System.out.println(getInstance().getcities());//
			   System.out.println(  getInstance().getPathArrayListByCityLevel("tel- aviv", Level.EASY));//
			   System.out.println(  getInstance().getLabels());//
			   System.out.println(  getInstance().getPathArrayListByCityLabel("tel- aviv", "vegan"));//
			   System.out.println(  getInstance().getParkingStopInPath("444"));//
			   System.out.println(   "order is"+getInstance().getOrderParkingStopInPath("444","123"));//
			   Integer x= (getInstance().getOrderParkingStopInPath("444","123"))+1;
			   System.out.println(x);
			   System.out.println(  getInstance().getBusinessByPS("444",x));//לכתוב שאם המערך ריק או שלא נמצאת תחנה הבאה או שלא נמצאו עסקים 
		
			   
			   
			}
		}