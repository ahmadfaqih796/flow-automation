package com.flow.pages.auth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flow.drivers.DriverSingleton;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement txtUsername;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement btnSignIn;

    @FindBy(xpath = "//h1[normalize-space()='Dashboard']")
    WebElement txtDashboardPage;

    @FindBy(xpath = "//div[@class='brand']")
    WebElement txtLoginPage;

    @FindBy(xpath = "//strong[normalize-space()='Gagal!']")
    WebElement invalidCredentials;

    @FindBy(xpath = "//div[contains(text(),'Username required')]")
    WebElement requiredUsername;

    @FindBy(xpath = "//div[contains(text(),'Please enter password')]")
    WebElement requiredPassword;

    public void setTxtUsername(String username) {
        this.txtUsername.clear();
        this.txtUsername.sendKeys(username);
    }

    public void setTxtPassword(String password) {
        this.txtPassword.clear();
        this.txtPassword.sendKeys(password);
    }

    public void clickBtnSignIn() {
        this.btnSignIn.click();
    }

    public void loginUser(String username, String password) {
        this.txtUsername.sendKeys(username);
        this.txtPassword.sendKeys(password);
        this.btnSignIn.click();
    }

    public String getTextInvalidCredentials() {
        return this.invalidCredentials.getText();
    }

    public String getTextDashboardPage() {
        return this.txtDashboardPage.getText();
    }

    public String getTxtLoginPage() {
        return txtLoginPage.getText();
    }

    public String getTitlePage() {
        String resultTitle = "";
        String titlePageNotFound = driver.getTitle();
        String titlePageLogin = driver.getTitle();
        if (titlePageNotFound.contains("404 Page Not Found")) {
            resultTitle = titlePageNotFound;
        } else if (titlePageLogin.contains("Login Page | PT DIKA")) {
            resultTitle = titlePageLogin;
        }
        return resultTitle;
    }

    public String getRequired() {
        return this.txtUsername.getAttribute("required");
    }
}
