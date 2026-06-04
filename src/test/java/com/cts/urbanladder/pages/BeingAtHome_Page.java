package com.cts.urbanladder.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BeingAtHome_Page extends BasePage{
	
	public BeingAtHome_Page(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[@class='product-title-block']/div/span")
	WebElement desc;
	
	@FindBy(xpath="//div[@class='pmv2N']/div[10]//span")
	WebElement LightsAndDecor;
	
	@FindBy(xpath="//div[@class='otherinfo']/a[2]")
	WebElement info;
	
	@FindBy(xpath="//div[@class='vert-container']/div[2]/a")
	WebElement popupAdClose;
	
	@FindBy(xpath="//div[@class='IvanW ']//h2")
	WebElement dropDownBox;
	
	@FindBy(tagName="ct-web-popup-imageonly")
	WebElement smallPopup;
	
	@FindBy(xpath="//div[@data-testid='navigation-desktop-sub-category-1']/a")
	List<WebElement> Lightingslist;
	
	
	public void LightsClick() {
		wait.until(ExpectedConditions.visibilityOf(LightsAndDecor));
		LightsAndDecor.click();
	}
	public void hoverOverDesc() {
		Actions a=new Actions(driver);
		a.moveToElement(desc).perform();
	}
	public void optionsClick() {
		wait.until(ExpectedConditions.visibilityOf(info));
		info.click();
	}
	public void closingAd() {
		try 
		{
			if(popupAdClose.isDisplayed())
			{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vert-container']")));
		
		
				popupAdClose.click();
			}
		}
		catch(Exception e)	{}
		
	}
	public void smallPopupHandle() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vert-container']")));
        // Use JavaScript to access the shadow root
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowElement = (WebElement) js.executeScript(
                "return arguments[0].shadowRoot.querySelector('#close')", smallPopup);
 
        // Perform actions on the shadow element
        shadowElement.click();
	}
	public void dropDownClick() {
		dropDownBox.click();
	}
	public List<String> listDisplay() {
		List<String> li=new ArrayList<>();
		for(WebElement i:Lightingslist) {
			li.add(i.getText());
		}
		return li;
	}
	

}
