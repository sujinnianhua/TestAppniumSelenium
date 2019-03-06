package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import cn.taofen8.dao.Tf8DAO;
import cn.taofen8.dao.impl.Tf8DAOImpl;
import cn.taofen8.model.Sms;

@Test
public class T2 {
	private static ApplicationContext applicationContext = null;
	static{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	public void t(){
		Sms s = new Sms();
		s.setMobile("13612341234");
		Sms s1 = new Sms();
		Tf8DAOImpl tf8 = (Tf8DAOImpl) applicationContext.getBean("Tf8DAO");
		s1 = tf8.findSms(s);
		System.out.println(s1.getContent());
	}

}
