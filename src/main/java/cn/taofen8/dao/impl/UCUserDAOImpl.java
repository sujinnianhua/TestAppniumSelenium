package cn.taofen8.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.taofen8.dao.GenericDAO;
import cn.taofen8.dao.UCUserDAO;
import cn.taofen8.model.MmsChangeAlipay;
import cn.taofen8.model.User;
import cn.taofen8.util.Tf8DateUtils;

public class UCUserDAOImpl extends GenericDAO<User> implements UCUserDAO {

    public void addUser(User user) {
        super.insert("addUser", user);
    }

    public void updateUser(User user) {
        super.update("updateUser", user);
    }

    public User getUserById(long userId) {
        return super.selectOne("getUserById", userId);
    }

    public User getUserByTBNick(String tbNick) {
        return super.selectOne("getUserByTBNick", tbNick);
    }

    public User getUserByUserNick(String userNick) {
        return super.selectOne("getUserByUserNick", userNick);
    }

    public void updateUserIdByTbNick(User user) {
        super.update("updateUserIdByTbNick", user);
    }

    public void syncUserMobileOrAlipay(MmsChangeAlipay mca) {
        super.update("syncUserMobileOrAlipay", mca);
    }

    public void updateUserNickByUserId(User user) {
        super.update("updateUserNickByUserId", user);
    }

    public List<User> getUsersByAlipay(String alipay) {
        return super.selectList("getUsersByAlipay", alipay);
    }

    public int getUserAlipayCount(Long userId, String alipay) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("alipay", alipay);
        if(userId != null){
            param.put("userId", userId);
        }
        return super.count("getUserAlipayCount", param);
    }

    public void updateMmsUsersReferByUserId(long userId, String refer) {
        User user = new User();
        user.setId(userId);
        user.setRefer(refer);
        super.update("updateMmsUsersReferByUserId", user);
    }

    public void updateUserForLastLoginTime(long userId) {
        super.update("updateUserForLastLoginTime", userId);
    }

    public void updateUserForLastLoginTimeByDate(long userId, Date lastLoginTime) {
        Map<String, Object> map = new HashMap<String, Object>(4);
        map.put("userId", userId);
        map.put("lastLoginTime", lastLoginTime);
        super.update("updateUserForLastLoginTimeByDate", map);
    }
    
    public void deleteUserForUserTaskByUserId(long userId) {
        super.delete("deleteUserForUserTaskByUserId", userId);
    }
    
    public void deleteUserByUserId(long userId) {
        this.delete("deleteUserByUserId", userId);
    }
    
    public int countByFirstLoginTime(Date startTime, Date endTime) {
        Map<String, Object> param = new HashMap<String, Object>(4);
        param.put("startTime", startTime);
        param.put("endTime", endTime);
        return this.count("countByFirstLoginTime", param);
    }

    public int countByLastLoginTime(Date startTime, Date endTime) {
        Map<String, Object> param = new HashMap<String, Object>(4);
        param.put("startTime", startTime);
        param.put("endTime", endTime);
        return this.count("countByLastLoginTime", param);
    }

    public int countMMsUsers() {
        return (Integer) this.count("countMMsUsers");
    }

    public List<User> getMMsUsersList(int startNum, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", startNum);
        map.put("end", pageSize);
        return this.selectList("getMMsUsersList", map);
    }

    public List<User> getUserByMobile(String mobile) {
        return this.selectList("getUserByMobile", mobile);
    }

    public List<User> getUserByWrongTBNick(int start, int end) {
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("end", end);
        return this.selectList("getUserByWrongTBNick", param);
    }

    public int getUserCountByWrongTBNick() {
        return this.count("getUserCountByWrongTBNick");
    }

    @SuppressWarnings("unchecked")
    public List<String> getTaobaoNicksByAlipay(String alipay) {
        return getSqlMapClientTemplate().queryForList(getWholeSqlId("getTaobaoNicksByAlipay"),
                alipay);
    }

    public int getUserCountByFirstLoginTime(Date firstLoginTime) {
        Map<String, Object> map = new HashMap<String, Object>();
        firstLoginTime = Tf8DateUtils.zerolizedTime(firstLoginTime);
        map.put("startTime", firstLoginTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(firstLoginTime);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        map.put("endTime", cal.getTime());
        return this.count("getUserCountByFirstLoginTime", map);
    }

	public List<User> getUserListByFirstLoginDate(Date firstLoginDate,
			long startUserId, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		firstLoginDate = Tf8DateUtils.zerolizedTime(firstLoginDate);
        map.put("startTime", firstLoginDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(firstLoginDate);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        map.put("endTime", cal.getTime());
		map.put("startUserId", startUserId);
		map.put("pageSize", pageSize);
		return selectList("getUserListByFirstLoginDate",map);
	}

    public List<User> getUserByIds(List<Long> userIds) {
       return this.selectList("getUserByIds", userIds);
    }

    public int countByTbNick(String nick) {
        return this.count("countByTbNick", nick);
    }

    public void updateUserNickAndTbNickByUserId(String userNick, String tbNick, long userId) {
        Map<String, Object> param = new HashMap<String, Object>(8, 1);
        param.put("userNick", userNick);
        param.put("tbNick", tbNick);
        param.put("userId", userId);
        super.update("updateUserNickAndTbNickByUserId", param);
    }

    public List<User> getUserByPageStartId(long startId, int size) {
        Map<String,Object> param = new HashMap<String, Object>(4);
        param.put("startId", startId);
        param.put("size", size);
        return this.selectList("getUserByPageStartId",param);
    }

    public Long getUserIdByUserNick(String userNick) {
        return (Long) getSqlMapClientTemplate().queryForObject(getWholeSqlId("getUserIdByUserNick"),userNick);
    }

    public List<User> getUserListByLastLoginDate(Date lastLoginDate, long startUserId, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        lastLoginDate = Tf8DateUtils.zerolizedTime(lastLoginDate);
        map.put("startTime", lastLoginDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(lastLoginDate);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        map.put("endTime", cal.getTime());
        map.put("startUserId", startUserId);
        map.put("pageSize", pageSize);
        return selectList("getUserListByLastLoginDate",map);
    }
    
    public List<User> getUserListByUserNick(String userNick) {
        return selectList("getUserListByUserNick",userNick);
    }

	public void updateUserReferByUserId(long userId, String refer) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("refer", refer);
		
		update("updateUserReferByUserId", map);
	}

	public void updateUserLastLoginTime(long userId, Date lastLoginTime) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("lastLoginTime", lastLoginTime);
		
		update("updateUserLastLoginTime", map);
	}

    public List<User> queryNewUserLevelLt2AndNotInTbUserLevelList() {
        return selectList("queryNewUserLevelLt2AndNotInTbUserLevelList");
    }

    public List<User> queryLastSomeDayLoginUserList(long startUserId, int subDayAmount,
            int pageSize) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("startUserId",startUserId);
        map.put("subDayAmount",subDayAmount);
        map.put("pageSize",pageSize);
        return selectList("queryLastSomeDayLoginUserList",map);
    }

    public List<User> getUserListByLastLoginDate(Date startDate, Date endDate, long startUserId,
            int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startTime", startDate);
        map.put("endTime", endDate);
        map.put("startUserId", startUserId);
        map.put("pageSize", pageSize);
        return selectList("getUserListByLastLoginDate",map);
    }
}
