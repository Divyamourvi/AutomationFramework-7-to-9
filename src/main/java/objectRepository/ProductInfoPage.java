package objectRepository;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	
	public class ProductInfoPage {
		//Declaration
		@FindBy(xpath="//span[@class='lvtHeaderText']")
		private WebElement ProductHeaderText;
		
		
		//Initialization
		public ProductInfoPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
	}



	   public WebElement getContatHeaderText() {
			return ProductHeaderText;
		}

		//Bussiness Library
		/**
		 * This method will get the Product header text
		 * @return
		 */
		public String getHeader() {
			return ProductHeaderText.getText();
			
		}
	}


