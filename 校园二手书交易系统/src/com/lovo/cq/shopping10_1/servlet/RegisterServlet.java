package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.User;


public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ�������봦��
		request.setCharacterEncoding("gb2312");
		//��ȡ�ͻ��˷��͹�������Ϣ
		String name = request.getParameter("name");
		String password=request.getParameter("password");
		String email = request.getParameter("email");
		String trueName=request.getParameter("trueName");
		String sex = request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String address = request.getParameter("address");
		String postcode = request.getParameter("postcode");
		String phone = request.getParameter("phone");
		String mphone = request.getParameter("mphone");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		System.out.println("name="+name);
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			user.setEmail(email);
			user.setTrueName(trueName);
			user.setSex(sex);
			user.setBirthday(birthday);
			user.setAddress(address);
			user.setPostcode(postcode);
			user.setPhone(phone);
			user.setMphone(mphone);
			user.setQuestion(question);
			user.setAnswer(answer);	
			Model model = new Model();
			if(model.addUser(user)){
				//ע��ɹ�
				request.getSession().setAttribute("user", user);
				response.sendRedirect("index.jsp");
			}else {
				//ע��ʧ��
				response.sendRedirect("errRegister.jsp");
			}	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
