package US_303;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;

public class Negative_CreditCart extends BaseDriver {

    @Test
    public void Test3(){

        driver.get("https://shopdemo.fatfreeshop.com/?");
        MyFunc.Bekle(2);
        WebElement addToCartBtn=driver.findElement(By.xpath("//a[@href='/product/1595015/Demo-eBook']//div//button[@class='view_product']"));

        addToCartBtn.click();
        MyFunc.Bekle(5);

        WebElement iFrame1 = driver.findElement(By.xpath("//*[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iFrame1);

        WebElement KrediKartBtn=driver.findElement(By.xpath("//div[@class='Payment-Options'] / button[3] / span"));
        KrediKartBtn.click();
        MyFunc.Bekle(2);


        WebElement email=driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("team5@gmail.com");
        MyFunc.Bekle(2);

        WebElement confirmEmail=driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        confirmEmail.sendKeys("team5@gmail.com");
        MyFunc.Bekle(2);

        WebElement nameOnCard=driver.findElement(By.xpath("//input[@placeholder='Name On Card']"));
        nameOnCard.sendKeys("Team Campus");
        MyFunc.Bekle(2);

        WebElement iframe2=driver.findElement(By.xpath("//iframe[@title='Güvenli kart ödeme giriş çerçevesi']"));
        driver.switchTo().frame(iframe2);

        WebElement kartNumarasi=driver.findElement(By.xpath("//input[@placeholder='Kart numarası']"));
        kartNumarasi.sendKeys("1111 1111 1111 1111");
        MyFunc.Bekle(2);

        WebElement rbtDegilim=driver.findElement(By.xpath("//div[@id='checkbox']"));
        rbtDegilim.click();
        MyFunc.Bekle(2);

        WebElement payButton=driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        payButton.click();
        MyFunc.Bekle(2);

        WebElement gecersizKartNumarasıMsg=driver.findElement(By.xpath("//div[@id='SnackBar'] / span"));

        Assert.assertTrue("Aranan mesaj bulunamadı" , gecersizKartNumarasıMsg.getText().contains("Kart numaranız geçersiz."));

        BekleKapat();


    }

}
