package com.wangting.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	

	
	/**
	 * 是否有值
	判断源字符串是否有值，空引号和空格也算没值
	 * @param str
	 * @return
	 */
	public static boolean hasText1(String str) {
		
		// 以下两种写法都对
		//return !(null ==str || "".equals(str.trim()));
		return (null !=str && !"".equals(str.trim()));
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str) {
		String pattern = "^(136|135|137)\\d{8}$";
		return str.matches(pattern);
	}


	/**
	 * 验证全为字母
	 * @param str
	 * @return
	 */
	public static boolean isLetter(String str) {
		String pattern = "^[a-zA-Z]+$";
		return str.matches(pattern);
	}
	
	/**
	 * 
	 * 获取n位随机英文字符串
	 * @param n
	 * @return
	 */
	public String randomLetterStr(int n) {
		
		if(n<=0)
			return "";
		Random random = new Random();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			char letter = (char)('A' + random.nextInt(26));
			sb.append(letter);
		}		
		return sb.toString();
	}

	
	
	
	/*方法功能：将字符串转换成html文本，如果遇到“\n”换行换符，则要将这一段文本使用<p></p>标签
	 * @ContextConfiguration("classpath:spring.xml")
	*@RunWith(SpringRunner.class)
	* 包起来。如果遇到“\n\r”两个在一起按上面\n处理。如果只遇到一个“\r”则替换成<br/>标签。
	* 使用场景：网页文本框传到后台的字符串就可能就会回车换行。*/
	public static String toHtml1(String src){
		String[] strings = src.split("\\\n");
		StringBuilder sb = new StringBuilder();
		for (String string : strings) {
			sb.append("<p>").append(string).append("</p>");
		}
		return sb.toString();
	}
	
	
	
	
	



	public static void main(String[] args) {
		
		
		
		String percentage = toPercentage(1,3);
		System.out.println("百分比"+percentage);
	}
	
	public static boolean isUrl(String str) {
		 //转换为小写
       str = str.toLowerCase();
       String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https、http、ftp、rtsp、mms
               + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
              + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184  
                + "|" // 允许IP和DOMAIN（域名）
                + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
                + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
               + "[a-z]{2,6})" // first level domain- .com or .museum  
               + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
               + "((/?)|" // a slash isn't required if there is no file name  
               + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
       return  str.matches(regex);
	}
	
	
	

	/*
	* 方法：生成唯一标签名，处理步骤：
	* 1、全部变成小写；
	* 2、清空两边的空格，把中间所有的空格替换成“-”；
	* 3、使用URLEncoder.encode()编码
	* 最后返回处理的结果。
	* 举例“Spring MVC”处理后为“spring-mvc”，“Spring Mvc”处理后也为“spring-mvc”
	*/
	public static String toUniqueTerm(String term) throws UnsupportedEncodingException{
	//TODO 实现代码
		term=term.toLowerCase();
		term=term.trim();
		term = term.replaceAll(" ", "-");
		return URLEncoder.encode(term,"UTF-8");
		
	}
	
	/*
	* 方法功能：根据正则在字符串提取一段值，用于后面在url地址里提取ID值。
	* 例如在“http://news.cnstock.com/news,yw-201908-4413224.htm”把“4413224”提取出来。
	*/
	public static String getPlaceholderValue(String src, String regex){
		//TODO 实现代码
        Pattern pattern = Pattern.compile(regex);// 匹配的模式  
        Matcher m = pattern.matcher(src);  
        boolean find = m.find();
        if(find) {
        	String group = m.group(0);
        	 return group.substring(1,group.lastIndexOf('.'));
        }
        return "";
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
	 * 获取n位随机英文和数字字符串
	 * @param n
	 * @return
	 */
	public String randomStr(int n) {
		
		char chars[]= {'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N'};
		
		// 定义个随机对象
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			// 随机得到一个下标，根据下标从数组当中获取值，拼接到字符串上
			
			// 随机获取一个下标
			int index = random.nextInt(chars.length);
			char c = chars[index];
			sb.append(c);//向后拼接
			
			/*sb.append( chars[random.nextInt(chars.length)]
					);*/
			
		}
		return sb.toString();
		
	}
	


	//获取n个随机中文字符串
	public static String getRandonCnStr(int n) {
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(getOneCn());
		}
		return sb.toString();
		
	} 
	
	
	/**
	 * 随机获取一个中文字符
	 * @return
	 */
	private static String getOneCn(){
		
		String str = "";
        int hightPos; //
        int lowPos;
        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("错误");
        }

        return str;
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
	/*	public static boolean hasText(String str) {
		//return !(str==null || 0== str.trim().length());
		return str!=null && 0 < str.trim().length();   
	
	}*/
	/**
	 * 测试工具包中hasText()，该方法是过滤String参数空格后判断是否有值，
	 * 如果你有该功能方法，但不是这个方法名不扣分。如果没有该方法，必须现在编写该方法
	 * @param src
	 * @return
	 */
	public static boolean hasText(String src) {
		String string = src.replaceAll("\\s", "");
		return (!"".equals(string));
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
	 * 检测含有\n\r 转换成\n
	 * \r 转换<br>
	 * @param str
	 * @return
	 */
	public static String toHtml(String str) {
		String replaceAll = str.replaceAll("\\\n\r", "\n");
		String replaceAll2 = replaceAll.replaceAll("\\\r", "<br/>");
		/* System.out.println(replaceAll2); */
		String[] split = replaceAll2.split("\\\n");
		StringBuilder sb = new StringBuilder();
		for (String string : split) {
			sb.append("<p>").append(string).append("</p>\n");
		}
		return sb.toString();	
	}
	
	/**
	 * (1)鍒╃敤Html鐨�<p>鏍囩鏉ヤ繚鐣欐枃鏈殑鎹㈣銆�
(2)Windows绯荤粺鎹㈣绗︽槸鈥淺r\n鈥�,Linux绯荤粺鏄�淺n鈥濓紝鍥犳瑕佸皢\n\r鏇挎崲鎴愪竴涓猏n銆�
(3)鍐嶅皢\n缁撳熬鐨勮繖琛屾枃鏈敤<p></p>鏍囩鍖呰捣鏉ャ�� 寮犱笁\n鏉庡洓      <p>寮犱笁</p><p>鏉庡洓</p>
(4)濡傛灉閬囧埌鍗曚釜\r瀛楃瑕佷娇鐢�<br/>鏍囩鏇挎崲銆�
	 * @param src
	 * @return
	 */
	/*public static String toHtml(String src) {
		//Windows绯荤粺鎹㈣绗︽槸鈥淺r\n鈥�,Linux绯荤粺鏄�淺n鈥濓紝鍥犳瑕佸皢\n\r鏇挎崲鎴愪竴涓猏n銆�
		String dst = src.replaceAll("\r\n", "\n");
		
		//鍐嶅皢\n缁撳熬鐨勮繖琛屾枃鏈敤<p></p>鏍囩鍖呰捣鏉ャ�� 寮犱笁\n鏉庡洓      <p>寮犱笁</p><p>鏉庡洓</p>
		dst=dst.replaceAll("\n", "</p><p>");
		dst="<p>" + dst + "</p>";
		//濡傛灉閬囧埌鍗曚釜\r瀛楃瑕佷娇鐢�<br/>鏍囩鏇挎崲銆�
		dst=dst.replaceAll("\r", "<br/>");
		return dst;
	}
	*/
	
	
	
	
	
}
