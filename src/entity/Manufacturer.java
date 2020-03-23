package entity;

public class Manufacturer {
	
	private String codeManufacturer;
	private String fNameManufacturer;
	private String lNameManufacturer;
	private String telManufacturer;
	private String emailManufacturer;
	/**
	 * @param codeManufacturer
	 * @param fNameManufacturer
	 * @param lNameManufacturer
	 * @param telManufacturer
	 * @param emailManufacturer
	 */
	public Manufacturer(String codeManufacturer, String fNameManufacturer, String lNameManufacturer,
			String telManufacturer, String emailManufacturer) {
		this.codeManufacturer = codeManufacturer;
		this.fNameManufacturer = fNameManufacturer;
		this.lNameManufacturer = lNameManufacturer;
		this.telManufacturer = telManufacturer;
		this.emailManufacturer = emailManufacturer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeManufacturer == null) ? 0 : codeManufacturer.hashCode());
		result = prime * result + ((emailManufacturer == null) ? 0 : emailManufacturer.hashCode());
		result = prime * result + ((fNameManufacturer == null) ? 0 : fNameManufacturer.hashCode());
		result = prime * result + ((lNameManufacturer == null) ? 0 : lNameManufacturer.hashCode());
		result = prime * result + ((telManufacturer == null) ? 0 : telManufacturer.hashCode());
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
		Manufacturer other = (Manufacturer) obj;
		if (codeManufacturer == null) {
			if (other.codeManufacturer != null)
				return false;
		} else if (!codeManufacturer.equals(other.codeManufacturer))
			return false;
		if (emailManufacturer == null) {
			if (other.emailManufacturer != null)
				return false;
		} else if (!emailManufacturer.equals(other.emailManufacturer))
			return false;
		if (fNameManufacturer == null) {
			if (other.fNameManufacturer != null)
				return false;
		} else if (!fNameManufacturer.equals(other.fNameManufacturer))
			return false;
		if (lNameManufacturer == null) {
			if (other.lNameManufacturer != null)
				return false;
		} else if (!lNameManufacturer.equals(other.lNameManufacturer))
			return false;
		if (telManufacturer == null) {
			if (other.telManufacturer != null)
				return false;
		} else if (!telManufacturer.equals(other.telManufacturer))
			return false;
		return true;
	}
	public String getCodeManufacturer() {
		return codeManufacturer;
	}
	public void setCodeManufacturer(String codeManufacturer) {
		this.codeManufacturer = codeManufacturer;
	}
	public String getfNameManufacturer() {
		return fNameManufacturer;
	}
	public void setfNameManufacturer(String fNameManufacturer) {
		this.fNameManufacturer = fNameManufacturer;
	}
	public String getlNameManufacturer() {
		return lNameManufacturer;
	}
	public void setlNameManufacturer(String lNameManufacturer) {
		this.lNameManufacturer = lNameManufacturer;
	}
	public String getTelManufacturer() {
		return telManufacturer;
	}
	public void setTelManufacturer(String telManufacturer) {
		this.telManufacturer = telManufacturer;
	}
	public String getEmailManufacturer() {
		return emailManufacturer;
	}
	public void setEmailManufacturer(String emailManufacturer) {
		this.emailManufacturer = emailManufacturer;
	}
	@Override
	public String toString() {
		return "Manufacturer [codeManufacturer=" + codeManufacturer + ", fNameManufacturer=" + fNameManufacturer
				+ ", lNameManufacturer=" + lNameManufacturer + ", telManufacturer=" + telManufacturer
				+ ", emailManufacturer=" + emailManufacturer + "]";
	}
	
	
	

}
