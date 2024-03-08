package LoginTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Entrata_Website.Config;



public class LoginTest extends Config {
	String Url=null;
	
	@BeforeTest
	public void readUrl() {
		Url= readPropertyFile();
	}
	
	@BeforeClass
	public void openBrowser() {
		browserSetting(Url);   
	}
	
	@Test(priority = 1)
	//click on the Signin functionality button
	public void btnClickTest() {
		WebElement HomePageElement= accessByXpath("//a[@title='Entrata Home Page']");
		HomePageElement.click();  
	}
	
	@Test(priority = 2)
	//click on the property manager login functionality
	
	public void btnClickTest2() {
		WebElement btnElement= accessByXpath("//a[@title='Client Login Button']");
		btnElement.click();
	}
	
	@Test(priority = 3)
	//click on the ' property manager login functionality' functionality button
	
	public void SigninTOEntrata() {
		//sending invalid Input Data 
		WebElement usernameElement=accessByXpath("//input[@type='text']");
		usernameElement.sendKeys("DemoEntrata");
		
		//Username Data
		WebElement InvalidErrorEelement= accessById("statusMessage");
		String actualResult= InvalidErrorEelement.getText(); // Enter Actual result show error
		String expectedResult="Please enter username as Entrata1234";  // Enter Expected result
		
		//Password Data
		WebElement PasswordElement=accessByXpath("//input[@type='password']");
		PasswordElement.sendKeys("1234");
		
		WebElement InvalidPasswordErrorEelement= accessById("statusMessage");
		String actualPasswordResult= InvalidErrorEelement.getText();
		String expectedResult2="Please enter username as 34567";
		
		
		//Using assetEquals To execute Test Cases
	System.out.println("------- Before Assert Method---------");
	Assert.assertEquals(actualResult, expectedResult);
	Assert.assertEquals(actualPasswordResult, expectedResult2);
	System.out.println("------- After Assert Method---------");
		
		
		
		
		
	}

}