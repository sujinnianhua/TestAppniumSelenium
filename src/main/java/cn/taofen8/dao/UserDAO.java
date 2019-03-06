package cn.taofen8.dao;

import cn.taofen8.model.User;

public interface UserDAO {
    /**
     * 通过UserNick获取用户信息
     * @param userNick
     * @return
     */
    User getUserByTbNick(String userNick);
}
