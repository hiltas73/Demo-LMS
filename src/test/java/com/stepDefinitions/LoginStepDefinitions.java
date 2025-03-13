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

    @When("user enters a valid email")
    public void userEntersAValidEmail() {
        loginPage.emailBox.sendKeys(ConfigurationReader.getProperty("email"));
    }

    @And("user enters a valid password")
    public void userEntersAValidPassword() {
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @And("user click on Login button button")
    public void userClickOnLoginButtonButton() {
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
        Assert.assertEquals("Validation message test", expectedMessage, actualMessage);
    }

    @When("user leaves the email address box empty")
    public void userLeavesTheEmailAddressBoxEmpty() {
        loginPage.emailBox.sendKeys("");
    }

    @And("user click on Login button")
    public void userClickOnLoginButton() {
        loginPage.loginBtn.click();
    }

    @Then("the system display {string} message under the email box")
    public void theSystemDisplayMessageUnderTheEmailBox(String message) {
        String actualMessage = loginPage.emailBox.getAttribute("validationMessage");
        Assert.assertEquals("Validation message in email box test", message, actualMessage);
    }

    @And("user leaves the password box empty")
    public void userLeavesThePasswordBoxEmpty() {
        loginPage.passwordBox.sendKeys("");
    }

    @Then("the system display {string} message under the password box")
    public void theSystemDisplayMessageUnderThePasswordBox(String message) {
        String actualMessage = loginPage.passwordBox.getAttribute("validationMessage");
        Assert.assertEquals("Validation message in password box test", message, actualMessage);
    }
}
