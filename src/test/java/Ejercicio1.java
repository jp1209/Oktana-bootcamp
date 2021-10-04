import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.ElementActions;

import java.io.File;
import java.util.List;

public class Ejercicio1 extends Base {
    @BeforeTest
    public void initialize() {
        driver = initializeDriver();
    }

    @Test
    public void validaSubmitExitoso() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        String nombre = "Jean Pierre";
        String apellido = "Retamozo";
        String email = "jeanp1209@gmail.com";
        String telefono = "0999999999";
        String fecha = "12/09/1991";
        String subjects = "Computer Science";
        String direccion = "Siempre viva";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        ElementActions elementActions = new ElementActions();


        elementActions.escribir(driver, "//*[@id='firstName']", nombre);
        elementActions.escribir(driver, "//*[@id='lastName']", apellido);
        elementActions.escribir(driver, "//*[@id='userEmail-wrapper']//input", email);

        List<WebElement> generos = driver.findElements(By.xpath("//input[@name='gender']"));
        jse.executeScript("arguments[0].click();", generos.get(0));

        elementActions.escribir(driver, "//*[@id='userNumber']", telefono);
        elementActions.escribir(driver, "//*[@id='dateOfBirth-wrapper']//input", fecha);

        elementActions.escribir(driver, "//*[@id='subjectsWrapper']//input", subjects);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

        List<WebElement> hobbies = driver.findElements(By.xpath("//div[@class='custom-control custom-checkbox custom-control-inline']//input"));

        for (WebElement hobby : hobbies) {
            jse.executeScript("arguments[0].click();", hobby);
        }

        String RutaArchivo = "src/main/resources/img/bender.jpg";
        File file = new File(RutaArchivo);

        driver.findElement(By.id("uploadPicture")).sendKeys(file.getAbsolutePath());

        driver.switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(1000);
        elementActions.escribir(driver, "//*[@id='currentAddress']", direccion);


        List<WebElement> Estados = driver.findElements(By.xpath("//*[@id='stateCity-wrapper']/div"));
        jse.executeScript("arguments[0].click();", Estados.get(0));

        elementActions.darClic(driver, "//*[@id='state']");
        elementActions.darClic(driver, "//*[text()='NCR']");
        elementActions.darClic(driver, "//*[@id='city']");
        elementActions.darClic(driver, "//*[text()='Delhi']");

        Thread.sleep(5000);
        elementActions.darClic(driver, "//*[@id='submit']");

        String textoModal = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        Assert.assertTrue(textoModal.equals("Thanks for submitting the form"), "Se encontro el siguiente mensaje [" + textoModal + "]");

    }
}
