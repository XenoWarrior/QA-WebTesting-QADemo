package com.projectge.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar {

	@FindBy(xpath = "//li[@id=\"menu-item-140\"]/a")
	private WebElement draggableButton;
	
	@FindBy(xpath = "//li[@id=\"menu-item-141\"]/a")
	private WebElement droppableButton;
	
	@FindBy(xpath = "//li[@id=\"menu-item-143\"]/a")
	private WebElement resizableButton;
	
	public void clickDraggable() {
		draggableButton.click();
	}
	
	public void clickDroppable() {
		droppableButton.click();
	}
	
	public void clickResizable() {
		resizableButton.click();
	}
	
}
