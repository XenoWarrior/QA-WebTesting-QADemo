package com.projectge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.projectge.QADemoWebTesting.AppTest;

public class SortableElements {
	@FindBy(xpath = "//*[@id=\"sortable\"]/li[1]")
	private WebElement liElement1;
	
	@FindBy(xpath = "//*[@id=\"sortable\"]/li[2]")
	private WebElement liElement2;
	
	@FindBy(xpath = "//*[@id=\"sortable\"]/li[3]")
	private WebElement liElement3;
	
	@FindBy(xpath = "//*[@id=\"sortable\"]/li[4]")
	private WebElement liElement4;
	
	@FindBy(xpath = "//*[@id=\"sortable\"]/li[5]")
	private WebElement liElement5;
	
	@FindBy(xpath = "//*[@id=\"sortable\"]/li[6]")
	private WebElement liElement6;
	
	@FindBy(xpath = "//*[@id=\"sortable\"]/li[7]")
	private WebElement liElement7;

	private Actions builder;
	
	public SortableElements(WebDriver d) {
		AppTest.reportSortableTest.debug("[" + this.getClass().getName() + ".java] constructor(WebDriver): Initialising with a [" + d.getClass().getName() + "] driver.");
		
		builder = new Actions(d);
	}
	

	public void doTestTask() {
		AppTest.reportSortableTest.log(Status.INFO, "Sorting elements by dragging them down by a block.");
		
		AppTest.reportSortableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): Configuring test...");

		AppTest.reportSortableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, clickAndHold(WebElement).");
		AppTest.reportSortableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, moveByOffset(32, 0).");
		AppTest.reportSortableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, moveByOffset(0, +/-34).");
		AppTest.reportSortableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, moveByOffset(-32, 0).");
		AppTest.reportSortableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): testActions, (Loops several times)");
		
		Action testActions = builder
			.clickAndHold(liElement1).moveByOffset(32, 0).moveByOffset(0, 34).moveByOffset(-32, 0).release()
			.clickAndHold(liElement4).moveByOffset(32, 0).moveByOffset(0, -64).moveByOffset(-32, 0).release()
			.clickAndHold(liElement6).moveByOffset(32, 0).moveByOffset(0, 34).moveByOffset(-32, 0).release()
			.clickAndHold(liElement2).moveByOffset(32, 0).moveByOffset(0, -64).moveByOffset(-32, 0).release()
			.clickAndHold(liElement5).moveByOffset(32, 0).moveByOffset(0, 34).moveByOffset(-32, 0).release()
			.clickAndHold(liElement3).moveByOffset(32, 0).moveByOffset(0, -34).moveByOffset(-32, 0).release()
			.clickAndHold(liElement7).moveByOffset(32, 0).moveByOffset(0, 34).moveByOffset(-32, 0).release()
			.build();

		AppTest.reportSortableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): Performing actions...");
		for(int i = 0; i < 10; i ++) {
			AppTest.reportSortableTest.debug("[" + this.getClass().getName() + ".java] doTestTask(): Sort iteration " + String.valueOf(i+1) + " of 10...");
			testActions.perform();
		}
	}
	
}
