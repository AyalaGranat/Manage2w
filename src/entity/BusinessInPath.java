package entity;

public class BusinessInPath {

	private String codeParkingStop;
	private String codePath;
	private String codeBusiness;
	/**
	 * @param codeParkingStop
	 * @param codePath
	 * @param codeBusiness
	 */
	public BusinessInPath(String codeParkingStop, String codePath, String codeBusiness) {
		this.codeParkingStop = codeParkingStop;
		this.codePath = codePath;
		this.codeBusiness = codeBusiness;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeBusiness == null) ? 0 : codeBusiness.hashCode());
		result = prime * result + ((codeParkingStop == null) ? 0 : codeParkingStop.hashCode());
		result = prime * result + ((codePath == null) ? 0 : codePath.hashCode());
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
		BusinessInPath other = (BusinessInPath) obj;
		if (codeBusiness == null) {
			if (other.codeBusiness != null)
				return false;
		} else if (!codeBusiness.equals(other.codeBusiness))
			return false;
		if (codeParkingStop == null) {
			if (other.codeParkingStop != null)
				return false;
		} else if (!codeParkingStop.equals(other.codeParkingStop))
			return false;
		if (codePath == null) {
			if (other.codePath != null)
				return false;
		} else if (!codePath.equals(other.codePath))
			return false;
		return true;
	}
	public String getCodeParkingStop() {
		return codeParkingStop;
	}
	public void setCodeParkingStop(String codeParkingStop) {
		this.codeParkingStop = codeParkingStop;
	}
	public String getCodePath() {
		return codePath;
	}
	public void setCodePath(String codePath) {
		this.codePath = codePath;
	}
	public String getCodeBusiness() {
		return codeBusiness;
	}
	public void setCodeBusiness(String codeBusiness) {
		this.codeBusiness = codeBusiness;
	}
	@Override
	public String toString() {
		return "BusinessInPath [codeParkingStop=" + codeParkingStop + ", codePath=" + codePath + ", codeBusiness="
				+ codeBusiness + "]";
	}
	
	
	
}
