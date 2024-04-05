import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHRM {

	WebDriver driver;
	@BeforeMethod 
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://dhanyashree-trials712.orangehrmlive.com/auth/login");
	
	}
	
	@Test(priority=1, enabled=true)
	public void LoginWithInvalidCredential() throws InterruptedException
	{
		//find Username and enter valid username
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		//find Password and enter invalid password
		driver.findElement(By.id("txtPassword")).sendKeys("Admin123");
		//Login Button click
		driver.findElement(By.xpath("//div//button[contains(text(),'Login')]")).click();
		
		//verify if the login was unsuccesful by checking the error as Invalid Credentials
		String message_expected="Invalid Credentials";
		String message_actual = driver.findElement(By.xpath("//*[@id='toast-container']/div/div")).getText();
		
		//Assert.assertTrue(message_actual.contains(message_expected));
		Assert.assertEquals(message_expected, message_actual);
		Thread.sleep(500);
		
	}
	
	
	@Test(priority=2,enabled=true)
	public void LoginWithValidCredential() throws InterruptedException
	{
	//find Username and enter username
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	//find Password and enter password
	driver.findElement(By.id("txtPassword")).sendKeys("BXq6Ew1@iB");
	//Login Button click
	driver.findElement(By.xpath("//div//button[contains(text(),'Login')]")).click();
	
	//verify if the login was succesfull by checking the page title or a specific elements
	String pageTitle= driver.getTitle();
	/*if (pageTitle.equals("OrangeHRM"))
	{
		System.out.println("Login Successfull");
	}
		else
		{
			System.out.println("Login Failed");
		}
	}*/
	Assert.assertEquals("Employee Management",pageTitle);
	Logout();
	}
	
	@Test(priority=3,enabled=true)
	public void AddReport() throws InterruptedException
	{
		Login();
		//find Reports and Analytics menu click on the menu
		driver.findElement(By.xpath("//*[@id='left_menu_item_12']")).click();
		//find new Report button and click on that button
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--long oxd-button--secondary with-icon table-header-action-btn w-100']")).click();
		//find next button and click on the button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//find the Report name text feild and enter the name
		driver.findElement(By.xpath("//input[@id='pimDefineReportName']")).sendKeys("Abhyasaaa");
		//find the check box element and select the check box as Supervisuor
		driver.findElement(By.xpath("//label[normalize-space()='Supervisor']")).click();
		//find the next button element and click on the button
		Thread.sleep(100);
		 driver.findElement(By.xpath("//button[@class='btn waves-effect waves-light right']")).click();
		 Thread.sleep(500);
		 //find the additional section details element and click that button
		 driver.findElement(By.xpath("//button[@id='filter-group-dropdown-trigger']")).click();
		 Thread.sleep(300);
	     //select salary option
		 driver.findElement(By.xpath("//a[normalize-space()='Salary']")).click();
		 //select personal details check box like employee name
		 driver.findElement(By.xpath("//label[normalize-space()='Employee Name']")).click();
		 //age
		 driver.findElement(By.xpath("//label[contains(normalize-space(),'Age (Years)')]")).click();
		 //gender
		 driver.findElement(By.xpath("//label[normalize-space()='Gender']")).click();
		 //job details like employeement status
		 driver.findElement(By.xpath("//label[normalize-space()='Employment Status']")).click();
		 //job title
		 driver.findElement(By.xpath("//label[normalize-space()='Job Title']")).click();
		 // click next button
		 driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();;
		 //select add display feild group
		 driver.findElement(By.xpath("//button[@id='display-group-dropdown-trigger']")).click();
		 //personal
		 driver.findElement(By.xpath("//a[normalize-space()='Personal']")).click();
		 //select all check box
		 driver.findElement(By.xpath("//label[normalize-space()='Select All']")).click();
		 //click the save button
		 driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		 Thread.sleep(500);
		 //generate report
		 //driver.findElement(By.xpath("//button[translate(@class, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='btn btn-secondary']")).click();
		 //save the report
		 driver.findElement(By.xpath("//button[normalize-space()='Save As']")).click();
		 //save 
		 Thread.sleep(200);
		 driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
		 Logout();
	}
		 
		 @Test(priority=4,enabled=true)
			public void SearchReport() throws InterruptedException
			{
				Login();	
			    //find Reports and Analytics menu click on the menu
				driver.findElement(By.xpath("//*[@id='left_menu_item_12']")).click();
				//find new Report button and click on that button
				Thread.sleep(300);
				//find my report element and click the filed
				driver.findElement(By.xpath("//p[normalize-space()='My Reports']")).click();
				//find search text feild
				driver.findElement(By.xpath("//input[@data-test='searchInput']")).sendKeys("abhyas");
				//find search button element and click the button 
				driver.findElement(By.xpath("//button[@class='oxd-icon-button']//i[@class='oxd-svg-icon oxd-svg-icon--medium']//*[name()='svg']")).click();
				Logout();
				
	}
	
   public void Login()
		 {
			//find Username and enter username
				driver.findElement(By.id("txtUsername")).sendKeys("Admin");
				//find Password and enter password
				driver.findElement(By.id("txtPassword")).sendKeys("BXq6Ew1@iB");
				//Login Button click
				driver.findElement(By.xpath("//div//button[contains(text(),'Login')]")).click();
				
		 }
		 
		 
	public void Logout()
	{
		driver.findElement(By.xpath("//*[@id=\"navbar-logout\"]/a")).click();
	}
	
	@AfterMethod
	public void Quitbrowser() throws InterruptedException
	{ 
		Thread.sleep(500); //wait for five seconds before quit
		driver.close();
		driver.quit();
	}

}
