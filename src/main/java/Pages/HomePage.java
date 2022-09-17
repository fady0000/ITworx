package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By AccountList = By.xpath("//a[@class='skip-link skip-account']");
    private By Register = By.linkText("Register");
    private By login = By.linkText("Log In");
    private By logOut = By.linkText("Log Out");
    private By womenList = By.xpath("(//a[@class=\"level0 has-children\"])[1]");
    private By pantsAndDenim= By.xpath("//a[@href='http://magento-demo.lexiconn.com/women/pants-denim.html']");
    @Step("Open Account List")
public void openAccountList (){
    click(AccountList); }

    @Step("Open Registration Page")
    public void selectRegister(){
        click(Register);
    }
    @Step("Open Login Page")
    public void selectLogin(){
        click(login);}

        @Step("Log Out")
    public void selectLogOut(){
        click(logOut);
    }

    @Step("Open Women List")
    public void openWomenList(){
      hoverAndClickOnElement(womenList,pantsAndDenim);

    }


}

