package com.stepDefinitions;

import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

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

        assertEquals("Login Test", expectedPageTitle, actualPageTitle);

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
        assertEquals("Validation message test", expectedMessage, actualMessage);
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
        assertEquals("Validation message in email box test", message, actualMessage);
    }

    @And("user leaves the password box empty")
    public void userLeavesThePasswordBoxEmpty() {
        loginPage.passwordBox.sendKeys("");
    }

    @Then("the system display {string} message under the password box")
    public void theSystemDisplayMessageUnderThePasswordBox(String message) {
        String actualMessage = loginPage.passwordBox.getAttribute("validationMessage");
        assertEquals("Validation message in password box test", message, actualMessage);
    }

    @Then("the password field should be masked")
    public void thePasswordFieldShouldBeMasked() {
        assertEquals("Password field is masked test","password", loginPage.passwordBox.getAttribute("type"));
    }

    @When("user click on the eye icon")
    public void userClickOnTheEyeIcon() {
        loginPage.toggleBtn.click();
    }

    @Then("the password should be visible")
    public void thePasswordShouldBeVisible() {
        //System.out.println(loginPage.passwordBox.getAttribute("type"));
        assertEquals("Password should be visible test","text", loginPage.passwordBox.getAttribute("type"));
    }

    @When("user enter {string} in email field")
    public void userEnterInEmailField(String email) {
        loginPage.emailBox.sendKeys(email);
    }

    @And("user enter {string} in password field")
    public void userEnterInPasswordField(String password) {
        loginPage.passwordBox.sendKeys(password);
    }

    @Then("email and password fields should have {string}")
    public void emailAndPasswordFieldsShouldHave(String expectedBorderColor) {
        // get the cssValue of email box
        String emailBoxCssValue = loginPage.emailBox.getCssValue("border-color");
        // get the cssValue of password box
        String passwordBoxCssValue = loginPage.passwordBox.getCssValue("border-color");

        BrowserUtils.sleep(2);
        assertEquals("Email box red color test", expectedBorderColor, emailBoxCssValue);
        assertEquals("Password box red color test", expectedBorderColor, passwordBoxCssValue);
    }

    @And("user should see the error message {string}")
    public void userShouldSeeTheErrorMessage(String expectedErrorMessage) {
        // get error message
        loginPage.getValidationMessage(expectedErrorMessage);
    }

}
