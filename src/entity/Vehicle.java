package entity;

public class Vehicle {

	protected String codeVehicle;
	protected typeVehicle type;
	protected String LastParkingStop;
	/**
	 * @param codeVehicle
	 * @param type
	 * @param lastParkingStop
	 */
	public Vehicle(String codeVehicle, typeVehicle type, String lastParkingStop) {
		this.codeVehicle = codeVehicle;
		this.type = type;
		LastParkingStop = lastParkingStop;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LastParkingStop == null) ? 0 : LastParkingStop.hashCode());
		result = prime * result + ((codeVehicle == null) ? 0 : codeVehicle.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Vehicle other = (Vehicle) obj;
		if (LastParkingStop == null) {
			if (other.LastParkingStop != null)
				return false;
		} else if (!LastParkingStop.equals(other.LastParkingStop))
			return false;
		if (codeVehicle == null) {
			if (other.codeVehicle != null)
				return false;
		} else if (!codeVehicle.equals(other.codeVehicle))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	public String getCodeVehicle() {
		return codeVehicle;
	}
	public void setCodeVehicle(String codeVehicle) {
		this.codeVehicle = codeVehicle;
	}
	public typeVehicle getType() {
		return type;
	}
	public void setType(typeVehicle type) {
		this.type = type;
	}
	public String getLastParkingStop() {
		return LastParkingStop;
	}
	public void setLastParkingStop(String lastParkingStop) {
		LastParkingStop = lastParkingStop;
	}
	@Override
	public String toString() {
		return "Vehicle [codeVehicle=" + codeVehicle + ", type=" + type + ", LastParkingStop=" + LastParkingStop + "]";
	}
	
	
	
}
