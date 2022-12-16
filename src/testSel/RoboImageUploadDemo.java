package testSel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class RoboImageUploadDemo {

	public static void main(String[] args) throws AWTException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		

		String url = "https://blueimp.github.io/jQuery-File-Upload/";
		driver.get(url);
		
		driver.findElement(By.cssSelector(".btn.btn-success.fileinput-button")).click();
		
		Robot robo = new Robot();
		StringSelection path = new StringSelection("C:\\myinfo.png");
		
		//put the path in clipboard
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
		
		//put the path in clipboard into windows explorer
		robo.delay(1000);
		//keyPress is similar to keyDown in actions
		robo.keyPress(KeyEvent.VK_ENTER);
		
		//keyRelease is similar to keyUp in Actions
		robo.keyRelease(KeyEvent.VK_ENTER);
		
		robo.delay(1000);
		
		//pasting the clipboard path
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		
		robo.delay(1000);
		
		//relesaing the Cntrl + V		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);

		robo.delay(1000);
		//keyPress is similar to keyDown in actions
		robo.keyPress(KeyEvent.VK_ENTER);
		
		//keyRelease is similar to keyUp in Actions
		robo.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
