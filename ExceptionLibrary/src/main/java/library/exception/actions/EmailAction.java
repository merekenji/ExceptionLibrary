package library.exception.actions;

import java.util.Map;

public class EmailAction extends Action {

	private EmailAction() {
		
	}
	
	public static EmailAction newInstance() {
		return new EmailAction();
	}
	
	public void executeAction(Map<String, String> attributes) {
		
	}

}
