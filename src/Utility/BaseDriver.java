package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(20));

    //bunun sarti extends olmasi ve basta yer almasi
    static{
        KalanOncekileriKapat();
        driver=new ChromeDriver();

        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // 5 sn mühlet: elementi bulma mühleti
    }

    public static void BekleKapat(){
        MyFunc.Bekle(3);
        driver.quit();  // bütün açılmış windowları kapatır
    }

    public static void KalanOncekileriKapat() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {
        }
    }

    public static void ScreenShotOfWebElement(WebElement element, String name) throws IOException {
        DateTimeFormatter of2 = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDate = LocalDateTime.now().format(of2);

        File file = element.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file,new File("C:\\Users\\seiko_1rt9ul9\\IdeaProjects\\Team5SeleniumTekrar\\ScreenShots\\"+formattedDate+name+".jpg"));
    }

}
