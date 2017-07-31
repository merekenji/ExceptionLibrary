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
	
}
