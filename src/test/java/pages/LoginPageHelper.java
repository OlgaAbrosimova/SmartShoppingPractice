package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase{
    @FindBy(id = "club.conim.hahamim:id/fldLogin")
    WebElement loginField;

    @FindBy(id = "club.conim.hahamim:id/fldEditPassword")
    WebElement passwordField;

    @FindBy(id = "club.conim.hahamim:id/linkComeIn")
    WebElement comeInLink;

    @FindBy(id = "club.conim.hahamim:id/fldRememberMeCheck")
    WebElement rememberMeCheck;

    @FindBy(id = "club.conim.hahamim:id/alertTitle")
    WebElement alertTitle;

    @FindBy(id = "android:id/message")
    WebElement authentificationErrorMessage;
    //"Authentification server error"

    public LoginPageHelper(WebDriver driver){
        super(driver);
    }
    public String getRememberMeCheckText(){
        return rememberMeCheck.getText();
    }


    public LoginPageHelper waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(loginField, 15);
        return this;
    }

    public LoginPageHelper enterLoginPasswordFieldsAndClick(String login, String password) {
        loginField.click();
        loginField.sendKeys(login);
        passwordField.click();
        passwordField.sendKeys(password);
        comeInLink.click();
        return this;
    }

    public boolean ErrorMessageAppears() {
        return authentificationErrorMessage.getText().equals("Authentification server error");
    }

    public String getErrorMessageText() {
        return authentificationErrorMessage.getText();
    }

    public LoginPageHelper waitUntilMessageAppears() {
        waitUntilElementIsVisible(authentificationErrorMessage, 15);
        return this;
    }
}
