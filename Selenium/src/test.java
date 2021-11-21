import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	      
	      System.out.print("타겟 이름을 입력해주세요 : ");
	      String targetName = sc.nextLine();
	      System.out.print("악플 내용을 입력해주세요 : ");
	      String nagativeComment = sc.nextLine();
	      
	      WebDriver driver = new ChromeDriver();
	      JavascriptExecutor script = (JavascriptExecutor) driver;
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      WebDriverWait tmpWait = new WebDriverWait(driver, Duration.ofSeconds(1));

	      

	      driver.get("https://iei.or.kr/login/login.kh");

	      wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("id")));
	      WebElement id = driver.findElement(By.id("id"));
	      WebElement password = driver.findElement(By.id("password"));
	      WebElement loginBtn = driver.findElement(By.cssSelector(".login_frm_detail>a"));

	      // 아이디 비밀번호 입력
	      id.sendKeys("kdh3543");
	      password.sendKeys("donghyun12@");
	      loginBtn.click();

	      wait.until(ExpectedConditions
	            .presenceOfAllElementsLocatedBy(By.cssSelector("#right_nav_e > ul.class_news > li.title")));
	      WebElement myGroupBoard = driver.findElement(By.cssSelector("#right_nav_e > ul.class_news > li.title"));
	      myGroupBoard.click();

	      wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".tab_list>a:nth-child(2)")));
	      WebElement assignmentBoard = driver.findElement(By.cssSelector(".tab_list>a:nth-child(2)"));
	      assignmentBoard.click();

	      abc: for (int j = 3; j < 12; j++) {
	         for (int i = 2; i < 12; i++) {
	            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	                  By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(3)")));
	            WebElement searchName = driver
	                  .findElement(By.cssSelector("tbody > tr:nth-child(" + i + ") > td:nth-child(3)"));
	            String searchedName = searchName.getText();
	            if (targetName.equals(searchedName)) {
	               searchName.click();
	               wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("comment_area")));
	               WebElement commentArea = driver.findElement(By.id("comment_area"));
	               commentArea.sendKeys(nagativeComment);

	               script.executeScript("fnComment()");

	               break abc;
	            }
	         }
	         
	         
	         
	         
	         
	         wait.until(ExpectedConditions
	               .presenceOfAllElementsLocatedBy(By.cssSelector("div.board_num > a:nth-child(" + j + ")")));
	         WebElement nextBoard = driver.findElement(By.cssSelector("div.board_num > a:nth-child(" + j + ")"));
	         nextBoard.click();
	      }

	}

}
