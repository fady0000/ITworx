package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDateTime;

public class EndToEndScenario extends TestBase{
    LocalDateTime date = LocalDateTime.now();
    int seconds = date.toLocalTime().toSecondOfDay();
     public String firstName = "Fady";
    public String lName = "michel" + seconds;
    public String mail = firstName+seconds+"@gmail.com";
    public String pass = "P@ssw0rd123";

    int myBudget = 350;

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void RegisterTest ()  {
        homePage.openAccountList();
        homePage.selectRegister();
        regPage.setFirstName(firstName);
        regPage.setLastName(lName);
        regPage.setEmailAddress(mail);
        regPage.setPassword(pass);
        regPage.setConfPass(pass);
        regPage.submitData();
        Assert.assertTrue(regPage.thanksMsg().contains("Thank you for registering with Madison Island."));
        homePage.openAccountList();
        homePage.selectLogOut();
    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void login () {
        homePage.openAccountList();
        homePage.selectLogin();
        loginPage.setEmailAddress(mail);
        loginPage.setPassword(pass);
        loginPage.submitLogin();
        Assert.assertTrue(driver.getPageSource().contains(firstName));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void purchasingProduct(){
        homePage.openWomenList();
        denimPage.openItemDetails();
        productDetails.setColor(1);
        productDetails.setSize(1);
        productDetails.addToCard();
        Assert.assertTrue(productDetails.getGrandTotal() < myBudget);
    }
}
