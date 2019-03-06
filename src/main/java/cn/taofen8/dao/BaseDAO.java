package cn.taofen8.dao;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BaseDAO extends SqlMapClientDaoSupport {
	public void setBeanFactory(BeanFactory beanFactory){
		SqlMapClient sqlMapClient = (SqlMapClient) beanFactory.getBean("sqlMapClientFactoryBean");
		setSqlMapClient(sqlMapClient);
	} 
}
