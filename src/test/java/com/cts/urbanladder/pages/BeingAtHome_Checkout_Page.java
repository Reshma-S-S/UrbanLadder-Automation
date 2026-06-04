package com.cts.urbanladder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BeingAtHome_Checkout_Page extends BasePage{
	
	public BeingAtHome_Checkout_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[contains(text(),'Add to Cart')]")
	WebElement addToCartBtn;
	
	@FindBy(id="checkout-link")
	WebElement checkOutBtn;
	
	@FindBy(id="order_email")
	WebElement txtEmail;
	
	@FindBy(id="order_ship_address_attributes_zipcode")
	WebElement txtZip;
	
	@FindBy(id="order_ship_address_attributes_address1")
	WebElement txtAddress;
	
	@FindBy(xpath="//*[@placeholder='First Name']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//*[@placeholder='Last Name']")
	WebElement txtLastName;
	
	@FindBy(id="order_ship_address_attributes_phone")
	WebElement txtPhone;
	
	@FindBy(id="address-form-submit")
	WebElement submitBtn;
	
	@FindBy(xpath="//label[@class='error' and @for='order_ship_address_attributes_phone']")
	WebElement errorMsg;
	
	public void addToCartClick() {
		addToCartBtn.click();
	}
	public void checkOutClick() {
		checkOutBtn.click();
	}
	public void inputEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void inputZip(String zip) {
		txtZip.sendKeys(zip);
	}
	public void inputAddress(String addr) {
		txtAddress.sendKeys(addr);
	}
	public void inputFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	public void inputLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	public void inputPhone(String ph) {
		txtPhone.sendKeys(ph);
	}
	public void submitClick() {
		submitBtn.click();
	}
	public String errorMsgEvent() {
		return errorMsg.getText();
	}

}
