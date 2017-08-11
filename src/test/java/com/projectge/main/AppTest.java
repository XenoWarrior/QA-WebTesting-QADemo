package com.projectge.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
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
import com.projectge.utils.Screenshot;

public class AppTest {

	public static WebDriver chromeWebDriver;
	public static WebDriver firefoxWebDriver;
	
	private static String reportFilePath = System.getProperty("user.dir") + File.separatorChar + "Report" + File.separatorChar + "Report.html";
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
		
		AppTest.capture(reportDraggableTest, chromeWebDriver, "DraggableBeforeOpeningPage");
		chromeNavBar.clickDraggable();
		AppTest.capture(reportDraggableTest, chromeWebDriver, "DraggableBeforeDraggableTest");
		
		DraggableElements chromeDraggableElements = PageFactory.initElements(chromeWebDriver, DraggableElements.class);
		chromeDraggableElements.doTestTask();
		AppTest.capture(reportDraggableTest, chromeWebDriver, "DraggableAfterTest");

		reportDraggableTest.pass("No errors found.");
	}

	@Test
	public void runDroppableTest() {
		reportDroppableTest.log(Status.INFO, "Starting test...");

		NavigationBar chromeNavBar = PageFactory.initElements(chromeWebDriver, NavigationBar.class);
		
		AppTest.capture(reportDroppableTest, chromeWebDriver, "DroppableBeforeOpeningPage");
		chromeNavBar.clickDroppable();
		AppTest.capture(reportDroppableTest, chromeWebDriver, "DroppableBeforeDraggableTest");
		
		DroppableElements chromeDroppableElements = PageFactory.initElements(chromeWebDriver, DroppableElements.class);
		chromeDroppableElements.doTestTask();
		AppTest.capture(reportDroppableTest, chromeWebDriver, "DroppableAfterTest");
		
		assertEquals("Element must say \"Dropped!\"", chromeDroppableElements.droppableViewText(), "Dropped!");
		if(!chromeDroppableElements.droppableViewText().equals("Dropped!")) {
			reportDroppableTest.fail("Listener responded with \"" + chromeDroppableElements.droppableViewText() + "\", expected was \"Dropped!\"");
		}
		else {
			reportDroppableTest.pass("No errors found, listener responded with \"" + chromeDroppableElements.droppableViewText() + "\"");
		}
	}

	@Test
	public void runResizableTest() {
		reportResizableTest.log(Status.INFO, "Starting test...");

		NavigationBar chromeNavBar = PageFactory.initElements(chromeWebDriver, NavigationBar.class);
		AppTest.capture(reportResizableTest, chromeWebDriver, "ResizableBeforeOpeningPage");
		chromeNavBar.clickResizable();
		AppTest.capture(reportResizableTest, chromeWebDriver, "ResizableBeforeDraggableTest");
		
		ResizableElements chromeResizableElements = PageFactory.initElements(chromeWebDriver, ResizableElements.class);
		chromeResizableElements.doTestTask();
		AppTest.capture(reportResizableTest, chromeWebDriver, "ResizableAfterTest");

		assertNotSame("Element must not remain the same size after a resize.", chromeResizableElements.serialiseSize(), "[150, 150]");
		if(chromeResizableElements.serialiseSize().equals("[150, 150]")) {
			reportResizableTest.fail("Listener responded with \"" + chromeResizableElements.serialiseSize() + "\", expected was +/- [150, 150]");
		}
		else {
			reportResizableTest.pass("No errors found, listener responded with \"" + chromeResizableElements.serialiseSize() + "\"");
		}
	}

	@Test
	public void runSelectableTest() {
		reportSelectableTest.log(Status.INFO, "Starting test...");

		NavigationBar chromeNavBar = PageFactory.initElements(chromeWebDriver, NavigationBar.class);
		AppTest.capture(reportSelectableTest, chromeWebDriver, "SelectableBeforeOpeningPage");
		chromeNavBar.clickSelectable();
		AppTest.capture(reportSelectableTest, chromeWebDriver, "SelectableBeforeDraggableTest");

		try {
			SelectableElements chromeSelectableElements = PageFactory.initElements(chromeWebDriver, SelectableElements.class);
			chromeSelectableElements.doTestTask();
			AppTest.capture(reportSelectableTest, chromeWebDriver, "SelectableAfterDraggableTest");
		}
		catch(NoSuchElementException ex) {
			reportSortableTest.fail(ex.getMessage());
			fail(ex.getMessage());
		}

		reportSelectableTest.pass("No errors found.");
	}
	
	@Test
	public void runSortableTest() {
		reportSortableTest.log(Status.INFO, "Starting test...");

		NavigationBar chromeNavBar = PageFactory.initElements(chromeWebDriver, NavigationBar.class);
		AppTest.capture(reportSortableTest, chromeWebDriver, "SortableBeforeOpeningPage");
		chromeNavBar.clickSortable();
		AppTest.capture(reportSortableTest, chromeWebDriver, "SortableBeforeDraggableTest");
	
		SortableElements chromeSortableElements = PageFactory.initElements(chromeWebDriver, SortableElements.class);
		chromeSortableElements.doTestTask();
		AppTest.capture(reportSortableTest, chromeWebDriver, "SortableAfterTest");

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

	public static void capture(ExtentTest t, WebDriver d, String fn) {
		try {
			t.addScreenCaptureFromPath(Screenshot.take(d, fn));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void hackySleep(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
