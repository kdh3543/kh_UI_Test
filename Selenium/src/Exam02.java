import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam02 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor script = (JavascriptExecutor)driver;
		
		driver.get("http://www.nate.com");
		
		script.executeScript("onclick_Join();");
		
		
		
		
//		List<WebElement> ankers = driver.findElements(By.tagName("a"));
//		System.out.println(ankers.size());
//		
//		for(int i = 0; i<ankers.size();i++) {
//			ankers.get(3+i).click();
//		}
		
//		for(WebElement w : ankers) {
//			System.out.println(w.getText()+" : "+w.getAttribute("href"));
//		}
		
		Thread.sleep(5000);
		driver.close();
	}
}
