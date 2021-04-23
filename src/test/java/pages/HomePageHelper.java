package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHelper extends PageBase {
    @FindBy(className = "android.widget.TextView")
    WebElement homePageTitle;

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public HomePageHelper waitUntilPageIsLoaded() {
        waitUntilElementIsVisible(homePageTitle, 15);
        return this;
    }

    public boolean isOpenedCorrectly() {
        return homePageTitle.getText().equals("Club of smart shopping");
    }

    public String getHomePageTitleText(){
        return homePageTitle.getText();
    }

}
