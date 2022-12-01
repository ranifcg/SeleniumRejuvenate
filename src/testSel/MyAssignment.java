package testSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MyAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.makemytrip.com");

		driver.manage().window().maximize();
		//driver.findElement(By.cssSelector("a.contains('www.makemytrip.com/hotels')")).click();
	
		driver.findElement(By.linkText("Hotels")).click();
		
		//driver.findElement(By.className("lbl_input")).click();
	
		driver.findElement(By.cssSelector("span.lbl_input[data-cy=hotelCityLabel]")).click();
		//works
		//driver.findElement(By.xpath("//*[@id=\'root\']/div/div[2]/div/div[1]/div/div/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("marathahalli");
		
		driver.findElement(By.cssSelector("input.react-autosuggest__input")).sendKeys("marathahalli");

		Thread.sleep(2000);
		//works
		//driver.findElement(By.xpath("//*[text()='Marathahalli, Bangalore']")).click();
		driver.findElement(By.cssSelector("li#react-autowhatever-1-section-0-item-0")).click();
		//driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
		//driver.findElement(By.xpath("//*[@id=\'react-autowhatever-1-section-0-item-0\']")).click();
		//driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
		
		driver.findElement(By.xpath("//*[@id=\'root\']/div/div[2]/div/div[1]/div/div/div[1]/div[2]/label/p[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("span.DayPicker-NavButton--next[aria-label=Next Month]")).click();
		//<span tabindex="0" role="button" aria-label="Next Month" class="DayPicker-NavButton DayPicker-NavButton--next"></span>
		Thread.sleep(2000);

		driver.close();
	}

}
