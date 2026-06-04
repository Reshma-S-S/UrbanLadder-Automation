package com.cts.urbanladder.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cts.urbanladder.pages.BeingAtHome_Page;
import com.cts.urbanladder.pages.Bookshelves_Page;
import com.cts.urbanladder.pages.HomePage;

public class BookshelvesExcludeTest extends TestBase{
	@Test(priority = 1)
    public void openBookshelvesPage() {
        HomePage hp = new HomePage(driver);
        hp.bookshelvesClick();
    }
    
    @Test(priority = 2, dependsOnMethods = "openBookshelvesPage")
    public void closeAd() {
        BeingAtHome_Page bahp = new BeingAtHome_Page(driver);
        bahp.closingAd();
    }
    
    @Test(priority = 3, dependsOnMethods = "closeAd")
    public void filterBookshelves() {
        Bookshelves_Page bp = new Bookshelves_Page(driver);
        bp.storageHover();
        bp.storageTypeClick();
        bp.priceHover();
        bp.priceSliderEvent();
        bp.clickexcludestock();
        bp.clickFilterButton();
     
    }
    
    @Test(priority = 4, dependsOnMethods = "filterBookshelves")
    public void printBookshelvesDetails() throws InterruptedException {
        Bookshelves_Page bp = new Bookshelves_Page(driver);
       
        List<WebElement> li = bp.getBookShelfNames();
        List<WebElement> li2 = bp.getBookShelfPrices();
        System.out.println("Name and price of bookShelves excluding out of stock");
        System.out.println("-----------------------------------------------------");
        System.out.println("");
        Map<String, String> productMap = new HashMap<String, String>(); 
        
        for (int i = 0; i <= 2; i++) {
            productMap.put(li.get(i).getText(), li2.get(i).getText());
        }
        for (String key : productMap.keySet()) {
            System.out.println("Product Name: " + key + ", Price: " + productMap.get(key));
            System.out.println();
        }
        System.out.println("------------------------------------------------------");
    }
}
