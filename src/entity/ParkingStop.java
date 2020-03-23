package entity;

public class ParkingStop {
 
	private String codeParkingStopString;
	private String city;
	private String street;
	private Double corx;
	private Double cory;
	private int capacityVehicle;
	/**
	 * @param codeParkingStopString
	 * @param city
	 * @param street
	 * @param corx
	 * @param cory
	 * @param capacityVehicle
	 */
	public ParkingStop(String codeParkingStopString, String city, String street, Double corx, Double cory,
			int capacityVehicle) {
		this.codeParkingStopString = codeParkingStopString;
		this.city = city;
		this.street = street;
		this.corx = corx;
		this.cory = cory;
		this.capacityVehicle = capacityVehicle;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacityVehicle;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((codeParkingStopString == null) ? 0 : codeParkingStopString.hashCode());
		result = prime * result + ((corx == null) ? 0 : corx.hashCode());
		result = prime * result + ((cory == null) ? 0 : cory.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingStop other = (ParkingStop) obj;
		if (capacityVehicle != other.capacityVehicle)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (codeParkingStopString == null) {
			if (other.codeParkingStopString != null)
				return false;
		} else if (!codeParkingStopString.equals(other.codeParkingStopString))
			return false;
		if (corx == null) {
			if (other.corx != null)
				return false;
		} else if (!corx.equals(other.corx))
			return false;
		if (cory == null) {
			if (other.cory != null)
				return false;
		} else if (!cory.equals(other.cory))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	public String getCodeParkingStopString() {
		return codeParkingStopString;
	}
	public void setCodeParkingStopString(String codeParkingStopString) {
		this.codeParkingStopString = codeParkingStopString;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Double getCorx() {
		return corx;
	}
	public void setCorx(Double corx) {
		this.corx = corx;
	}
	public Double getCory() {
		return cory;
	}
	public void setCory(Double cory) {
		this.cory = cory;
	}
	public int getCapacityVehicle() {
		return capacityVehicle;
	}
	public void setCapacityVehicle(int capacityVehicle) {
		this.capacityVehicle = capacityVehicle;
	}
	@Override
	public String toString() {
		return "Number of Parking Stop=" + codeParkingStopString + " || city=" + city + " || street=" + street
				+ " || corx=" + corx + " || cory=" + cory + " || capacityVehicle=" + capacityVehicle + "";
	}
	
	
	
	

	
	
}
