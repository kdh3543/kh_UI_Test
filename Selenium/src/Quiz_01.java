import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Quiz_01 {

	public static void main(String[] args) throws Exception{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options); 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//�����Ͽ� �ν��Ͻ�
		
		JavascriptExecutor script = (JavascriptExecutor)driver;
		// �����Ͽ��� �ڹٽ�ũ��Ʈ�� ������ �� �ְ� �����ϴ� Ŭ����
		
		driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com");
		
		script.executeScript("document.getElementById('id').value=arguments[0]", Statics.NAVER_ID);
		script.executeScript("document.getElementById('pw').value=arguments[0]", Statics.NAVER_PW);
		
		
//		WebElement inputId = driver.findElement(By.id("id"));
//		WebElement inputPassword = driver.findElement(By.id("pw"));
//		
//		inputId.sendKeys("ABC");
//		inputPassword.sendKeys(("ABC"));
		
		WebElement loginBtn = driver.findElement(By.id("log.login"));
		loginBtn.click();
		Thread.sleep(500);
		driver.switchTo().frame("minime");
		
		WebElement email = driver.findElement(By.className("link_new"));
		email.click();
		Thread.sleep(500);
		
//		List<WebElement> list = driver.findElements(By.className("btn_import"));
//		WebElement writeToMe1 = list.get(0);
//		
//		WebElement WriteToMe2 = driver.findElement(By.cssSelector("div.btn_worset>a:nth-child(2)"));
		
//		WebElement emailicon = driver.findElement(By.className("btn_import"));
//		emailicon.click();
		
//		WebElement web = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/a[2]"));
//		web.click();
		
		WebElement writeToMe5 = driver.findElement(By.linkText("���Ծ���"));
		writeToMe5.click();
		
		
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("subject")));
		WebElement write = driver.findElement(By.id("subject"));
		write.sendKeys("�� �ڵ�ȭ ������");
		
		driver.findElement(By.name("subject")).sendKeys(Keys.TAB+"����");
		
//		driver.switchTo().frame("	");
//		WebElement writemsg = driver.findElement(By.className("se2_inputarea"));
//		writemsg.sendKeys("�� �ڵ�ȭ �������Դϴ�.");
		
		driver.switchTo().parentFrame();
		WebElement sendBtn = driver.findElement(By.id("sendBtn"));
		sendBtn.click();
		
		Thread.sleep(5000);
		driver.close();
	}

}
