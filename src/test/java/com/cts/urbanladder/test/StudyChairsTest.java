package com.cts.urbanladder.test;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;
import com.cts.urbanladder.pages.HomePage;
import com.cts.urbanladder.pages.StudyChairs_Page;
import com.cts.urbanladder.util.ExcelUtil;

public class StudyChairsTest extends TestBase{
	
	@Test(priority = 1)
    public void searchStudyChairs() throws IOException {
        HomePage hp = new HomePage(driver);
        hp.searchBoxEvent(ExcelUtil.getCellData(location, "Sheet2", 0, 0));
        hp.searchBoxClick();
    }
    
    @Test(priority = 2, dependsOnMethods = "searchStudyChairs")
    public void displayStudyChairsDetails() throws InterruptedException {
        StudyChairs_Page scp = new StudyChairs_Page(driver);
        List<String> titles = scp.titlesDisplay();
        List<String> prices = scp.pricesDisplay();
        System.out.println("Study Chairs:");
        for (int i = 0; i < titles.size(); i++) {
            System.out.println("Title: " + titles.get(i));
            System.out.println("Price: " + prices.get(i));
            System.out.println();
        }
        System.out.println("------------------------------------------------------");
    }

}
