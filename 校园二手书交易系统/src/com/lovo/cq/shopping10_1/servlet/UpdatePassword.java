package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.lovo.cq.shopping10_1.model.Model;


public class UpdatePassword extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2= request.getParameter("newPassword2");
		
		   HttpSession session =   request.getSession();
	       ServletContext context = session.getServletContext(); 
	       Model model = new Model();//�͵�¼��࣬��Ҫ���жϾ������Ƿ���ȷ
			Boolean fly = model.loggin(name, password);
		
		    	if(fly){//��������ȷ
		    		if(!newPassword1.equals(newPassword2)){
		    			request.setAttribute("passwordenrol", "�����������벻һ��");
						request.getRequestDispatcher("updatePassword.jsp").forward(request, response);
		    		}else{
		    			Boolean bo = model.updatePassword(name, password);
		    			if(bo){
		    				request.setAttribute("passwordOK", "�����޸ĳɹ�");
							request.getRequestDispatcher("updatePassword.jsp").forward(request, response);
		    			}
		    	   }
			    }else{
			    	request.setAttribute("passwordexception", "���������");
					request.getRequestDispatcher("Web/pages/updatePassword.jsp").forward(request, response);
			    }
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	        this.doGet(request, response);
	}

}
