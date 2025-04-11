package US_302;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class US_302 extends BaseDriver {

    @Test
    public void testUS302() throws IOException {
        driver.get("https://shopdemo.fatfreeshop.com/?");
        Assert.assertTrue(driver.getCurrentUrl().contains("https://shopdemo.fatfreeshop.com"));
        Assert.assertTrue(driver.getTitle().contains("E-junkie Shop"));
        List<WebElement> items = driver.findElements(By.xpath("//*[@class='box']"));

        for (int i = 0; i < items.size(); i++) {
            WebElement name = items.get(i).findElement(By.tagName("h4"));
            myWait.until(ExpectedConditions.visibilityOf(items.get(i)));
            Assert.assertTrue(items.get(i).isDisplayed());
            ScreenShotOfWebElement(items.get(i), name.getText());

        }

        WebElement addToCartButton = driver.findElement(By.xpath("(//*[@class='view_product'])[2]"));
        Assert.assertTrue(addToCartButton.isDisplayed());
        Assert.assertTrue(addToCartButton.isEnabled());
        ScreenShotOfWebElement(addToCartButton,"_addToCartButton");
        addToCartButton.click();

        WebElement iFrame1 = driver.findElement(By.xpath("//*[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iFrame1);
        WebElement shoppingCart = driver.findElement(By.xpath("(//span[@class='Cart-Items-Nos'])[2]"));
        myWait.until(ExpectedConditions.visibilityOf(shoppingCart));
        MyFunc.Bekle(2);
        ScreenShotOfWebElement(shoppingCart,"_shoppingCart");
        Assert.assertTrue(shoppingCart.isDisplayed());
        Assert.assertTrue(shoppingCart.isEnabled());
        Assert.assertTrue(shoppingCart.getText().contains("1"));


        WebElement payCCButton = driver.findElement(By.xpath("//*[@class='Payment-Button CC']"));
        ScreenShotOfWebElement(payCCButton,"_payCCButton");
        payCCButton.click();

        WebElement emailInputField = driver.findElement(By.xpath("//*[@placeholder='Email']"));
        ScreenShotOfWebElement(emailInputField,"_emailInputField");
        emailInputField.clear();

        WebElement confirmEmailInputField = driver.findElement(By.xpath("//*[@placeholder='Confirm Email']"));
        ScreenShotOfWebElement(confirmEmailInputField, "_confirmEmailInputField");
        confirmEmailInputField.clear();


        WebElement nameOrCardInputField = driver.findElement(By.xpath("//*[@placeholder='Name On Card']"));
        ScreenShotOfWebElement(nameOrCardInputField,"_nameOrCardInputField");
        nameOrCardInputField.clear();


        WebElement phoneInputField = driver.findElement(By.xpath("//*[@placeholder='Optional']"));
        ScreenShotOfWebElement(phoneInputField,"_phoneInputField");
        phoneInputField.clear();

        WebElement iFrame2 = driver.findElement(By.xpath("(//*[contains(@name,'privateStripeFrame')])[1]"));
        driver.switchTo().frame(iFrame2);

        WebElement cardNumberInputField = driver.findElement(By.xpath("//*[@name='cardnumber']"));
        cardNumberInputField.clear();
        cardNumberInputField.sendKeys("4242 4242 4242 4242");
        ScreenShotOfWebElement(cardNumberInputField,"_cardNumberInputField");

        WebElement expDateInputField = driver.findElement(By.xpath("//*[@name='exp-date']"));
        expDateInputField.clear();
        expDateInputField.sendKeys("1225");
        ScreenShotOfWebElement(expDateInputField,"_expDateInputField");

        WebElement cvcInputField = driver.findElement(By.xpath("//*[@name='cvc']"));
        cvcInputField.clear();
        cvcInputField.sendKeys("000");
        ScreenShotOfWebElement(cvcInputField,"_cvcInputField");
        MyFunc.Bekle(20);

        driver.switchTo().parentFrame();

        WebElement payButton = driver.findElement(By.xpath("//*[@class='Pay-Button']"));
        ScreenShotOfWebElement(payButton, "_payButton");
        payButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='SnackBar']"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(errorMessage.getText().contains("Invalid Email"));
        Assert.assertTrue(errorMessage.getText().contains("Invalid Billing Name"));
        ScreenShotOfWebElement(errorMessage,"_errorMessage");
        BekleKapat();
    }
}
