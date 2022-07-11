package tests.day15;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_E2ETest {
    //1. Tests packagenin altına class olusturun: D17_CreateHotel
    //2. Bir metod olusturun: createHotel
    //3. https://qa-environment.concorthotel.com/ adresine git.
    //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri
    //girin.
    //a. Username : manager
    //b. Password : Manager1!



    //5. Login butonuna tıklayın.
    //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
    //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
    //8. Save butonuna tıklayın.
    //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
    //10. OK butonuna tıklayın.

    @Test (groups ="birinciGrup")
    public void test () throws InterruptedException {
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();

        qaConcortPage.hotelManagementlink.click();
        qaConcortPage.hotelListlink.click();
        qaConcortPage.addHotellink.click();

        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
         actions
                 .click(qaConcortPage.addHotelCodeBox)
                 .sendKeys(faker.address().zipCode())
                 .sendKeys(Keys.TAB)
                 .sendKeys(faker.name().name()+" "+faker.name().lastName())
                 .sendKeys(Keys.TAB)
                 .sendKeys(faker.address().fullAddress())
                 .sendKeys(Keys.TAB)
                 .sendKeys(faker.phoneNumber().cellPhone())
                 .sendKeys(Keys.TAB)
                 .sendKeys(faker.internet().emailAddress()).perform();

        Select select=new Select(qaConcortPage.dropDownIdGroup);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAAddHotelDropdownOption"));
        System.out.println(select.getFirstSelectedOption().getText());

        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        Thread.sleep(1000);
        System.out.println(qaConcortPage.hotelBasariliInsertedyazisi.getText());
        Assert.assertTrue(qaConcortPage.hotelBasariliInsertedyazisi.isDisplayed());

        qaConcortPage.addHotelAllertOk.click();





    }
}
