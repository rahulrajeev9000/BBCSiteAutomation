package pom.bbcsite.BbcPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BbcSignInPage {

    private WebDriver driver;


    private String BbcSignInPageURL ="https://account.bbc.com/signin";

    //page identifiers
    private By usernameFieldID = By.id("user-identifier-input");
    private By passwordFieldID = By.id("password-input");
    private By submitButtonID = By.id("submit-button");
    private By passwordErrorMessageID = By.id("form-message-password");

    public BbcSignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToSignInPage(){
        driver.navigate().to(BbcSignInPageURL);
    }

    public BbcSignInPage inputUserName(String name){
        driver.findElement(usernameFieldID).sendKeys(name);
        return this;
    }

    public BbcSignInPage inputPassword(String password){
        driver.findElement(passwordFieldID).sendKeys(password);
        return this;
    }

    public BbcSignInPage clickSubmitButton(){
        driver.findElement(submitButtonID).click();
        return this;
    }

    public String getPasswordErrorText(){
        return driver.findElement(passwordErrorMessageID).getText();
    }

}
