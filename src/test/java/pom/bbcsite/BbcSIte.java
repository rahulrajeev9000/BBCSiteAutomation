package pom.bbcsite;

import org.openqa.selenium.WebDriver;
import pom.bbcsite.BbcPages.BbcHomePage;
import pom.bbcsite.BbcPages.BbcRegisterPage;
import pom.bbcsite.BbcPages.BbcSignInPage;

public class BbcSIte {

    private WebDriver driver;
    private BbcHomePage bbcHomePage;
    private BbcSignInPage bbcSignInPage;
    private BbcRegisterPage bbcRegisterPage;


    public BbcSIte(WebDriver driver) {
        this.driver = driver;
        bbcHomePage = new BbcHomePage(driver);
        bbcSignInPage = new BbcSignInPage(driver);
        bbcRegisterPage = new BbcRegisterPage(driver);
    }

    //pages
    public BbcHomePage getBbcHomePage(){
        return bbcHomePage;
    }
    public BbcSignInPage getBbcSignInPage(){
        return bbcSignInPage;
    }

    public BbcRegisterPage getBbcRegisterPage() {
        return bbcRegisterPage;
    }

    //driver actions
    public void closeDriver(){
        driver.quit();
    }
}
