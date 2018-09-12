package com.springformwork.pojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/29
 * Time: 上午 09:07
 * explain: 加载配置文件
 */
public class Application {
    private static Properties properties = null;

    static {
        System.out.println( "加载配置文件" );
        String path = "/application.properties";
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream( path );
        if (inputStream == null) {
            System.out.println( "加载配置文件失败" );
        }
        try {
            properties= new Properties();
            properties.load( inputStream );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) throws IOException {
//        String path = "/application.properties";
//        System.out.println(Application.class.getClass().getResourceAsStream( path ));
//        InputStream inputStream = Application.class.getClass().getResourceAsStream( path );
//        if (inputStream == null) {
//            System.out.println( "加载配置文件失败" );
//        } else {
//            System.out.println( "加载配置文件成功" );
//            BufferedReader   bufferedReader = new BufferedReader( new InputStreamReader( inputStream ) );
//            char[] charBuffer = new char[128];
//            int bytesRead = -1;
//            StringBuilder stringBuilder = new StringBuilder();
//
//            while ((bytesRead = bufferedReader.read( charBuffer )) > 0) {
//                stringBuilder.append( charBuffer, 0, bytesRead );
//            }
//            properties.load( inputStream );
//            System.out.println(stringBuilder.toString());
//        }
//
//    }

    public static String getProperty(String key) {
        String value = "";
        if (properties != null && properties.containsKey( key )) {
            value = properties.getProperty( key );
        }
        return value;
    }

}
