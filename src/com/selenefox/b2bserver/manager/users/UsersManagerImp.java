package com.selenefox.b2bserver.manager.users;

import com.selenefox.b2bserver.dao.users.UsersDao;

/**
 * Created with IntelliJ IDEA.
 * User: SeleneFox
 * Date: 13-1-22
 * Time: 下午7:39
 * To change this template use File | Settings | File Templates.
 */
public class UsersManagerImp implements UsersManager {
    private UsersDao userdao;

    public void setUserdao(UsersDao userdao) {
        this.userdao = userdao;
    }
}
