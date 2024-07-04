package com.flow.stepdefinitions;

import com.flow.hooks.Hooks;
import com.flow.pages.auth.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestLogin {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static LoginPage loginPage = new LoginPage();

    public TestLogin() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("Input url web {string}")
    public void input_url_web(String Url) {
        driver.get(Url);
        extentTest.log(LogStatus.PASS, "Input url web");
        Hooks.delay(1);
    }

    @Then("Menampilkan halaman login {string}")
    public void menampilkan_halaman_login(String expect) {
        if (expect.equals("true")) {
            Assert.assertEquals(loginPage.getTitlePage(), expect);
            extentTest.log(LogStatus.PASS, "Menampilkan halaman login");
        } else {
            Assert.assertEquals(loginPage.getTitlePage(), expect);
            extentTest.log(LogStatus.FAIL, "Gagal Menampilkan halaman login");
        }
        // System.out.println(loginPage.getTitlePage().contains(expect));
    }

    @When("User input username {string}")
    public void user_input_username(String username) {
        Hooks.delay(1);
        loginPage.setTxtUsername(username);
        extentTest.log(LogStatus.PASS, "User input username");
    }

    @When("User input password {string}")
    public void user_input_password(String password) {
        Hooks.delay(1);
        loginPage.setTxtPassword(password);
        extentTest.log(LogStatus.PASS, "User input password");
    }

    @When("Klik tombol Sign In {string}")
    public void klik_tombol_sign_in(String statusTest) {
        Hooks.delay(0.5);
        loginPage.clickBtn();
        extentTest.log(LogStatus.PASS, "Klik Tombol Sign In");
    }

    @Then("Berhasil login dan menampilkan halaman dashboard {string}")
    public void berhasil_login_dan_menampilkan_halaman_dashboard(String txtDashboardPage) {
        Hooks.delay(1);
        if (txtDashboardPage.contains("Failed")) {
            Assert.assertEquals(loginPage.getTextInvalidCredentials(), "Invalid user and password");
            loginPage.clickAlertBtn();
            extentTest.log(LogStatus.PASS, "Menampilkan alert Invalid Credentials");
        } else if (txtDashboardPage.contains("Dashboard")) {
            Assert.assertTrue(loginPage.getTextDashboardPage().contains("SMART FLOW"));
            extentTest.log(LogStatus.PASS, "Menampilkan halaman dashboard");
            Hooks.delay(1);
        }
    }

}
