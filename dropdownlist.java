package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownlist {

	public static void main(String[] args) {
			
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		
		driver.get("http://facebook.com");
		driver.findElement(By.xpath("//*[starts-with(@id,'u_0_0')]")).click();
		Select x = new Select(driver.findElement(By.id("month")));
        x.selectByIndex(0);
		List<WebElement> daylist =x.getOptions();
		System.out.println(daylist.size());
		String cat1, cat2;
		
		boolean	order= true;
		for(int i=1;i<daylist.size();i++)
		{	
		cat1 = daylist.get(i-1).getText();
		cat2 = daylist.get(i).getText();
		if (cat2.compareToIgnoreCase(cat1)>0) {
			
		order=false;
		break;	
		}
		
		else if (order) {
			System.out.println("Test pass");
			
		}
		else {
			System.out.println("Test fail");
		
		}
	
		}
	}
			
	
		}


