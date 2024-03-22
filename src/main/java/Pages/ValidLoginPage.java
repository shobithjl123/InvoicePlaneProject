package Pages;

import com.google.common.annotations.VisibleForTesting;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class ValidLoginPage extends Base {

    @FindBy(id="email")
    WebElement userName;

    @FindBy(id = "password")
    WebElement passWord;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;

    @FindBy(xpath = "//a[.='Dashboard']")
    WebElement actualTitle;


    public ValidLoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void enterUsername(String username)
    {
        userName.sendKeys(username);
    }

    public void enterPassword(String password)
    {
        passWord.sendKeys(password);
    }

    public void clickLoginbtn()
    {
        btnLogin.click();
    }

    public void verifyDashboardPage() {
        String actualText = actualTitle.getText();
        String expectedText = "Dashboard";
        Assert.assertEquals(actualText, expectedText, "User is not in the Home or Dashboard page");
    }

}
