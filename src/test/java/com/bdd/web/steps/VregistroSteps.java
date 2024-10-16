package com.bdd.web.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class VregistroSteps {
    
    static WebDriver driver;
    static String idusuario;

    public static void abrirpg(String url) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver1.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(url);
    }


    public static void login() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='app']/div/div/div/div/div/div/form/div/div/div/input")).sendKeys("Admin");

        // Encuentra el segundo campo de entrada usando XPath y escribe "Admin123"
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");

        // Opcional: Encuentra y haz clic en el botón de login
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
    }

    public static void seccionregistro() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")).click();

    }

    public static void registrousuario(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")).sendKeys(arg0);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input")).sendKeys(arg1);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")).sendKeys(arg2);

        idusuario = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/form/div/div/div/div/div/div/div/input")).getAttribute("value");
        System.out.println("El número extraído es: " + idusuario);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")).sendKeys(arg3);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input")).sendKeys(arg4);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")).sendKeys(arg5);

        driver.findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }


    public static void busquedausuarioregistrado() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div/form/div/div/div/div/div/input")).sendKeys(idusuario);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void validacionidapellido(String arg0, String arg1, String arg2) {

        if (driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]")).getText().equals(arg0 + " " + arg1)) {
            System.out.println("El nombre coincide con " + arg0 + " " + arg1 + ". Valor extraído: " + driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]")).getText());
        } else {
            System.out.println("El nombre no coincide. Se esperaba: " + arg0 + " " + arg1 + ", pero se encontró: " + driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]/div")).getText());
        }


        if (driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[4]")).getText().equals(arg2)) {
            System.out.println("El apellido coincide con " + arg2 + ". Valor extraído: " + driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[4]")).getText());
        } else {
            System.out.println("El apellido no coincide. Se esperaba: " + arg2 + ", pero se encontró: " + driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[4]")).getText());
        }

        driver.quit();
    }


}
