package com.academy.techcenture;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.config.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.UserManagingAccountPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserManagingAccountTest {
    private WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("URL"));
    }

    @Test
    public void userManagingAccountTest(){
        HomePage homPage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        UserManagingAccountPage userManagingAccountPage = new UserManagingAccountPage(driver);


        homPage.clickSignInLink();
        loginPage.login();
        userManagingAccountPage.manageAccountVerifying();


    }


    @AfterMethod
    public void cleanUp(){
        if(driver != null){
            driver.quit();
        }
    }
}
