package com.hhxfindingjob.practicebinary.calculatebinarytree;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by HHX on 16/4/1.
 */
public class OrderModel {
    ArrayList<Character> resultArrayList;
    public OrderModel() {
//		System.out.println(orderModel.securityCheck("adf", "fda"));
    }

    public ArrayList<Character> calculateOrderList(String s1, String s2, boolean isPre) {
        if (isPre)
            resultArrayList = OrderUtil.calPreOrderHelper(s1, s2);
        else
            resultArrayList = OrderUtil.calPostOrderHelper(s1, s2);
        return resultArrayList;
    }

    public int securityCheck(String s1, String s2) {
        if (hasDuplicate(s1) || hasDuplicate(s2))
            return -1;
        if (hasDifferent(s1, s2))
            return -2;
        if (!isDigitalOrNumbers(s1) || !isDigitalOrNumbers(s2))
            return -3;

        return 0;
    }

    private boolean isDigitalOrNumbers(String s) {
        return s.length() == s.replaceAll("[^a-z^A-Z^0-9]", "").length() ? true : false;
    }

    //str = str.replaceAll("[^a-z^A-Z^0-9]", "");
    private boolean hasDifferent(String s1, String s2) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            if (set.contains(s2.charAt(i)))
                set.remove(s2.charAt(i));
            else
                return true;
        }
        return !set.isEmpty();
    }

    private boolean hasDuplicate(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i)))
                return true;
            else {
                set.add(s.charAt(i));
            }
        }

        return false;
    }

}
