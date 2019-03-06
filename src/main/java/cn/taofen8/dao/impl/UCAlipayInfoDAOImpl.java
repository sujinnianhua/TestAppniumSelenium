package cn.taofen8.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.taofen8.dao.UCAlipayInfoDAO;
import cn.taofen8.model.AlipayInfo;

import com.taofen8.dao.GenericDAO;

public class UCAlipayInfoDAOImpl extends GenericDAO<AlipayInfo> implements UCAlipayInfoDAO {

    public Long saveAlipayInfo(AlipayInfo alipayInfo) {
        return (Long) insert("saveAlipayInfo", alipayInfo);
    }

	public AlipayInfo getAlipayInfoByAlipay(String alipay) {
		return selectOne("getAlipayInfoByAlipay",alipay);
	}

	public void updateValidStatus(long id, int valid) {
		Map<String,Object> map = new HashMap<String, Object>(4,1);
		map.put("id", id);
		map.put("valid", valid);
		update("updateValidStatus", map);
	}

	public void updateLastPayTime(long id, Date lastPayTime) {
		Map<String,Object> map = new HashMap<String, Object>(4,1);
		map.put("id", id);
		map.put("lastPayTime", lastPayTime);
		update("updateLastPayTime", map);
	}

	public void updateConfirmAuthorizedTime(long id, Date confirmAuthorizedTime) {
		Map<String,Object> map = new HashMap<String, Object>(4,1);
		map.put("id", id);
		map.put("confirmAuthorizedTime", confirmAuthorizedTime);
		update("updateConfirmAuthorizedTime", map);
	}

}
