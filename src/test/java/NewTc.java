import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class NewTc {

    WebDriver driver;

    //1
    @AfterTest
    public void tearDown() {
        //driver.close();
        //driver.quit();
    }

    //2
    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver");
        driver = new ChromeDriver();
    }




}
