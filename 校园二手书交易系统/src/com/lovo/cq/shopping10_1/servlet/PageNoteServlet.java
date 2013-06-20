package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.daoimpl.NoMessageException;
import com.lovo.cq.shopping10_1.daoimpl.NoRelativeBooksException;
import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.Page;

public class PageNoteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageSize = 4; //ÿҳ��ʾ��������
		int pageNo = 0;//��ǰҳ��
		
		String str_pageroffset = request.getParameter("pager.offset");
		System.out.println("str_pageroffset="+str_pageroffset);
		if(str_pageroffset != null){
			pageNo = Integer.parseInt(str_pageroffset);
		}
		Model model = new Model();
		try{
		Page page = model.doNotePage(pageNo, pageSize);
		request.setAttribute("page", page);
		request.getRequestDispatcher("showNoteServlet").forward(request, response);
		}catch(NoMessageException e){
			request.setAttribute("NoMessageException",e.getMessage());
			request.getRequestDispatcher("note.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
