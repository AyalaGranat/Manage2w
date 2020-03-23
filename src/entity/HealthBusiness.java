package entity;

public class HealthBusiness extends Business{
	
	private String type;

	

	/**
	 * @param codeBusiness
	 * @param nameBusiness
	 * @param city
	 * @param streetString
	 * @param houseNumber
	 * @param imageBu
	 * @param descriptionBu
	 * @param type
	 */
	public HealthBusiness(String codeBusiness, String nameBusiness, String city, String streetString,
			String houseNumber, String imageBu, String descriptionBu, String type) {
		super(codeBusiness, nameBusiness, city, streetString, houseNumber, imageBu, descriptionBu);
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		HealthBusiness other = (HealthBusiness) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		type = type;
	}

	@Override
	public String toString() {
		return "HealthBusiness [Type=" + type + ", codeBusiness=" + codeBusiness + ", nameBusiness=" + nameBusiness
				+ ", city=" + city + ", streetString=" + streetString + ", houseNumber=" + houseNumber + ", ImageBu="
				+ ImageBu + ", DescriptionBu=" + DescriptionBu + "]";
	}


	
	

}
