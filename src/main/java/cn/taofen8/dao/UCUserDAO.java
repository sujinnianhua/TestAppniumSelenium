package cn.taofen8.dao;

import java.util.Date;
import java.util.List;

import cn.taofen8.model.MmsChangeAlipay;
import cn.taofen8.model.User;

public interface UCUserDAO {

    /**
     * 新增用户
     * @param user
     */
    void addUser(User user);
    
    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);
    
    /**
     * 依据用户ID查询用户信息
     * @param id
     * @return
     */
    User getUserById(long userId);

    /**
     * 依据用户淘宝昵称查询用户信息
     * @param tbNick
     * @return
     */
    User getUserByTBNick(String tbNick);
    
    /**
     * 通过UserNick获取用户信息
     * @param userNick
     * @return
     */
    User getUserByUserNick(String userNick);
    
    /**
     * 按照用户淘宝昵称更新用户ID
     * @param user
     */
    void updateUserIdByTbNick(User user);
    
    /**
     * 同步用户的支付宝帐号和手机号码
     * @param user
     */
    void syncUserMobileOrAlipay(MmsChangeAlipay mca);
    
    /**
     * 按照用户ID更新用户昵称
     * @param user
     */
    void updateUserNickByUserId(User user);
    
    /**
     * 按照支付宝帐号查询用户列表
     * @param alipay
     * @return
     */
    List<User> getUsersByAlipay(String alipay);
    
    /**
     * 按照支付宝帐号统计用户数，
     * 如果userId为null,则根据alipay账号统计所有的用户数，
     * 如果userId不为null,则根据alipay账号统计用户ID值不等于userId的用户数
     * @param userId
     * @param alipay
     * @return
     */
    int getUserAlipayCount(Long userId, String alipay);
    
    /**
     * 更新用户refer同时更新last_login_time
     * @param userId
     * @param refer
     */
    void updateMmsUsersReferByUserId(long userId, String refer);
    
    /**
     * 更新用户最后一次登录时间
     * @param userId
     */
    void updateUserForLastLoginTime(long userId);

    /**
     * 更新用户最后一次登录时间,且明确指定
     * @param userId
     * @param lastLoginTime
     */
    void updateUserForLastLoginTimeByDate(long userId, Date lastLoginTime);
    
    /**
     * 根据用户id删除mms_users表记录，用于初始化新人有礼
     * @param userId
     */
    void deleteUserForUserTaskByUserId(long userId);
    
    /**
     * 根据用户id删除mms_users表记录
     * @param userId
     */
    void deleteUserByUserId(long userId);
    
    /**
     * 根据首次登陆时间统计用户数量
     * @param startTime
     * @param endTime
     * @return
     */
    int countByFirstLoginTime(Date startTime, Date endTime);

    /**
     * 根据最后一次登陆时间统计用户数量
     * @param startTime
     * @param endTime
     * @return
     */
    int countByLastLoginTime(Date startTime, Date endTime);
    
    /**
     * 查询首次登陆时间在2012-08-27 0点以后的所有用户数量
     * @return
     */
    int countMMsUsers();
    
    /**
     * 分页获取首次登陆时间在2012-08-27 0点以后的用户列表
     * @param map
     * @return
     */
    List<User> getMMsUsersList(int startNum, int pageSize);
    
    /**
     * 根据手机号码获取用户列表
     * @param mobile
     * @return
     */
    List<User> getUserByMobile(String mobile);
    
    /**
     * 分页获取用户名是乱码的用户信息列表
     * @param start
     * @param end
     * @return
     */
    List<User> getUserByWrongTBNick(int start, int end);
    
    /**
     * 获取用户乱码的用户总记录数
     * @return
     */
    int getUserCountByWrongTBNick();
    
    /**
     * 根据支付宝账号获取用户昵称列表
     * @param alipay
     * @return
     */
    List<String> getTaobaoNicksByAlipay(String alipay);
    
    /**
     * 获取指定日期当天首次登录的用户数量
     * @param firstLoginTime
     * @return
     */
    int getUserCountByFirstLoginTime(Date firstLoginTime);
    
    /**
     * 根据首次登陆日期分页查询用户列表
     * @param firstLoginTime
     * @param startId
     * @param pageSize
     * @return
     */
    List<User> getUserListByFirstLoginDate(Date firstLoginDate,long startUserId,int pageSize);
    
    /**
     * 根据用户ID列表获取用户列表
     * @param userIds
     * @return
     */
    List<User> getUserByIds(List<Long> userIds);
    
    /**
     * 根据用户nick模糊查询用户数量,效率太低，准备废弃
     * @param nick
     * @return
     */
    @Deprecated
    int countByTbNick(String nick);
    
    /**
     * 修复用户昵称和淘宝昵称为URL编码的错误数据
     * @param userNick
     * @param tbNick
     * @param userId
     */
    void updateUserNickAndTbNickByUserId(String userNick, String tbNick, long userId);
    
    /**
     * 根据起始id和每页数量分页查询用户信息
     * @param startId
     * @param size
     * @return
     */
    List<User> getUserByPageStartId(long startId, int size);

    /**
     * 仅供后台使用
     * 根据usernick查询userid user_nick = userNick|userNick@tf8|userNick@taobao
     * @return
     */
    Long getUserIdByUserNick(String userNick);
    
    /**
     * 根据最后一次登陆日期分页查询用户列表
     * @param lastLoginTime
     * @param startId
     * @param pageSize
     * @return
     */
    List<User> getUserListByLastLoginDate(Date lastLoginDate,long startUserId,int pageSize);

    /**
     * 根据最后一次登陆日期分页查询用户列表
     * @param startDate
     * @param endDate
     * @param startUserId
     * @param pageSize
     * @return
     */
    List<User> getUserListByLastLoginDate(Date startDate, Date endDate, long startUserId,int pageSize);
    
    
    /**
     * 仅供后台使用
     * 根据usernick查询用户列表 user_nick = userNick|userNick@tf8|userNick@taobao
     *
     * @return
     */
    List<User> getUserListByUserNick(String userNick);
    
    /**
     * 仅更新refer,where user_id=#userId# and refer like 'mobile_'
     * @param userId
     * @param refer
     */
    void updateUserReferByUserId(long userId,String refer);
    
    /**
     * 根据userId 仅更新lastLoginTime,login_times不会加1,修复数据使用
     * @param userId
     * @param lastLoginTime
     */
    void updateUserLastLoginTime(long userId,Date lastLoginTime);

    /**
     *查询新用户.level<2 并且不在mms_users_tb_level表中(common-job使用)
     * @return
     */
    List<User> queryNewUserLevelLt2AndNotInTbUserLevelList();

	/**
	 * 查询过去subDayAmount天内登陆的用户
	 */
	List<User> queryLastSomeDayLoginUserList(long startUserId, int subDayAmount, int pageSize);
}
