package HW5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class MyTest {

    static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

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
        }

    @BeforeEach
    void getPage(){
        driver.get("https://www.livemaster.ru");
    }


    @Test
    void test() throws InterruptedException {

        WebElement webElementJournal = driver.findElement(By.xpath("//a[contains(@href, 'zhurnal')]"));
        webElementJournal.click();

        WebElement webElementBlogs = driver.findElement(By.xpath("//a[contains(@href, 'blogs')]"));
        webElementBlogs.click();

        WebElement webElementAdd = driver.findElement(By.linkText("Добавить"));
        webElementAdd.click();

        WebElement webElementName = driver.findElement(By.name("name"));
        webElementName.sendKeys("Мастерство");

        WebElement webElementRubric = driver.findElement(By.cssSelector(".form-creation__fields-col"));
        webElementRubric.click();

        WebElement webElementRubricId = driver.findElement(By.name("rubricId"));
        webElementRubricId.sendKeys("Персональные записи");

        WebElement webElementSave = driver.findElement(By.xpath("//button[contains(.,'В черновики')]"));
        webElementSave.click();
        Assertions.assertEquals("Ярмарка Мастеров - ручная работа, handmade",driver.getTitle(),"Не та страница");
    }



    @AfterAll
    static void close(){
        driver.quit();
    }

}
