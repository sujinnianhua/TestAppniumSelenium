package cn.taofen8.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import cn.taofen8.dao.impl.Tf8DAOImpl;
import cn.taofen8.model.Sms;

public class getSms {
	private static ApplicationContext applicationContext = null;
	static{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void tt(){
		System.out.println(t("15168256851"));
	}
	
	public static String t(String mobile){
		//String mobile = "13612341234";
		Sms s = new Sms();
		Sms s1 = new Sms();
		String regEx = "\\d{4}?";
		String result = null;
		String context = null;
		
		s.setMobile(mobile);

		Tf8DAOImpl tf8 = (Tf8DAOImpl) applicationContext.getBean("Tf8DAO");
		s1 = tf8.findSms(s);
		context = s1.getContent();

		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(context);
		while(m.find()){
			System.out.println(m.group());
			result = m.group();
		}
		return result;
	}
}
