package testSel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragDropDemo {

	public static void main(String[] args) throws InterruptedException 
	{

		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		String url = "https://demoqa.com/droppable";
		driver.get(url);
		
		//Find the webelement for draggable element
		WebElement draggable = driver.findElement(By.id("draggable"));
		System.out.println("Found draggable");
		JavascriptExecutor executorjs = (JavascriptExecutor) driver;
		executorjs.executeScript("arguments[0].scrollIntoView(true)",draggable);
		
		//Find the webelement for droppable element
		WebElement droppable = driver.findElement(By.id("droppable"));
		String dropHere = droppable.getText();
		System.out.println("Before Drag n Drop, display text is: " +dropHere);
		System.out.println(droppable.getCssValue("background-color"));
		//Create an instance of the action class
		Actions action = new Actions(driver);
		
		//Drag and drop the element on the page
		action.dragAndDrop(draggable, droppable).build().perform();
		
		String isDropped = droppable.getText();
		System.out.println("After Drag n Drop, display text changed to: " +isDropped);
		System.out.println(droppable.getCssValue("background-color"));
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}



