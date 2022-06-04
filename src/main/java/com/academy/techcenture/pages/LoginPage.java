package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.utils.CommonUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class LoginPage {
   private WebDriver driver ;
    private CommonUtils commonUtils;
    private WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.commonUtils = new CommonUtils();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);

    }


    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwdInput;

    @FindBy(id = "SubmitLogin")
    private WebElement submitBTN;

    @FindBy(xpath = "//h3[text()='Already registered?']")
    private WebElement loginHeaderTxt;

   @FindBy(xpath = "//label[@for='email']")
    private WebElement emailLabel;

    @FindBy(xpath = "//label[@for='passwd']")
    private WebElement passwdLabel;

    @FindBy(xpath = "//a[@title='Recover your forgotten password']")
    private WebElement forgetPasswdLink;


    @FindBy(xpath = "//h3[contains(text(),'Create an account')]")
    private WebElement createHeaderTxt;

    @FindBy(xpath = "//p[contains(text(),'Please enter your email')]")
    private WebElement createEmailSentence;

    @FindBy(xpath = "//label[@for='email_create']")
    private WebElement createEmailLabel;

    @FindBy(id = "email_create" )
    private WebElement createEmailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement submitCreateAccountBtn;

    @FindBy(xpath = "//div[contains(@class,'alert alert-danger')]//li")
    private WebElement authFailedError;

    @FindBy(id = "create_account_error")
    private WebElement alertMsg;


    private String[] invalidEmailAddress = {"kevin.lee@gmail", "kevin.leegmail", "kevin.lee@", "123456", "gmail.com"};




    public void login(){
        Assert.assertTrue(loginHeaderTxt.isDisplayed());
        Assert.assertTrue(emailLabel.isDisplayed());
        Assert.assertTrue(passwdLabel.isDisplayed());
        emailInput.clear();
        emailInput.sendKeys(ConfigReader.getProperty("username"));
        passwdInput.clear();
        passwdInput.sendKeys(ConfigReader.getProperty("password"));
        Assert.assertTrue(forgetPasswdLink.isDisplayed());
        Assert.assertTrue(submitBTN.isEnabled());
        Assert.assertEquals("sign in", submitBTN.getText().toLowerCase().trim());
        submitBTN.click();


        System.out.println("Clicking submit btn");


    }

    public void verifyLoginErrors(){

        emailInput.sendKeys("kevinlee1234@gmail.com");
        passwdInput.sendKeys("Kevin124");
        submitBTN.click();
        Assert.assertTrue(authFailedError.getText().equals("Authentication failed."), "error msg not correct");

        emailInput.clear();
        passwdInput.clear();

        emailInput.sendKeys("kevinlee1234@gmail");
        passwdInput.sendKeys("Kevin123");
        submitBTN.click();
        Assert.assertTrue(authFailedError.getText().equals("Invalid email address."), "invalid msg not correct");

        emailInput.clear();
        passwdInput.clear();


        emailInput.sendKeys("kevinlee1234@gmail");
        passwdInput.sendKeys("Kevin000");
        submitBTN.click();
        Assert.assertTrue(authFailedError.getText().equals("Invalid email address."), "invalid msg not correct");

        emailInput.clear();
        passwdInput.clear();

        passwdInput.sendKeys("Kevin123");
        submitBTN.click();
        Assert.assertTrue(authFailedError.getText().equals("An email address required."), "invalid msg not correct");

        emailInput.clear();
        passwdInput.clear();


        emailInput.sendKeys("kevinlee1234@gmail.com");
        submitBTN.click();
        Assert.assertTrue(authFailedError.getText().equals("Password is required."), "invalid msg not correct");


    }

    public void enterNewAddress() throws IOException {
        Assert.assertTrue(createHeaderTxt.isDisplayed());
        Assert.assertTrue(createEmailSentence.isDisplayed());
        Assert.assertTrue(emailLabel.isDisplayed());

        String randomEmail = commonUtils.randomEmail();
        ConfigReader.setProperty("randomEmail", randomEmail);
        createEmailInput.sendKeys(randomEmail);

        Assert.assertTrue(submitCreateAccountBtn.isEnabled());
        submitCreateAccountBtn.click();


    }

    public void verifyInvalidEmailAddress() throws InterruptedException {
        for (int i = 0; i < invalidEmailAddress.length; i++) {
            createEmailInput.sendKeys(invalidEmailAddress[i]);

            Assert.assertTrue(submitCreateAccountBtn.isEnabled());
            submitCreateAccountBtn.click();
            wait.until(ExpectedConditions.visibilityOf(alertMsg));

            Assert.assertEquals(alertMsg.getText().trim(), "Invalid email address.");
            Thread.sleep(1000);
            createEmailInput.clear();



        }
    }
































}
