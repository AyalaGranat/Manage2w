package entity;

public class nextParkingStop {
	private String codeParkingStop;
	private String nextParkingStop;
	private String distanceFromNextPS;
	/**
	 * @param codeParkingStop
	 * @param nextParkingStop
	 * @param distanceFromNextPS
	 */
	public nextParkingStop(String codeParkingStop, String nextParkingStop, String distanceFromNextPS) {
		this.codeParkingStop = codeParkingStop;
		this.nextParkingStop = nextParkingStop;
		this.distanceFromNextPS = distanceFromNextPS;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeParkingStop == null) ? 0 : codeParkingStop.hashCode());
		result = prime * result + ((distanceFromNextPS == null) ? 0 : distanceFromNextPS.hashCode());
		result = prime * result + ((nextParkingStop == null) ? 0 : nextParkingStop.hashCode());
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
		nextParkingStop other = (nextParkingStop) obj;
		if (codeParkingStop == null) {
			if (other.codeParkingStop != null)
				return false;
		} else if (!codeParkingStop.equals(other.codeParkingStop))
			return false;
		if (distanceFromNextPS == null) {
			if (other.distanceFromNextPS != null)
				return false;
		} else if (!distanceFromNextPS.equals(other.distanceFromNextPS))
			return false;
		if (nextParkingStop == null) {
			if (other.nextParkingStop != null)
				return false;
		} else if (!nextParkingStop.equals(other.nextParkingStop))
			return false;
		return true;
	}
	public String getCodeParkingStop() {
		return codeParkingStop;
	}
	public void setCodeParkingStop(String codeParkingStop) {
		this.codeParkingStop = codeParkingStop;
	}
	public String getNextParkingStop() {
		return nextParkingStop;
	}
	public void setNextParkingStop(String nextParkingStop) {
		this.nextParkingStop = nextParkingStop;
	}
	public String getDistanceFromNextPS() {
		return distanceFromNextPS;
	}
	public void setDistanceFromNextPS(String distanceFromNextPS) {
		this.distanceFromNextPS = distanceFromNextPS;
	}
	@Override
	public String toString() {
		return "nextParkingStop [codeParkingStop=" + codeParkingStop + ", nextParkingStop=" + nextParkingStop
				+ ", distanceFromNextPS=" + distanceFromNextPS + "]";
	}
	
	
	

}
