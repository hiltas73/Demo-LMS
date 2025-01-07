package com.pages;

import com.utilities.Driver;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static void navigateMenuTabs(String menuName){
        WebElement menuBtn = Driver.getDriver().findElement(By.xpath("//*[text()='" + menuName + "']"));
        menuBtn.click();
    }
}
