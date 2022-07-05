package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // facebook login sayfasina gidin
        driver.get("https://www.facebook.com");
        FacebookPage facebookPage=new FacebookPage(driver);
        // page sayfasinda cookiesGec elementi olusturun
        facebookPage.cookiesGec.click();
        // kullanici adi : mehmet@hotmail.com
        facebookPage.mailKutusu.sendKeys("mehmet@hotmail.com");
        // sifre : 22382238
        facebookPage.sifreKutusu.sendKeys("22382238");
        facebookPage.loginButton.click();
        // yazdigimizda giris yapamadigimizi test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());


    }
}
