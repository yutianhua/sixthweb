package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.Note;

public class AddNoteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = (String)request.getAttribute("title");
		String content = (String)request.getAttribute("content");
		String author = (String)request.getAttribute("author");
		String pic = (String)request.getAttribute("pic");
		System.out.println("title="+title+" content="+content+"pic="+pic);
		Note note = new Note();
		note.setTitle(title);
		note.setAuthor(author);
		note.setContent(content);
		note.setImgs(pic);
		Model model = new Model();
		if(model.addNote(note)){
			//���Գɹ�
			String message2 = "�������Գɹ���";
			request.setAttribute("message2", message2);
			request.getRequestDispatcher("pageNoteServlet").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
