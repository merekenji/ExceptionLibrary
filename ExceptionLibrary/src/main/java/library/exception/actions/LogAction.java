package library.exception.actions;

import java.util.Map;

public class LogAction extends Action {

	private LogAction() {
		
	}
	
	public static LogAction newInstance() {
		return new LogAction();
	}
	
	public void executeAction(Map<String, String> attributes) {
		
	}

}
