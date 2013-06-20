package com.lovo.cq.shopping10_1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ShoppingFilter implements Filter {

	//�������ĳ�ʼ��
	public void init(FilterConfig config) throws ServletException {
	
	}
	//ִ�й�����
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//���봦��
		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("gb2312");
		
		chain.doFilter(request, response);
		
	}
	//������������
	public void destroy() {
		
	}



}
