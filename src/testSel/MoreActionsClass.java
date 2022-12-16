package testSel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MoreActionsClass {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		

		String url = "https://demoqa.com/menu/";
		driver.get(url);
		//	create an instance of Actions class


	}

}
