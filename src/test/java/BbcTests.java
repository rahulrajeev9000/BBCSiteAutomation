import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.bbcsite.BbcPages.BbcRegisterPage;
import pom.bbcsite.BbcPages.BbcSignInPage;
import pom.bbcsite.BbcSIte;
import utilities.DriverUtilities;

public class BbcTests {

    static BbcSIte bbcSIte = new BbcSIte(DriverUtilities.getInstanceOfDriverUtilities().getDriver());

    @Test
    public void debugger(){
        bbcSIte.getBbcHomePage().goToHomePage().clickSignInLink();
       // bbcSIte.getBbcHomePage().clickSignInLink();
    }

    @Test
    public void testPasswordErrorMessage(){
        bbcSIte.getBbcSignInPage().goToSignInPage();
        bbcSIte.getBbcSignInPage().inputUserName("test@gmail.com").inputPassword("232").clickSubmitButton();
//        bbcSIte.getBbcSignInPage();
//        bbcSIte.getBbcSignInPage());
        Assert.assertEquals("Sorry, that password is too short. It needs to be eight characters or more.", bbcSIte.getBbcSignInPage().getPasswordErrorText());
    }

    @Test
    public void testRegistering() throws InterruptedException {
        bbcSIte.getBbcRegisterPage().goToRegisterPage();
        Thread.sleep(3000);
        bbcSIte.getBbcRegisterPage().clickOver13Button();
        Thread.sleep(2000);
        bbcSIte.getBbcRegisterPage().fullDOB();
        bbcSIte.getBbcRegisterPage().submit();
        bbcSIte.getBbcRegisterPage().enterNewEmail();
        bbcSIte.getBbcRegisterPage().enterPassword();
        bbcSIte.getBbcRegisterPage().enterPostcodeID();
        bbcSIte.getBbcRegisterPage().enterGender();
        Thread.sleep(1000);
        bbcSIte.getBbcRegisterPage().submit();
        Thread.sleep(1000);
        Assert.assertTrue(bbcSIte.getBbcRegisterPage().getSignedInNotification().contains("Ok you're signed in"));
    }

    @Test
    public void testRegisteringfalse() throws InterruptedException {
        bbcSIte.getBbcRegisterPage().goToRegisterPage();
        Thread.sleep(3000);
        bbcSIte.getBbcRegisterPage().clickOver13Button();
        Thread.sleep(2000);
        bbcSIte.getBbcRegisterPage().fullDOB();
        bbcSIte.getBbcRegisterPage().submit();
        bbcSIte.getBbcRegisterPage().enterEmail();
        bbcSIte.getBbcRegisterPage().enterPassword();
        bbcSIte.getBbcRegisterPage().enterPostcodeID();
        bbcSIte.getBbcRegisterPage().enterGender();
        Thread.sleep(1000);
        bbcSIte.getBbcRegisterPage().submit();
        Thread.sleep(1000);
        Assert.assertTrue(bbcSIte.getBbcRegisterPage().getSignInError().contains("Looks like you’ve already registered with this email"));
    }

    @AfterClass
    public static void teardown(){
        bbcSIte.closeDriver();
    }

}
