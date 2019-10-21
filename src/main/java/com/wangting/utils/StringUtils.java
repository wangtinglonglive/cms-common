package com.wangting.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	
	



	public static void main(String[] args) {
		
		
		
		String percentage = toPercentage(1,3);
		System.out.println("百分比"+percentage);
	}
	
	
	/*
	* 百分比计算方法，返回值只要整数不需要小数。
	* 给一个当前数，和一个总数，计算当前数百分占比，例如参数为5和10，方法内部
	* 5除以10得0.5，再乘以100，返回50，注意四舍五入。页面就可以显示50%
	*/
	public static String toPercentage(Integer a,Integer count) {
		double b = (double)a/count;
		
		System.out.println(b);
		b = b*100;
		
		System.out.println(b);
		String format = String.format("%.0f", b);
		System.out.println(format);
		
		return format;
	}
	
	
	
	
	/**
	 * 
	 */
	public static char cs[] = new char[36] ;
	
	static {
		int index=0;
		for (char i = 'a'; i <='z' ; i++) {
			cs[(int)index ++]=i;
		}
		
		for (char i = '0'; i <='9' ; i++) {
			cs[(int)index ++]=i;
		}
		
	}
	
	
	
	
	
	
	
	
	/**
	 * 鍒ゆ柇婧愬瓧绗︿覆鏄惁涓虹┖锛岀┖寮曞彿涔熺畻娌″�硷紱
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		
		//return (str==null|| "".equals(str.trim()));
		return (str==null || 0== str.trim().length());
	}
	
	/**
	 * 鍒ゆ柇婧愬瓧绗︿覆鏄惁鏈夊�硷紝绌哄紩鍙蜂篃绠楁病鍊硷紱
	 * @param str
	 * @return
	 */
	public static boolean hasText(String str) {
		//return !(str==null || 0== str.trim().length());
		return str!=null && 0 < str.trim().length();   
	
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static String randomChar(int n) {
		Random random = new Random();
		String str = "";
		for (int i = 0; i < n; i++) {
			 char c = (char)('a' + 	random.nextInt(26));// a - z
			str += c;
		}
		return str;
		
	}
	
	/**
	 * 闅忔満鐢熸垚闀垮害涓簄鐨勫瓧绗︿覆锛屽叾涓寘鍚瓧姣嶅拰鏁板瓧
	 * @param n
	 * @return
	 */
	public static String randomCharAndNumber(int n) {
		
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			sb.append(cs[random.nextInt(36)]);
		}
		return sb.toString();
		
	}
	
	/**
	 * 鑾峰彇涓�涓枃浠跺悕绉扮殑鎵╁睍鍚�
	 * 渚嬪锛� mytest/mynewFile.txt return .txt
	 * @param fileName
	 * @return
	 */
	public static String getFileSuffix(String fileName) {
		
		//return ".txt";
		int dotIndex = fileName.lastIndexOf('.');
		if(dotIndex==-1)
			return "";
		
		return fileName.substring(fileName.lastIndexOf('.'));
		
	}
	
	/**
	 * 鍒ゆ柇鏄惁涓烘暟瀛楋紙涓嶅寘鍚皬鏁帮級
	 * @param str
	 * @return
	 */
	public static boolean isNumberandxaio(String str) {
		
		String reg = "[0-9]+";
		return str.matches(reg);
	}
	
	
	
	/**
	 * 鍒ゆ柇鏄惁涓烘暟瀛�
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		
		String reg = "([1-9]+[0-9]*|0)(\\.[\\d]+)?";
		return str.matches(reg);
	}
	/**
	 * 楠岃瘉浠ｇ爜
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		String reg = "^[0-9a-zA-Z]+@[0-9a-zA-Z]+\\.[a-z]{2,3}";
		return str.matches(reg);
		
	}
	
	public static boolean isEmail2(String str) {
		
		String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"; 
        Pattern p = Pattern.compile(regEx1);
        Matcher m = p.matcher(str);
        return m.find();

	}
	
	/**
	 * 鏍￠獙涓�涓瓧绗︿覆鏄惁涓烘纭殑鐢佃瘽鍙风爜
	 * @param mobile
	 * @return
	 */
	public  static boolean isMobile(String mobile) {
		
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobile);
		boolean isMatch = m.matches();
		return isMatch;
	}
	
	/**
	 * (1)鍒╃敤Html鐨�<p>鏍囩鏉ヤ繚鐣欐枃鏈殑鎹㈣銆�
(2)Windows绯荤粺鎹㈣绗︽槸鈥淺r\n鈥�,Linux绯荤粺鏄�淺n鈥濓紝鍥犳瑕佸皢\n\r鏇挎崲鎴愪竴涓猏n銆�
(3)鍐嶅皢\n缁撳熬鐨勮繖琛屾枃鏈敤<p></p>鏍囩鍖呰捣鏉ャ�� 寮犱笁\n鏉庡洓      <p>寮犱笁</p><p>鏉庡洓</p>
(4)濡傛灉閬囧埌鍗曚釜\r瀛楃瑕佷娇鐢�<br/>鏍囩鏇挎崲銆�
	 * @param src
	 * @return
	 */
	public static String toHtml(String src) {
		//Windows绯荤粺鎹㈣绗︽槸鈥淺r\n鈥�,Linux绯荤粺鏄�淺n鈥濓紝鍥犳瑕佸皢\n\r鏇挎崲鎴愪竴涓猏n銆�
		String dst = src.replaceAll("\r\n", "\n");
		
		//鍐嶅皢\n缁撳熬鐨勮繖琛屾枃鏈敤<p></p>鏍囩鍖呰捣鏉ャ�� 寮犱笁\n鏉庡洓      <p>寮犱笁</p><p>鏉庡洓</p>
		dst=dst.replaceAll("\n", "</p><p>");
		dst="<p>" + dst + "</p>";
		//濡傛灉閬囧埌鍗曚釜\r瀛楃瑕佷娇鐢�<br/>鏍囩鏇挎崲銆�
		dst=dst.replaceAll("\r", "<br/>");
		return dst;
	}
	
	
	
	
	
	
}
