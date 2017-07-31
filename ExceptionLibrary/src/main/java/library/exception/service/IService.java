package library.exception.service;

public interface IService {
	
	public void init();
	public String execute(String projName, String modName, Exception exception);
	
}
