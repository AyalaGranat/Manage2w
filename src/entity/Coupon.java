package entity;

import java.sql.Date;

public class Coupon {

	private String codeBusiness;
	private String codeCoupon;
	private String DescriptionCou;
	private Date startDateCou;
	private Date endDateCou;
	
	
	/**
	 * @param codeBusiness
	 * @param codeCoupon
	 * @param descriptionCou
	 * @param startDateCou
	 * @param endDateCou
	 */
	public Coupon(String codeBusiness, String codeCoupon, String descriptionCou, Date startDateCou, Date endDateCou) {
		this.codeBusiness = codeBusiness;
		this.codeCoupon = codeCoupon;
		DescriptionCou = descriptionCou;
		this.startDateCou = startDateCou;
		this.endDateCou = endDateCou;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DescriptionCou == null) ? 0 : DescriptionCou.hashCode());
		result = prime * result + ((codeBusiness == null) ? 0 : codeBusiness.hashCode());
		result = prime * result + ((codeCoupon == null) ? 0 : codeCoupon.hashCode());
		result = prime * result + ((endDateCou == null) ? 0 : endDateCou.hashCode());
		result = prime * result + ((startDateCou == null) ? 0 : startDateCou.hashCode());
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
		Coupon other = (Coupon) obj;
		if (DescriptionCou == null) {
			if (other.DescriptionCou != null)
				return false;
		} else if (!DescriptionCou.equals(other.DescriptionCou))
			return false;
		if (codeBusiness == null) {
			if (other.codeBusiness != null)
				return false;
		} else if (!codeBusiness.equals(other.codeBusiness))
			return false;
		if (codeCoupon == null) {
			if (other.codeCoupon != null)
				return false;
		} else if (!codeCoupon.equals(other.codeCoupon))
			return false;
		if (endDateCou == null) {
			if (other.endDateCou != null)
				return false;
		} else if (!endDateCou.equals(other.endDateCou))
			return false;
		if (startDateCou == null) {
			if (other.startDateCou != null)
				return false;
		} else if (!startDateCou.equals(other.startDateCou))
			return false;
		return true;
	}
	public String getCodeBusiness() {
		return codeBusiness;
	}
	public void setCodeBusiness(String codeBusiness) {
		this.codeBusiness = codeBusiness;
	}
	public String getCodeCoupon() {
		return codeCoupon;
	}
	public void setCodeCoupon(String codeCoupon) {
		this.codeCoupon = codeCoupon;
	}
	public String getDescriptionCou() {
		return DescriptionCou;
	}
	public void setDescriptionCou(String descriptionCou) {
		DescriptionCou = descriptionCou;
	}
	public Date getStartDateCou() {
		return startDateCou;
	}
	public void setStartDateCou(Date startDateCou) {
		this.startDateCou = startDateCou;
	}
	public Date getEndDateCou() {
		return endDateCou;
	}
	public void setEndDateCou(Date endDateCou) {
		this.endDateCou = endDateCou;
	}
	@Override
	public String toString() {
		return " code Coupon=" + codeCoupon + ", Description="
				+ DescriptionCou + ", Start Date=" + startDateCou + ", End Date=" + endDateCou + "]";
	}
	
	
	
}
