import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exam04 {

	public static void main(String[] args) throws Exception{
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("http://127.0.0.1:5500/temp.html");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn1"))).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn2"))).click();
		wait.until(ExpectedConditions.alertIsPresent());		
		driver.switchTo().alert().accept();
		
		Thread.sleep(5000);
		driver.close();
		
		
	}

}
