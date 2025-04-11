package US_304;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Odeme_Onaylama extends BaseDriver {

    @Test
    public void Test(){

        driver.get("https://shopdemo.e-junkie.com/");
        MyFunc.Bekle(2);

        WebElement demoEbook = driver.findElement(By.xpath("//*[@href='/product/1595015/Demo-eBook'] // button"));
        demoEbook.click();

        WebElement iFrame1 = driver.findElement(By.xpath("//*[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iFrame1);

        WebElement payCart = driver.findElement(By.xpath("//*[@class='Payment-Button CC']"));
        payCart.click();

        WebElement email = driver.findElement(By.xpath("//*[@placeholder='Email']"));
        email.sendKeys("tteam.5.techno@gmail.com");

        WebElement confirmEmail = driver.findElement(By.xpath("//*[@placeholder='Confirm Email']"));
        confirmEmail.sendKeys("tteam.5.techno@gmail.com");

        WebElement nameCard = driver.findElement(By.xpath("//*[@placeholder='Name On Card']"));
        nameCard.sendKeys("Team 5");

        //WebElement iframe2= driver.findElement(By.xpath("//iframe[@name='__privateStripeFrame6193']"));
        WebElement iframe2 = driver.findElement(By.xpath("//iframe[@title='Güvenli kart ödeme giriş çerçevesi']"));
        driver.switchTo().frame(iframe2);

        WebElement cardNo = driver.findElement(By.cssSelector("[name='cardnumber']"));
        cardNo.sendKeys("4242424242424242");

        WebElement SKT = driver.findElement(By.xpath("//*[@placeholder='AA / YY']"));
        SKT.sendKeys("12/25");

        WebElement CVC = driver.findElement(By.xpath("//*[@placeholder='CVC']"));
        CVC.sendKeys("000");

        driver.switchTo().parentFrame();

        MyFunc.Bekle(15);

        WebElement payBtn = driver.findElement(By.xpath("//*[@class='Pay-Button']"));
        payBtn.click();

        driver.switchTo().defaultContent();

        WebElement onayMesaj = driver.findElement(By.xpath("//*[@class='confirme_text'] //span"));
        Assert.assertTrue("Aranan mesaj bulunamadı", onayMesaj.getText().contains("your order is confirmed"));

        BekleKapat();
    }
}
