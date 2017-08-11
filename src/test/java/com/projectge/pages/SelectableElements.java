package com.projectge.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.projectge.QADemoWebTesting.AppTest;

public class SelectableElements {

	@FindBy(xpath = "//*[@id=\"selectable\"]/li[1]")
	private WebElement liElement1;
	
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[2]")
	private WebElement liElement2;
	
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[3]")
	private WebElement liElement3;
	
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[4]")
	private WebElement liElement4;
	
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[5]")
	private WebElement liElement5;
	
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[6]")
	private WebElement liElement6;
	
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[7]")
	private WebElement liElement7;

	private Actions builder;
	
	public SelectableElements(WebDriver d) {
		AppTest.reportSelectableTest.debug("[" + this.getClass().getName() + ".java] constructor(WebDriver): Initialising with a [" + d.getClass().getName() + "] driver.");
		
		builder = new Actions(d);
	}
	
	public void doTestTask() {
		selectElement(1);
		selectElement(2);
		selectElement(3);
		selectElement(4);
		selectElement(5);
		selectElement(6);
		selectElement(7);

		dragSelect();
	}
	
	public void dragSelect() {
		AppTest.reportSelectableTest.log(Status.INFO, "Dragging down on the first element to select all (or some) below.");
		
		AppTest.reportSelectableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): Configuring test...");

		AppTest.reportSelectableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, clickAndHold(WebElement).");
		AppTest.reportSelectableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, moveByOffset(0, 50) (Recursive x5).");
		
		Action testActions = builder.clickAndHold(liElement1)
			.moveByOffset(0, 50)
			.moveByOffset(0, 50)
			.moveByOffset(0, 50)
			.moveByOffset(0, 50)
			.moveByOffset(0, 50)
			.build();

		AppTest.reportSelectableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): Performing actions...");
		testActions.perform();
	}
	
	public void selectElement(int id) throws NoSuchElementException {
		AppTest.reportSelectableTest.log(Status.INFO, "Selecting the element at position " + id + " in the list.");

		WebElement element = null;
		
		switch(id) {
		case 1:
			element = liElement1;
			break;
		case 2:
			element = liElement2;
			break;
		case 3:
			element = liElement3;
			break;
		case 4:
			element = liElement4;
			break;
		case 5:
			element = liElement5;
			break;
		case 6:
			element = liElement6;
			break;
		case 7:
			element = liElement7;
			break;
		default:
			throw new NoSuchElementException("Selectable element li: " + id + " does not exist in the DOM.");
		}

		AppTest.reportSelectableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): Configuring test...");

		AppTest.reportSelectableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, click(WebElement).");
		AppTest.reportSelectableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, release(WebElement).");
		Action testActions = builder.click(element)
			.release(element)
			.build();

		AppTest.reportSelectableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): Performing actions...");
		testActions.perform();
	}
	
}
