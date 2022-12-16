package testSel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassDemo {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		

		String url = "https://demoqa.com/buttons";
		driver.get(url);
		//	create an instance of Actions class

		Actions act = new Actions(driver);
		//double click
		WebElement db = driver.findElement(By.id("doubleClickBtn"));
		act.doubleClick(db).build().perform();;
		
		WebElement rb = driver.findElement(By.id("rightClickBtn"));
		//JavascriptExecutor executorjs = (JavascriptExecutor) driver;
		//executorjs.executeScript("window.scrollBy(0,500)");
		//executorjs.executeScript("arguments[0].scrollIntoView(true)", frame1);
		//executorjs.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//executorjs.executeScript("arguments[0].scrollIntoView(true)",rb);

	//right click is called context click
	//performing without action chaining -- direct
		//act.contextClick(rb).perform();
		//act.contextClick(rb).build().perform();
	//performing with action chaining
		act.moveToElement(rb).contextClick(rb).build().perform();

	}

}
