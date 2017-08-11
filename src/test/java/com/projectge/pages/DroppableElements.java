package com.projectge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.projectge.main.AppTest;

public class DroppableElements {
	
	@FindBy(xpath = "//*[@id=\"draggableview\"]")
	private WebElement draggableView;
	
	@FindBy(xpath = "//*[@id=\"droppableview\"]")
	private WebElement droppableView;

	private Actions builder;
	
	public DroppableElements(WebDriver d) {
		AppTest.reportDroppableTest.debug("[" + this.getClass().getName() + ".java] constructor(WebDriver): Initialising with a [" + d.getClass().getName() + "] driver.");
		
		builder = new Actions(d);
	}
	
	public void doTestTask() {
		AppTest.reportDroppableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): Configuring test...");

		AppTest.reportDroppableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, clickAndHold(WebElement).");
		AppTest.reportDroppableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, moveByOffset(140, 90).");
		AppTest.reportDroppableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, release(WebElement).");
		
		Action testActions = builder
			.clickAndHold(draggableView)
			.moveByOffset(140, 90)
			.release(draggableView)
			.build();

		AppTest.reportDroppableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): Performing actions...");
		testActions.perform();
	}
	
	public String droppableViewText() {
		return droppableView.getText();
	}
}
