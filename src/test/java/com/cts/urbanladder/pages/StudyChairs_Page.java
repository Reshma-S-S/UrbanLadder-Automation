package com.cts.urbanladder.pages;

import java.util.ArrayList;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StudyChairs_Page extends BasePage{
	
	public StudyChairs_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='U8z6D ']/div//h3")
	List<WebElement> titlesList;
	
	@FindBy(xpath="//div[@class='U8z6D ']/div//span[@class='ESGub']/div")
	List<WebElement> priceList;
	
	public List<String> titlesDisplay(){
		wait.until(ExpectedConditions.visibilityOfAllElements(titlesList));
		List<String> li=new ArrayList<>();
		for(int i=0;i<3;i++) {
			li.add(titlesList.get(i).getText());
		}
		return li;
	}
	public List<String> pricesDisplay(){
		wait.until(ExpectedConditions.visibilityOfAllElements(priceList));
		List<String> li=new ArrayList<>();
		for(int i=0;i<3;i++) {
			li.add(priceList.get(i).getText());
		}
		return li;
	}
	

}
