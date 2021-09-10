package testcase;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends Baseclass {
	
@Test(dataProvider = "sendData")
	public  void creatingLead( String firstname , String lstname, String cmpyname ,String phno) {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("cmpyname");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("firstname");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("lstname");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("phno");
		driver.findElement(By.name("submitButton")).click();
		
}
@DataProvider
public void sendData() {
	String data[][] = new String[2][4];
	data[0][0] = "vaishnavi";
	data[0][1] = "B";
	data[0][2] = "CTS";
	data[0][3] = "887";
	
	data[1][0] = "Monika";
	data[1][1] = "S";
	data[1][2] = "Testleaf";
	data[1][3] = "9890";
}
}





