package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeRangeTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //Inicializa el webdriver para chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void navegamosAFreeRangeTesters(){
        //Navega a la pagina web
       driver.get("www.freerangetesters.com"); 
    }
    
    @AfterMethod
    public void tearDown(){
        //Cierra navegador desues de la prueba
        if(driver !=null){
            driver.quit();
        }
    }
    
}
