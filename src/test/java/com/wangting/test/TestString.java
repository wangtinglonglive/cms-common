package com.wangting.test;

import org.junit.Test;

import com.wangting.utils.StringUtils;
public class TestString {
	
	@Test
	public  void testtoHtml() {
		String src =" ����\r\n����\r����";
		String html = StringUtils.toHtml(src);
		System.out.println("html is " + html);
	}
	
	@Test
	public  void testisPhone() {
		String mobile ="13014511111";
		 StringUtils.isMobile(mobile);
		System.out.println(StringUtils.isMobile(mobile));
	}
}
