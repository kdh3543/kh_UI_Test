import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam01 {
	public static void main(String[] args)throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.naver.com");//selenium naver.com으로 이동
		
		WebElement inputSearch = driver.findElement(By.id("query")); //검색 창 인스턴스 주소를 찾아와
		//검색 창의 id값을 가지고 옴
		inputSearch.sendKeys("selenium");
		WebElement btnSearch = driver.findElement(By.id("search_btn"));
		btnSearch.click();
		
		Thread.sleep(5000);
		driver.close();
	}
}
