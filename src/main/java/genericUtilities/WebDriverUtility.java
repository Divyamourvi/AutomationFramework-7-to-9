package genericUtilities;



import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of generic methods related to all webDriver actions
 * @author Vinay G
 *
 */
public class WebDriverUtility {

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	public void ImplicitWaiting(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method will wait for the page to get load for 10 seconds
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method will wait for 20 seconds for a element to be visible
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for 20 seconds for a element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	
	}
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown by visibletext
	 * @param element
	 * @param index
	 */
	public void handleDropDown(String visibleText,WebElement element) {
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method will perform mouse over actions
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will right click on anywhere on webpage
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will right click on particular element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will do double click on anywhere on webpage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	

	/**
	 * This method will do double click on particular element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will do drag and drop from src to target element
	 * @param driver
	 * @param srcElement
	 * @param tarElement
	 */
	
	public void dragAndDrop(WebDriver driver,WebElement srcElement,WebElement tarElement) {
		Actions act=new Actions(driver);
		act.dragAndDrop(srcElement, tarElement).perform();
	}
	
	/**
	 * This method will do drag and drop from src to target element offsets
	 * @param driver
	 * @param src
	 * @param x
	 * @param y
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,int x,int y) {
		Actions act=new Actions(driver);
		act.dragAndDropBy(src,x,y).perform();
	}
	
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame by nameorId
	 * @param driver
	 * @param nameorId
	 */
	public void switchToFrame(WebDriver driver,String nameorId) {
		driver.switchTo().frame(nameorId);
	}
	
	/**
	 * This method will handle frame by webelement
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch control to immediate parent
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch control to default
	 * @param driver
	 */
	
	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will accept the text of alert popup
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will take screen shot and return the absolute path
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
	public String takeScreenShot(WebDriver driver,String screenShotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\ScreenShots\\"+screenShotName+".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath(); //---used for extent report

	}
	
	/**
	 * this method will do scroll down action
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	/**
	 * This method will switch the window based on window title
	 * @param driver
	 * @param particularWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String particularWindowTitle) {
		//step 1 capture all window IDs
		 Set<String> winIds = driver.getWindowHandles();
		 
		 //step 2:Navigate to each window
		 for(String winId:winIds) {
			 
			//step 3:capture the title of each window
			 String actTitle=driver.switchTo().window(winId).getTitle();
			 
			 //step 4:compare the title
			 if(actTitle.contains(particularWindowTitle)) {
				 break;
			 }
		 }
	}
}
