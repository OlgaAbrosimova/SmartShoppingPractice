package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BPartnerPageHelper extends PageBase {
    @FindBy(id = "club.conim.hahamim:id/cabmBtnCreateAction")
    WebElement createActionButton;


    public BPartnerPageHelper(WebDriver driver) {
        super(driver);
    }

    public BPartnerPageHelper waitUntilPageIsLoaded() {
        waitUntilElementIsVisible(createActionButton, 15);
        return this;
    }

    public boolean BPartnerPageIsOpenedCorrectly() {
        return createActionButton.getText().equals("CREATE ACTION");
    }

    public String getCreateActionButtonText(){
        return createActionButton.getText();
    }
}
