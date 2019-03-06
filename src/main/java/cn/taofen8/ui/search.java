package cn.taofen8.ui;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.taofen8.util.Excel_read;
import cn.taofen8.util.sleep_t;

public class search {
	public static void w(AndroidDriver driver){
		String wb1 = Excel_read.test("首页顶部搜索框",0);
		driver.findElement(By.xpath(wb1)).click();
		
		String wb2 = Excel_read.test("淘宝商品搜索输入框",0);
		WebElement ss = driver.findElement(By.xpath(wb2));
		ss.sendKeys("女装");
		sleep_t.sleep(200);
		//点击搜索图标
		driver.tap(1, 900, 300, 200);
		//点击第一个商品
		sleep_t.sleep(1000);
		driver.tap(1,200,500,200);
		
/*		WebElement ss1 = driver.findElement(By.xpath("//com.leixun.taofen8:id/tv_associate[@instance[2]]"));
		ss1.click();*/
		
/*		String wb3 = Excel_read.test("搜索按钮",0);
		driver.findElement(By.xpath(wb3)).click();*/
		
	}
	
	public static void t(AndroidDriver driver) throws InterruptedException{
	      WebElement sj = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='com.leixun.taofen8:id/update_main']/android.widget.FrameLayout[1]"));
		  if(sj.isDisplayed()){
			  driver.findElement(By.id("com.leixun.taofen8:id/cancel")).click();
		  }
		  
		  Position.swipe(driver);
		  
		  WebElement newU = driver.findElement(By.id("com.leixun.taofen8:id/rl_content"));
		  if(newU.isDisplayed()){
			  driver.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='com.leixun.taofen8:id/rl_content']/android.widget.ImageView[1]")).click();;
		  }
		  
		  WebElement tip = driver.findElement(By.xpath(
				  "//android.widget.ImageView[@resource-id='com.leixun.taofen8:id/iv_tips']"
				  ));
		  if(tip.isDisplayed()){
			  driver.findElement(By.id("com.leixun.taofen8:id/v_action")).click();
		  }
		  
		  driver.findElement(By.name("复制商品标题 拿返利")).click();
		  
		  driver.findElement(By.id("com.leixun.taofen8:id/iv_home_search_tour_link"));
	/*	  if(ss.isDisplayed()){
			  System.out.println("显示了搜索教程，且点击");
			  WebElement sj1 = driver.findElement(By.name("搜索教程"));
			  if(sj1.isDisplayed()){
				  System.out.println("搜索教程显示正常，退出");
				  driver.findElement(By.id("com.leixun.taofen8:id/back")).click();
			  }
		  }*/
		  WebElement ss = driver.findElement(By.id("com.leixun.taofen8:id/et_home_search"));
		  ss.click();
		  ss.sendKeys("女装");
		  driver.findElement(By.xpath("//android.widget.FrameLayout[1]"
		  		+ "/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]"
		  		+ "/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"
		  		+ "/android.widget.FrameLayout[1]/android.support.v7.widget.RecyclerView[2]"
		  		+ "/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]"
		  		+ "/android.widget.TextView[1]")).click();
		  
		  int width = driver.manage().window().getSize().width;		
		  int height = driver.manage().window().getSize().height;		
		  for (int i1 = 0; i1 < 5; i1++) {			
			  driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4,1000);			
			  }
	}
}
