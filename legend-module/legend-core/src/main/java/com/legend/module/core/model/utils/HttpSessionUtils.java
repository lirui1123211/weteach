package com.legend.module.core.model.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * @date 2018/1/9
 */
public class HttpSessionUtils {

    /**
     * 得到httpSession
     *
     * @return httpsession
     */

    public static HttpSession getSession() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (servletRequestAttributes == null) {
            throw new NullPointerException();
        }
        return servletRequestAttributes.getRequest().getSession(true);
    }

    /**
     * 移除对应s（key）的o（value）属性，但此时，session没有失效
     *
     * @param s key值
     */
    public static void removeAttribute(String s) {
        getSession().removeAttribute(s);
    }

    /**
     * 设置s（key）和o（value）键值对
     *
     * @param s 关键字
     * @param o 值
     */
    public static void setAttribute(String s, Object o) {
        getSession().setAttribute(s, o);
    }

    /**
     * 通过关键字获得对应的值
     *
     * @param s 关键字
     * @return o
     */
    public static Object getAttribute(String s) {
        return getSession().getAttribute(s);
    }

    /**
     * 使得该次访问的session彻底失效，在用户退出或者关闭浏览器时使用
     */
    public static void invalidateSession() {
        getSession().invalidate();
    }

}
