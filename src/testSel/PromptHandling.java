package testSel;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PromptHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		//JavascriptExecutor executorjs = (JavascriptExecutor) driver;
		//executorjs.executeScript("window.scrollBy(0,200)");
		
		//First Button
		WebElement clkBut = driver.findElement(By.id("alertButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", clkBut);
		Alert prompt_alert = driver.switchTo().alert();
		System.out.println("Clicked 1st button. Text is: "+ prompt_alert.getText());
		prompt_alert.accept();
		
		//Second Button
		//<button id="timerAlertButton" type="button" class="btn btn-primary">Click me</button>
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		clkBut = driver.findElement(By.id("timerAlertButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", clkBut);
		wait.until(ExpectedConditions.alertIsPresent());
		prompt_alert = driver.switchTo().alert();
		System.out.println("Clicked 2nd button. Text is: "+ prompt_alert.getText());
		prompt_alert.accept();
		
		
		//Third Button
		//<button id="confirmButton" type="button" class="btn btn-primary">Click me</button>
		clkBut = driver.findElement(By.id("confirmButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", clkBut);
		prompt_alert = driver.switchTo().alert();
		System.out.print("Clicked 3rd button. Text is: ");
		prompt_alert.accept();
		//<span id="confirmResult" class="text-success">You selected Ok</span>
		System.out.println(driver.findElement(By.id("confirmResult")).getText());

		
		//Fourth Button
		clkBut = driver.findElement(By.cssSelector("button[id=promtButton]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", clkBut);
		// switch context to alert
		prompt_alert = driver.switchTo().alert();
		prompt_alert.sendKeys("Rani R Nair");
		System.out.print("Clicked 4th button. Text is: ");
		prompt_alert.accept();
		System.out.println(driver.findElement(By.id("promptResult")).getText());

		JavascriptExecutor executorjs = (JavascriptExecutor) driver;
		executorjs.executeScript("window.scrollBy(0,200)");
		//<button id="alertButton" type="button" class="btn btn-primary">Click me</button>
		// <button id="promtButton" type="button" class="btn btn-primary">Click me</button>
		
		//<span id="promptResult" class="text-success">You entered Rani R Nair</span>
		
		driver.quit();
	}

}
