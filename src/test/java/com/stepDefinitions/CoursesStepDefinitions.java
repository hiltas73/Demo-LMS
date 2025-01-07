package com.stepDefinitions;

import com.pages.BasePage;
import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CoursesStepDefinitions {

    @When("user click on {string} menu item")
    public void user_click_on_menu_item(String menuName) {
        BasePage.navigateMenuTabs(menuName);
    }
    @Then("user should see the {string} page")
    public void user_should_see_the_page(String pageName) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = pageName + " - Cydeo";
        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);
    }

}
