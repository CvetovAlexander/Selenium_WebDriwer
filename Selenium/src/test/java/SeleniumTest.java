import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
public class SeleniumTest {



    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.rulit.me/");
    }

    @After
    public void close() {
        driver.quit();
    }

    @Test
    public void testElementbook()
    {
        WebElement book = driver.findElement(By.xpath("//*[@id=\"myNavbar\"]/ul[5]/li[2]/a"));
        book.click();
        var expectedResult = "Новые книги";
        var actualResult = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/h2/small")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testsearch()
    {
        driver.findElement(By.xpath("//*[@id=\"myNavbar\"]/ul[3]/li/a/i")).click();
        driver.findElement(By.xpath("//*[@id=\"Search2\"]")).sendKeys("Владимир Кретов\n");
        var expectedResult = "По запросу \"Владимир Кретов\" найдено";
        var actualResult = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/h2/small")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testauthors()
    {
        WebElement book = driver.findElement(By.xpath("//*[@id=\"myNavbar\"]/ul[5]/li[4]/a"));
        book.click();
        var expectedResult = "Поиск авторов";
        var actualResult = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/h2")).getText();
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testforum()
    {
        WebElement book = driver.findElement(By.xpath("//*[@id=\"myNavbar\"]/ul[5]/li[7]/a"));
        book.click();
        var expectedResult = "Название Форума";
        var actualResult = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/article[1]/div[2]/div[1]")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }


    @Test
    public void testcontacts()
    {
        WebElement book = driver.findElement(By.xpath("//*[@id=\"myNavbar\"]/ul[5]/li[8]/a"));
        book.click();
        var expectedResult = "Или используйте форму ниже:";
        var actualResult = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/p")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

}
