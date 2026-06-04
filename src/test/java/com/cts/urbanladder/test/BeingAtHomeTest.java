package com.cts.urbanladder.test;

import java.io.IOException;

import java.util.List;
import org.testng.annotations.Test;

import com.cts.urbanladder.pages.BeingAtHome_Page;
import com.cts.urbanladder.pages.HomePage;
import com.cts.urbanladder.util.ExcelUtil;


public class BeingAtHomeTest extends TestBase{
	
	@Test(priority = 1)
    public void searchBeingAtHome() throws IOException {
//        HomePage hp = new HomePage(driver);
//        hp.searchBoxEvent(ExcelUtil.getCellData(location, "Sheet2", 1, 0));
//        hp.searchBoxClick();
		BeingAtHome_Page bp = new BeingAtHome_Page(driver);
		bp.LightsClick();
		List<String> items = bp.listDisplay();
        System.out.println("Lightings :\n");
        for (int i=1; i <items.size();i++) {
            System.out.println(items.get(i));
        }
        System.out.println("------------------------------------------------------");
        
        
    }
    
//    @Test(priority = 2, dependsOnMethods = "searchBeingAtHome")
//    public void displaySubMenuItems() {
//        BeingAtHome_Page bp = new BeingAtHome_Page(driver);
//        bp.dropDownClick();
//        List<String> items = bp.listDisplay();
//        System.out.println("Sub-menu Items:\n");
//        for (String item : items) {
//            System.out.println(item);
//        }
//        System.out.println("------------------------------------------------------");
//    }

}
