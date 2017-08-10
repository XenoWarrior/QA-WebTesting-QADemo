package com.projectge.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.projectge.QADemoWebTesting.AppTest;

public class DraggableElements {

	@FindBy(xpath = "//div[@id=\"draggable\"]")
	private WebElement element;
	
	private Actions builder = new Actions(AppTest.webDriver);
	
	public void doTestTask() {
		Action testActions = builder.clickAndHold(element)
			.moveByOffset(100, 100)
			.release(element)
			.build();

		testActions.perform();
	}
	
}
