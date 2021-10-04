package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {

    public void darClic(WebDriver driver, String xpath) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(xpath));
        Miscellaneous.highLighterMethod(driver,element);
        element.click();
    }

    public void escribir(WebDriver driver, String xpath, String valor) throws InterruptedException {
        String seleccionar = Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.HOME);
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        Miscellaneous.highLighterMethod(driver,element);
        element.sendKeys(seleccionar + valor);
    }

    public void seleccionarLista(WebDriver driver, String xpath, String valor) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(xpath));
        Miscellaneous.highLighterMethod(driver, element);
        Select elemento = new Select(element);
        elemento.selectByValue(valor);
    }
}
