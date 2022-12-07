package testSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MyFirstAutomation {

public static void main(String[] args) throws InterruptedException {
System.out.println("Using GIT");
			//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver-v0.32.0-win64\\geckodriver.exe");

			WebDriver driver = new EdgeDriver();
			driver.get("http://adactinhotelapp.com");
			//Thread.sleep(5000);

			driver.manage().window().maximize();
			/*driver.navigate().to("https://www.google.com");
			driver.navigate().back();
			driver.navigate().refresh();*/
			WebElement uName = driver.findElement(By.id("username"));
			uName.sendKeys("raniselen");
			driver.findElement(By.id("password")).sendKeys("adactin");
			//driver.findElement(By.cssSelector(".login_register")).click();
			//tag and id
			driver.findElement(By.cssSelector("input#login")).click();
			//tag and class
			//driver.findElement(By.cssSelector("input.login_button")).click();
			//tag and attribute
			//driver.findElement(By.cssSelector("input[name=login]")).click();
			// tag class and attribute
			//driver.findElement(By.cssSelector("input.login_button[type=Submit]")).click();
			// tag class and attribute
			//driver.findElement(By.cssSelector("input.login_button[value=Login]")).click();
			// forgot password -- doesn't work
			//driver.findElement(By.cssSelector("a.contains('Forgot Password?')")).click();

			//new Select(driver.findElement(By.className("search_combobox"))).selectByValue("Sydney");
			//new Select(driver.findElement(By.className("search_combobox"))).selectByIndex(3);
			//new Select(driver.findElement(By.className("search_combobox"))).selectByVisibleText("Sydney");
			//new Select(driver.findElement(By.className("search_combobox"))).selectByValue("Sydney");
			new Select(driver.findElement(By.cssSelector("#location.search_combobox"))).selectByIndex(1);
			new Select(driver.findElement(By.id("hotels"))).selectByIndex(3);

		       //Drop down - ROOMTYPE
	        new Select(driver.findElement(By.cssSelector("select[name=room_type]"))).selectByValue("Double");
	        
	      //click on Search
	        driver.findElement(By.id("Submit")).click();
	        
	        //Radio button on next page
	        driver.findElement(By.id("radiobutton_0")).click();
	        
	        //Click on any hyperlink above
	        driver.findElement(By.linkText("Booked Itinerary")).click();
	        
	        driver.findElement(By.linkText("Search Hotel")).click();



			//driver.quit();
		}


}
