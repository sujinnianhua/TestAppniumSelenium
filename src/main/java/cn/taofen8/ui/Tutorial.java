package cn.taofen8.ui;

import io.appium.java_client.android.AndroidDriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.taofen8.util.Excel_read;

public class Tutorial {
	static String s1 = null;
	static String s2 = null;
	public static void t(AndroidDriver driver){
/*		Set s = Excel_read.test("搜索引导页");
		Iterator<String> i = s.iterator();
		while(i.hasNext()){
			s1 = i.next();
		}*/
		String s1 = Excel_read.test("搜索引导页",1);
		WebElement wb = driver.findElement(By.id(s1));
		if(wb.isDisplayed()){
			/*Set ss = Excel_read.test("搜索引导页点击我知道了");*/
			String s2 = Excel_read.test("搜索引导页点击我知道了",1);
/*			Iterator<String> it = ss.iterator();
			while(it.hasNext()){
				s2 = it.next();
			}*/
			driver.findElement(By.id(s2)).click();;
		}else{
			System.out.println("搜索引导页，没显示");
		}
	}
}
