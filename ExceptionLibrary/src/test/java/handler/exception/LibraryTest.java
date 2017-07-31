package handler.exception;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

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
	}
	
	@Test
	public void readFromXMLFile() {
		service.init("D:/exception_actions.xml");
	}
	
	@Test
	public void readFromNonExistantXMLFile() {
		service.init("D:/rubbish.xml");
	}
	
	@Test
	public void TestExceptionHandling() {
		service.init("D:/exception_actions.xml");
		assertEquals("Success", service.execute("Game Scheduler", "Add Player", new NullPointerException()));
	}
	
	@Test
	public void EmptyProjectName() {
		service.init("D:/exception_actions.xml");
		assertEquals("Empty Project Name", service.execute(null, "Add Player", new NullPointerException()));
	}
	
	@Test
	public void EmptyModuleName() {
		service.init("D:/exception_actions.xml");
		assertEquals("Empty Module Name", service.execute("Game Scheduler", null, new NullPointerException()));
	}
	
	@Test
	public void EmptyException() {
		service.init("D:/exception_actions.xml");
		assertEquals("Empty Exception", service.execute("Game Scheduler", "Add Player", null));
	}
	
	@Test
	public void NotInLibraryException() {
		service.init("D:/exception_actions.xml");
		assertEquals("No Such Combination of Project, Module and Exception", service.execute("Game Scheduler", "Add Player", new IOException()));
	}
	
}
