package testingbaba_script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {
	
public static void main(String[] args) throws InterruptedException {
	 
WebDriver driver= new ChromeDriver();


ExcelReadData ob = new ExcelReadData();

String path="D:\\Software Testing\\Selenium\\Testdata.xlsx";
		
		driver.get("https://www.testingbaba.com/old");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")).click();
		driver.findElement(By.xpath("//*[@id=\"v-pills-tab\"]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"fullname1\"]")).sendKeys(ob.getReaddata(path, 0, 0, 1));
		driver.findElement(By.xpath("//*[@id=\"fullemail1\"]")).sendKeys(ob.getReaddata(path, 0, 3, 1));
		driver.findElement(By.xpath("//*[@id=\"fulladdresh1\"]")).sendKeys(ob.getReaddata(path, 0, 4, 1));
		driver.findElement(By.xpath("//*[@id=\"paddresh1\"]")).sendKeys(ob.getReaddata(path, 0, 5, 1));
		driver.findElement(By.xpath("//*[@id=\"tab_1\"]/div/div[1]/form/input[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"v-pills-tab\"]/a[3]")).click();
		
	String[] arr = {"//*[@id=\"yes\"]","//*[@id=\"impressive\"]","//*[@id=\"no\"]"};
		
		for(int i=1;i<=3;i++) {
			
			String condition=ob.getReaddata(path, 1, 1, i);
			Thread.sleep(1000);
			if(condition.equalsIgnoreCase("True")) {
				driver.findElement(By.xpath(arr[i-1])).click();
		}
		
		}
		
		driver.findElement(By.xpath("//*[@id=\"v-pills-tab\"]/a[2]")).click();
		
		WebElement eleframe=driver.findElement(By.xpath("//*[@id=\"tab_2\"]/div/iframe"));
		
		//into the frame
		
		driver.switchTo().frame(eleframe);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"myCheck\"]")).click();
		String Value1=driver.findElement(By.xpath("//*[@id=\"text\"]")).getText();
		System.out.println(Value1);
		
		
		driver.findElement(By.xpath("//*[@id=\"mylaptop\"]")).click();
		String Value2=driver.findElement(By.xpath("//*[@id=\"text1\"]")).getText();
		System.out.println(Value2);
		
		driver.findElement(By.xpath("//*[@id=\"mydesktop\"]")).click();
		String Value3=driver.findElement(By.xpath("//*[@id=\"text2\"]")).getText();
		System.out.println(Value3);
		
		// exit the frame
		
		driver.switchTo().defaultContent();
	
		driver.findElement(By.xpath("//*[@id=\"v-pills-tab\"]/a[4]")).click();
		
		WebElement eleframe1=driver.findElement(By.xpath("//*[@id=\"tab_4\"]/div/iframe"));
		
				//into the frame
		
				driver.switchTo().frame(eleframe1);
				Thread.sleep(1000);
				
				String[] Name = new String[10];
				String[] Mail = new String[10];
				
				for(int i=1;i<10;i++) {
					
					driver.findElement(By.xpath("/html/body/div/form/div[1]/input")).sendKeys(ob.getReaddata(path, 0, 0, i));
					driver.findElement(By.xpath("/html/body/div/form/div[2]/input")).sendKeys(ob.getReaddata(path, 0, 3, i));
					driver.findElement(By.xpath("/html/body/div/form/button")).click();
					Name[i-1]= driver.findElement(By.xpath("/html/body/div/table/tbody/tr["+i+"]/td[1]")).getText();
					Mail[i-1]= driver.findElement(By.xpath("/html/body/div/table/tbody/tr["+i+"]/td[2]")).getText();
					
					System.out.println(Name[i-1] + ":-  "+ Mail[i-1]);
				}
				
				
				
				// exit the frame
				driver.switchTo().defaultContent();		
	}
}
