package tests;

import Pages.*;
import com.google.common.collect.ImmutableMap;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class TestBase {

    String URL = "http://magento-demo.lexiconn.com/";

   WebDriver driver;
   HomePage homePage;
   RegistrationPage regPage;
   LoginPage loginPage;
   PantsAndDenimPage denimPage;
   ProductDetails productDetails;

        @BeforeSuite
        void setEnvironment() {
            allureEnvironmentWriter(
                    ImmutableMap.<String, String>builder()
                            .put("Browser", "Chrome")
                            .put("Browser.Version", "97.0.4692.71")
                            .build(), System.getProperty("user.dir")
                            + "/allure-results/");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.navigate().to(URL);


        }

        @BeforeMethod
        public void setUp(){
            homePage = new HomePage(driver);
            regPage = new RegistrationPage(driver);
            loginPage = new LoginPage(driver);
            denimPage = new PantsAndDenimPage(driver);
            productDetails = new ProductDetails(driver);


        }

        @AfterSuite
        public void tearDown(){
            driver.quit();


    }

}
