package vtiger_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGpractice {

	
	@Test(invocationCount=2,priority=-2)
	
	public void create() {
		Assert.fail();
		System.out.println("create");
	}
	
	@Test(enabled=false)
	public void modify() {
		System.out.println("modify");
	}
	
	@Test
	public void delete() {
		System.out.println("delete");
	}
}
