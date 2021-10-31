package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Funct {
    private ChromeDriver driver;
    private WebDriverWait wait;

    public Funct(ChromeDriver chromeDriver,WebDriverWait driverWait) {
        this.driver = chromeDriver;
        this.wait = driverWait;
    }

    public void genericClick(String elementPath){
        WebElement clickElement = driver.findElement(By.xpath(elementPath));
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        clickElement.click();
    }

    public String genericGetText(String elementPath) {
        WebElement textElement = driver.findElement(By.xpath(elementPath));
        wait.until(ExpectedConditions.elementToBeClickable(textElement));
        return (textElement.getAttribute("value"));
    }

    public String countListRows(String elementPath) {
        return String.valueOf(driver.findElements(By.xpath(elementPath)).size());
    }

}
