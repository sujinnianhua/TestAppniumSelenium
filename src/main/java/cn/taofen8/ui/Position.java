package cn.taofen8.ui;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import cn.taofen8.util.Excel_read;
import cn.taofen8.util.sleep_t;
import io.appium.java_client.android.AndroidDriver;

public class Position {
	
	//x1,y1 点击的坐标；x2,y2 测试手机的屏幕大小
	//实现不同手机均能实现点击同一控件就要用到相对坐标
	public static void Click_p(AndroidDriver driver,int x1,int y1,int x2,int y2){
		int width = driver.manage().window().getSize().width;  //获取当前屏幕的宽度
		int height = driver.manage().window().getSize().height; //获取当前屏幕的高度
		int x = x1/x2;
		int y = y1/y2;
		driver.tap(1, x*width, y*height, 200);
	}
	
	//可配置滑动次数
	//向上滑动
	//during 滑动时间（默认5毫秒）
	public static void swipeToUp(AndroidDriver driver,int during, int num){
		int width = driver.manage().window().getSize().width;  //获取当前屏幕的宽度
		int height = driver.manage().window().getSize().height; //获取当前屏幕的高度
		for(int i = 0; i < num; i++){
			driver.swipe(width/2, height*3/4, width/2, height*2/4, during);
		}
	}
	
	//向下滑动
	public static void swipeToDown(AndroidDriver driver,int during, int num){
		int width = driver.manage().window().getSize().width;  //获取当前屏幕的宽度
		int height = driver.manage().window().getSize().height; //获取当前屏幕的高度
		for(int i = 0; i < num; i++){
			driver.swipe(width/2, height/4, width/2, height*3/4, during);
		}
	}
	
	//向左滑动
	public static void swipeToLeft(AndroidDriver driver,int during, int num){
		int width = driver.manage().window().getSize().width;  //获取当前屏幕的宽度
		int height = driver.manage().window().getSize().height; //获取当前屏幕的高度
		for(int i = 0; i < num; i++){
			sleep_t.sleep(500);
			driver.swipe(width*3/4, height/2, width/4, height/2, during);
			System.out.println("滑动第"+i+"次");
		}
	}
	
	//向左滑动
	public static void swipeToLeftRight(AndroidDriver driver,int during, int num){
		int width = driver.manage().window().getSize().width;  //获取当前屏幕的宽度
		int height = driver.manage().window().getSize().height; //获取当前屏幕的高度
		for(int i = 0; i < num; i++){
			driver.swipe(width/4, height/2, width*3/4, height/2, during);
		}
	}
	
	//刷新页面
	public static void refresh(AndroidDriver driver){
		swipeToDown(driver,800,1);
	}
	
	public static void swipe(AndroidDriver driver){
		swipeToLeft(driver,800,3);
		String s = Excel_read.test("启动页开启省钱之旅",0);
		driver.findElement(By.xpath(s)).click();
		
		//720,1280  X轴起点设为600，终点设为100，Y轴设置坐标为600，每次间隔1秒
		/*System.out.println(driver.get);*/
		//driver.swipe(800, 600, 200, 600, 1000);
/*		System.out.println("滑动第一次");
		
		Thread.sleep(500);
		driver.swipe(800, 600, 200, 600, 1000);
		System.out.println("滑动第二次");
		
		Thread.sleep(500);
		driver.swipe(800, 600, 200, 600, 1000);
		System.out.println("滑动第三次");
		
		Thread.sleep(500);
		driver.swipe(800, 600, 200, 600, 1000);
		System.out.println("滑动第四次");*/
	}

}
