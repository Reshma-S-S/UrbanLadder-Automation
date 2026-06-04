package com.cts.urbanladder.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
	public static WebDriver driver;
	public String location=System.getProperty("user.dir")+"//src//test//resources//Data.xlsx";
	
	@BeforeClass
	@Parameters({"browser"})
	void setup(@Optional("chrome") String br) throws IOException {
		Properties properties = new Properties();
	    FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties");
	    properties.load(inputStream);
	    String url=properties.getProperty("url");
	    switch(br.toLowerCase()) {
	    	case "chrome":
	    		driver=new ChromeDriver();
	    		break;
	    	case "edge":
	    		driver=new EdgeDriver();
	    		break;
	    		
	    	default:
                System.out.println("Invalid browser name."); // Print message if invalid browser name
                return;
	    }
		driver.get(url);
		driver.manage().window().maximize();
	}
	public String captureScreen(String tname) throws IOException { // Method to capture screenshot
		
		if (driver == null) {
            throw new IllegalStateException("Driver is not initialized.");
        }
		
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); // Generate timestamp for screenshot file name
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver; // Cast WebDriver to TakesScreenshot
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE); // Capture screenshot as file

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png"; // Define target file path
        File targetFile = new File(targetFilePath); // Create target file

        sourceFile.renameTo(targetFile); // Rename source file to target file

        return targetFilePath; // Return target file path
    }
	
	@AfterClass
	void tearDown() {
		if (driver != null) {
            driver.quit();
        }
	}
	
	
	


}
