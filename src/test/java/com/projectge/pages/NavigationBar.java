package com.projectge.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.projectge.QADemoWebTesting.AppTest;

public class NavigationBar {

	@FindBy(xpath = "//li[@id=\"menu-item-140\"]/a")
	private WebElement draggableButton;
	
	@FindBy(xpath = "//li[@id=\"menu-item-141\"]/a")
	private WebElement droppableButton;

	@FindBy(xpath = "//li[@id=\"menu-item-143\"]/a")
	private WebElement resizableButton;
	
	@FindBy(xpath = "//li[@id=\"menu-item-142\"]/a")
	private WebElement selectableButton;
	
	@FindBy(xpath = "//li[@id=\"menu-item-151\"]/a")
	private WebElement sortableButton;
	
	public void clickDraggable() {
		AppTest.reportDraggableTest.debug("[" + this.getClass().getName() + ".java] clickDraggable(): Sending click...");
		draggableButton.click();
	}
	
	public void clickDroppable() {
		AppTest.reportDroppableTest.debug("[" + this.getClass().getName() + ".java] clickDroppable(): Sending click...");
		droppableButton.click();
	}

	public void clickResizable() {
		AppTest.reportResizableTest.debug("[" + this.getClass().getName() + ".java] clickResizable(): Sending click...");
		resizableButton.click();
	}

	public void clickSelectable() {
		AppTest.reportSelectableTest.debug("[" + this.getClass().getName() + ".java] clickSelectable(): Sending click...");
		selectableButton.click();
	}
	
	public void clickSortable() {
		AppTest.reportSortableTest.debug("[" + this.getClass().getName() + ".java] clickSortable(): Sending click...");
		sortableButton.click();
	}
	
}
