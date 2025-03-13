package com.stepDefinitions;

import com.pages.LoginPage;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user navigate to login URL")
    public void user_navigate_to_login_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("user enters email")
    public void user_enters_email() {
        loginPage.emailBox.sendKeys(ConfigurationReader.getProperty("email"));
    }
    @When("user enters password")
    public void user_enters_password() {
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
    }
    @When("click on login button")
    public void click_on_login_button() {
        loginPage.loginBtn.click();
    }
    @Then("user should see home page")
    public void user_should_see_home_page() {
        String actualPageTitle = Driver.getDriver().getTitle();
        String expectedPageTitle = "Dashboard - Cydeo";

        Assert.assertEquals("Login Test", expectedPageTitle, actualPageTitle);

        loginPage.logOutBtn.click();
    }

    @When("user leave {string} empty")
    public void userLeaveEmpty(String emailOrPassword) {
        loginPage.missingCredentialsLogin(emailOrPassword);
    }

    @Then("{string} should appear under {string}")
    public void shouldAppearUnder(String expectedMessage, String emptyField) {
        // get actual validation message from the related field email or password
        String actualMessage = loginPage.getValidationMessage(emptyField);

        // assert validation message is correct
        Assert.assertEquals("Validation message test",expectedMessage, actualMessage);
    }

    @When("user leaves the email address box empty")
    public void userLeavesTheEmailAddressBoxEmpty() {
        loginPage.emailBox.sendKeys("");
    }

    @And("user enters a valid password")
    public void userEntersAValidPassword() {
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @And("user click on Login button")
    public void userClickOnLoginButton() {
        loginPage.loginBtn.click();
    }

    @Then("the system display {string} message under the email box")
    public void theSystemDisplayMessageUnderTheEmailBox(String message) {
        String actualMessage = loginPage.emailBox.getAttribute("validationMessage");
        Assert.assertEquals("Validation message in email box test",message, actualMessage);
    }
}
