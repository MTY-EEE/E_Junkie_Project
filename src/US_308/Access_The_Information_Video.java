package US_308;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class Access_The_Information_Video extends BaseDriver {

    @Test
    public void eJunkie() throws AWTException {

        driver.get("https://shopdemo.fatfreeshop.com/?");

        if (driver == null || Objects.requireNonNull(driver.getPageSource()).contains("504 Gateway Time-out")) {
            assert driver != null;
            driver.get("https://shopdemo.e-junkie.com/");
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement eCommerceLnk = driver.findElement(By.linkText("E-commerce by E-junkie"));
        eCommerceLnk.click();

        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("e-junkie.com"), "URL shopdemo.e-junkie.com içermiyor!");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement _14DayFreeTrialText = driver.findElement(By.xpath("//*[text()='14-Day FREE Trial']"));
        wait.until(ExpectedConditions.visibilityOf(_14DayFreeTrialText.findElement(By.xpath("//*[text()='14-Day FREE Trial']"))));

        WebElement ejunkieLink = driver.findElement(By.xpath("//*[@href='/']/img"));
        ejunkieLink.click();

        WebElement seeHowItWorksBtn = driver.findElement(By.xpath("//*[@onclick='toggleYoutubeModal(true)']"));
        wait.until(ExpectedConditions.elementToBeClickable(seeHowItWorksBtn)).click();

        Robot robot = new Robot();
        for (int i = 0; i < 17; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            MyFunc.Bekle(1);
        }
        for (int j = 0; j < 2; j++) {
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            MyFunc.Bekle(11);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement closeBtn = driver.findElement(By.cssSelector("[aria-label='close']"));
        new Actions(driver).moveToElement(closeBtn).click().perform();

        BekleKapat();
    }
}