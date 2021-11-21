import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test2 {

	public static void main(String[] args) {
		  WebDriver driver = (WebDriver)new ChromeDriver();
	      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	      
	      JavascriptExecutor script = (JavascriptExecutor)driver;
	      driver.get("https://www.spacecloud.kr/");
	      
	      wait.until(ExpectedConditions.presenceOfElementLocated(By.className("icon-search"))).click();
	      WebElement btnSearch = driver.findElement(By.cssSelector("input"));
	      btnSearch.sendKeys("브레인워시"+ Keys.ENTER);
	      
	      
	      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#__layout > div > div > div.content_wraper > div.wrapper-result.result_area.bg_original > div.inner_width.wrap-normal > div > div > article > div > a > div.info_area"))).click();
	      
	      String parentWindow = driver.getWindowHandle();
	      
	      for(String handle : driver.getWindowHandles()) {
	    	  if(!handle.equals(parentWindow)) {
					driver.switchTo().window(handle);
					break;
				}
	      }
	      
	      WebElement btn = driver.findElement(By.cssSelector("#content_wraper > div.section_cont > div > div.detail_forms > div.box_form.right_fixed.detail_space > div > div > div.scroll_box > div > ul > li:nth-child(1) > div.flex_box > div:nth-child(1)"));
	      btn.click();
	      

	}

}
