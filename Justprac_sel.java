package practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Justprac_sel {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver =  new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	/*	driver.get("http://flights.qedgetech.com");
		driver.findElement(By.name("email")).sendKeys("bhanubabul53@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Qedge123#@!");
		driver.findElement(By.xpath("//button[@type= 'submit']")).click();
		driver.findElement(By.linkText("Flight Bookings")).click();
		driver.findElement(By.linkText("Delete")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();*/
		driver.get("http://orangehrm.qedgetech.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.partialLinkText("Change")).click();
		Thread.sleep(5000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("c:\\Pictures\\def2.png");
		FileUtils.copyFile(src, trg);
		//trg.delete();
		
		
	}
	
	
}
