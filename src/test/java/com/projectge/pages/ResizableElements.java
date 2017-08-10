package com.projectge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.projectge.QADemoWebTesting.AppTest;

public class ResizableElements {

	@FindBy(xpath = "//*[@id=\"resizable\"]/div[3]")
	private WebElement element;

	private Actions builder;
	
	public ResizableElements(WebDriver d) {
		builder = new Actions(d);
	}
	
	public void doTestTask() {
		Action testActions = builder.clickAndHold(element)
			.moveByOffset(200, 200)
			.release(element)
			.build();

		testActions.perform();
	}
	
}
