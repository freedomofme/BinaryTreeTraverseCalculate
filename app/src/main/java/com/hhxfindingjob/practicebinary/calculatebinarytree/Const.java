package com.hhxfindingjob.practicebinary.calculatebinarytree;

import java.util.HashMap;

/**
 * Created by HHX on 16/4/1.
 */
public class Const {
    static final String duplicate = "存在重复字符";
    static final String diffrennt = "两个输入字符串不匹配";
    static final String notChar = "输入中存在汉字或特殊符号";
    public static HashMap<Integer, String> wrongCode = new HashMap<>();
    static {
        wrongCode.put(-1, duplicate);
        wrongCode.put(-2, diffrennt);
        wrongCode.put(-3, notChar);
    }

    public static String get(int code) {
        String hold = wrongCode.get(code);
        if (hold == null)
            return "发生异常";
        return hold;
    }
}
