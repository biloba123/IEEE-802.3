package com.lvqingyang.ieee_8023;

/**
 * 一句话功能描述
 * 功能详细描述
 *
 * @author Lv Qingyang
 * @date 2018/5/25
 * @email biloba12345@gamil.com
 * @github https://github.com/biloba123
 * @blog https://biloba123.github.io/
 * @see
 * @since
 */
class Utils {
    /**
     * 将ascci字符串转换为二进制字符串
     * @param s ascci字符串
     * @return 二进制字符串
     */
    public static String strToBinaryStr(String s){
        if(isStrEmpty(s)){
            return null;
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0, len=s.length(); i<len; i++){
            sb.append(completeStrWithZero(Integer.toBinaryString(s.charAt(i)), 8, false));
        }

        return sb.toString();
    }

    /**
     * 用0补全字符串
     * @param s 字符串
     * @param len 目标长度
     * @param isBehind 是否后补全
     * @return 补全后的字符串
     */
    public static String completeStrWithZero(String s, int len, boolean isBehind){
        int strLen=s.length();
        if(strLen>=len){
            return s;
        }

        StringBuilder sb=new StringBuilder(s);
        for(int i=strLen; i<len; i++){
            if (isBehind){
                sb.append('0');
            }else {
                sb.insert(0, '0');
            }
        }

        return sb.toString();
    }

    public static boolean isStrEmpty(String s){
        return s==null || s.length()<1;
    }
}
