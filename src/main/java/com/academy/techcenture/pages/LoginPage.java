package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver ;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
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




    public void login(){
        Assert.assertTrue(loginHeaderTxt.isDisplayed(),"Login Header text was not displayed");
        Assert.assertTrue(emailLabel.isDisplayed(), " Email label was not displayed");
        Assert.assertTrue(passwdLabel.isDisplayed(), " Password label was not displayed");
        emailInput.clear();
        emailInput.sendKeys("kevinlee1234@gmail.com");
        passwdInput.clear();
        passwdInput.sendKeys("Kevin123");
        Assert.assertTrue(forgetPasswdLink.isDisplayed(),"Forget passwd is not displayed");
        Assert.assertTrue(submitBTN.isEnabled(), "Submit button was not enabled");
        Assert.assertEquals("sign in", submitBTN.getText().toLowerCase().trim());
        submitBTN.click();


        System.out.println("Clicking submit btn");


    }


    public void verifyLoginErrors(){

        emailInput.sendKeys("kevinlee1234@gmail.com");
        passwdInput.sendKeys("Kevin123");
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






























}
