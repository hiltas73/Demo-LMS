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

    @FindBy(xpath = "//span[@aria-hidden='true']")
    public WebElement toolTipHidden;

    public void login(String email, String password){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        this.emailBox.sendKeys(email);
        this.passwordBox.sendKeys(password);
        this.loginBtn.click();
    }

    public void navigateApp(String appName){
        Driver.getDriver().findElement(By.xpath("//*[text()='"+ appName +"']/..")).click();
    }

    public void missingCredentialsLogin(String emailOrPassword){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        if (emailOrPassword.equals("email")){
            this.emailBox.sendKeys("");
            this.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
            this.loginBtn.click();
        }else {
            this.emailBox.sendKeys(ConfigurationReader.getProperty("email"));
            this.passwordBox.sendKeys("");
            this.loginBtn.click();
        }
    }

    public String getValidationMessage(String fieldName){
        if (fieldName.equals("email")){
            return this.emailBox.getAttribute("validationMessage");
        }else if (fieldName.equals("password")){
            return this.passwordBox.getAttribute("validationMessage");
        } else {
            return "Error in validation message";
        }
    }

}
