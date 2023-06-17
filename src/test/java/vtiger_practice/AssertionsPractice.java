package vtiger_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	
	@Test
	public void assertPract() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		String expected = driver.getTitle();
		System.out.println(expected);
		Assert.assertEquals("Googl", expected);
		System.out.println("Welcome");
	}
	
	

	@Test
	public void softassertPract() {
		SoftAssert sa=new SoftAssert();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		String expected = driver.getTitle();
		System.out.println(expected);
		sa.assertEquals("ogle", expected);
		System.out.println("Welcome");
		sa.assertAll();
	}
}
