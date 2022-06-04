package com.academy.techcenture.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = " //a[@class='login']")
    private WebElement signInLIke;

    @FindBy(linkText = "Contact us")
    private WebElement contactUsLLink;

    @FindBy(className = "logout")
    private WebElement signOutLink;

    public void clickSignInLink() {
        Assert.assertTrue(driver.getTitle().equals("My Store"), "title is not correct");
        Assert.assertTrue(signInLIke.isDisplayed(), "Sign in link was not displayed");
        signInLIke.click();
        System.out.println("Clicking sign in link");
    }

    public void clickContactUsLink() {
        Assert.assertTrue(contactUsLLink.isDisplayed(), "Contact link was not displayed");
        contactUsLLink.click();
        System.out.println("Clicking contact us link");
    }


    public void signOut() {
        if(signOutLink.isDisplayed()){
            signOutLink.click();
            System.out.println("Clicking sign out");
        }


    }
}