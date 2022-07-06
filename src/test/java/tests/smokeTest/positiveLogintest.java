package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class positiveLogintest {

    @Test
    public void test(){

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        QAConcortPage qaConcortPage=new QAConcortPage();

        qaConcortPage.ilkLoginTusu.click();
        qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.click();

        Assert.assertTrue(qaConcortPage.basariliGirisYaziElementi.isDisplayed());

        Driver.closeDriver();
    }
}
