package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;

public class chk_emp_table {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		
		driver.get("http://orangehrm.qedgetech.com");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.name("Submit")).click();
		
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();		
		
		driver.findElement(By.id("firstName")).sendKeys("Pratap");
		driver.findElement(By.id("lastName")).sendKeys("demo");
		String empid = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
		System.out.println(empid);
		Thread.sleep(1200);
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		driver.findElement(By.id("searchBtn")).click();
		WebElement table = driver.findElement(By.id("resultTable"));
		List<WebElement> trows =driver.findElements(By.tagName("tr"));
		for(int i=1;i<trows.size();i++) 
		{
				List<WebElement> tdata =trows.get(i).findElements(By.tagName("td"));
				
					if (tdata.get(i).getText().equals(empid)) {
						
						System.out.println("test pass");
					
				}
		}

	}
	

}
