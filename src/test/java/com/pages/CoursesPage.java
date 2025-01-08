package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursesPage extends BasePage{

    @FindBy(xpath = "//h1[@class='NS_Title-Info']")
    public static WebElement courseTitle;

    public static void selectCourse(String courseName){
        Driver.getDriver().findElement(By.xpath("//*[text()='"+ courseName +"']")).click();
    }

}
