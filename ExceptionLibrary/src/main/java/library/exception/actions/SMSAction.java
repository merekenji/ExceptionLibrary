package library.exception.actions;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class SMSAction extends GeneralAction {

	public SMSAction() {
		
	}
	
	public static SMSAction newInstance() {
		return new SMSAction();
	}
	
	public void executeAction(Map<String, String> attributes) {
		System.out.print("SMS ");
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
