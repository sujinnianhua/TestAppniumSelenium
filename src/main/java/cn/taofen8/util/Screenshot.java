package cn.taofen8.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.android.AndroidDriver;

public class Screenshot {
	//,String screenName
	public static void  t(AndroidDriver driver){
		SimpleDateFormat Timeformat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String dateSring = Timeformat.format(new Date());
		
		String dir_name = System.getProperty("user.dir")+"\\"+"异常图片";
		if(!(new File(dir_name).isDirectory())){
			new File(dir_name).mkdir();
		}
		File screen = driver.getScreenshotAs(OutputType.FILE);
		System.out.println("异常图片保存路径："+new File(dir_name));
		try {
			FileUtils.copyFile(screen, new File(dir_name+"\\"+dateSring+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
