package entity;

public class Business {

	protected String codeBusiness;
	protected String nameBusiness;
	protected String city;
	protected String streetString;
	protected String houseNumber;
	protected String ImageBu;
	protected String DescriptionBu;
	/**
	 * @param codeBusiness
	 * @param nameBusiness
	 * @param city
	 * @param streetString
	 * @param houseNumber
	 * @param imageBu
	 * @param descriptionBu
	 */
	public Business(String codeBusiness, String nameBusiness, String city, String streetString, String houseNumber,
			String imageBu, String descriptionBu) {
		this.codeBusiness = codeBusiness;
		this.nameBusiness = nameBusiness;
		this.city = city;
		this.streetString = streetString;
		this.houseNumber = houseNumber;
		ImageBu = imageBu;
		DescriptionBu = descriptionBu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DescriptionBu == null) ? 0 : DescriptionBu.hashCode());
		result = prime * result + ((ImageBu == null) ? 0 : ImageBu.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((codeBusiness == null) ? 0 : codeBusiness.hashCode());
		result = prime * result + ((houseNumber == null) ? 0 : houseNumber.hashCode());
		result = prime * result + ((nameBusiness == null) ? 0 : nameBusiness.hashCode());
		result = prime * result + ((streetString == null) ? 0 : streetString.hashCode());
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
		Business other = (Business) obj;
		if (DescriptionBu == null) {
			if (other.DescriptionBu != null)
				return false;
		} else if (!DescriptionBu.equals(other.DescriptionBu))
			return false;
		if (ImageBu == null) {
			if (other.ImageBu != null)
				return false;
		} else if (!ImageBu.equals(other.ImageBu))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (codeBusiness == null) {
			if (other.codeBusiness != null)
				return false;
		} else if (!codeBusiness.equals(other.codeBusiness))
			return false;
		if (houseNumber == null) {
			if (other.houseNumber != null)
				return false;
		} else if (!houseNumber.equals(other.houseNumber))
			return false;
		if (nameBusiness == null) {
			if (other.nameBusiness != null)
				return false;
		} else if (!nameBusiness.equals(other.nameBusiness))
			return false;
		if (streetString == null) {
			if (other.streetString != null)
				return false;
		} else if (!streetString.equals(other.streetString))
			return false;
		return true;
	}
	public String getCodeBusiness() {
		return codeBusiness;
	}
	public void setCodeBusiness(String codeBusiness) {
		this.codeBusiness = codeBusiness;
	}
	public String getNameBusiness() {
		return nameBusiness;
	}
	public void setNameBusiness(String nameBusiness) {
		this.nameBusiness = nameBusiness;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreetString() {
		return streetString;
	}
	public void setStreetString(String streetString) {
		this.streetString = streetString;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getImageBu() {
		return ImageBu;
	}
	public void setImageBu(String imageBu) {
		ImageBu = imageBu;
	}
	public String getDescriptionBu() {
		return DescriptionBu;
	}
	public void setDescriptionBu(String descriptionBu) {
		DescriptionBu = descriptionBu;
	}
	@Override
	public String toString() {
		return  " nameBusiness:" + nameBusiness + "\n  city=" + city
				+ "\n  street: " + streetString + "\n  house Number: " + houseNumber
				+ "\n  Description: " + DescriptionBu + "";
	}
	
	
	
	
}

