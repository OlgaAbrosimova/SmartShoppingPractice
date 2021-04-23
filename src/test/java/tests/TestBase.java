package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageHelper;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public AppiumDriver driver;
    LoginPageHelper loginPage;

    @BeforeMethod
    public void startUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","10.0");
        capabilities.setCapability("appPackage","club.conim.hahamim");
        capabilities.setCapability("appActivity",".activities.MainActivity");
        capabilities.setCapability("automationName","Uiautomator2");
        capabilities.setCapability("app", "D:/Olga/QA/AutoQA/IntelliG IDEA/SmartShopping/SmartShoppingPractice/apk/konim-hahamim-v0.8.6.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        loginPage.waitUntilPageIsLoaded();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
