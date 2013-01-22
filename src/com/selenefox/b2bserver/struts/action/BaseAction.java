package com.selenefox.b2bserver.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: SeleneFox
 * Date: 13-1-22
 * Time: 下午7:47
 * To change this template use File | Settings | File Templates.
 */
public class BaseAction extends ActionSupport {
    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }
}
