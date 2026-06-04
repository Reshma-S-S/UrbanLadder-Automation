package com.cts.urbanladder.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
 
public class Bookshelves_Page extends HomePage{
	
	public Bookshelves_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[text()='Storage Type']")
	WebElement storageTypeBox;
	
	@FindBy(xpath="//div[@id='dropdown-menu-storage-type']//*[contains(text(), 'Open Storage')]")
	WebElement openStorage;
	
	@FindBy(xpath="//div[@class='Gybge '][12]/div/span")
	WebElement priceBox;
	
	@FindBy(xpath="//div[@class='Gybge '][12]//div[@class='fieldItem'][2]//input")
	WebElement maxSlider;
	
	@FindBy(xpath="//div[@class='Gybge '][14]/div/span")
	WebElement stock;
	
	@FindBy(xpath="//div[@class='Gybge '][14]//div[@class='EOPBF']/div")
	WebElement outStock;
	
	@FindBy(xpath="//button[@data-testid='plp-filter-apply-button']/span")
	WebElement applyFilter;
	
	@FindBy(xpath="//div[@class='qJoGr']")
	WebElement filter;
	
	By titlesList=By.xpath("//div[@class='HOVM7']/div/div//h3");
	By priceList=By.xpath("//div[@class='HOVM7']/div/div//span/div");
	
	public void storageHover() {
		wait.until(ExpectedConditions.visibilityOf(storageTypeBox));
		storageTypeBox.click();
	}
	public void storageTypeClick() {
		wait.until(ExpectedConditions.visibilityOf(openStorage));
		openStorage.click();
	}
	public void priceHover() {
//		wait.until(ExpectedConditions.elementToBeClickable(priceBox));
//    	js.executeScript("arguments[0].scrollIntoView(true);", priceBox);
//        a.moveToElement(priceBox).perform();
		filter.click();
		priceBox.click();
		
	}
	public void priceSliderEvent() {
//		wait.until(ExpectedConditions.visibilityOf(maxSlider));
//        js.executeScript("arguments[0].scrollIntoView(true);", maxSlider);     
//        a.clickAndHold(maxSlider).moveByOffset(-271, 0).release().perform();
		maxSlider.clear();
		maxSlider.sendKeys("15000");
	}
	public void clickexcludestock(){
//		wait.until(ExpectedConditions.visibilityOf(stock));
//		Boolean isSelected = (Boolean) js.executeScript("return arguments[0].checked;", stock);
//        if (!isSelected) {
//            js.executeScript("arguments[0].click();", stock);
//        }
		//js.executeScript("arguments[0].scrollIntoView(true);", stock);
		//stock.click();
      stock.click();
      wait.until(ExpectedConditions.visibilityOf(outStock));
      outStock.click();
      
        
    }
	public void clickFilterButton() {
		applyFilter.click();
		
	}
	public List<WebElement> getBookShelfNames()  {
		
  	  return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(titlesList));
    }
 // Method to get the list of bookshelf prices
    public List<WebElement> getBookShelfPrices() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(priceList));

    }  
}
 
