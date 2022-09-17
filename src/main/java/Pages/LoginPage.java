package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By emailAddress = By.name("login[username]");
    private By password = By.name("login[password]");
    private By loginButton = By.xpath("//button[@title='Login']");


    @Step("Set Email Address: [{mail}]")
    public void setEmailAddress(String mail){
        setText(emailAddress,mail);
    }
@Step("Set Password: [{pass}]")
    public void setPassword(String pass){
        setText(password ,pass);
    }

    @Step("Click On Login Button")
    public void submitLogin(){
        click(loginButton);
    }
}
