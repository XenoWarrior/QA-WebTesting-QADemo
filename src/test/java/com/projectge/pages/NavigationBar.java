package com.projectge.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.projectge.main.AppTest;

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
		AppTest.reportDraggableTest.log(Status.INFO, " Clicking on button for Draggable.");
		draggableButton.click();
	}
	
	public void clickDroppable() {
		AppTest.reportDroppableTest.log(Status.INFO, " Clicking on button for Droppable.");
		droppableButton.click();
	}

	public void clickResizable() {
		AppTest.reportResizableTest.log(Status.INFO, " Clicking on button for Resizable.");
		resizableButton.click();
	}

	public void clickSelectable() {
		AppTest.reportSelectableTest.log(Status.INFO, " Clicking on button for Selectable.");
		selectableButton.click();
	}
	
	public void clickSortable() {
		AppTest.reportSortableTest.log(Status.INFO, " Clicking on button for Sortable.");
		sortableButton.click();
	}
	
}
