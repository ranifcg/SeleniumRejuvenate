package testSel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHoverDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
	
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		String url = "https://demoqa.com/menu/";
		driver.get(url);

		//Create an instance of the action class
		Actions action = new Actions(driver);
		
		WebElement mItem2 = driver.findElement(By.xpath("//*[@id='nav']/li[2]/a"));
		JavascriptExecutor executorjs = (JavascriptExecutor) driver;
		executorjs.executeScript("arguments[0].scrollIntoView(true)",mItem2);
		//executorjs.executeScript("window.scrollBy(0,250)"); 
		
		//Hover over Main Item 2 
		action.moveToElement(mItem2).build().perform(); 
		System.out.println("I am at Main Item 2. Items in Main Item 2 are:");
		List<WebElement> list1 = driver.findElements(By.xpath("//*[@id='nav']/li[2]/ul/li[*]"));

		for (int i = 0; i < list1.size(); i++) {
		  System.out.println(list1.get(i).getText());}
					

		WebElement subSubList = driver.findElement(By.xpath("//*[@id='nav']/li[2]/ul/li[3]"));
		
		//Hover over SUB SUB LIST menu
		action.moveToElement(subSubList).build().perform(); 
		System.out.println("I am at SUB SUB LIST. Items in SUB SUB LIST are:");
			
		//Find the webelement of the 'Sub Sub Item 2' menu (2nd in the menu)
		List<WebElement> list2 = driver.findElements(By.xpath("//*[@id='nav']/li[2]/ul/li[3]/ul/li[*]"));
		for (int i = 0; i < list2.size(); i++) {
			  System.out.println(list2.get(i).getText());}

		
		driver.quit();


	}

}

