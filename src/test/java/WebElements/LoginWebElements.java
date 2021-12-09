package WebElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class LoginWebElements {

    public LoginWebElements() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "loginButton")
    private WebElement logIn;

    @FindBy(css = "ul[id='sessionLocation']>li")
    private List<WebElement> sessionLocations;

    @FindBy(id = "error-message")
    private WebElement invalidError;

    @FindBy(id = "sessionLocationError")
    private WebElement locationError;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLogIn() {
        return logIn;
    }

    public List<WebElement> getSessionLocations() {
        return sessionLocations;
    }

    public WebElement getInvalidError() {
        return invalidError;
    }

    public WebElement getLocationError() {
        return locationError;
    }
}
