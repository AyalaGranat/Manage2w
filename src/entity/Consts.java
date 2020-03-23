package entity;
import java.net.URLDecoder;

/**
 * http://www.javapractices.com/topic/TopicAction.do?Id=2
 */
public final class Consts {
	private Consts() {
		throw new AssertionError();
	}

	protected static final String DB_FILEPATH = getDBPath();
	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH + ";COLUMNORDER=DISPLAY";
	
	
	/*--------------------------------------------------------------*/	
	
	public static final String SQL_SEL_GET_PATH_BY_CITY_AND_LEVEL="SELECT Path.CodePath, Path.Level, Path.PathLenght\r\n" + 
	"FROM Path INNER JOIN (ParkingStop INNER JOIN ParkingStopInPath ON ParkingStop.CodeParkingStop = ParkingStopInPath.CodeParkingStop) ON Path.CodePath = ParkingStopInPath.CodePath\r\n" + 
	"GROUP BY Path.CodePath, Path.Level, ParkingStop.City\r\n" + 
	"HAVING (((Path.Level)=?) AND ((ParkingStop.City)=?))"
	+ "ORDER BY Path.CodePath;\r\n";
	
	public static final String SQL_SEL_GET_PATH_BY_CITY_AND_LABEL="SELECT Path.CodePath, Path.Level, Path.PathLenght\r\n" + 
	"FROM (Business INNER JOIN ((ParkingStop INNER JOIN (Path INNER JOIN ParkingStopInPath ON Path.CodePath = ParkingStopInPath.CodePath) ON ParkingStop.CodeParkingStop = ParkingStopInPath.CodeParkingStop) INNER JOIN businessInPath ON (ParkingStopInPath.CodeParkingStop = businessInPath.CodeParkingStop) AND (ParkingStopInPath.CodePath = businessInPath.CodePath)) ON Business.CodeBusiness = businessInPath.CodeBusiness) INNER JOIN (HealthBusiness INNER JOIN LabelInHealthBusiness ON HealthBusiness.CodeBusiness = LabelInHealthBusiness.CodeBusiness) ON Business.CodeBusiness = HealthBusiness.CodeBusiness\r\n" + 
	"GROUP BY Path.CodePath, ParkingStop.City, LabelInHealthBusiness.NameLabel, Path.Level, Path.PathLenght\r\n" + 
	"HAVING (((ParkingStop.City)=?) AND ((LabelInHealthBusiness.NameLabel)=?))\r\n" + 
	"ORDER BY Path.Level, Path.PathLenght;\r\n" + 
	"";
/*GET */
	public static final String GET_CITIES = "SELECT ParkingStop.City\r\n" + 
			"FROM ParkingStop GROUP BY ParkingStop.City";
			
	public static final String GET_LABEL = "SELECT Label.NameLabel, Label.Color\r\n" + 
			"FROM Label;\r\n" + 
			"";

	public static final String GET_PARKINGSTOP_IN_PATH ="SELECT ParkingStop.CodeParkingStop, ParkingStop.City, ParkingStop.Street, ParkingStop.CorX, ParkingStop.CorY, ParkingStop.CapacityVehicle\r\n" + 
	"FROM ParkingStop INNER JOIN (Path INNER JOIN ParkingStopInPath ON Path.CodePath = ParkingStopInPath.CodePath) ON ParkingStop.CodeParkingStop = ParkingStopInPath.CodeParkingStop\r\n" + 
	"WHERE (((Path.CodePath)=?));\r\n" + 
	"";
	
	public static final String GET_ORDER_PARKINGSTOP_IN_PATH ="SELECT ParkingStopInPath.OrderPSInPath\r\n" + 
	"FROM ParkingStop INNER JOIN (Path INNER JOIN ParkingStopInPath ON Path.CodePath = ParkingStopInPath.CodePath) ON ParkingStop.CodeParkingStop = ParkingStopInPath.CodeParkingStop\r\n" + 
	"GROUP BY Path.CodePath, ParkingStop.CodeParkingStop, ParkingStopInPath.OrderPSInPath\r\n" + 
	"HAVING (((Path.CodePath)=?) AND ((ParkingStop.CodeParkingStop)=?));\r\n" + 
	"";
	
	
	public static final String GET_BUSSINES_IN_PS="SELECT Business.CodeBusiness, Business.NameBusiness, Business.City, Business.Street, Business.HouseNumber,Business.ImageBu, Business.DescriptionBu, ParkingStopInPath.CodeParkingStop\r\n" + 
	"FROM ParkingStopInPath INNER JOIN (Business INNER JOIN businessInPath ON Business.CodeBusiness = businessInPath.CodeBusiness) ON (ParkingStopInPath.CodeParkingStop = businessInPath.CodeParkingStop) AND (ParkingStopInPath.CodePath = businessInPath.CodePath)\r\n" + 
	"WHERE (((businessInPath.CodePath)=?) AND ((ParkingStopInPath.OrderPSInPath)=?));\r\n" + 
	"";
	

	public static final String GET_VIDEO_COPUNS_BY_BUSSINESS ="SELECT VIPBusiness.CodeBusiness, Business.NameBusiness, Business.City, Business.Street, Business.HouseNumber, Business.ImageBu, Business.DescriptionBu, VIPBusiness.Video, Coupon.CodeCoupon, Coupon.DescriptionCou, Coupon.StartDateCou, Coupon.EndDateCou\r\n" + 
			"FROM Business INNER JOIN (VIPBusiness INNER JOIN Coupon ON VIPBusiness.CodeBusiness = Coupon.CodeBusiness) ON Business.CodeBusiness = VIPBusiness.CodeBusiness\r\n" + 
			"WHERE (((VIPBusiness.CodeBusiness)=?));";

		
	public static final String GET_VIDEO_LABEL_BY_HEALTH_BUSSINESS ="SELECT Business.CodeBusiness, Business.NameBusiness, Business.City, Business.Street, Business.HouseNumber, Business.ImageBu, Business.DescriptionBu, HealthBusiness.Type, Label.NameLabel, Label.Color\r\n" + 
			"FROM Label INNER JOIN ((Business INNER JOIN HealthBusiness ON Business.CodeBusiness = HealthBusiness.CodeBusiness) INNER JOIN LabelInHealthBusiness ON HealthBusiness.CodeBusiness = LabelInHealthBusiness.CodeBusiness) ON Label.NameLabel = LabelInHealthBusiness.NameLabel\r\n" + 
			"WHERE (((Business.CodeBusiness)=?));\r\n" + 
			"";
	
	
	
			/**
	 * find the correct path of the DB file
     * @return the path of the DB file (from eclipse or with runnable file)
	 */
	private static String getDBPath() {
		try {
			String path = Consts.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			String decoded = URLDecoder.decode(path, "UTF-8");
			// System.out.println(decoded) - Can help to check the returned path
			if (decoded.contains(".jar")) {
				decoded = decoded.substring(0, decoded.lastIndexOf('/'));
				System.out.println(decoded);
				return decoded + "/database/Manage2W.accdb";
			} else {
				decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
				return decoded + "src/entity/Manage2W.accdb";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}