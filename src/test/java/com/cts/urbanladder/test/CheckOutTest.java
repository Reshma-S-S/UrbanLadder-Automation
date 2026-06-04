package com.cts.urbanladder.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.cts.urbanladder.pages.BeingAtHome_Checkout_Page;
import com.cts.urbanladder.pages.BeingAtHome_Page;
import com.cts.urbanladder.pages.HomePage;
import com.cts.urbanladder.util.ExcelUtil;

public class CheckOutTest extends TestBase{

	@Test(priority = 1)
    public void searchBeingAtHome() throws IOException {
        HomePage hp = new HomePage(driver);
        hp.searchBoxEvent(ExcelUtil.getCellData(location, "Sheet2", 1, 0));
        hp.searchBoxClick();
    }
    
    @Test(priority = 2, dependsOnMethods = "searchBeingAtHome")
    public void handleBeingAtHomePage() throws InterruptedException {
        BeingAtHome_Page bp = new BeingAtHome_Page(driver);
        bp.hoverOverDesc();
        bp.optionsClick();
        bp.smallPopupHandle();
        bp.closingAd();
    }
    
    @Test(priority = 3, dependsOnMethods = "handleBeingAtHomePage")
    public void proceedToCheckout() throws IOException {
        BeingAtHome_Checkout_Page bcp = new BeingAtHome_Checkout_Page(driver);
        bcp.addToCartClick();
        bcp.checkOutClick();
        bcp.inputEmail(ExcelUtil.getCellData(location, "Sheet1", 1, 1));
        bcp.inputZip(ExcelUtil.getCellData(location, "Sheet1", 2, 1));
        bcp.inputAddress(ExcelUtil.getCellData(location, "Sheet1", 3, 1));
        bcp.inputFirstName(ExcelUtil.getCellData(location, "Sheet1", 4, 1));
        bcp.inputLastName(ExcelUtil.getCellData(location, "Sheet1", 5, 1));
        bcp.inputPhone(ExcelUtil.getCellData(location, "Sheet1", 6, 1));
        bcp.submitClick();
        System.out.println("Error Message: " + bcp.errorMsgEvent());
        System.out.println("------------------------------------------------------");
    }
	
}
