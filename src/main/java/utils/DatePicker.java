package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePicker {

	public void selectdatepicker(WebElement clickondate, String month_year, String day, WebDriver driver) {
		clickondate.click();

		while (true) {
			String text = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			if (text.equals(month_year)) {
				break;
			} else {
				driver.findElement(By.xpath("//td[@class='next']")).click();
			}
		}
		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/table[1]/tbody[1]/tr/td[contains(text(), " + day + ")]")).click();
	}

}
