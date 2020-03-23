package entity;

public class VIPBusiness extends Business {
	
	private String video;

	/**
	 * @param codeBusiness
	 * @param nameBusiness
	 * @param city
	 * @param streetString
	 * @param houseNumber
	 * @param imageBu
	 * @param descriptionBu
	 * @param video
	 */
	public VIPBusiness(String codeBusiness, String nameBusiness, String city, String streetString, String houseNumber,
			String imageBu, String descriptionBu, String video) {
		super(codeBusiness, nameBusiness, city, streetString, houseNumber, imageBu, descriptionBu);
		this.video = video;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((video == null) ? 0 : video.hashCode());
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
		VIPBusiness other = (VIPBusiness) obj;
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		return true;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "VIPBusiness [codeBusiness=" + codeBusiness + ", video=" + video + ", nameBusiness=" + nameBusiness
				+ ", city=" + city + ", streetString=" + streetString + ", houseNumber=" + houseNumber + ", ImageBu="
				+ ImageBu + ", DescriptionBu=" + DescriptionBu + "]";
	}

	
	
	
	
	
	
	
	

}
