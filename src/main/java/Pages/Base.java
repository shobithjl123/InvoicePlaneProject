package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

import static stepDefinition.SharedSD.getDriver;

public class Base {
    public static WebElement webAction(By locator) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(50)) // max time
                .pollingEvery(Duration.ofSeconds(5)) // every 5 seconds
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ArithmeticException.class)
                .ignoring(NullPointerException.class)
                .ignoring(Exception.class)
                .withMessage(
                        "WebDriver waited for 50 seconds but still " +
                                "could not find the element therefore " +
                                "Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver)
            {
                return driver.findElement(locator);
            }
        });

        return element;
    }

    public void setValue(By locator,String value)
    {
        //webAction(locator)-->driver.findElement(locator);
        webAction(locator).sendKeys(value);
    }

    public void closeBrowser()
    {
        getDriver().close();
    }
}
