package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.User;

public class OneUserManameServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("gb2312");
		request.setCharacterEncoding("gb2312");
		
		HttpSession session = request.getSession();
		String name = (String)session .getAttribute("name");//���Ҫ��
	
		
		if(name!=null){
			Model model = new Model();
		  // User user =  model.SelectUser(name);
			//System.out.println("abcd");
	    response.sendRedirect("onePage.jsp");
	    
		}else{//�����ص���¼ҳ���ȵ�¼
	     request.setAttribute("pleseLoggin", "���ȵ�¼");
	     request.getRequestDispatcher("index.jsp").forward(request, response);	
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doGet(request, response);
	}

}
