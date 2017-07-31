package library.exception.actions;

import java.util.Map;

public abstract class GeneralAction {
	
	public abstract void executeAction(Map<String, String> attributes);
	public static GeneralAction newInstance() {
		return null;
	}
	
}
