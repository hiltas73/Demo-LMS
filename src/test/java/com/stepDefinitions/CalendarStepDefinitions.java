package com.stepDefinitions;

import com.pages.BasePage;
import com.pages.CalendarPage;
import com.utilities.Driver;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class CalendarStepDefinitions {

    CalendarPage calendarPage = new CalendarPage();

    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String expectedPageName) {
        BasePage.navigateMenuTabs("Calendar");
        assertEquals("Page verification test", expectedPageName, Driver.getDriver().getTitle());
    }
    @Given("the {string} view is currently displayed")
    public void the_view_is_currently_displayed(String viewName) {
        assertTrue("Month view test",calendarPage.monthViewActiveButton.isDisplayed());
        assertTrue("Week view test",calendarPage.weekViewPassiveButton.isDisplayed());
    }
    @When("the user clicks on the {string} view button on the top right")
    public void the_user_clicks_on_the_view_button_on_the_top_right(String viewButton) {
        // click on view button
        calendarPage.weekViewPassiveButton.click();
    }
    @Then("the calendar should display the weekly view")
    public void the_calendar_should_display_the_weekly_view() {
        assertTrue("Weekly view test",calendarPage.weekViewActiveButton.isDisplayed());
    }
    @Then("daily hours should be displayed on the left")
    public void daily_hours_should_be_displayed_on_the_left() {
        // verify timegrid hours is displayed
        assertTrue("Daily hours test",calendarPage.dailyHours.isDisplayed());
    }
    @Then("weekday numbers should be displayed on top")
    public void weekday_numbers_should_be_displayed_on_top() {
        // verify weekdays are displayed on the page
        assertTrue("Weekdays are displayed test", calendarPage.weekDaysList.get(0).isDisplayed());
        // verify weekdays all 7 are displayed
        assertEquals("Weekdays count test", 7, calendarPage.weekDaysList.size());
    }

}
