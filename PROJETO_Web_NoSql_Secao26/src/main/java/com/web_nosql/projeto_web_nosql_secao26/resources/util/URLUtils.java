package com.web_nosql.projeto_web_nosql_secao26.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLUtils {
    public static String decodeParam (String text){
        try {
            return URLDecoder.decode(text, "UTF-8");
        }catch (UnsupportedEncodingException e){
            return "";
        }
    }
}
