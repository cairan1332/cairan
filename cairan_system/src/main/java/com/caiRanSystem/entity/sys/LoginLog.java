package com.caiRanSystem.entity.sys;

import com.caiRanSystem.util.DateUtil;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

;

/**
 * 登录日志
 */
@Data
public class LoginLog {
    private int loginId;//id

    private int userId;//用户id

    private String token;//登录令牌

    private String userAgent;//浏览器信息

    private String ip;//ip地址

    private String mac;//MAC地址

    private String loginTime;//登录时间

    private String logoutTime;//注销时间

    public LoginLog(HttpServletRequest request, User user) {
        this.ip = getIpAddress(request);
        this.userId = user.getUserId();
        this.token = user.getToken();
        this.userAgent = request.getHeader("user-agent");
        this.loginTime = DateUtil.getDate();
    }

    public LoginLog(User user) {
        this.userId = user.getUserId();
        this.token = user.getToken();
        this.logoutTime = DateUtil.getDate();
    }

    /**
     * 获取IP地址
     *
     * @param request 请求
     * @return IP地址
     */
    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-real-ip");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 通过访问的Ip地址得到mac地址
     *
     * @param ip Ip地址
     * @return mac
     */
    private String getMacByIp(String ip) {
        String macAddress = "";
        try {
            java.lang.Process process = Runtime.getRuntime().exec("nbtstat -A " + ip);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String str = "";
            while ((str = input.readLine()) != null) {
                str = str.toUpperCase();
                if (str.indexOf("MAC ADDRESS") > 1) {
                    int start = str.indexOf("=");
                    macAddress = str.substring(start + 1, str.length()).trim();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return macAddress;
    }


}
