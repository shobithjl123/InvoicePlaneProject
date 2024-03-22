package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static Utility.ConfigReader.*;

public class SharedSD {
    static WebDriver driver;
    @Before
    public void openUrl() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());
    }

    @After
    public void closeBrowser()
    {
        driver.close();
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

}
