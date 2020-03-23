package entity;

public class Path {
	
	private String CodePath;
	private Level level;
	private Integer lenghtPath;
	

	
	/**
	 * @param codePath
	 * @param level
	 * @param lenghtPath
	 */
	public Path(String codePath, Level level, Integer lenghtPath) {
		CodePath = codePath;
		this.level = level;
		this.lenghtPath = lenghtPath;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CodePath == null) ? 0 : CodePath.hashCode());
		result = prime * result + ((lenghtPath == null) ? 0 : lenghtPath.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
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
		Path other = (Path) obj;
		if (CodePath == null) {
			if (other.CodePath != null)
				return false;
		} else if (!CodePath.equals(other.CodePath))
			return false;
		if (lenghtPath == null) {
			if (other.lenghtPath != null)
				return false;
		} else if (!lenghtPath.equals(other.lenghtPath))
			return false;
		if (level != other.level)
			return false;
		return true;
	}



	public String getCodePath() {
		return CodePath;
	}



	public void setCodePath(String codePath) {
		CodePath = codePath;
	}



	public Level getLevel() {
		return level;
	}



	public void setLevel(Level level) {
		this.level = level;
	}



	public Integer getLenghtPath() {
		return lenghtPath;
	}



	public void setLenghtPath(Integer lenghtPath) {
		this.lenghtPath = lenghtPath;
	}



	@Override
	public String toString() {
		return "CodePath: " + CodePath + " || level: " + level + " || lenghtPath: " + lenghtPath;
	}



	
}
