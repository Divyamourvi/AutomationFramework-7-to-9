package webtable_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario3 {
	public static void main(String[] args) {
		
		//Step 1:Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		//Step 2:Login to vtiger app
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		

		//Step2:Navigate to organizations page
		driver.findElement(By.partialLinkText("Organizations")).click();
		List<WebElement> orgName = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]//a[@title='Organizations']"));
		int count=orgName.size();
		System.out.println(count);
		for(WebElement o:orgName) {
			String text = o.getText();
			System.out.println(text);
		}
		}
}
	
