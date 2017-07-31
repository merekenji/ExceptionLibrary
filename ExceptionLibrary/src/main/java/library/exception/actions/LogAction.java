package library.exception.actions;

import java.util.Map;

public class LogAction extends GeneralAction {

	public LogAction() {
		
	}
	
	public static LogAction newInstance() {
		return new LogAction();
	}
	
	public void executeAction(Map<String, String> attributes) {
		System.out.println("Log");
	}

}
