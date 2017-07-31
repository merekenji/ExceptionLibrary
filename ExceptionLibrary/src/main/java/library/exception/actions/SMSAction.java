package library.exception.actions;

import java.util.Map;

public class SMSAction extends Action {

	private SMSAction() {
		
	}
	
	public static SMSAction newInstance() {
		return new SMSAction();
	}
	
	public void executeAction(Map<String, String> attributes) {
		
	}

}
