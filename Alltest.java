package practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alltest {

	private static final List<WebElement> WebElement = null;

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http:/flights.qedgetech.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*
		 * driver.findElement(By.linkText("Register")).click();
		 * driver.findElement(By.id("name")).sendKeys("bhanu");
		 * driver.findElement(By.id("contact")).sendKeys("54465646655");
		 * driver.findElement(By.id("email")).sendKeys("bhanubabul53@gmil.com");
		 * driver.findElement(By.id("address")).sendKeys("Qedge123#$@!"); 
		 * Select dlist = new Select(driver.findElement(By.name("gender"))); dlist.selectByIndex(1);
		 * driver.findElement(By.name("dob")).click();
		 * //driver.findElement(By.id("popupDatepicker")).sendKeys("27-12-2000"); [This
		 * method only use where text box is available] String dob = "27-Dec-2000";
		 * String[] temp =dob.split("-"); String date = temp[0]; String month = temp[1];
		 * String year = temp[2];
		 * 
		 * Select mlist = new
		 * Select(driver.findElement(By.className("ui-datepicker-month")));
		 * mlist.selectByVisibleText(month); Select ylist = new
		 * Select(driver.findElement(By.className("ui-datepicker-year")));
		 * ylist.selectByVisibleText(year); WebElement caltab=
		 * driver.findElement(By.className("ui-datepicker-calendar")); List<WebElement>
		 * trows = driver.findElements(By.tagName("tr")); for(int i=0;
		 * i<trows.size();i++) { List<WebElement> dates
		 * =trows.get(i).findElements(By.tagName("td")); for(WebElement element: dates)
		 * { if (element.getText().equals(date)) { element.click();
		 * System.out.println("Test pass"); } }
		 * 
		 * }
		 * 
		 * WebElement x= driver.findElement(By.className("form-check-input"));
		 * if(!x.isSelected()) { x.click(); }
		 * //driver.findElement(By.name("submit")).click();
		 * 
		 */
		// driver.navigate().back();
		driver.findElement(By.name("email")).sendKeys("bhanubabul53@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Qedge123#@!");
		driver.findElement(By.xpath("//button[@type= 'submit']")).click();
		// driver.findElement(By.id("search-date")).sendKeys("12/22/2023");

		driver.findElement(By.id("search-date")).click();

		String flydate = "25-June-2025";
		String[] temp2 = flydate.split("-");
		String date2 = temp2[0];
		String month2 = temp2[1];
		String year2 = temp2[2];
		String calyr = driver.findElement(By.className("ui-datepicker-year")).getText();
		while (!calyr.equals(year2)) {
			driver.findElement(By.linkText("Next")).click();
			calyr = driver.findElement(By.className("ui-datepicker-year")).getText();
		}
		String calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		while (!calmonth.equalsIgnoreCase(month2)) {
			driver.findElement(By.linkText("Next")).click();
			calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		}

		WebElement table = driver.findElement(By.className("ui-datepicker-calendar"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			List<WebElement> tcolm = rows.get(i).findElements(By.tagName("td"));
			for (WebElement element4 : tcolm) {
				if (element4.getText().equals(date2)) {
					element4.click();
					break;
				}
			}
		}
		Select from = new Select(
				driver.findElement(By.xpath("//section[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/select")));
		from.selectByVisibleText("Hyderabad");
		Select to = new Select(driver
				.findElement(By.xpath("/html/body/section[2]/div/div[2]/div/div[2]/div[1]/div/div/div[3]/select")));
		to.selectByIndex(3);
		driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div/div[2]/div[1]/div/div/div[4]/button"))
				.click();
		Thread.sleep(2000);
		WebElement tables = driver.findElement(By.className("flights_table"));

		List<WebElement> tbrow2 = tables.findElements(By.tagName("tr"));
		for (int i = 1; i < tbrow2.size(); i++) {
			List<WebElement> tbcol2 = tbrow2.get(i).findElements(By.tagName("td"));
			for (WebElement element3 : tbcol2) {
				if (element3.getText().contains("Soft Airlines")) {
					element3.findElement(By.xpath("//button[@data-airline='Soft Airlines']")).click();
					// element.click();
					break;

				}
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Bhanu");
		driver.findElement(By.xpath("//input[@value ='Business']")).click();
		driver.findElement(By.xpath("//div[2]/div[1]/div/div/form/div/div[4]/div/button")).click();
		driver.findElement(By.linkText("View Ticket")).click();
		String odrid =driver.findElement(By.xpath("//div[1]/div/div/div/div[2]/div[1]")).getText();
		System.out.println(odrid);
		String bookid =odrid.substring(8);
		/*driver.navigate().back();
		driver.findElement(By.linkText("Flight Bookings")).click();
		driver.findElement(By.className("flights_table"));
		List<WebElement> flightbrow = driver.findElements(By.tagName("tr"));
		for (int i = 1; i < flightbrow.size(); i++) {
			List<WebElement> flighttbcol = flightbrow.get(i).findElements(By.tagName("td"));
			for (WebElement flightelement : flighttbcol) {
				if (flightelement.getText().equalsIgnoreCase("8565")) {
					flightelement.findElement(By.xpath("//div/div[2]/div/table/tbody/tr[4]/td[10]/a[3]")).click();
					Thread.sleep(2000);
					driver.switchTo().alert().accept();
				}
				

			}

		}

	}*/
	}
}
