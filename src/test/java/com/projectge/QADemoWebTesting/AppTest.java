package com.projectge.QADemoWebTesting;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.projectge.pages.*;

@FixMethodOrder
public class AppTest {
	
	public static WebDriver webDriver;
	
	@BeforeClass
	public static void beforeClass() {
		// TODO Initialise the report
	}
	
	@Before
	public void beforeTest() {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.navigate().to("http://demoqa.com");
	}

	@Test
	public void runDraggableTests() {
		// TODO Add an ExtrentTest for this test, to the report
		
		NavigationBar navBar = PageFactory.initElements(webDriver, NavigationBar.class);
		navBar.clickDraggable();
		
		DraggableElements draggableElements = PageFactory.initElements(webDriver, DraggableElements.class);
		draggableElements.doTestTask();
	}

	@Test
	public void runDroppableTest() {
		// TODO Add an ExtrentTest for this test, to the report
		
		NavigationBar navBar = PageFactory.initElements(webDriver, NavigationBar.class);
		navBar.clickDroppable();
		
		DroppableElements droppableElements = PageFactory.initElements(webDriver, DroppableElements.class);
		droppableElements.doTestTask();
		
		assertEquals("Element must say \"Dropped!\"", "Dropped!", droppableElements.droppableViewText());
		if(droppableElements.droppableViewText() != "Dropped!") {
			// TODO Add fail log message
		}
		else {
			// TODO Add pass log message
		}
	}

	@Test
	public void runResizableTest() {
		// TODO Add an ExtrentTest for this test, to the report
		
		NavigationBar navBar = PageFactory.initElements(webDriver, NavigationBar.class);
		navBar.clickResizable();
		
		ResizableElements resizableElements = PageFactory.initElements(webDriver, ResizableElements.class);
		resizableElements.doTestTask();
	}
	
	@Test
	public void runSelectableTest() {
		// TODO Add an ExtrentTest for this test, to the report

		NavigationBar navBar = PageFactory.initElements(webDriver, NavigationBar.class);
		navBar.clickSelectable();
		
		SelectableElements selectableElements = PageFactory.initElements(webDriver, SelectableElements.class);
		selectableElements.doTestTask();
	}
	
	@After
	public void afterTest() { 
		webDriver.close();
		webDriver.quit();
	}
	
	@AfterClass
	public static void afterClass() {
		// TODO Flush the report
	}
	
	public void hackySleep(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
