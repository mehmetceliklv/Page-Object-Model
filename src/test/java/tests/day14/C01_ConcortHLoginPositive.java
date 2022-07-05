package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C01_ConcortHLoginPositive extends TestBase {
    @Test
    public void positiveLoginTest(){

        // 	https://www.concorthotel.com/ adresine git
        driver.get("https://www.concorthotel.com/");

        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        //	login butonuna bas
        concortHotelPage.ilkLoginTusu.click();
        //	test data username: manager ,
        concortHotelPage.userNameKutusu.sendKeys("manager");
        //	test data password : Manager1!
        concortHotelPage.passwordKutusu.sendKeys("Manager1!");
        concortHotelPage.loginButonu.click();

        //	Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(concortHotelPage.basariliGirisYaziElementi.isDisplayed());
    }
}
