package library.exception.actions;

import java.util.Map;

public abstract class GeneralAction {
	
	public void executeAction(Map<String, String> attributes) {
		System.out.println("hello");
	}
	public static GeneralAction newInstance() {
		return null;
	}
	
}
