package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.UserPager;

public class GetUserPagerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从第几条记录开始查询
		String pagerOffset = request.getParameter("pager.offset");
		//查询多少条数据
		String pageSize_str = request.getParameter("pageSize");
		int offset = 0;
		int pagecurrentPageNo = 1;
		int pageSize = 5;
		if(pagerOffset != null && pageSize_str != null) {
			offset = Integer.parseInt(pagerOffset);
			pageSize = Integer.parseInt(pageSize_str);
		}
		Model model = new Model();
		UserPager up = model.getUserPager(offset, pageSize);
		if(up.getUserMap().size() == 0 && offset != 0) {
			offset -=pageSize;
			up = model.getUserPager(offset, pageSize);
		}
		if(offset%pageSize == 0 || offset/pageSize >0) {
			pagecurrentPageNo = offset/pageSize + 1;
		}
		up.setPageOffset(offset);
		up.setPagecurrentPageNo(pagecurrentPageNo);
		request.getSession().setAttribute("userPager", up);
		request.getSession().setAttribute("userList", up.getUserMap().values());
		request.getRequestDispatcher("Admin/pages/manageUsers.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
