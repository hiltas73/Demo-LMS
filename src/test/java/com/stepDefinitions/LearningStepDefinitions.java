package com.stepDefinitions;

import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LearningStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user logs in to the app")
    public void user_logs_in_to_the_app() {
        loginPage.login(ConfigurationReader.getProperty("email"), ConfigurationReader.getProperty("password"));
    }
    @When("user click on {string}")
    public void user_click_on(String appName) {
        loginPage.navigateApp(appName);
    }
    @Then("user should see Cydeo Learning page")
    public void user_should_see_cydeo_learning_page() {
        for(String each : Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current title while switching windows: " + Driver.getDriver().getTitle());
        }
        BrowserUtils.sleep(5);
        Assert.assertEquals("LMS navigate test", "CYDEO Learning", Driver.getDriver().getTitle());
    }

}
