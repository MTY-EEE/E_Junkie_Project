package US_305;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US_305 extends BaseDriver {

    @Test
    public void Test01(){

        driver.get("https://shopdemo.fatfreeshop.com/");
        MyFunc.Bekle(2);

        //sepete ekleme
        WebElement AddToChartBtn = driver.findElement(By.xpath("//button[@onclick=\"return EJProductClick('1595015')\"]"));
        AddToChartBtn.click();
        MyFunc.Bekle(2);

        //Credit Card ile ödeme seçeneği
        WebElement iFrame1 = driver.findElement(By.xpath("//*[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iFrame1);

        WebElement creditCard = driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        creditCard.click();
        MyFunc.Bekle(2);


        //email giriş
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("willsmith@gmail.com");
        MyFunc.Bekle(2);

        //email confirmation
        WebElement confirmEmail = driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        confirmEmail.sendKeys("willsmith@gmail.com");
        MyFunc.Bekle(2);

        //Name On Card Addition
        WebElement NameOnCard = driver.findElement(By.xpath("//input[@placeholder='Name On Card']"));
        NameOnCard.sendKeys("Will Smith");
        MyFunc.Bekle(2);

        //Kart Numarası Yazma
        WebElement cardNoFrame = driver.findElement(By.xpath("//iframe[starts-with(@name, '__privateStripeFrame')]"));
        driver.switchTo().frame(cardNoFrame);

        WebElement CardNo = driver.findElement(By.xpath("//input[@placeholder='Kart numarası']"));
        CardNo.sendKeys("4242 4242 4242 4242 12/25 000");
        MyFunc.Bekle(40);


        //Ödemeye Tıklama
        driver.switchTo().parentFrame();
        WebElement payBtn = driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        payBtn.click();
        MyFunc.Bekle(2);

        //download Ekranı

        driver.switchTo().parentFrame();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Yeni sayfanın yüklenmesini bekle
        wait.until(ExpectedConditions.urlContains("https://www.fatfreecartpro.com/ecom/rp.php"));

        // Butonun kendisine değil, <a> elementine tıkla
        WebElement downloadLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@class='download_btn top10']")));


        // Tıklamayı JavaScript ile yap (güvenli tıklama)

        driver.switchTo().parentFrame();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", downloadLink);

        WebElement errorText = driver.findElement(By.cssSelector(".all_text.bottom_text.desktop_text"));

        try{
            Assert.assertFalse("Hata mesajı görüntülendi",
                    errorText.getText().contains("This download link (https://www.e-junkie.com/ecom/df.php?txn_id=st-ch_3RBkQ2FWSmRjvnlt1hVxPsZB&d_id=69086748&client_id=341695) has expired. "));
        } catch (Exception e) {
            System.out.println("Hata mesajı görüntülenemedi");
        }
        finally {
            BekleKapat();
        }
    }


}

