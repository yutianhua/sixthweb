package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.SuperType;

public class AddSuperTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=utf-8");
		String superTypeName = request.getParameter("superTypeName");
		System.out.println(superTypeName);
		if(superTypeName != null) {
			
			Model model = new Model();
			SuperType superType = new SuperType();
			superType.setTypeName(superTypeName);
			if(model.addSuperType(superType)) {
				request.setAttribute("message", "��ӳɹ�");
			} else {
				request.setAttribute("message", "���ʧ��");
			}
			request.getRequestDispatcher("Admin/pages/addSuperType.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
