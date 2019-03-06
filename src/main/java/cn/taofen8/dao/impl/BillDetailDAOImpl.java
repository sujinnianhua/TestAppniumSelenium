package cn.taofen8.dao.impl;

import cn.taofen8.dao.BaseDAO;
import cn.taofen8.dao.BillDetailDAO;
import cn.taofen8.model.BillDetail;

public class BillDetailDAOImpl extends BaseDAO implements BillDetailDAO {

	public int getErrorTimes(BillDetail bill) {
		return (Integer) getSqlMapClientTemplate().queryForObject("errorAlipay",bill);	
	}

}
