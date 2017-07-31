package library.exception.actions;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EmailAction extends GeneralAction {

	public EmailAction() {
		
	}
	
	public static EmailAction newInstance() {
		return new EmailAction();
	}
	
	public void executeAction(Map<String, String> attributes) {
		System.out.print("Email ");
		Set<Entry<String, String>> attributeSet = attributes.entrySet();
		Iterator<Entry<String, String>> iter = attributeSet.iterator();
		while(iter.hasNext()) {
			Entry<String, String> element = iter.next();
			System.out.print(element.getKey() + ": ");
			System.out.print(element.getValue());
		}
		System.out.println("");
	}

}
