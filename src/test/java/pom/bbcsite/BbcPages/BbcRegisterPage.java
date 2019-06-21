package pom.bbcsite.BbcPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BbcRegisterPage {

    private WebDriver driver;

    private String BbcRegisterPageURL ="https://account.bbc.com/register";


    private By over13ButtonXpath = By.xpath("//*[@id=\"container\"]/div/div/div/div[2]/div[2]/div[2]/div/div[3]/fieldset/div[1]/a[2]/span");
    private By dayInputID= By.id("day-input");
    private By monthInputID= By.id("month-input");
    private By yearInputID= By.id("year-input");
    private By emailID = By.id("user-identifier-input");
    private By passwordID = By.id("password-input");
    private By postcodeID = By.id("postcode-input");
    private By genderID = By.id("gender-input");
    private By submitButtonID = By.id("submit-button");
    private By signedInNotification = By.xpath("//*[@id=\"container\"]/div/div/div/div[2]/div[2]/div[2]/div/h1");
    private By signInError = By.xpath("//*[@id=\"form-message-email\"]/p");

    int r1 = (int)(Math.random() * 100 + 1);
    int r2 = (int)(Math.random() * 100 + 1);
    int r3 = (int)(Math.random() * 100 + 1);
    String email = "hahgd"+r1+"fjk"+r2+"+"+r3+"@gmail.com";




    public BbcRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToRegisterPage(){
        driver.navigate().to(BbcRegisterPageURL);
    }

    public void clickOver13Button(){
        driver.findElement(over13ButtonXpath).click();
    }

    public void fullDOB(){
        driver.findElement(dayInputID).sendKeys("20");
        driver.findElement(monthInputID).sendKeys("11");
        driver.findElement(yearInputID).sendKeys("1996");
    }

    public void submit(){
        driver.findElement(submitButtonID).click();
    }

    public void enterEmail(){
        driver.findElement(emailID).sendKeys("reagdadgkl@gmail.com");
    }

    public void enterNewEmail(){
        driver.findElement(emailID).sendKeys(email);
    }

    public void enterPassword(){
        driver.findElement(passwordID).sendKeys("relFkl34com");
    }

    public void enterPostcodeID(){
        driver.findElement(postcodeID).sendKeys("EC2Y 5AS");
    }

    public void enterGender(){
        Select passOption = new Select(driver.findElement(genderID));
        passOption.selectByVisibleText("Male");
    }

    public String getSignedInNotification(){
        return driver.findElement(signedInNotification).getText();
    }

    public String getSignInError(){
        return driver.findElement(signInError).getText();
    }


}
