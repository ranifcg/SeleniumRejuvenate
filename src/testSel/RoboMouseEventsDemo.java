package testSel;

import java.awt.AWTException;
import org.openqa.selenium.Dimension;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class RoboMouseEventsDemo {

	public static void main(String[] args) throws AWTException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		

		String url = "http://my.monsterindia.com/create_account.html";
		driver.get(url);
		driver.findElement(By.xpath("//span[@class='browse-text']")).click();
		
		Robot robo = new Robot();
		Dimension dim = driver.manage().window().getSize();
		System.out.println("Finding dimesions");
		int x = (dim.getWidth()/4);
		int y = (dim.getHeight()/10)+50;
		
		robo.mouseMove(x, y);
		
		robo.delay(3000);
		robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		robo.delay(3000);
		robo.keyPress(KeyEvent.VK_ENTER);
		
		robo.delay(3000);
		robo.keyRelease(KeyEvent.VK_ENTER);

	}

}
