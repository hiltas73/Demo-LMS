package com.stepDefinitions;

import com.pages.BasePage;
import com.pages.CoursesPage;
import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
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

    @When("user select a course {string}")
    public void userSelectACourse(String course) {
        CoursesPage.selectCourse(course);
    }

    @Then("user should see the details {string}")
    public void userShouldSeeTheDetails(String expectedCourseTitle) {
        String actualCourseTitle = CoursesPage.courseTitle.getText();
        System.out.println("actualCourseTitle = " + actualCourseTitle);
        Assert.assertEquals(expectedCourseTitle,actualCourseTitle);
    }
}
