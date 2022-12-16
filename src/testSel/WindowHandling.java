package testSel;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandling {
	public final String s1 = new String();
	public final String s2 = new String();

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		//Xpath - contains
		//WebElement clkBut = driver.findElement(By.xpath("//button[contains(@id,'windowButton')]"));
		//Xpath - starts with
		//WebElement clkBut = driver.findElement(By.xpath("//button[starts-with(@id,'wind')]"));
		// Xpath - text function
		//WebElement clkBut = driver.findElement(By.xpath("//button[text()='New Window']"));
		// any element wit the text
		//WebElement clkBut = driver.findElement(By.xpath("//*[text()='New Window']"));
		// combination conditions -- and
		//WebElement clkBut = driver.findElement(By.xpath("//*[(@id='windowButton' and @type = 'button')]"));
		// combination conditions -- or
		WebElement clkBut = driver.findElement(By.xpath("//*[(@id='windowButton' or @type = 'bun')]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click()", clkBut);
		//<button id="windowButton" type="button" class="mt-4 btn btn-primary">New Window</button>
		
		 

		
		String main_window = driver.getWindowHandle();
		System.out.println("Main window handle: " + main_window);
		
		Set <String> window_handles = driver.getWindowHandles();
		
        Iterator value = window_handles.iterator();
        String child_window = new String();
        
        while(value.hasNext())
        {
        	child_window = (String) value.next();
        	
        	if(!main_window.equalsIgnoreCase(child_window))
        	{
        		
        		driver.switchTo().window(child_window);
        		
        		System.out.println("Child window handle is: "+ child_window);
        		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        		driver.close();
            	System.out.println(child_window + " closed");
        			
        	}
        		
        }
        		
		driver.switchTo().window(main_window); 
		clkBut = driver.findElement(By.id("messageWindowButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", clkBut);
		//<button id="messageWindowButton" type="button" class="btn btn-primary">New Window Message</button>

		window_handles = driver.getWindowHandles();
		
        value = window_handles.iterator();
       
        System.out.println(window_handles.size());
        while(value.hasNext())
        {
        	child_window = (String) value.next();
        	
        	if(!main_window.equalsIgnoreCase(child_window))
        	{
        		
        		driver.switchTo().window(child_window);
        		
        		System.out.println("Child window handle is: "+ child_window);
            	System.out.println(driver.getPageSource());

        		System.out.println(driver.findElement(By.xpath("/body [contains( text(), ‘Knowledge’)]")).getText());
        		//System.out.println(driver.findElement(By.tagName("body")).getText());
        		driver.close();
            	System.out.println(child_window + " closed");
        			
        	}
        		
        }

        driver.switchTo().window(main_window); 

		//driver.quit();


		
	}

}
