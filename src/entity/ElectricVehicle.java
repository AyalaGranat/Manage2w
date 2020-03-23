package entity;

import java.sql.Date;

public class ElectricVehicle extends Vehicle{

	 Date DateOfPro;
	 String codeBattery;
	 String codeManufacturer;
	
	/**
	 * @param codeVehicle
	 * @param type
	 * @param lastParkingStop
	 * @param dateOfPro
	 * @param codeBattery
	 * @param codeManufacturer
	 */
	public ElectricVehicle(String codeVehicle, typeVehicle type, String lastParkingStop, Date dateOfPro,
			String codeBattery, String codeManufacturer) {
		super(codeVehicle, type, lastParkingStop);
		DateOfPro = dateOfPro;
		this.codeBattery = codeBattery;
		this.codeManufacturer = codeManufacturer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((DateOfPro == null) ? 0 : DateOfPro.hashCode());
		result = prime * result + ((codeBattery == null) ? 0 : codeBattery.hashCode());
		result = prime * result + ((codeManufacturer == null) ? 0 : codeManufacturer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElectricVehicle other = (ElectricVehicle) obj;
		if (DateOfPro == null) {
			if (other.DateOfPro != null)
				return false;
		} else if (!DateOfPro.equals(other.DateOfPro))
			return false;
		if (codeBattery == null) {
			if (other.codeBattery != null)
				return false;
		} else if (!codeBattery.equals(other.codeBattery))
			return false;
		if (codeManufacturer == null) {
			if (other.codeManufacturer != null)
				return false;
		} else if (!codeManufacturer.equals(other.codeManufacturer))
			return false;
		return true;
	}

	public Date getDateOfPro() {
		return DateOfPro;
	}

	public void setDateOfPro(Date dateOfPro) {
		DateOfPro = dateOfPro;
	}

	public String getCodeBattery() {
		return codeBattery;
	}

	public void setCodeBattery(String codeBattery) {
		this.codeBattery = codeBattery;
	}

	public String getCodeManufacturer() {
		return codeManufacturer;
	}

	public void setCodeManufacturer(String codeManufacturer) {
		this.codeManufacturer = codeManufacturer;
	}

	@Override
	public String toString() {
		return "ElectricVehicle [DateOfPro=" + DateOfPro + ", codeBattery=" + codeBattery + ", codeManufacturer="
				+ codeManufacturer + ", codeVehicle=" + codeVehicle + ", type=" + type + ", LastParkingStop="
				+ LastParkingStop + "]";
	}
	

	
	 

	
	
	
}
