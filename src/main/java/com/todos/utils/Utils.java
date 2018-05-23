package com.todos.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    final public static String LOGIN_PAGE = "login.html";
    final public static String HOME_PAGE = "index.html";
    final public static String USER_ID_COOKIE = "UserId";
    final public static String LOGIN_TOKEN_COOKIE = "LoginToken";
    final public static String EMPTY_STRING = "";

    public static HashMap<String, String> parseDataFromUrl(String str) {
        if (str.length() == 0) return null;
        String[] pairs = str.split("\\&");
        HashMap<String, String> data = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            String[] fields = pairs[i].split("=");
            try {
                String name = URLDecoder.decode(fields[0], "UTF-8");
                String value = URLDecoder.decode(fields[1], "UTF-8");
                data.put(name,value);
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
                System.err.println(ex);
            }
        }
        return data;
    }

}
