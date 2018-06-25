package com.epam.notareligion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Attila_Horvath2 on 1/15/2016.
 */
public class Ch5 {

    public static String f(String in) {
        String tmp = "";
        int started = 0;
        for(int i = 0; i < in.length(); i++) {
            boolean lastChar = i+1 == in.length();
            if(in.charAt(i) == '/' ) {
                if(!lastChar) {
                    started = 1;
                    if(in.charAt(i+1) == '/')
                        tmp += "/";
                    if(in.charAt(i+1) == '|')
                        tmp += "/";
                    if(in.charAt(i+1) == '_') {
                        tmp += "/";
                        started = 0;
                    }
                    if(in.charAt(i+1) == ' ') {
                        tmp += "__";
                        started = 0;
                    }
                } else {
                    tmp += "__";
                    started = 0;
                }
            }
            if (in.charAt(i) == '|' ) {
                if(started == 0)
                    tmp += "|";
                if(started == 1) {
                    if(!lastChar) {
                        if (in.charAt(i + 1) == '/')
                            tmp += "/";
                        if (in.charAt(i + 1) == '\\') {
                            tmp += "|";
                            started = 0;
                        }

                        if (in.charAt(i + 1) == '|')
                            tmp += "/";
                        if (in.charAt(i + 1) == '_') {
                            tmp += "/";
                            started = 0;
                        }
                        if (in.charAt(i + 1) == ' ') {
                            tmp += "__";
                            started = 0;
                        }
                        if (in.charAt(i + 1) == ' ') {
                            tmp += "__";
                            started = 0;
                        }
                    } else {
                        
                    }
                }
                if(started == -1){
                    if(!lastChar) {
                        if (in.charAt(i + 1) == '\\')
                            tmp += "\\";
                        if (in.charAt(i + 1) == '|')
                            tmp += "\\";
                        if (in.charAt(i + 1) == '_') {
                            tmp += "\\";
                            started = 0;
                        }
                        if (in.charAt(i + 1) == ' ') {
                            tmp += "__";
                            started = 0;
                        }
                    } else {
                        tmp += "|";
                        started = 0;
                    }
                }
            }
            if (in.charAt(i) == '\\' ) {
                boolean first;
                if(!lastChar) {
                    started = -1;
                    if (in.charAt(i - 1) == '\\')
                        tmp += "\\";
                    if (in.charAt(i + 1) == '/'){
                        tmp += "\\";
                        started = 0;
                    }
                    if (in.charAt(i + 1) == '|'){
                        tmp += "\\";
                        started = 0;
                    }
                    if (in.charAt(i + 1) == '_') {
                        tmp += "\\";
                        started = 0;
                    }
                    if (in.charAt(i-1) == ' ') {
                        tmp += "__";
                        started = -1;
                    }
                } else {
                    tmp += "\\";
                    started = 0;
                }
            }
        }
        return tmp;
    }
}
