package com.academy.techcenture;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.config.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.UserAccountPage;
import com.academy.techcenture.pages.UserRegistrationPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserRegistrationTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
    driver =Driver.getDriver();
        driver.get(ConfigReader.getProperty("URL"));
}

    @Test
    public void userRegistrationTest() throws IOException {
        HomePage homPage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(driver);



        homPage.clickSignInLink();
        loginPage.enterNewAddress();
        userRegistrationPage.registerUser();





    }
}
