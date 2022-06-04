package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class UserAccountPage {
    //i need to create the constructor
    //i need to find the web elements
    //i need to create methods for user actions
    //i need to assert or validate the functional
    private WebDriver driver;


    public UserAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(className = "logout")
    private WebElement signOutLink;

    @FindBy(xpath = "//a[contains(@title,'View my')]")
    private WebElement userAccountLink;

    @FindBy(className = "page-heading")
    private WebElement myAccountHeader;

    @FindBy(xpath = "//div[contains(@class,'addresses-lists')]//ul/li//span")
    private List<WebElement> accountOptions;

    @FindBy(className = "info-account")
    private WebElement welcomeMsg;

    @FindBy(xpath = "//a[@title='Home']")
    private WebElement homeBtn;

    private String[] accountOptionsExpected = {"order history and details", "my credit slips",
            "my addresses", "my personal information", "my wishlists"};


    public void signOut(){
        Assert.assertTrue(signOutLink.isDisplayed(), "Sign out is not displayed");
        signOutLink.click();
        System.out.println("Clicking sign out");

    }

  public void verifyAccountOptions() {

      Assert.assertEquals(5, accountOptions.size());
      for (int i = 0; i < accountOptions.size(); i++) {
          Assert.assertEquals(accountOptions.get(i).getText().toLowerCase(), accountOptionsExpected[i],
                  "account option did not match" + accountOptionsExpected[i]);

      }
  }

  public void navigateHome(){
        Assert.assertTrue(homeBtn.isDisplayed());
        homeBtn.click();


  }

















}
