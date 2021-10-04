import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.ElementActions;

import java.awt.event.ActionEvent;

public class Ejercicio2 extends Base {
    @BeforeTest
    public void initialize() {
        driver = initializeDriver();
    }

    @Test
    public void validaSubmitExitoso() throws InterruptedException {
        driver.get("https://demoqa.com/buttons");

        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(element).build().perform();
        element = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertTrue(element.getText().equals("You have done a double click"));


        element = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(element).build().perform();
        element = driver.findElement(By.id("rightClickMessage"));
        Assert.assertTrue(element.getText().equals("You have done a right click"));


        element = driver.findElement(By.xpath("//*[text()='Click Me']"));
        element.click();
        element = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(element.getText().equals("You have done a dynamic click"));
    }

}
