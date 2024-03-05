package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
       /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus subclases
     */
    protected static WebDriver driver;
    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    /* 
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el driver del navegador
    */
    static{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // contructor de la basepage
    public BasePage(WebDriver driver){
            BasePage.driver = driver;
    }

    public static void navigateTo(String url){
        //Inicializa la variable estática 'driver' con una instancia de ChromeDriver
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    //wait para llamar desde cualquier punto
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
    // esta opcion elimina codigo cada vez que se 
    // llame un clic evitando crear un webelement cada vez
    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String keysToSend){
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }

    public void selectFromDropdownByValue(String locator, String value){
        // crear instancia del objeto
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex(String locator, Integer index){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByIndex(index);
    }
    public int dropdownSize (String locator){
        // tamano de la lista
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }

    public List<String> getDropdownValues(String locator){
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        
        for (WebElement option : dropdownOptions){
            values.add(option.getText());
        }

        return values;
    }


}