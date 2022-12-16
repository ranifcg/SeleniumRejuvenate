package testSel;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class MyAdactin {

public static void main(String[] args) throws InterruptedException {
System.out.println("Using GIT");
			//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver-v0.32.0-win64\\geckodriver.exe");

			WebDriver driver = new EdgeDriver();
			driver.get("http://adactinhotelapp.com");

			driver.manage().window().maximize();
			WebElement uName = driver.findElement(By.id("username"));
			uName.sendKeys("raniselen");
			driver.findElement(By.id("password")).sendKeys("adactin");
			driver.findElement(By.cssSelector("input#login")).click();
			new Select(driver.findElement(By.cssSelector("#location.search_combobox"))).selectByIndex(1);
			new Select(driver.findElement(By.id("hotels"))).selectByIndex(3);

		   //Drop down - ROOMTYPE
	        new Select(driver.findElement(By.cssSelector("select[name=room_type]"))).selectByValue("Double");
	        
	       //click on Search
	        driver.findElement(By.id("Submit")).click();
	        
	        //Radio button on next page
	        driver.findElement(By.id("radiobutton_0")).click();
	        
	        driver.findElement(By.id("continue")).click();
	        
	        //<input name="first_name" type="text" class="reg_input" id="first_name" value="" maxlength="25">
	        driver.findElement(By.cssSelector("input[id=first_name]")).sendKeys("Rani");
	        
	        //<input name="last_name" type="text" class="reg_input" id="last_name" value="" maxlength="25">
	        driver.findElement(By.cssSelector("input[id=last_name]")).sendKeys("Nair");
	        
	        //<textarea name="address" rows="4" class="txtarea" id="address"></textarea>
	        driver.findElement(By.cssSelector("textarea.txtarea")).sendKeys("B204, Aradhana Residency, Jayanagar, Bangalore");
			
	        //<input name="cc_num" type="text" class="reg_input" id="cc_num" value="" maxlength="16" onkeypress="return OnlyNumbersonly(event)">
	        driver.findElement(By.id("cc_num")).sendKeys("1234567890123456");
	        new Select(driver.findElement(By.cssSelector("select[id=cc_type]"))).selectByValue("MAST");
	        new Select(driver.findElement(By.cssSelector("select[id=cc_exp_month]"))).selectByValue("10");
	        new Select(driver.findElement(By.cssSelector("select[id=cc_exp_year]"))).selectByValue("2022");

	        //<input name="cc_cvv" type="text" class="reg_input" id="cc_cvv" value="" maxlength="4" onkeypress="return OnlyNumbersonly(event)">
	        driver.findElement(By.cssSelector("input[id=cc_cvv]")).sendKeys("768");
	        
	        //<input type="button" name="book_now" id="book_now" class="reg_button" value="Book Now" onclick="book_hotel_validate();">
	        driver.findElement(By.id("book_now")).click();

	        //Thread.sleep(5000);
	        //implicit wait - wait for a max of 10 sec. If page is loaded in between resumes without completing the 10 seconds.
	        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        //<input type="button" name="my_itinerary" id="my_itinerary" class="reg_button" value="My Itinerary" onclick="window.location=&quot;BookedItinerary.php&quot;">
			JavascriptExecutor executorjs = (JavascriptExecutor) driver;
			executorjs.executeScript("window.scrollBy(0,1000)");
			
			//Fluent wait
			//wait for 30 seconds, every 2 seconds. Ignore NoSuchElememntException if not found during polling
			Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(NoSuchElementException.class);
			
			/*WebElement itButton = fluentwait.until(new Function<WebDriver, WebElement>()
					{
						public WebElement apply(WebDriver driver)
						{
							return driver.findElement(By.id("my_itinerary"));
						}
					}
	        );*/
			WebElement itButton = fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my_itinerary")));
	        itButton.click();
	        //implicit wait - wait for a max of 10 sec. If page is loaded in between resumes without completing the 10 seconds.
	        //pageLoadTimeout, scriptTimeout can be used instead
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        
	        List<WebElement> results = driver.findElements(By.xpath("//input[contains(@id,'order_id')]"));
	        //driver.findElement(By.xpath("//input[contains(@name,'btnK')]")); 
			executorjs.executeScript("window.scrollBy(0,1000)");
	        System.out.println("\n");
	        System.out.println("Number of itenary items: " + (results.size() - 1));
	        System.out.println("\n");

	        for (int i = 1; i< results.size(); i++)
	        {
	     	   
	        	System.out.println("Itenary " + i + ": " + results.get(i).getAttribute("value"));


	        }
	        
	        
	        //explicit wait
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	        WebElement logout_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout")));
	        logout_button.click();
	        Thread.sleep(5000);
	        driver.quit();
		}


}
