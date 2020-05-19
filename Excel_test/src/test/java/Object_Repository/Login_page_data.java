package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Login_page_data {
	

	WebDriver driver;
	
	public Login_page_data(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="pass")
	WebElement Pass;
	
	//By Email=By.id("email");
	//By Pass=By.id("pass");
	
	public WebElement email_id() {
		///return driver.findElement(Email);
		return Email;
	}
	
	public WebElement password()
	{
	//	return driver.findElement(Pass);
		return Pass;
	}

}
