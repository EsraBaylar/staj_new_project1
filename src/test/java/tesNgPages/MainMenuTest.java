package tesNgPages;

import WebElements.LoginWebElements;
import WebElements.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Driver;

public class MainMenuTest {
    LoginWebElements lg;
    WebDriver driver;
    MainPage mp;
    @Test()
    public void MainFunction(){

        lg=new LoginWebElements();
        mp=new MainPage();


        driver= Driver.getDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();

        lg.getUserName().sendKeys("Admin");
        lg.getPassword().sendKeys("Admin123");


        lg.getLogIn().click();


    }
}
