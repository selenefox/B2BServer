package com.selenefox.b2bserver.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: SeleneFox
 * Date: 12-4-16
 * Time: 下午9:39
 * 带忽略后缀检测的 登录用户检测Filter
 */
public class LoginFilter implements Filter {
    public static final String ROLLBACK_PARAM = "rollbackpage";
    public static final String UNFILTER_PARAM = "unfilterparam";
    public static final String CHECK_USERSESSION = "checksession";
    public static final String SPLIT_STR = ";";

    private String rollbackpage;
    private List<String> unfilter = new ArrayList<String>();
    private String checkusersession ;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        rollbackpage = filterConfig.getInitParameter(ROLLBACK_PARAM);
        if(rollbackpage == null){
            rollbackpage = "/";
        }
        String unneed = filterConfig.getInitParameter(UNFILTER_PARAM);
        if(unneed != null && !unneed.equals("")){
            try{
                String[] temps = unneed.split(SPLIT_STR);
                Collections.addAll(unfilter, temps);
            }catch (Exception e){
                unfilter.clear();
            }
        }
        checkusersession = filterConfig.getInitParameter(CHECK_USERSESSION);
        if(checkusersession == null || checkusersession.equals("")){
            checkusersession = null;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String last = getActionPath(request);
        if(last.equals("")){
            if(checkUserSession(request)){
                filterChain.doFilter(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + rollbackpage);
            }
        }else{
            if(!unfilter.contains(last)){
                if(checkUserSession(request)){
                    filterChain.doFilter(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + rollbackpage);
                }
            }else{
                filterChain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 获取访问路径的后缀
     * @param request request对象
     * @return 返回格式 *.后缀
     */
    private String getActionPath(HttpServletRequest request){
        String t = request.getRequestURI();
        if(t.lastIndexOf(".") > 0){
            t = t.substring(t.lastIndexOf(".")+1);
            if(t.length() != 6 && t.length() != 3 && t.length() !=4 ){
                t = "";
            }
        }else{
            t = "";
        }
        return "*."+t;
    }

    /**
     * 会话检测用户信息
     * @param request request对象
     * @return 成功true 失败 false
     */
    private boolean checkUserSession(HttpServletRequest request){
        if(checkusersession == null){
            return true;
        }
        HttpSession session = request.getSession(true);
        Object obj = session.getAttribute(checkusersession);
        return null != obj;
    }
}
