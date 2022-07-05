package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

    WebDriver driver;

    public FacebookPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@id='email']")
    public WebElement mailKutusu;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement sifreKutusu;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath ="//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']" )
    public WebElement cookiesGec;

    @FindBy(className= "_9ay7")
    public WebElement girilemediYaziElementi;

}
