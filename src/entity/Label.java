package entity;

public class Label {

	
	private String nameLabel;
	private String color;
	/**
	 * @param nameLabel
	 * @param color
	 */
	public Label(String nameLabel, String color) {
		this.nameLabel = nameLabel;
		this.color = color;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
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
		Label other = (Label) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (nameLabel == null) {
			if (other.nameLabel != null)
				return false;
		} else if (!nameLabel.equals(other.nameLabel))
			return false;
		return true;
	}
	public String getNameLabel() {
		return nameLabel;
	}
	public void setNameLabel(String nameLabel) {
		this.nameLabel = nameLabel;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return " Name Label=" + nameLabel + " Color=" + color + "";
	}
	
	
}
