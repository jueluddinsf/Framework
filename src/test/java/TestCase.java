import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {
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

    //3
    @Test
    public void verifyUserCanMoveToStep2Page() throws InterruptedException {
        String url = "https://insurancewebsitedemo.com/personal-insurance/car-insurance";
        driver.get(url);
        String expectedTitle = "Auto, Automobile, Car, Vehicle Insurance in Las Vegas Nevada - Demo Insurance Agency,";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement quoteRequestLink = driver.findElement(By.linkText("Auto Insurance Quote Request"));
        quoteRequestLink.click();

        // validate we are in quote form page
        WebElement headerText = driver.findElement(By.id("title_div"));
        String actualHeaderText = headerText.getText();
        String expectedHeaderText = "Secure Auto Insurance Quote Request Form";
        Assert.assertEquals(actualHeaderText, expectedHeaderText);


        // fillout form
        // first name
        WebElement firstName = driver.findElement(By.id("fname"));
        String firstNameVal = "Tester";
        firstName.sendKeys(firstNameVal);
        // last name
        WebElement lastName = driver.findElement(By.cssSelector("#lname"));
        lastName.sendKeys("awesome");
        // email
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        email.sendKeys("tester.awesome@testmail.com");

        // phone number
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("4445556666");

        // zip code
        WebElement zip = driver.findElement(By.id("zip"));
        zip.sendKeys("11102");

        // click button
        WebElement continueBtn = driver.findElement(By.className("btn-success"));
        continueBtn.click();

        Thread.sleep(2000);
        //assertion
        WebElement progressStatus = driver.findElement(By.id("progress_id"));
        String progressStatusActualResult = progressStatus.getText();
        String expectProgressStatusResult = "Step 1 of 4";
        Assert.assertEquals(progressStatusActualResult, expectProgressStatusResult);

        // Assert first name
        WebElement firstNamePrgressPage = driver.findElement(By.id("fname"));
        String actualFirstNameVal = firstNamePrgressPage.getAttribute("value");
        String expectFirstNameVal = firstNameVal;
        Assert.assertEquals(actualFirstNameVal, expectFirstNameVal);
        // Enter address
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("123 Broadway St");


        // date of birth - month
        Select month = new Select(driver.findElement(By.name("form_data[applicant_info][_crypt_date_DOB][month]")));
        month.selectByIndex(4);

        // date of birth - day
        Select day = new Select(driver.findElement(By.name("form_data[applicant_info][_crypt_date_DOB][day]")));
        day.selectByValue("27");

        // date of birth - Year
        Select year = new Select(driver.findElement(By.xpath("//select[@name='form_data[applicant_info][_crypt_date_DOB][year]']")));
        year.selectByVisibleText("1950");

        /*
        we are pushing this in git to show new changes
        and the pull request process
         */





    }



}
