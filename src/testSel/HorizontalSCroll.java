package testSel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HorizontalSCroll {
	public static void main(String[] args) throws Exception{
/*
		<a href="http://www.guru99.com/vbscript-tutorials-for-beginners.html">
		<i class="icon-code-fork" style="color: rgb(112, 189, 205); font-size: 60px; line-height: 125px;"></i>
		  </a>
		  */
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		

		String url = "http://demo.guru99.com/test/guru99home/scrolling.html";
		driver.get(url);
		WebElement a1 = driver.findElement(By.linkText("VBScript"));
		JavascriptExecutor executorjs = (JavascriptExecutor) driver;
		//executorjs.executeScript("window.scrollBy(0,500)");
		//executorjs.executeScript("arguments[0].scrollIntoView(true)", frame1);
		//executorjs.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		executorjs.executeScript("arguments[0].scrollIntoView(true)",a1);
	}

}
