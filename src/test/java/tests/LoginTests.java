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
import pages.HomePageHelper;
import pages.LoginPageHelper;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTests extends TestBase{
    LoginPageHelper loginPage;
    HomePageHelper homePage;

    @BeforeMethod
    public void testsInit()  {
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPage.waitUntilPageIsLoaded();
    }

    @Test
    public void LoginTestPositive() {
        String login = "victor";
        String password = "123";
        loginPage.enterLoginPasswordFieldsAndClick(login, password);
        homePage.waitUntilPageIsLoaded();
        Assert.assertTrue(homePage.isOpenedCorrectly());

        System.out.println("Text: " + homePage.getHomePageTitleText());
    }

    @Test
    public void LoginTestNegative() {
        String login = "victor";
        String password = "333";
        loginPage.enterLoginPasswordFieldsAndClick(login, password);
        Assert.assertTrue(loginPage.ErrorMessageAppears());

        System.out.println("Text: " + loginPage.getErrorMessageText());
    }

}
