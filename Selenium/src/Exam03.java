import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam03 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor script = (JavascriptExecutor)driver;
		driver.get("https://www.interpark.com/member/login.do?_method=initial&GNBLogin=Y&&wid1=wgnb&wid2=wel_login&wid3=login&imfsUserPath=http%3A%2F%2Fwww.interpark.com%2Fmalls%2Findex.html%3FgateTp%3D1&historyGoCnt=-1");
		
		driver.switchTo().frame("loginIframe");
		
		WebElement idInput = driver.findElement(By.id("userId"));
		WebElement pwInput = driver.findElement(By.id("userPwd"));
		
		idInput.sendKeys("");
		pwInput.sendKeys("");
		
		WebElement loginBtn = driver.findElement(By.id("btn_login"));
		loginBtn.click();
		
		System.out.println(idInput);
		System.out.println(pwInput);

		Thread.sleep(5000);
		driver.close();
	}
}
