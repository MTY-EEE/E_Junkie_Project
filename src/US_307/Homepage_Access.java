package US_307;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Homepage_Access extends BaseDriver {
    @Test
    public void Test1()
    {
        driver.get("https://shopdemo.fatfreeshop.com/?");
        MyFunc.Bekle(2);

        WebElement scrolElement= driver.findElement(By.xpath("//a[@class='EJ-ShopLink']"));
        new Actions(driver).scrollByAmount(0,500).build().perform();
        MyFunc.Bekle(2);

        WebElement ejunkieClick= driver.findElement(By.xpath("//a[@class='EJ-ShopLink']"));
        ejunkieClick.click();

        WebElement ejunkieLogo= driver.findElement(By.xpath("//img[@src='/wiki/user/themes/Wiki/images/logo.svg?123']"));
        ejunkieLogo.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("e-junkie.com") );

        BekleKapat();
    }


}
