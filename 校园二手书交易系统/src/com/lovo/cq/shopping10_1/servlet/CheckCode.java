package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckCode extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");//Ҫ��XML���ҲҪ��ΪUTF-8���ܲ�������
		response.setContentType("text/xml;carset=UTF-8");
	      PrintWriter out = response.getWriter();
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
        String  ranCode  = (String) session.getAttribute("randomCode");
        out.print("<body>");
		if(code.equals(ranCode)){
    	   out.print("<text>"+"��"+"</text>");
		}else{
	       out.print("<text>"+"��֤�����"+"</text>");
		}
       out.print("</body>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doGet(request, response);
	}

}
