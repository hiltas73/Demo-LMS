package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarPage extends BasePage{

    @FindBy(xpath = "//h1")
    public WebElement pageTitle;

    @FindBy(xpath = "//button[@title='Month view'][@aria-pressed='true']")
    public WebElement monthViewActiveButton;

    @FindBy(xpath = "//button[@title='Month view'][@aria-pressed='false']")
    public WebElement monthViewPassiveButton;

    @FindBy(xpath = "//button[@title='Week view'][@aria-pressed='true']")
    public WebElement weekViewActiveButton;

    @FindBy(xpath = "//button[@title='Week view'][@aria-pressed='false']")
    public WebElement weekViewPassiveButton;

    @FindBy(xpath = "//div[@class='fc-timegrid-body']")
    public WebElement dailyHours;

    @FindBy(xpath = "//th[@role='columnheader']")
    public List<WebElement> weekDaysList;

}
