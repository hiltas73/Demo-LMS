package com.pages;

import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@id='username']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[text()='Log Out']")
    public WebElement logOutBtn;

    public void login(String email, String password){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        this.emailBox.sendKeys(email);
        this.passwordBox.sendKeys(password);
        this.loginBtn.click();
    }

    public void navigateApp(String appName){
        Driver.getDriver().findElement(By.xpath("//*[text()='"+ appName +"']/..")).click();
    }

}
