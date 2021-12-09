package WebElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class MainPage {

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@id='content']//..//h4")
    private WebElement logginMessage;

    @FindBy(css = "li[class='nav-item logout']")
    private WebElement logOut;

    @FindBy(css ="li[class='nav-item identifier']" )
    private WebElement admin;

    @FindBy(xpath ="//a[contains(text(),'My Account')]" )
    private WebElement MyAccount;

    @FindBy(xpath ="(//ul[@id='breadcrumbs']//li)[2]" )
    private WebElement MyAccountCountrol;



    public WebElement getLogginMessage() {
        return logginMessage;
    }

    public WebElement getLogOut() {
        return logOut;
    }
}
