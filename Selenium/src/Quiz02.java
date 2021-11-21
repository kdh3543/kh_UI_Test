import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Quiz02 {

	public static void main(String[] args) throws Exception{
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		JavascriptExecutor script = (JavascriptExecutor)driver;
		String parentWindow = driver.getWindowHandle();
		
		driver.get("https://www.tmon.co.kr/");

		WebElement login = driver.findElement(By.className("login"));
		login.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userid")));
		WebElement userid = driver.findElement(By.id("userid"));
		userid.sendKeys(StaticsTmon.Tmon_Id);
		
		WebElement pwd = driver.findElement(By.id("pwd"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pwd")));
		pwd.sendKeys(StaticsTmon.Tmon_Pw);
		
		WebElement btn_login = driver.findElement(By.className("btn_login"));
		btn_login.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("top_srch")));
		WebElement top_srch = driver.findElement(By.id("top_srch"));
		top_srch.sendKeys("·Ôµ¥¿ùµå");
		
		WebElement btn_search = driver.findElement(By.className("btn_search"));
		btn_search.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#search_app > div.ct_wrap > section.search_deallist > div.deallist_wrap > ul > li:nth-child(1) > a")));
		WebElement list = driver.findElement(By.cssSelector("#search_app > div.ct_wrap > section.search_deallist > div.deallist_wrap > ul > li:nth-child(1) > a"));
		list.click();
		
		driver.close();
		
		for(String handle : driver.getWindowHandles()) {
			if(!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		
		WebElement tit = driver.findElement(By.cssSelector("#_optionScroll > div > div > div > div > button"));
		tit.click();
		
		WebElement tit_first = driver.findElement(By.cssSelector("#_optionScroll > div > div > div > div > ul > li:nth-child(1) > button"));
		tit_first.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#view-default-scene-default > section.wrap_deals_basic.center_grid > div.bx_ct.deal_info > div:nth-child(3) > div.ct_wrp.order_btn > div.ct > div > ul > li:nth-child(2) > button")));
		WebElement purchase = driver.findElement(By.cssSelector("#view-default-scene-default > section.wrap_deals_basic.center_grid > div.bx_ct.deal_info > div:nth-child(3) > div.ct_wrp.order_btn > div.ct > div > ul > li:nth-child(2) > button"));
		purchase.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("_iselect_payInfo_card")));
		WebElement card = driver.findElement(By.id("_iselect_payInfo_card"));
		card.click();
		
		WebElement woori = driver.findElement(By.cssSelector("#_iselect_payInfo_card > option:nth-child(7)"));
		woori.click();
		
		WebElement check = driver.findElement(By.cssSelector("#_terms > dl > dt > label > i"));
		check.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("_confirmCheckout")));
		WebElement confirm = driver.findElement(By.id("_confirmCheckout"));
		confirm.click();
		
		Thread.sleep(5000);
		driver.close();
		
	}
}
