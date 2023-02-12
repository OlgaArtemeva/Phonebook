package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver; //protected - виден в папке и в подклассах(у нас лежат в разных папках)

    String url = "http://phonebook.telran-edu.de:8080/user/login";

    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //ожидание по умолчанию для всех элементов
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit(); //браузер закрывается, driver выключается
//    driver.close(); //закрывается текущая вкладка, driver работает (м. исп-ть при открытии новой вкладки...)
    }
}
