package com.academy.techcenture;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.config.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.UserAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

//ths class will contain all test methods that checks the login functionality.

public class UserLoginTest {

    private WebDriver driver;


    @BeforeMethod
    public void setUp(){

        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("URL"));
    }

    @Test
    public void userLoginPositive() {


        HomePage homPage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        UserAccountPage userAccountPage = new UserAccountPage(driver);


        homPage.clickSignInLink();
        loginPage.login();
        userAccountPage.verifyAccountOptions();
        userAccountPage.navigateHome();
        homPage.signOut();
        homPage.clickSignInLink();
        loginPage.verifyLoginErrors();


    }


        @AfterMethod
        public void cleanUp() {

            if (driver != null) {
                driver.quit();
            }
        }



    }

