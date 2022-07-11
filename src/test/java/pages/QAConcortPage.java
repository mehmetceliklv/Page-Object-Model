package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class QAConcortPage {

   public WebDriver driver;

    public QAConcortPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(linkText = "Log in")
    public WebElement ilkLoginTusu;

    @FindBy(id = "UserName")
    public WebElement userNameKutusu;

    @FindBy(id = "Password")
    public WebElement passwordKutusu;

    @FindBy(id ="btnSubmit")
    public WebElement loginButonu;

    @FindBy(xpath="//span[text()='ListOfUsers']")
    public WebElement basariliGirisYaziElementi;

    @FindBy(xpath="//span[text()='Try again please']")
    public WebElement loginFailyazisi;

    @FindBy(xpath ="//span[text()='Hotel Management']" )
    public WebElement hotelManagementlink;

    @FindBy(xpath ="//a[@href='/admin/HotelAdmin']" )
    public WebElement hotelListlink;

    @FindBy(xpath ="//span[text()='Add Hotel ']" )
    public WebElement addHotellink;

    @FindBy(id ="Code")
    public WebElement addHotelCodeBox;

    @FindBy(id ="IDGroup")
    public WebElement dropDownIdGroup;

    @FindBy(xpath ="//div[text()='Hotel was inserted successfully']")
    public WebElement hotelBasariliInsertedyazisi;

    @FindBy(xpath="//button[@class='btn btn-primary']")
    public WebElement addHotelAllertOk;


    @FindBy(xpath="//button[@id='details-button']")
    public WebElement connectionNotPrivateAdvancedButton;

    @FindBy(xpath="//a[@id='proceed-link']")
    public WebElement connectionProceedButton;

    @FindBy(xpath ="//a[@href='/admin/HotelRoomAdmin']")
    public WebElement addroomHotelRoomsLinki;

    @FindBy(xpath ="//span[text()='Add Hotelroom ']")
    public WebElement addHotelRoomButonu;

    @FindBy(id="IDHotel")
    public WebElement addRoomIdDropdown;

    @FindBy(id="IDGroupRoomType")
    public WebElement addRoomTypeDropdown;

    @FindBy(id="btnSubmit")
    public WebElement addRoomSaveButonu;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement addRoomSuccessfulYazisi;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement addRoomAllertOkButonu;

    @FindBy(xpath ="//span[text()='List Of Hotelrooms']")
    public WebElement addRoomHotelRoomListyazisi;

    @FindBy(xpath = "//thead/tr[1]/th")
    public List<WebElement> basliklarListesi;

    @FindBy(xpath = "//tbody")
    public WebElement tBodyTumu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement birinciSatir;

     @FindBy(xpath = "//tbody/tr//td[4]")
    public List<WebElement> dorduncuSutunListesi;


    public void  ConcortHotelLogin(){
     Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

     QAConcortPage qaConcortPage=new QAConcortPage();
     qaConcortPage.connectionNotPrivateAdvancedButton.click();
     qaConcortPage.connectionProceedButton.click();
     qaConcortPage.ilkLoginTusu.click();
     qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
     qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
     qaConcortPage.loginButonu.click();

    }

     public String printData(int satir, int sutun) {
     // ornekteki haliyle 3.satir, 5.sutundaki elemani yazdiralim
     //  String xpath= //tbody//tr[3]//td[5]
     // degismeyecek kisimlari String, degisecek kisimlari ise parametre ismi olarak yazdik
      String xpath= "//tbody//tr[" + satir +"]//td["+ sutun + "]";
     //System.out.println(xpath);

     // satir no : 3, sutun no : 5
     //System.out.println("satir no : "+ satir+ " sutun no : " + sutun);

     // @FindBy notasyonu parametreli calismadigi icin onceki yontemle locate edelim
     String istenenData = Driver.getDriver().findElement(By.xpath(xpath)).getText();
     System.out.println("satir no  "+ satir+ ", sutun no : " + sutun + "'deki data : " + istenenData );

  return istenenData;
 }

}
