package cn.taofen8.dao.impl;

import org.springframework.stereotype.Service;

import cn.taofen8.dao.BaseDAO;
import cn.taofen8.dao.Tf8DAO;
import cn.taofen8.model.Sms;

public class Tf8DAOImpl extends BaseDAO implements Tf8DAO {

	public Sms findSms(Sms s) {
		return (Sms) getSqlMapClientTemplate().queryForObject("selectMobile",s);
		
	}

}
