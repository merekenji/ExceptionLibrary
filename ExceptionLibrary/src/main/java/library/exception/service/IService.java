package library.exception.service;

public interface IService {
	
	public void init(String path);
	public String execute(String projName, String modName, Exception exception);
	
}
