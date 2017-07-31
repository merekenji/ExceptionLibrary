package library.exception.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import library.exception.beans.Action;
import library.exception.beans.LibException;

public class ReadFromXML {
	
	private static Document doc;
	private static final String PATH = "D:/exception_actions.xml";
	private static Map<LibException, List<Action>> exceptionMap = new HashMap<>();
	
	private ReadFromXML() {
	}
	
	public static Map<LibException, List<Action>> extract() {
		parseXmlFile();
		parseDocument();
		return exceptionMap;
	}
	
	private static void parseXmlFile(){
		File file = new File(PATH);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(file);
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private static void parseDocument(){
		Element docEle = doc.getDocumentElement();
		retrieveProjects(docEle.getElementsByTagName("project"));
	}
	
	private static void retrieveProjects(NodeList nl) {
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {
				Element el = (Element)nl.item(i);
				retrieveModules(el.getElementsByTagName("module"), el.getAttribute("name"));
			}
		}
	}
	
	private static void retrieveModules(NodeList nl, String projName) {
		if(nl != null && nl.getLength() > 0) {
			for(int j = 0 ; j < nl.getLength(); j++) {
				Element el = (Element)nl.item(j);
				retrieveExceptions(el.getElementsByTagName("exception"), projName, el.getAttribute("name"));
			}
		}
	}
	
	private static void retrieveExceptions(NodeList nl, String projName, String modName) {
		if(nl != null && nl.getLength() > 0) {
			for(int k = 0; k < nl.getLength(); k++) {
				Element el = (Element)nl.item(k);
				LibException libException = new LibException(projName, modName, el.getAttribute("type"));
				List<Action> actions = retrieveActions(el.getElementsByTagName("action"));
				exceptionMap.put(libException, actions);
			}
		}
	}
	
	private static List<Action> retrieveActions(NodeList nl) {
		List<Action> actions = new ArrayList<>();
		if(nl != null && nl.getLength() > 0) {
			for(int i=0; i<nl.getLength(); i++) {
				Element el = (Element) nl.item(i);
				
				for(int j=0; j<el.getChildNodes().getLength(); j++) {
					actions.add(retrieveAttribute(el.getChildNodes().item(j)));
				}
			}
		}
		return actions;
	}
	
	private static Action retrieveAttribute(Node node) {
		Action action = null;
		if(node != null && node.getNodeType() == Node.ELEMENT_NODE) {
			action = new Action(node.getNodeName());
			for(int k=0; k<node.getAttributes().getLength(); k++) {
				action.addAttributeToMap(node.getAttributes().item(k).getNodeName(), node.getAttributes().item(k).getNodeValue());
			}
		}
		return action;
	}

}
