package cn.taofen8.ui;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import cn.taofen8.util.Excel_read;
import io.appium.java_client.android.AndroidDriver;


public class update {
	static String s1 = null;
	static String s2 = null;
	
	//点击升级
	public static void update_a(AndroidDriver driver){
		String s1 = Excel_read.test("版本升级弹窗",1);
		if(driver.findElement(By.id(s1)).isDisplayed()){
			//点击升级
		}
	}
	
	@Test  //
	public static void update_t(AndroidDriver driver){
			try{
				String s2 = Excel_read.test("版本升级弹窗关闭",1);
				driver.findElement(By.id(s2)).click();
			}catch(Exception e){
				//e.printStackTrace();
				System.out.println("升级弹窗没有显示！");
			}
	}
	
/*    WebElement wb = driver.findElement(By.id("com.leixun.taofen8:id/title"));
    if(wb.isDisplayed()){
        driver.findElement(By.id("com.leixun.taofen8:id/cancel")).click();
    }*/
	
	/*Set set1 = Excel_read.test("版本升级弹窗关闭");*/
	/*Set set = Excel_read.test("版本升级弹窗");*/
	/*		Iterator<String> it = set.iterator();
	while(it.hasNext()){
		s1 = it.next();
	}*/
	//WebElement webElement = driver.findElement(By.id(s1));
	/*Iterator<String> it1 = set1.iterator();
	while(it1.hasNext()){
		s2 = it1.next();
		System.out.println("str:"+s2);
	}*/
	//WebElement w1 = driver.findElement(By.id(s2));

}

/*for(Map.Entry<String, String> entry : map.entrySet()){
	String t1 = entry.getKey();
	String t2 = entry.getValue();
	System.out.println(entry.getKey()+": value: "+entry.getValue());
}*/