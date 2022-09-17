package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends PageBase {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By emailAddress = By.id("email_address");
    private By password = By.id("password");
    private By confPassword = By.id("confirmation");
    private By RegisterButton = By.xpath("//button[@title='Register']");
    private By successMsg = By.cssSelector("li[class='success-msg'] ul li span");


    @Step("Add First Name: [{name}]")
    public void setFirstName(String name){
        setText(firstName,name);
    }

    @Step("Add Last Name: [{lName}]")
    public void setLastName (String lName){
        setText(lastName,lName);
    }

    @Step("Add Email Address: [{mail}]")
    public void setEmailAddress(String mail) {
      setText(emailAddress , mail);
    }

    @Step("Add Password: [{pass}]")
    public void setPassword(String pass){
        setText(password, pass);
    }

    @Step("Add Confirm Password: [{pass}]")
    public void setConfPass (String pass){
        setText(confPassword , pass);
    }

    @Step("Click On Register Button")
    public void submitData(){
        click(RegisterButton);
    }


    public String thanksMsg (){
     return action(successMsg).getText();
    }

}
