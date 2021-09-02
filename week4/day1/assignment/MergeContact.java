package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//div[@id='label']/parent::div")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		driver.findElement(By.xpath("//input[@id='partyIdFrom']//following::img")).click();
		
		Set<String> windowhandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowhandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		driver.switchTo().window(windowHandlesList.get(0));
		
		
		driver.findElement(By.xpath("//input[@id='partyIdTo']//following::img")).click();
		Set<String> windowhandles1Set = driver.getWindowHandles(); 
		List<String> windowHandles1List = new ArrayList<String>(windowhandles1Set);
		driver.switchTo().window(windowHandles1List.get(1));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		driver.switchTo().window(windowHandles1List.get(0));
		
		driver.findElement(By.linkText("Merge")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		String title2 = driver.getTitle();
		System.out.println(title2);
		
		driver.close();

}
}
