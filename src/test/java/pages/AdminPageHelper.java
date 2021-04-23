package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPageHelper extends PageBase {
    @FindBy(id = "club.conim.hahamim:id/cabModerPurchases")
    WebElement purchasesButton;


    public AdminPageHelper(WebDriver driver) {
        super(driver);
    }

    public AdminPageHelper waitUntilPageIsLoaded() {
        waitUntilElementIsVisible(purchasesButton, 15);
        return this;
    }

    public boolean adminPageIsOpenedCorrectly() {
        return purchasesButton.getText().equals("PURCHASE");
    }

    public String getCreateActionButtonText(){
        return purchasesButton.getText();
    }
}
