package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PantsAndDenimPage extends PageBase {
    public PantsAndDenimPage(WebDriver driver) {
        super(driver);
    }

private By tribecaSkinny = By.xpath(" //a[@class='button'][contains(@href,'skinny')]");


    @Step("Select Product")
    public void openItemDetails(){
        click(tribecaSkinny);
    }

}
