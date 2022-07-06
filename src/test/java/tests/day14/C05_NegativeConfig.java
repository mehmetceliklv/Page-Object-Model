package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C05_NegativeConfig extends TestBase {

    @Test
    public void test (){

        driver.get(ConfigReader.getProperty("CHUrl"));

        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);

        concortHotelPage.ilkLoginTusu.click();
        concortHotelPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHInvalidUsername"));
        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        concortHotelPage.loginButonu.click();
        Assert.assertTrue(concortHotelPage.loginFailyazisi.isDisplayed());

    }
}
