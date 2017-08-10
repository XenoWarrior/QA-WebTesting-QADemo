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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.projectge.pages.*;

public class AppTest {

	public static WebDriver chromeWebDriver;
	public static WebDriver firefoxWebDriver;
	
	@BeforeClass
	public static void beforeClass() {
		// TODO Initialise the report
	}
	
	@Before
	public void beforeTest() {
		chromeWebDriver = new ChromeDriver();
		chromeWebDriver.manage().window().maximize();
		chromeWebDriver.navigate().to("http://demoqa.com");
		
		//firefoxWebDriver = new FirefoxDriver();
		//firefoxWebDriver.manage().window().maximize();
		//firefoxWebDriver.navigate().to("http://demoqa.com");
	}

	@Test
	public void runDraggableTests() {
		// TODO Add an ExtrentTest for this test, to the report

		NavigationBar chromeNavBar = PageFactory.initElements(chromeWebDriver, NavigationBar.class);
		chromeNavBar.clickDraggable();
		
		DraggableElements chromeDraggableElements = PageFactory.initElements(chromeWebDriver, DraggableElements.class);
		chromeDraggableElements.doTestTask();
	}

	@Test
	public void runDroppableTest() {
		// TODO Add an ExtrentTest for this test, to the report
		
		NavigationBar chromeNavBar = PageFactory.initElements(chromeWebDriver, NavigationBar.class);
		chromeNavBar.clickDroppable();
		
		DroppableElements chromeDroppableElements = PageFactory.initElements(chromeWebDriver, DroppableElements.class);
		chromeDroppableElements.doTestTask();
		
		assertEquals("Element must say \"Dropped!\"", "Dropped!", chromeDroppableElements.droppableViewText());
		if(chromeDroppableElements.droppableViewText() != "Dropped!") {
			// TODO Add fail log message
		}
		else {
			// TODO Add pass log message
		}
	}

	@Test
	public void runResizableTest() {
		// TODO Add an ExtrentTest for this test, to the report
		
		NavigationBar chromeNavBar = PageFactory.initElements(chromeWebDriver, NavigationBar.class);
		chromeNavBar.clickResizable();
		
		ResizableElements chromeResizableElements = PageFactory.initElements(chromeWebDriver, ResizableElements.class);
		chromeResizableElements.doTestTask();
	}
	
	@Test
	public void runSelectableTest() {
		// TODO Add an ExtrentTest for this test, to the report

		NavigationBar chromeNavBar = PageFactory.initElements(chromeWebDriver, NavigationBar.class);
		chromeNavBar.clickSelectable();
		
		SelectableElements chromeSelectableElements = PageFactory.initElements(chromeWebDriver, SelectableElements.class);
		chromeSelectableElements.doTestTask();
	}
	
	@After
	public void afterTest() { 
		chromeWebDriver.close();
		chromeWebDriver.quit();
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
