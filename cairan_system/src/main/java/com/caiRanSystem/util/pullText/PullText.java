package com.caiRanSystem.util.pullText;

import com.caiRanSystem.entity.book.RegexReplace;
import lombok.extern.log4j.Log4j2;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * http请求
 */
@Log4j2
public class PullText {


    public static String JsonSMS(String postData, String postUrl) {
        try {
            //发送POST请求
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "GBK");
            out.write(postData);
            out.flush();
            out.close();
            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                return "";
            }
            //获取响应内容体
            String line, result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return "";
    }

    public static boolean getData(UrlText urlText) {
        System.out.println("############################## 开始获取页面数据 ##############################");
        String str = PullText.get(urlText.getIp() + urlText.getPath());
        if (str == null) {
            System.err.println("############################## 获取页面数据失败 ##############################");
            return false;
        } else {
            System.out.println("############################## 获取页面数据结束 ##############################");
        }
        System.out.println("############################ 开始获取页面地址数据 ############################");
        List<Map<String, String>> mapList = getUrlList(str, urlText);
        System.out.println("##################### 获取页面地址数据结束,地址数量：" + mapList.size() + "#####################");
        if (mapList.size() > 0) {
            String content = "\r\n------------\r\n\t正文卷\r\n------------\r\n";
            if (write(content, urlText, false)) {
                if (getPageData(mapList, urlText)) {
                    System.out.println("获取数据完成");
                } else {
                    System.out.println("获取数据中断");
                }
            } else {
                System.err.println("写入文件失败");
            }

        }
        return true;
    }

    /**
     * 向指定URL发送GET方法的请求
     */
    public static String get(String url) {
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            log.error("Exception occur when send http get request!", e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    //获取地址
    public static List<Map<String, String>> getUrlList(String str, UrlText urlText) {
        int begin = str.indexOf(urlText.getBeginStr());
        int end = str.indexOf(urlText.getEndStr());
        str = str.substring(begin, end);

        Matcher matcher = Pattern.compile(urlText.getUrlRegex()).matcher(str);

        List<Map<String, String>> list = new ArrayList<>();

        while (matcher.find()) {
            Map<String, String> map = new HashMap<>();
            map.put("pageUrl", matcher.group(1));
            map.put("pageName", matcher.group(2));
//            System.out.println("内容页面地址：" + matcher.group(1) + "   标题：" + matcher.group(2));
            list.add(map);
        }

        return list;
    }

    //写入文件
    public static boolean write(String str, UrlText urlText, boolean append) {
        if (str == null) {
            return true;
        }
        FileWriter writer = null;
        try {
            File dir = new File(urlText.getFilePath());
            // 一、检查放置文件的文件夹路径是否存在，不存在则创建
            if (!dir.exists()) {
                if (!dir.mkdirs()) {// mkdirs创建多级目录
                    System.err.println("创建目录：{" + urlText.getFileName() + "}失败。");
                    return false;
                }
            }
            File checkFile = new File(urlText.getFilePath() + "/" + urlText.getFileName());
            // 二、检查目标文件是否存在，不存在则创建
            if (!checkFile.exists()) {
                if (!checkFile.createNewFile()) {  // 创建目标文件
                    System.err.println("创建目标文件：{" + urlText.getFileName() + "}失败。");
                    return false;
                }
            }
            // 三、向目标文件中写入内容
            writer = new FileWriter(checkFile, append);
            writer.append(str);
            writer.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public static boolean getPageData(List<Map<String, String>> mapList, UrlText urlText) {
        System.out.println("##############################################################################");
        System.out.println("############################## 开始获取页面数据 ##############################");
        System.out.println("##############################################################################");
        int num = 1;
        for (Map<String, String> map : mapList) {
            System.out.println("########################## 第" + num + "次获取数据开始 ##########################");
            String content;
            String str = PullText.get(urlText.getIp() + map.get("pageUrl"));
            if (str == null) {
                content = map.get("pageName") + " 未获取到数据";
            } else {
                content = getContent(str, urlText);
                content = getContentText(content, urlText);
                content = "\r\n" + map.get("pageName") + "\r\n\r\n" + content + "\r\n\r\n------------";
                System.out.println("\t【" + map.get("pageName") + "】内容获取成功。");
            }
            if (!write(content, urlText, true)) {
                System.err.println("\t内容写入失败。内容：" + content);
                return false;
            } else {
                System.out.println("\t内容写入成功。");
            }
            System.out.println("########################## 第" + num + "次获取数据结束 ##########################\n");
            num++;
        }
        return true;
    }

    //获取内容
    public static String getContent(String str, UrlText urlText) {
        Matcher m = Pattern.compile(urlText.getContentRegex())
                .matcher(str.trim());
        if (m.find()) {
            str = m.group(1).trim();
        }
        return str;
    }

    //内容转换
    public static String getContentText(String str, UrlText urlText) {
        if (str == null) {
            return null;
        }
        if (urlText.getReplaceList() == null || urlText.getReplaceList().size() == 0) {
            return str;
        }
        for (RegexReplace replace : urlText.getReplaceList()) {
            str = str.replaceAll(replace.getRegex(), replace.getReplace());
        }
        return str;
    }


}
