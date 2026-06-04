package com.cts.urbanladder.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	public Actions a;
	public JavascriptExecutor js;
	public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.a = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); 
  
        PageFactory.initElements(driver, this);
    }

}
