package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linktest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.railyatri.in/time-table");
		WebElement trainstable = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div/div/div/div/table"));
		List<WebElement> x = driver.findElements(By.tagName("tr"));
		System.out.println(x.size());
		//Count the number of rows
		
		List<WebElement> cols = x.get(1).findElements(By.tagName("td"));
		System.out.println(cols.size());
 		//Count the no columns
		for(int i=1;i<=x.size()-1;i++) {
					/*String trainname = tcols.get(0).getText();
					String trainno = tcols.get(1).getText();
					System.out.println(trainname+""+trainno );*/  // This will print the only the train name and train number
					
			/*String  detail = x.get(i).getText();
					System.out.println(detail);*/ //Another logic for print all statement
			
			List<WebElement> list1 = x.get(i).findElements(By.tagName("td"));
			for(WebElement ele: list1)
			{
				System.out.println(ele.getText());
			}
					
			
			
		}

		
		
	}
	}


