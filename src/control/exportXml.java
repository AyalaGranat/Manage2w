package control;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class exportXml {
	

		private static exportXml instance;
		
		private exportXml() {}
		
		public static exportXml getInstance() {
			if (instance == null)
				instance = new exportXml();
			return instance;
			
			
		}
		
		
		  public void exportParkingStopToXML() {
		        try {
		            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		            try (Connection conn = DriverManager.getConnection(entity.Consts.CONN_STR);
		                    PreparedStatement stmt = conn.prepareStatement(
		                            entity.Consts.SELECT_ALL_PARKINGSTOP);
		                    ResultSet rs = stmt.executeQuery()) {
		                
		                // create document object.
		                Document doc = DocumentBuilderFactory.newInstance()
		                        .newDocumentBuilder().newDocument();
		                
		                // push root element into document object.
		                Element rootElement = doc.createElement("ParkingStop_info");
		                rootElement.setAttribute("exportDate", LocalDateTime.now().toString());
		                doc.appendChild(rootElement);
		                
		                while (rs.next()) {     // parking stop on all customer records..
		                    // create parkingStop element.
		                    Element parkingStop = doc.createElement("ParkingStop");
		                    
		                    // assign key to customer.
		                    Attr attr = doc.createAttribute("ID");
		                    attr.setValue(rs.getString(1));
		                    parkingStop.setAttributeNode(attr);
		                    
		                    // push elements to customer.
		                    for (int i = 2; i <= rs.getMetaData().getColumnCount(); i++) {
		                        Element element = doc.createElement(
		                                rs.getMetaData().getColumnName(i)); // push element to doc.
		                        rs.getObject(i); // for wasNull() check..
		                        element.appendChild(doc.createTextNode(
		                                rs.wasNull() ? "" : rs.getString(i)));  // set element value.
		                        parkingStop.appendChild(element);  // push element to customer.
		                    }
		                    
		                    // push customer to document's root element.
		                    rootElement.appendChild(parkingStop);
		                }
		                
		                // write the content into xml file
		                
		                DOMSource source = new DOMSource(doc);
		                File file = new File("xml/parkingStop.xml");
		                file.getParentFile().mkdir(); // create xml folder if doesn't exist.
		                StreamResult result = new StreamResult(file);
		                TransformerFactory factory = TransformerFactory.newInstance();
		                
		                // IF CAUSES ISSUES, COMMENT THIS LINE.
		                factory.setAttribute("indent-number", 2);
		                //
		                
		                Transformer transformer = factory.newTransformer();
		                
		                // IF CAUSES ISSUES, COMMENT THESE 2 LINES.
		                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		                //
		                
		                transformer.transform(source, result);
		                
		                System.out.println("parkingStop data exported successfully!");
		            } catch (SQLException | NullPointerException | ParserConfigurationException
		                    | TransformerException e) {
		                e.printStackTrace();
		            }
		            
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		    }
		  
		  
		  public void exportVehicleToXML() {
		        try {
		            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		            try (Connection conn = DriverManager.getConnection(entity.Consts.CONN_STR);
		                    PreparedStatement stmt = conn.prepareStatement(
		                            entity.Consts.SELECT_ALL_VEHICLE);
		                    ResultSet rs = stmt.executeQuery()) {
		                
		                // create document object.
		                Document doc = DocumentBuilderFactory.newInstance()
		                        .newDocumentBuilder().newDocument();
		                
		                // push root element into document object.
		                Element rootElement = doc.createElement("Vehicle_info");
		                rootElement.setAttribute("exportDate", LocalDateTime.now().toString());
		                doc.appendChild(rootElement);
		                
		                while (rs.next()) {     // parking stop on all customer records..
		                    // create parkingStop element.
		                    Element parkingStop = doc.createElement("Vehicle");
		                    
		                    // assign key to customer.
		                    Attr attr = doc.createAttribute("ID");
		                    attr.setValue(rs.getString(1));
		                    parkingStop.setAttributeNode(attr);
		                    
		                    // push elements to customer.
		                    for (int i = 2; i <= rs.getMetaData().getColumnCount(); i++) {
		                        Element element = doc.createElement(
		                                rs.getMetaData().getColumnName(i)); // push element to doc.
		                        rs.getObject(i); // for wasNull() check..
		                        element.appendChild(doc.createTextNode(
		                                rs.wasNull() ? "" : rs.getString(i)));  // set element value.
		                        parkingStop.appendChild(element);  // push element to customer.
		                    }
		                    
		                    // push customer to document's root element.
		                    rootElement.appendChild(parkingStop);
		                }
		                
		                // write the content into xml file
		                
		                DOMSource source = new DOMSource(doc);
		                File file = new File("xml/Vehicle.xml");
		                file.getParentFile().mkdir(); // create xml folder if doesn't exist.
		                StreamResult result = new StreamResult(file);
		                TransformerFactory factory = TransformerFactory.newInstance();
		                
		                // IF CAUSES ISSUES, COMMENT THIS LINE.
		                factory.setAttribute("indent-number", 2);
		                //
		                
		                Transformer transformer = factory.newTransformer();
		                
		                // IF CAUSES ISSUES, COMMENT THESE 2 LINES.
		                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		                //
		                
		                transformer.transform(source, result);
		                
		                System.out.println("Vehicle data exported successfully!");
		            } catch (SQLException | NullPointerException | ParserConfigurationException
		                    | TransformerException e) {
		                e.printStackTrace();
		            }
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		    }
		  public void exportElectricVehicleToXML() {
		        try {
		            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		            try (Connection conn = DriverManager.getConnection(entity.Consts.CONN_STR);
		                    PreparedStatement stmt = conn.prepareStatement(
		                            entity.Consts.SELECT_ALL_ELECTRIC_VEHICLE);
		                    ResultSet rs = stmt.executeQuery()) {
		                
		                // create document object.
		                Document doc = DocumentBuilderFactory.newInstance()
		                        .newDocumentBuilder().newDocument();
		                
		                // push root element into document object.
		                Element rootElement = doc.createElement("ElectricVehicle_info");
		                rootElement.setAttribute("exportDate", LocalDateTime.now().toString());
		                doc.appendChild(rootElement);
		                
		                while (rs.next()) {     // parking stop on all customer records..
		                    // create parkingStop element.
		                    Element ElectricVehicle = doc.createElement("ElectricVehicle");
		                    
		                    // assign key to customer.
		                    Attr attr = doc.createAttribute("ID");
		                    attr.setValue(rs.getString(1));
		                    ElectricVehicle.setAttributeNode(attr);
		                    
		                    // push elements to customer.
		                    for (int i = 2; i <= rs.getMetaData().getColumnCount(); i++) {
		                        Element element = doc.createElement(
		                                rs.getMetaData().getColumnName(i)); // push element to doc.
		                        rs.getObject(i); // for wasNull() check..
		                        element.appendChild(doc.createTextNode(
		                                rs.wasNull() ? "" : rs.getString(i)));  // set element value.
		                        ElectricVehicle.appendChild(element);  // push element to customer.
		                    }
		                    
		                    // push customer to document's root element.
		                    rootElement.appendChild(ElectricVehicle);
		                }
		                
		                // write the content into xml file
		                
		                DOMSource source = new DOMSource(doc);
		                File file = new File("xml/ElectricVehicle.xml");
		                file.getParentFile().mkdir(); // create xml folder if doesn't exist.
		                StreamResult result = new StreamResult(file);
		                TransformerFactory factory = TransformerFactory.newInstance();
		                
		                // IF CAUSES ISSUES, COMMENT THIS LINE.
		                factory.setAttribute("indent-number", 2);
		                //
		                
		                Transformer transformer = factory.newTransformer();
		                
		                // IF CAUSES ISSUES, COMMENT THESE 2 LINES.
		                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		                //
		                
		                transformer.transform(source, result);
		                
		                System.out.println("ElectricVehicle data exported successfully!");
		            } catch (SQLException | NullPointerException | ParserConfigurationException
		                    | TransformerException e) {
		                e.printStackTrace();
		            }
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		    }

}
