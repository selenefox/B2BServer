package com.selenefox.b2bserver.mode.users;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: SeleneFox
 * Date: 13-1-14
 * Time: 上午11:27
 * To change this template use File | Settings | File Templates.
 */
public class UsersBean {
    private Long id;
    private String name;
    private String orgcoding;
    private String coding;
    private String loginname;
    private String password;
    private Date lastlogintime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgcoding() {
        return orgcoding;
    }

    public void setOrgcoding(String orgcoding) {
        this.orgcoding = orgcoding;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

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

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }
}
