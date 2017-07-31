package library.exception.beans;

public class LibException {
	
	private String projectName;
	private String moduleName;
	private String exceptionName;
	
	public LibException(String pName, String mName, String eName) {
		projectName = pName;
		moduleName = mName;
		exceptionName = eName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getExceptionName() {
		return exceptionName;
	}

	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}
	
	@Override
	public boolean equals(Object o) {
		if(((LibException)o) == null || ((LibException)o).getExceptionName() == null) {
			throw new NullPointerException();
		}
		return ((LibException)o).getExceptionName().equals(this.exceptionName);
	}
	@Override
	public int hashCode() {
		String name = projectName + moduleName + exceptionName;
		return name.hashCode();
	}
}
