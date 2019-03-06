package cn.taofen8.dao.impl;

import cn.taofen8.dao.BaseDAO;
import cn.taofen8.dao.UserDAO;
import cn.taofen8.model.Sms;
import cn.taofen8.model.User;

public class UserDAOImpl extends BaseDAO implements UserDAO {

	public User getUserByTbNick(String TbNick) {
		// TODO Auto-generated method stub
		return (User) getSqlMapClientTemplate().queryForObject("getUserByTBNick",TbNick);
	}

}
