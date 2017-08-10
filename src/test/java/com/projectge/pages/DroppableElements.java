package com.projectge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.projectge.QADemoWebTesting.AppTest;

public class DroppableElements {
	
	@FindBy(xpath = "//*[@id=\"draggableview\"]")
	private WebElement draggableView;
	
	@FindBy(xpath = "//*[@id=\"droppableview\"]")
	private WebElement droppableView;

	private Actions builder;
	
	public DroppableElements(WebDriver d) {
		builder = new Actions(d);
	}
	
	public void doTestTask() {
		Action testActions = builder.clickAndHold(draggableView)
			.moveByOffset(140, 90)
			.release(draggableView)
			.build();

		testActions.perform();
	}
	
	public String droppableViewText() {
		return droppableView.getText();
	}
}
