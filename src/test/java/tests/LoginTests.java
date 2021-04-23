package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPageHelper;
import pages.BPartnerPageHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;
import util.DataProviders;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTests extends TestBase{
    LoginPageHelper loginPage;
    HomePageHelper homePage;
    BPartnerPageHelper bPartnerPage;
    AdminPageHelper adminPage;

    @BeforeMethod
    public void testsInit()  {
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        bPartnerPage = PageFactory.initElements(driver, BPartnerPageHelper.class);
        adminPage = PageFactory.initElements(driver, AdminPageHelper.class);
        loginPage.waitUntilPageIsLoaded();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "enterLoginPasswordPositiveFromFile")
    public void LogInAuthenticationTestPositive(String login, String password) {
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLoginPasswordFieldsAndClick(login, password);
        homePage.waitUntilPageIsLoaded();
        Assert.assertTrue(homePage.isOpenedCorrectly());

        System.out.println("Text: " + homePage.getHomePageTitleText());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "enterLoginPasswordNegativeFromFile")
    public void LogInAuthenticationTestNegative(String login, String password) {
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLoginPasswordFieldsAndClick(login, password);
        loginPage.waitUntilMessageAppears();
        Assert.assertTrue(loginPage.ErrorMessageAppears());

        System.out.println("Text: " + loginPage.getErrorMessageText());
    }

    @Test
    public void LogInBPartnerAutorisationTestPositive() {
        String login = "aron";
        String password = "123";
        loginPage.enterLoginPasswordFieldsAndClick(login, password);
        bPartnerPage.waitUntilPageIsLoaded();
        Assert.assertTrue(bPartnerPage.BPartnerPageIsOpenedCorrectly());

        System.out.println("Text: " + bPartnerPage.getCreateActionButtonText());
    }

    @Test
    public void LogInAdminAutorisationTestPositive() {
        String login = "vova";
        String password = "123";
        loginPage.enterLoginPasswordFieldsAndClick(login, password);
        adminPage.waitUntilPageIsLoaded();
        Assert.assertTrue(adminPage.adminPageIsOpenedCorrectly());

        System.out.println("Text: " + adminPage.getCreateActionButtonText());
    }

}
