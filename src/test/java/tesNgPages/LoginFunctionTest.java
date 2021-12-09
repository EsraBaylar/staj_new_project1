package tesNgPages;

import WebElements.LoginWebElements;
import WebElements.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Driver;

public class LoginFunctionTest {

    LoginWebElements lg;
    MainPage mp;
    WebDriver driver;

    @Test(dataProvider ="credentials" )
    public void loginFunction(String username, String password, String location, String message){
        boolean selected=false;
        lg=new LoginWebElements();
        mp=new MainPage();

        driver= Driver.getDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();

        lg.getUserName().sendKeys(username);
        lg.getPassword().sendKeys(password);

        for (WebElement lc: lg.getSessionLocations()){
            if (lc.getText().equals(location)){
                lc.click();
                selected=true;
            }
        }

        lg.getLogIn().click();

        if (selected){
            if (username.equals("Admin") && password.equals("Admin123")){
                Assert.assertTrue(mp.getLogginMessage().getText().contains("Logged"));
                mp.getLogOut().click();
            }
            else {
                Assert.assertTrue(lg.getInvalidError().getText().contains("Invalid"));
            }
        }else
            Assert.assertTrue(lg.getLocationError().getText().contains("choose"));

        driver.manage().deleteAllCookies();

    }

    @DataProvider
    public Object[][] credentials(){

        Object[][] objects={
                {"Admin","Admin123", "Inpatient Ward","Login Successfu"},
                {"admin","admin123", "Pharmacy","Invalid Credentials"},
                {"","Admin123","Laboratory","Invalid Credentials"},
                {"Admin","","Isolation Ward","Invalid Credentials"},
                {"Admin","Admin123","","Choose Location"}
        };
        return objects;
    }

    @AfterClass
    public void finish(){
        Driver.quitDriver();
    }
}
