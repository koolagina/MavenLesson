package org.example.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

public class Test1Authority {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livemaster.ru");


        WebElement webElementAuth = driver.findElement(By.cssSelector(".header-nav-element__icon--auth"));
        webElementAuth.click();

        WebElement webElementLogin = driver.findElement(By.id("auth-login"));
        webElementLogin.sendKeys("+79191440544");

        WebElement webElementPass = driver.findElement(By.id("auth-password"));
        webElementPass.sendKeys("Еуые123456");

        WebElement webElementButtonOk = driver.findElement(By.cssSelector(".btn--small"));
        webElementButtonOk.click();
        driver.quit();
    }
}