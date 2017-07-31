package library.exception.beans;

import java.util.HashMap;
import java.util.Map;

public class Action {
	
	private String name;
	private Map<String, String> attributeMap;
	
	public Action(String name) {
		this.name = name;
		attributeMap = new HashMap<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getAttributeMap() {
		return attributeMap;
	}

	public void addAttributeToMap(String key, String value) {
		attributeMap.put(key, value);
	}
	
}
