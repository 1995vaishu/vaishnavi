package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://dev113545.service-now.com/");
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("w6hnF2FRhwLC");
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("filter")).sendKeys("incident");
		Actions action = new Actions(driver); 
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.className("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[text()='New']")).click();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//button[@name='lookup.incident.caller_id']']")).click();
		
		Set<String> windowhandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowhandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));
		driver.findElement(By.xpath("//a[text()='Aileen Mottern']")).click();
		driver.switchTo().window(windowHandlesList.get(0));
		
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Short Description");
		String incidentNum = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident Number"+incidentNum);
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		
		WebElement incidentSearchElement = driver.findElement(By.xpath("//input[@class='form-control']"));
		incidentSearchElement.sendKeys(incidentNum);
		incidentSearchElement.sendKeys(Keys.ENTER);
		WebElement ssWebElement = driver.findElement(By.xpath("//div[@class='vcr_controls']//span"));
		String rowNumber = ssWebElement.getText();
		System.out.println("Incident displayed after searching :" + rowNumber);
		if (rowNumber.contains("Showing rows 1 ")) {
			System.out.println("Incident created successfully");
		} else
			System.out.println("Incident not created");
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snap/ServiceNow.png");
		FileUtils.copyFile(src1, dst);
		
		
		
	}

}
