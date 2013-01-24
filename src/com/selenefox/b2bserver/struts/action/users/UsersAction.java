package com.selenefox.b2bserver.struts.action.users;

import com.selenefox.b2bserver.manager.users.UsersManager;
import com.selenefox.b2bserver.struts.action.BaseAction;

/**
 * Created with IntelliJ IDEA.
 * User: SeleneFox
 * Date: 13-1-22
 * Time: 下午7:46
 * To change this template use File | Settings | File Templates.
 */
public class UsersAction extends BaseAction {
    private UsersManager usersmanager;
    private String loginname;
    private String password;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsersmanager(UsersManager usersmanager) {
        this.usersmanager = usersmanager;
    }

    public String login(){
        return SUCCESS;
    }
}
