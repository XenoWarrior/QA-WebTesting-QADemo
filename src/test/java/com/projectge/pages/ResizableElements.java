package com.projectge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.projectge.main.AppTest;

public class ResizableElements {

	@FindBy(xpath = "//*[@id=\"resizable\"]/div[3]")
	private WebElement element;
	@FindBy(xpath = "//*[@id=\"resizable\"]")
	private WebElement parent;

	private Actions builder;
	
	public ResizableElements(WebDriver d) {
		AppTest.reportResizableTest.debug("[" + this.getClass().getName() + ".java] constructor(WebDriver): Initialising with a [" + d.getClass().getName() + "] driver.");
		
		builder = new Actions(d);
	}
	
	public void doTestTask() {
		AppTest.reportResizableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): Configuring test...");

		AppTest.reportResizableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, clickAndHold(WebElement).");
		AppTest.reportResizableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, moveByOffset(200, 200).");
		AppTest.reportResizableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, release(WebElement).");
		Action testActions = builder.clickAndHold(element)
			.moveByOffset(200, 200)
			.release(element)
			.build();

		AppTest.reportResizableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): Performing actions...");
		testActions.perform();
	}
	
	public String serialiseSize() { 
		
		return "[" + String.valueOf(parent.getSize().getWidth()) + ", " + String.valueOf(parent.getSize().getWidth()) + "]"; 
	}
	
}
