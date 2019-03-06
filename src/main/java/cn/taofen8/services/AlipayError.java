package cn.taofen8.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import cn.taofen8.dao.impl.BillDetailDAOImpl;
import cn.taofen8.dao.impl.UCUserDAOImpl;
import cn.taofen8.dao.impl.UserDAOImpl;
import cn.taofen8.model.BillDetail;
import cn.taofen8.model.User;

public class AlipayError {
	
	private static ApplicationContext applicationContext = null;
	static{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void t(){
		isError("lt6851");
	}
	
	public static boolean isError(String tb_nick){
		BillDetailDAOImpl tf8 = (BillDetailDAOImpl) applicationContext.getBean("BillDetailDAO");
		
		UserDAOImpl tf8_u = (UserDAOImpl) applicationContext.getBean("UserDAO");
		User u =tf8_u.getUserByTbNick(tb_nick);
		//User u = getUserByIdFromCache("lt6851");
		System.out.println(u.getId());
		Long user_id = u.getId();
		
		BillDetail b = new BillDetail();
		/*b.setUserId(2000008223390L);*/
		b.setUserId(user_id);
		System.out.println();
		if(tf8.getErrorTimes(b)>0){
			System.out.println("false");
			return false;
		}
		return true;
	}
}
