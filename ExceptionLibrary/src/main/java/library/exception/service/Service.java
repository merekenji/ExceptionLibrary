package library.exception.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import library.exception.beans.Action;
import library.exception.beans.LibException;
import library.exception.utility.ReadFromXML;

public class Service implements IService {

	private Map<LibException, List<Action>> actionsMap;
	
	public Service() {
		actionsMap = new HashMap<>();
	}
	
	public void init() {
		actionsMap = ReadFromXML.extract();
	}
	
	public String execute(String projName, String modName, Exception exception) {
		String exceptionName = exception.getClass().getName();
		LibException libException = new LibException(projName, modName, exceptionName);
		List<Action> actions = actionsMap.get(libException);
		for(Action a : actions) {
			Class c;
			try {
				c = Class.forName(a.getName());
			} catch (ClassNotFoundException e) {
				return "";
			}
			Object o = null;
			try {
				o = c.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			library.exception.actions.Action action = (library.exception.actions.Action) o;
			action.executeAction(a.getAttributeMap());
		}
		return null;
	}
	
}
