import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exam05 {

	public static void main(String[] args) throws Exception{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=1920,1080");
		
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("http://127.0.0.1:5500/temp.html");
		String parentWindow = driver.getWindowHandle(); 
		//ó�� ���� �� ũ��â�� �ּҰ�
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn1"))).click();
		for(String handle : driver.getWindowHandles()) {
			if(!handle.equals(parentWindow)) { // handle�� �ּҰ��� popup window�� ����ų��
				System.out.println("�˾� ������ �˻� ���� : "+handle);
				driver.switchTo().window(handle);
				break;
			}
		}
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("close"))).click();
		driver.switchTo().window(parentWindow);
		Thread.sleep(5000);
		driver.close();
		
		//driver.getWindowHandles() --> �ҷ����� window�� �ּҰ��� �޶�� ��
		
//		driver.switchTo().alert().accept();
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn2"))).click();
//			
//		driver.switchTo().alert().accept();
		
		
	}

}
