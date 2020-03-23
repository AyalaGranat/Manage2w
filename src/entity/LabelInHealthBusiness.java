package entity;

public class LabelInHealthBusiness {
	private String CodeBusiness;
	private String nameLabel;
	/**
	 * @param codeBusiness
	 * @param nameLabel
	 */
	public LabelInHealthBusiness(String codeBusiness, String nameLabel) {
		CodeBusiness = codeBusiness;
		this.nameLabel = nameLabel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CodeBusiness == null) ? 0 : CodeBusiness.hashCode());
		result = prime * result + ((nameLabel == null) ? 0 : nameLabel.hashCode());
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
		LabelInHealthBusiness other = (LabelInHealthBusiness) obj;
		if (CodeBusiness == null) {
			if (other.CodeBusiness != null)
				return false;
		} else if (!CodeBusiness.equals(other.CodeBusiness))
			return false;
		if (nameLabel == null) {
			if (other.nameLabel != null)
				return false;
		} else if (!nameLabel.equals(other.nameLabel))
			return false;
		return true;
	}
	public String getCodeBusiness() {
		return CodeBusiness;
	}
	public void setCodeBusiness(String codeBusiness) {
		CodeBusiness = codeBusiness;
	}
	public String getNameLabel() {
		return nameLabel;
	}
	public void setNameLabel(String nameLabel) {
		this.nameLabel = nameLabel;
	}
	@Override
	public String toString() {
		return "LabelInHealthBusiness [CodeBusiness=" + CodeBusiness + ", nameLabel=" + nameLabel + "]";
	} 
	
	

}
