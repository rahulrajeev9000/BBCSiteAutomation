package pom.bbcsite.BbcPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BbcHomePage {

    private WebDriver driver;

    //page objects
    private String HomePageURL = "https://www.bbc.co.uk/";
    private By signInLinkID = By.id("idcta-username");

    public BbcHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //page actions

    public void goToHomePage(){
        driver.navigate().to(HomePageURL);
    }

    public void clickSignInLink(){
        driver.findElement(signInLinkID).click();
    }


}
