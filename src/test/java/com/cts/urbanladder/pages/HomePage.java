package com.cts.urbanladder.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="searchInput")
	WebElement searchBox;
	
	@FindBy(id="search_button")
	WebElement searchBtn;
	
	@FindBy(xpath="//div[@class='dKglw'][4]/a[2]/div/img")
	WebElement bookshelvesLink;
	
	public void searchBoxEvent(String text) {
		searchBox.click();
		searchBox.sendKeys(text);
	}
	public void searchBoxClick() {
		a.sendKeys(Keys.ENTER).build().perform();
	}
	public void bookshelvesClick() {
		bookshelvesLink.click();
	}

}
