package com.projectge.QADemoWebTesting;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.projectge.pages.DraggableElements;
import com.projectge.pages.DroppableElements;
import com.projectge.pages.NavigationBar;
import com.projectge.pages.ResizableElements;
import com.projectge.pages.SelectableElements;
import com.projectge.pages.SortableElements;

public class AppTest {

	public static WebDriver chromeWebDriver;
	public static WebDriver firefoxWebDriver;
	
	private static String reportFilePath = "C:\\Users\\Administrator\\Desktop\\Report.html";
    private static ExtentReports reportTests;
    
	public static ExtentTest reportDraggableTest;
	public static ExtentTest reportDroppableTest;
	public static ExtentTest reportResizableTest;
	public static ExtentTest reportSelectableTest;
	public static ExtentTest reportSortableTest;

	@BeforeClass
	public static void beforeClass() {
        reportTests = new ExtentReports();
		
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("DemoQA");
        extentHtmlReporter.config().setDocumentTitle("Functionality Tests");
        reportTests.attachReporter(extentHtmlReporter);

        reportDraggableTest = reportTests.createTest("Draggable Tests");
        reportDroppableTest = reportTests.createTest("Droppable Tests");
        reportResizableTest = reportTests.createTest("Resizable Tests");
        reportSelectableTest = reportTests.createTest("Selectable Tests");
        reportSortableTest = reportTests.createTest("Sortable Tests");
	}
	
	@Before
	public void beforeTest() {
		chromeWebDriver = new ChromeDriver();
		chromeWebDriver.manage().window().maximize();
		chromeWebDriver.navigate().to("http://demoqa.com");
	}

	@Test
	public void runDraggableTests() {
		reportDraggableTest.log(Status.INFO, "Starting test...");

		NavigationBar chromeNavBar = PageFactory.initElements(chromeWebDriver, NavigationBar.class);
		chromeNavBar.clickDraggable();
		
		DraggableElements chromeDraggableElements = PageFactory.initElements(chromeWebDriver, DraggableElements.class);
		chromeDraggableElements.doTestTask();

		reportDraggableTest.pass("No errors found.");
	}

	@Test
	public void runDroppableTest() {
		reportDroppableTest.log(Status.INFO, "Starting test...");

		NavigationBar chromeNavBar = PageFactory.initElements(chromeWebDriver, NavigationBar.class);
		chromeNavBar.clickDroppable();
		
		DroppableElements chromeDroppableElements = PageFactory.initElements(chromeWebDriver, DroppableElements.class);
		chromeDroppableElements.doTestTask();
		
		assertEquals("Element must say \"Dropped!\"", "Dropped!", chromeDroppableElements.droppableViewText());
		if(!chromeDroppableElements.droppableViewText().equals("Dropped!")) {
			reportDroppableTest.fail("Listener responded with \"" + chromeDroppableElements.droppableViewText() + "\", expected was \"Dropped!\"");
		}
		else {
			reportDroppableTest.pass("No errors found, listener responsed with \"" + chromeDroppableElements.droppableViewText() + "\"");
		}
	}

	@Test
	public void runResizableTest() {
		reportResizableTest.log(Status.INFO, "Starting test...");

		NavigationBar chromeNavBar = PageFactory.initElements(chromeWebDriver, NavigationBar.class);
		chromeNavBar.clickResizable();
		
		ResizableElements chromeResizableElements = PageFactory.initElements(chromeWebDriver, ResizableElements.class);
		chromeResizableElements.doTestTask();

		reportResizableTest.pass("No errors found.");
	}
	
	@Test
	public void runSelectableTest() {
		reportSelectableTest.log(Status.INFO, "Starting test...");

		NavigationBar chromeNavBar = PageFactory.initElements(chromeWebDriver, NavigationBar.class);
		chromeNavBar.clickSelectable();
		
		SelectableElements chromeSelectableElements = PageFactory.initElements(chromeWebDriver, SelectableElements.class);
		chromeSelectableElements.doTestTask();

		reportSelectableTest.pass("No errors found.");
	}
	
	@Test
	public void runSortableTest() {
		reportSortableTest.log(Status.INFO, "Starting test...");

		NavigationBar chromeNavBar = PageFactory.initElements(chromeWebDriver, NavigationBar.class);
		chromeNavBar.clickSortable();
		
		SortableElements chromeSortableElements = PageFactory.initElements(chromeWebDriver, SortableElements.class);
		chromeSortableElements.doTestTask();

		reportSortableTest.pass("No errors found.");
	}
	
	@After
	public void afterTest() { 
		chromeWebDriver.close();
		chromeWebDriver.quit();
	}
	
	@AfterClass
	public static void afterClass() {
		reportTests.flush();
	}
	
	public static void hackySleep(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
