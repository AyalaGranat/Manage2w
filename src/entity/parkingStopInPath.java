package entity;

public class parkingStopInPath {

	private String CodePath;
	private String CodeParkingStop;
	private Integer OrderPSInPath;
	/**
	 * @param codePath
	 * @param codeParkingStop
	 * @param orderPSInPath
	 */
	public parkingStopInPath(String codePath, String codeParkingStop, Integer orderPSInPath) {
		CodePath = codePath;
		CodeParkingStop = codeParkingStop;
		OrderPSInPath = orderPSInPath;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CodeParkingStop == null) ? 0 : CodeParkingStop.hashCode());
		result = prime * result + ((CodePath == null) ? 0 : CodePath.hashCode());
		result = prime * result + ((OrderPSInPath == null) ? 0 : OrderPSInPath.hashCode());
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
		parkingStopInPath other = (parkingStopInPath) obj;
		if (CodeParkingStop == null) {
			if (other.CodeParkingStop != null)
				return false;
		} else if (!CodeParkingStop.equals(other.CodeParkingStop))
			return false;
		if (CodePath == null) {
			if (other.CodePath != null)
				return false;
		} else if (!CodePath.equals(other.CodePath))
			return false;
		if (OrderPSInPath == null) {
			if (other.OrderPSInPath != null)
				return false;
		} else if (!OrderPSInPath.equals(other.OrderPSInPath))
			return false;
		return true;
	}
	public String getCodePath() {
		return CodePath;
	}
	public void setCodePath(String codePath) {
		CodePath = codePath;
	}
	public String getCodeParkingStop() {
		return CodeParkingStop;
	}
	public void setCodeParkingStop(String codeParkingStop) {
		CodeParkingStop = codeParkingStop;
	}
	public Integer getOrderPSInPath() {
		return OrderPSInPath;
	}
	public void setOrderPSInPath(Integer orderPSInPath) {
		OrderPSInPath = orderPSInPath;
	}
	@Override
	public String toString() {
		return "parkingStopInPath [CodePath=" + CodePath + ", CodeParkingStop=" + CodeParkingStop + ", OrderPSInPath="
				+ OrderPSInPath + "]";
	}
	
	
	
	
}
