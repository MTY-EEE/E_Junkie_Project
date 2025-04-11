package US_301;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEbookToCart extends BaseDriver {

    @Test
    public void AddEbookToCart() {
        driver.get("https://shopdemo.fatfreeshop.com/?");
        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://shopdemo.fatfreeshop.com/?", driver.getCurrentUrl());
        System.out.println("E-junkie.com doğru şekilde yüklendi.");
        MyFunc.Bekle(2);

        WebElement ebook= driver.findElement(By.xpath("//*[text()='Demo eBook']"));
        ebook.click();
        System.out.println("Ebook ürününe tıklandı.");
        MyFunc.Bekle(2);

        WebElement addToCart= driver.findElement(By.xpath("//*[text()='ADD TO CART']"));
        addToCart.click();
        System.out.println("Sepete Ekle butonuna tıklandı.");
        MyFunc.Bekle(2);

        WebElement iframe=driver.findElement(By.xpath("//*[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(), 'Demo eBook')]")));
        System.out.println("Demo e-Kitabı başarıyla sepete eklendi.");

        WebElement addPromoCode=driver.findElement(By.xpath("//*[text()='Add Promo Code']"));
        addPromoCode.click();
        System.out.println("Promosyon koduna tıklandı.");

        WebElement writePromoCode=driver.findElement(By.xpath("//*[@placeholder='Promo Code']"));
        writePromoCode.sendKeys("123");
        System.out.println("Geçersiz kod girildi.");
        MyFunc.Bekle(2);

        WebElement applyButton = driver.findElement(By.xpath("//button[contains(text(), 'Apply')]"));
        applyButton.click();
        System.out.println("Uygula butonuna tıklandı.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Invalid promo code')]")));
        System.out.println("Geçersiz promosyon kodu uyarısı başarıyla görüntülendi.");

} }
