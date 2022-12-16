package testSel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class IFramesDemo {


	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		

		String url = "https://demoqa.com/frames";
		driver.get(url);

		JavascriptExecutor executorjs = (JavascriptExecutor) driver;
		//executorjs.executeScript("window.scrollBy(0,500)");
		//executorjs.executeScript("arguments[0].scrollIntoView(true)", frame1);
		executorjs.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);

		WebElement f1_heading = driver.findElement(By.id("sampleHeading"));
		
		String f1_text = f1_heading.getText();
		System.out.println(f1_text);
		driver.switchTo().defaultContent();
		String main_para = driver.findElement(By.xpath("//div[@id='framesWrapper']/child::div")).getText();
		System.out.println(main_para);

	}

}
