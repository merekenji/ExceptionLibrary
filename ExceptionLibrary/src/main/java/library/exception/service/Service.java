package library.exception.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import library.exception.beans.Action;
import library.exception.actions.*;
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
		for (Action a : actions) {
			if (a != null) {
				GeneralAction action = null;
				try {
					action = (GeneralAction) Class.forName("library.exception.actions." + a.getName()).newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(action != null) {
					action.executeAction(a.getAttributeMap());
				}
			}
		}
		return "Success";
	}

}
