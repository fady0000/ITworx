package Pages;

import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductDetails extends PageBase {
    public ProductDetails(WebDriver driver) {
        super(driver);
    }
    private By color = By.id("attribute92");
    private By size = By.id("attribute180");
    private By addToCardButton= By.xpath("(//button[@title=\"Add to Cart\"])[1]");
    private By priceCard = By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[3]");
    Double productPrice;
    public String strPrice;

    @Step("Set Product Color")
    public void setColor (int numberOfOption){
        selectFromList(color,numberOfOption);
    }
    @Step("Set Product Size")
    public void setSize(int NumberOfOption){
        selectFromList(size ,NumberOfOption);
    }


    @Step("Add Product To Card")
    public void addToCard(){
        click(addToCardButton);
    }


    public String getContainsOfPriceCard(){
        return getTextContain(priceCard);
    }

    public Double getGrandTotal(){
        String price = getContainsOfPriceCard();
        String[]arrOfPrice=price.split("\\p{Sc}");
        for(String val : arrOfPrice)
            strPrice= val;
            productPrice = Double.parseDouble(strPrice);
            return productPrice;
    }

    }
