package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class stepDefinitions {

    public static WebDriver driver;


    @Given("the user navigates to Amazon web page")
    public void the_user_navigates_to_amazon_web_page() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String Url = "https://www.amazon.com/";
        driver.get(Url);
    }

    @And("Searches for ‘Alexa’")
    public void searchesForAlexa() {
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.click();
        searchBar.sendKeys("Alexa");
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();


    }

    @And("navigates to the second page")
    public void navigatesToTheSecondPage() {
        try {
            JavascriptExecutor js;
            js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            WebElement secondPage = driver.findElement(By.xpath("//a[contains(@class,'s-pagination-item s-pagination-button')][1]"));
            if(secondPage.isDisplayed()) {
                js.executeScript("arguments[0].click();", secondPage);
            }
        } catch (Exception e) {
            final String ERROR_MESSAGE = "An error occurred";
            throw new Error(ERROR_MESSAGE, e);
        }

    }

    @And("selects the third item")
    public void selectsTheThirdItem() {
        try {
            JavascriptExecutor js;
            js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,200)");
            WebElement thirdItem = driver.findElement(By.xpath("//img[@data-image-index='19']"));
            if(thirdItem.isDisplayed()) {
                js.executeScript("arguments[0].click();", thirdItem);
            }
        } catch (Exception e) {
            final String ERROR_MESSAGE = "An error occurred";
            throw new Error(ERROR_MESSAGE, e);
        }
    }


    @Then("the {string} option should be visible for user to purchase")
    public void theOptionShouldBeVisibleForUserToPurchase(String avail) {
        //WebElement itemIsAvailable = driver.findElement(By.xpath("//input[@value='Add to Cart']"));
        WebElement itemIsAvailable = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-price']"));

        Assert.assertEquals(avail, itemIsAvailable.getText());
    }
}


