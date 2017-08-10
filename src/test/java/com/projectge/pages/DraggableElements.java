package com.projectge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.projectge.QADemoWebTesting.AppTest;

public class DraggableElements {

	@FindBy(xpath = "//div[@id=\"draggable\"]")
	private WebElement element;

	private Actions builder;
	
	public DraggableElements(WebDriver d) {
		AppTest.reportDraggableTest.debug("[" + this.getClass().getName() + ".java] constructor(WebDriver): Initialising with a [" + d.getClass().getName() + "] driver.");
		
		builder = new Actions(d);
	}
	
	public void doTestTask() {
		AppTest.reportDraggableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): Configuring test...");

		AppTest.reportDraggableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, clickAndHold(WebElement).");
		AppTest.reportDraggableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, moveByOffset(100, 100).");
		AppTest.reportDraggableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, release(WebElement).");
		Action testActions = builder
			.clickAndHold(element)
			.moveByOffset(100, 100)
			.release(element)
			.build();
		
		AppTest.reportDraggableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): Performing actions...");
		testActions.perform();
	}
	
}
