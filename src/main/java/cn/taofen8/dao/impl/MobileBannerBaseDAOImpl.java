package cn.taofen8.dao.impl;

import java.util.HashMap;
import java.util.List;

import cn.taofen8.dao.BaseDAO;
import cn.taofen8.dao.MobileBannerBaseDAO;
import cn.taofen8.model.MobileBannerBase;
import cn.taofen8.model.User;

public class MobileBannerBaseDAOImpl extends BaseDAO implements MobileBannerBaseDAO {

	public Integer getGlobalBanner(String type) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("type", type);
		return (Integer) getSqlMapClientTemplate().queryForObject("countMobileBannerBaseListByType",map);
	}

}
