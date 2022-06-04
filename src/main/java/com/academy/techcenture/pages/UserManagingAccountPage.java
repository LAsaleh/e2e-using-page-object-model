package com.academy.techcenture.pages;

import com.academy.techcenture.utils.CommonUtils;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class UserManagingAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private CommonUtils commonUtils;

    public UserManagingAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.commonUtils = new CommonUtils();
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[contains(text(),'Contact us')][1]")
    private WebElement contactUsBtn;

    @FindBy(xpath = "//a[contains(text(),'Sign out')][1]")
    private WebElement signOutBtnManage;

    @FindBy(xpath = "//div[@class='header_user_info'][1]")
    private WebElement userNameBtn;

    @FindBy(xpath = "//img[contains(@class,'logo img-responsive')]")
    private WebElement yourLogoImg;

    @FindBy(id = "search_query_top")
    private WebElement inputSearch;

    @FindBy(xpath = "//span[text()='Search']")
    private WebElement searchBtn;

    @FindBy(xpath = "//a[contains(@title,'View my shopping cart')]")
    private WebElement shoppingCart;

    @FindBy(xpath = "//ul[contains(@class,'sf-menu')]/li")
    private List<WebElement> categories;

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement myAccountHeader;

    @FindBy(className = "info-account")
    private WebElement welcomingTxt;

    @FindBy(xpath = "//div[contains(@class,'addresses-lists')]/div/ul/li")
    private List<WebElement> rowAddressesList;

    @FindBy(xpath = "//a[@title='Home']")
    private WebElement backHomeBtn;



    public void manageAccountVerifying(){
        workSpaceManageVerifying();
    }


    private String[] options = {"WOMEN", "DRESSES", "T-SHIRTS"};

    private String[] allListMsgS = {"ORDER HISTORY AND DETAILS", "MY CREDIT SLIPS", "MY ADDRESSES", "MY PERSONAL INFORMATION", "MY WISHLISTS"};


    private void workSpaceManageVerifying(){
        Assert.assertEquals(contactUsBtn.getText(),"Contact us");
        Assert.assertTrue(contactUsBtn.isEnabled());

        Assert.assertEquals(userNameBtn.getText(), "Kevin Lee");
        Assert.assertTrue(yourLogoImg.isDisplayed());

        Assert.assertTrue(inputSearch.isDisplayed());
        Assert.assertTrue(searchBtn.isEnabled());
        Assert.assertTrue(shoppingCart.isDisplayed());

        for (int i = 0; i < categories.size(); i++) {
            Assert.assertEquals(categories.get(i).getText().trim(), options[i], "DID NOT MATCH");
        }

        Assert.assertEquals(myAccountHeader.getText(), "MY ACCOUNT");
        Assert.assertEquals(welcomingTxt.getText(), "Welcome to your account. Here you can manage all of your personal information and orders.");

        for (int i = 0; i < rowAddressesList.size(); i++) {
           Assert.assertEquals(rowAddressesList.get(i).getText().trim(), allListMsgS[i], "");
        }

        Assert.assertTrue(backHomeBtn.isDisplayed());
        backHomeBtn.click();

        Assert.assertTrue(signOutBtnManage.isEnabled());
        signOutBtnManage.click();

    }




}
