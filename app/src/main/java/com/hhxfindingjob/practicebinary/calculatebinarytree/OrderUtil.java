package com.hhxfindingjob.practicebinary.calculatebinarytree;

import java.util.ArrayList;

/**
 * Created by HHX on 16/4/1.
 */

public class OrderUtil {
    private static ArrayList<Character> result = new ArrayList<>();

//    public static void main(String[] args) {
//        String preString = "abdefgc";
//        String midString = "debgfac";
//        String postString = "edgfbca";
//        calPostOrderHelper(preString, midString);
//        System.out.println(result);
//        calPreOrderHelper(postString, midString);
//        System.out.println(result);
//    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Character> calPostOrderHelper(String preString, String midString) {
        result.clear();
        calPostOrder(preString, midString);
        return (ArrayList<Character>) result.clone();
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Character> calPreOrderHelper(String postString, String midString) {
        result.clear();
        calPreOrder(postString, midString);
        return (ArrayList<Character>) result.clone();
    }

    public static void calPostOrder(String preString, String midString) {
        if (preString.length() == 0) return;
        if (preString.length() == 1) {
            result.add(preString.charAt(0));
        }
        if (preString.length() > 1) {
            //以前序首字母拆分中序, split函数有点特殊，需要特别处理下
            String[] resultStrings = midString.split(preString.charAt(0) + "");
            for (int i = 0; i < resultStrings.length; i++) {
                String newPreString = findSubStringInPreORPostString(preString, resultStrings[i]);
                calPostOrder(newPreString, resultStrings[i]);
            }
            result.add(preString.charAt(0));
        }
    }

    public static void calPreOrder(String postString, String midString) {
        if (postString.length() == 0) return;
        if (postString.length() == 1) {
            result.add(postString.charAt(0));
        }
        if (postString.length() > 1) {
            result.add(postString.charAt(postString.length() - 1));
            //以前序首字母拆分中序, split函数有点特殊，需要特别处理下
            String[] resultStrings = midString.split(postString.charAt(postString.length() - 1) + "");
            for (int i = 0; i < resultStrings.length; i++) {
                String newPostString = findSubStringInPreORPostString(postString, resultStrings[i]);
                calPreOrder(newPostString, resultStrings[i]);
            }

        }
    }

    private static String findSubStringInPreORPostString(String preOrPostString, String resultString) {
        if (resultString.length() == 0) return "";
        int min = preOrPostString.length();
        int max = 0;

        for (int i = 0; i < resultString.length(); i++) {
            int index = preOrPostString.indexOf(resultString.charAt(i));
            if (index < min) min = index;
            if (index > max) max = index;
        }

        return preOrPostString.substring(min, max + 1);
    }


}
