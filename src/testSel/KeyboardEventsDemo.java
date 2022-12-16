package testSel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;


public class KeyboardEventsDemo  {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		

		String url = "https://demoqa.com/text-box";
		driver.get(url);
		//	create an instance of Actions class
		driver.findElement(By.id("userName")).sendKeys("Rani R Nair");
		driver.findElement(By.id("userEmail")).sendKeys("Rani.R.Nair@gds.ey.com");
		
		//<textarea placeholder="Current Address" rows="5" cols="20" id="currentAddress" class="form-control"></textarea>
		WebElement c_add = driver.findElement(By.id("currentAddress"));
		c_add.sendKeys("#B204, Aradhana Residency");
		
		Actions actions = new Actions(driver);
		//select all
		/*actions.keyDown(Keys.CONTROL);
		actions.sendKeys("a");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();*/
		
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

		//copy text from current address
		/*actions.keyDown(Keys.CONTROL);
		actions.sendKeys("c");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();*/
		
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

		//<textarea rows="5" cols="20" id="permanentAddress" class="form-control"></textarea>
		WebElement p_add = driver.findElement(By.id("permanentAddress"));
		//actions.click(p_add);
		//copy text from current address
		/*actions.sendKeys(Keys.TAB);
		actions.build().perform();

		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();*/
		
		actions.sendKeys(Keys.TAB).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();


		
		
		

	}

}
