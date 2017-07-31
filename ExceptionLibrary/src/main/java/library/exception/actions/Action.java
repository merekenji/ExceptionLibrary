package library.exception.actions;

import java.util.Map;

public abstract class Action {
	
	public abstract void executeAction(Map<String, String> attributes);
	public static Action newInstance() {
		return null;
	}
	
}
