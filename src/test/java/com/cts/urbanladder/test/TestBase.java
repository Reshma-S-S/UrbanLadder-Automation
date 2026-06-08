package com.cts.urbanladder.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    public static WebDriver driver;
    public String location = System.getProperty("user.dir") + "/src/test/resources/Data.xlsx";

    @BeforeClass
    @Parameters({ "browser" })
    public void setup(@Optional("chrome") String br) throws IOException {

        // ✅ Load properties file properly
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/config.properties");

        properties.load(inputStream);

        String url = properties.getProperty("url");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("headless"));

        System.out.println("Launching Browser: " + br);
        System.out.println("Headless Mode: " + isHeadless);

        // ✅ Cross-browser setup with WebDriverManager
        switch (br.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }

                driver = new ChromeDriver(chromeOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();

                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) {
                    edgeOptions.addArguments("--headless=new");
                    edgeOptions.addArguments("--window-size=1920,1080");
                }

                driver = new EdgeDriver(edgeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Invalid browser name: " + br);
                throw new RuntimeException("Invalid browser");
        }

        // ✅ Important setup
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(url);
    }

    // ✅ FIXED Screenshot Method
    public String captureScreen(String tname) throws IOException {

        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized.");
        }

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        String targetPath = System.getProperty("user.dir") + "/screenshots/" + tname + "_" + timeStamp + ".png";

        File targetFile = new File(targetPath);

        FileUtils.copyFile(sourceFile, targetFile); // ✅ FIXED

        return targetPath;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}