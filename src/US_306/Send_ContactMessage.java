package US_306;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class Send_ContactMessage extends BaseDriver{

    @Test

    public void US_306(){

        driver.get("https://shopdemo.fatfreeshop.com/?");
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement BizeYazin = driver.findElement(By.xpath("//*[text()=' Contact Us']"));
        BizeYazin.click();

        WebElement nameInput = driver.findElement(By.id("sender_name"));
        nameInput.sendKeys("nemesis");

        WebElement emailInput = driver.findElement(By.id("sender_email"));
        emailInput.sendKeys("Deneme@gmail.com");

        WebElement subjectInput = driver.findElement(By.id("sender_subject"));
        subjectInput.sendKeys("konuBasligi");

        WebElement messageInput = driver.findElement(By.id("sender_message"));
        messageInput.sendKeys("HataMesaji");

        driver.switchTo().defaultContent();

        WebElement SendMessage = driver.findElement(By.xpath("//button[@id='send_message_button']"));
        SendMessage.click();

        myWait.until(ExpectedConditions.alertIsPresent());

        String errorText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        Assert.assertTrue(errorText.contains("didn't match"));

        BekleKapat();
    }


}
