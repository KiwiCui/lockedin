package com.in.locked.barry;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode242 {
    public static boolean isAnagram(String a, String b){

        if(a.length() != b.length()){
            return false;
        }

        List<String> aList = stringToList(a);
        List<String> bList = stringToList(b);
        for(String s1 : aList){
            if(bList.contains(s1)){
                bList.remove(s1);
            }
        }

        if(bList.size() == 0) {
            return true;
        }else{
            return false;
        }
    }

    public static List<String> stringToList(String str){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++){
            result.add(str.substring(i, i+1));
        }
        return result;
    }


    public static boolean isAnagram01(String a, String b){
        if (a.length() != b.length()){
            return false;
        }

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        Arrays.sort(aChars);
        Arrays.sort(bChars);

        return Arrays.equals(aChars, bChars);
    }

    public static void main(String[] args){
        long begin = System.currentTimeMillis();
        System.out.println(isAnagram("accc", "acca"));
        System.out.println(isAnagram("abcddffffffffffddddeeabcddffffffffffddddee", "abcddffffffffffddddeedbcddfeefffffffffddda"));
        System.out.println(isAnagram("勃羽大官人", "大官人勃羽"));
        System.out.println(isAnagram("？？？！！！", "？！？！？！"));
        long end = System.currentTimeMillis();
        System.out.println("isAnagram : " + (end - begin));

        long begin1 = System.currentTimeMillis();
        System.out.println(isAnagram01("accc", "acca"));
        System.out.println(isAnagram01("abcddffffffffffddddabcddffffffffffddddee", "abcddffffffffffddddeedbcddffffffffffddda"));
        System.out.println(isAnagram01("勃羽大官人", "大官人勃羽"));
        System.out.println(isAnagram01("？？？！！！", "？！？！？！"));
        long end1 = System.currentTimeMillis();
        System.out.println("isAnagram01 : " + (end1- begin1));
    }
}
