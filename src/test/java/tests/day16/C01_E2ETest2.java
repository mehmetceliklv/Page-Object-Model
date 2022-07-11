package tests.day16;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_E2ETest2 {

    @Test (groups ="birinciGrup")
    public void     test() throws InterruptedException {

        //1. Tests packagenin altına class olusturun: D18_HotelRoomCreation
        //2. Bir metod olusturun: RoomCreateTest()
        //3. https://qa-environment.concorthotel.com/ adresine gidin.
        //4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        //a. Username : manager b. Password : Manager1!
        //5. Login butonuna tıklayın.
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();


        //6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        qaConcortPage.hotelManagementlink.click();
        qaConcortPage.addroomHotelRoomsLinki.click();
        qaConcortPage.addHotelRoomButonu.click();
        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.

        Select select=new Select(qaConcortPage.addRoomIdDropdown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAAddRoomIdHotel"));
        System.out.println(select.getFirstSelectedOption().getText());

        Faker faker=new Faker();
        Actions actions=new Actions(Driver.getDriver());

        actions
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name()+" "+faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHQAAddRoomDescription"))
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("CHQAAddRoomPrice")).perform();
        select=new Select(qaConcortPage.addRoomTypeDropdown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAAddRoomType"));

        actions.sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,2)))
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(0,5)))
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE).perform();

        //8. Save butonuna basin.

        Thread.sleep(2000);
        qaConcortPage.addRoomSaveButonu.click();

        Thread.sleep(2000);

        //9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        Assert.assertTrue(qaConcortPage.addRoomSuccessfulYazisi.isDisplayed());

        //10. OK butonuna tıklayın.
        qaConcortPage.addRoomAllertOkButonu.click();
        //11. Hotel rooms linkine tıklayın.
        actions.sendKeys(Keys.HOME).perform();

        Thread.sleep(2000);
        qaConcortPage.addroomHotelRoomsLinki.click();
        //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın.
        Assert.assertTrue(qaConcortPage.addRoomHotelRoomListyazisi.isDisplayed());

        Driver.closeDriver();
    }
}
