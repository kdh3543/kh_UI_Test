import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam01 {
	public static void main(String[] args)throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.naver.com");//selenium naver.com���� �̵�
		
		WebElement inputSearch = driver.findElement(By.id("query")); //�˻� â �ν��Ͻ� �ּҸ� ã�ƿ�
		//�˻� â�� id���� ������ ��
		inputSearch.sendKeys("selenium");
		WebElement btnSearch = driver.findElement(By.id("search_btn"));
		btnSearch.click();
		
		Thread.sleep(5000);
		driver.close();
	}
}
