package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.po.User;

public class CheckLogin_Note extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���봦��
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=gb2312");
		
		User user = (User)request.getSession().getAttribute("user");
		if(user!= null){
			//�Ѿ���¼������������
			String title = request.getParameter("ly_title");
			String content=request.getParameter("ly_content");
			String pic=request.getParameter("pic");
			request.setAttribute("title", title);
			request.setAttribute("content", content);
			request.setAttribute("author", user.getName());
			request.setAttribute("pic", pic);
			request.getRequestDispatcher("addNoteServlet").forward(request, response);
		}else {
			//��û�е�¼����ת����¼ҳ��
			String message = "���ȵ�¼�������ԣ���";
			request.setAttribute("message", message);
			request.getRequestDispatcher("note.jsp").forward(request, response);
			//response.sendRedirect("login.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
