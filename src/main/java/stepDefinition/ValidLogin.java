package stepDefinition;

import Pages.ValidLoginPage;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static stepDefinition.SharedSD.getDriver;

public class ValidLogin {

    ValidLoginPage validLoginPage;



@Given("^user is in login page$")
    public void givenLoginPage()
    {
        validLoginPage= new ValidLoginPage(getDriver());
    }

    @When("^user enters valid (.+) and (.+)$")
    public void userEntersValiduserNameAndPassword(String uname, String pwd)
    {
        validLoginPage.enterUsername(uname);
        validLoginPage.enterPassword(pwd);
    }


    @Then("^User should be redirected to Home page$")
    public void userShouldBeRedirectedToHomeDashboardPage() {
        validLoginPage.verifyDashboardPage();
    }


    @And("^Clicks on Login Button$")
    public void clicksOnLoginButton() {
        validLoginPage.clickLoginbtn();
    }
}
