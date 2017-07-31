package handler.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import library.exception.service.IService;
import library.exception.service.Service;
import library.exception.utility.ReadFromXML;

public class LibraryTest{

	IService service;
	
	@Before
	public void init() {
		service = new Service();
		service.init();
	}
	
	@Test
	public void readFromXMLFile() {
		ReadFromXML.extract();
	}
	
	@Test
	public void TestExceptionName() {
		assertEquals("Success", service.execute("Game Scheduler", "Add Player", new NullPointerException()));
	}
	
}
