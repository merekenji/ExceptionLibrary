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

	public void init(String path) {
		actionsMap = ReadFromXML.extract(path);
	}

	public String execute(String projName, String modName, Exception exception) {
		if (projName == null || projName.equals("")) {
			return "Empty Project Name";
		}
		if (modName == null || modName.equals("")) {
			return "Empty Module Name";
		}
		if (exception == null) {
			return "Empty Exception";
		}
		String exceptionName = exception.getClass().getName();
		LibException libException = new LibException(projName, modName, exceptionName);
		List<Action> actions = actionsMap.get(libException);
		if (actions == null) {
			return "No Such Combination of Project, Module and Exception";
		}
		for (Action a : actions) {
			if (a != null) {
				GeneralAction action = null;

				try {
					action = (GeneralAction) Class.forName("library.exception.actions." + a.getName()).newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					return "Error";
				}

				if (action != null) {
					action.executeAction(a.getAttributeMap());
				}
			}
		}
		return "Success";
	}

}
