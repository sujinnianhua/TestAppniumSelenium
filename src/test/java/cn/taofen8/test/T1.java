package cn.taofen8.test;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class T1 {
	private static Scanner input;
	@Test
	public void t(){
/*		System.setProperty("WebDriver.firefox.bin", "D:\\firefox\\firefox.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com/");*/
		
		
		input = new Scanner(System.in);
		System.out.println(input.nextLine());
		
	}
}
