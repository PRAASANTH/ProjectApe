package org.mighty;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class MightyApe {
	
	private static String getData(int rowNo, int cellno) throws Throwable {
		String v = null;
		File loc = new File("C:\\Users\\Prasanth\\eclipse-workspace\\Tester1\\Excel\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellno);
		v = c.getStringCellValue();
		return v;
	}
	
	
		public static void main(String[] args) throws Throwable {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prasanth\\eclipse-workspace\\Mighty\\Driver\\chromedriver.exe");
			WebDriver Driver = new ChromeDriver();
			Driver.get("https://www.mightyape.co.nz/");
			Driver.manage().window().maximize();
			WebElement element = Driver.findElement(By.id("headerSearchTerm"));
			element.sendKeys("Smart tv");
			Thread.sleep(1000);
			
			//to press enter
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			
	
			
			WebElement element2 = Driver.findElement(By.xpath("//a[text()='Gorilla 32\" Smart LED TV']"));
			element2.click();
			Thread.sleep(2000);
			WebElement element3 = Driver.findElement(By.xpath("//button[@class='trolley-button']"));
			element3.click();
			Thread.sleep(2000);
			WebElement element6 = Driver.findElement(By.xpath("//button[@name='checkout']"));
			element6.click();
			Driver.findElement(By.xpath("//input[@type='email']")).sendKeys(getData(0,0));
			Driver.findElement(By.xpath("//input[@type='password']")).sendKeys(getData(0,1));
			
			
			
			WebElement element4 = Driver.findElement(By.xpath("//a[@class='btn btn-action']"));
			
			Actions acc = new Actions(Driver);
			acc.contextClick(element4).perform();
			Thread.sleep(2000);
			
			Robot ro = new Robot();
			ro.keyPress(KeyEvent.VK_DOWN);
			ro.keyRelease(KeyEvent.VK_DOWN);
			ro.keyPress(KeyEvent.VK_ENTER);
			ro.keyRelease(KeyEvent.VK_ENTER);
		
			//Handling Windows
			
			Set<String> id = Driver.getWindowHandles();
			Iterator<String> it = id.iterator();
			String Parent = it.next();
			String Child = it.next();
			Driver.switchTo().window(Child);
			Thread.sleep(2000L);
			Driver.switchTo().window(Parent);
			
			
			
			//Screenshot
			
			TakesScreenshot tk = (TakesScreenshot) Driver;
			File temp = tk.getScreenshotAs(OutputType.FILE);
			
			File desc = new File("C:\\Users\\Prasanth\\eclipse-workspace\\Tester1\\target\\Screen.jpeg");
			FileUtils.copyFile(temp,desc);
			
			
				
			
			
		}
			
			
			

}
