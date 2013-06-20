<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@include file="common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>�û�����</title>
		<link rel="stylesheet" type="text/css" href="style.css" />
	</head>
	<body>
		<div id="wrap">
		
			<!-- the begin of header -->
			<%@include file="header.jsp"%>
			<!-- the end of header -->
			
			<!-- the begin of content -->
			<div class="center_content">
				<!-- the begin of left -->
				<div class="left_content">
					<font color="red">${user.trueName}&nbsp;</font> ��ӭ�㣡
					<div id="noteTitle" style="text-align: right"><img src="images/note.jpg" /></div>
					<div><font color="red">${message}${message2}</font></div>
					<div id="chooseDiv">
					<c:choose>
						<c:when test="${empty noteList}">
							<h1>
								<font color="red">${NoMessageException}</font>
							</h1>
						</c:when>
						<c:otherwise>
							<c:forEach var="note" items="${page.pageList}">
								<div class="feat_prod_box">
									<div>
										<div class="note_box">
											<div id="note_up">
												<div id="headImg" style="float: left;"><img src="${note.imgs}"/>�����ˣ�${note.author }</div>
												<div id="note_content">${note.content}</div>
											</div>
											<div id="note_down">
												<span id="notetitle">���Ա��⣺${note.title}</span>&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="ly_time">����ʱ�䣺${note.ly_time}<span/>
											</div>
											<div class="clear"></div>
										</div>
									</div>
								</div>	
							</c:forEach>
						</c:otherwise>
					</c:choose>
					</div>
					<div>������������${page.totalNum}�� </div>
					<div class="pagination">
						<span class="disabled"> 
						<pg:pager items="${page.totalNum}" url="pageNoteServlet" maxPageItems="4" maxIndexPages="5">
								<pg:first>
									<a href="${pageUrl}">��ҳ</a>
								</pg:first>
								<pg:prev>
									<a href="${pageUrl}">ǰҳ</a>
								</pg:prev>
								<pg:pages>
									<a href="${pageUrl}">${pageNumber}</a>
								</pg:pages>
								<pg:next>
									<a href="${pageUrl}">��ҳ</a>
								</pg:next>
								<pg:last>
									<a href="${pageUrl}">βҳ</a>
								</pg:last>
							</pg:pager> 
						</span>
					</div>
					<div class="clear"></div>
					<div id="messageDiv">
					<form action="checkLogin_Note" method="post" name="ly_form">
						<div style="text-align: center;color:#a53d17;">
		                    <label class="contact"><strong>���Ա���:</strong></label>
		                    <input type="text" name="ly_title"/>
	                    </div>
	                     <div style="text-align: center;color:#a53d17;margin-top:10px;">
	                     	<div>
		                    <label class="contact"><strong>��������:</strong></label>
		                    <textarea rows="5" cols="40" name="ly_content" class="contact_input"></textarea> 
	                   		 </div>
	                   		 <div id="face">
	                   		 	ѡ������ͷ��<input type="radio" name="pic" value="images/face/pic1.gif" checked="checked" /><img src="images/face/pic1.gif" />
	                   		 				<input type="radio" name="pic" value="images/face/pic2.gif" /><img src="images/face/pic2.gif" />
	                   		 				<input type="radio" name="pic" value="images/face/pic3.gif" /><img src="images/face/pic3.gif" /><br />
	                   		 				<input type="radio" name="pic" value="images/face/pic4.gif" /><img src="images/face/pic4.gif" />
	                   		 				<input type="radio" name="pic" value="images/face/pic5.gif" /><img src="images/face/pic5.gif" />
	                   		 				<input type="radio" name="pic" value="images/face/pic6.gif" /><img src="images/face/pic6.gif" />
	                   		 				<input type="radio" name="pic" value="images/face/pic7.gif" /><img src="images/face/pic7.gif" /><br />
	                   		 				<input type="radio" name="pic" value="images/face/pic8.gif" /><img src="images/face/pic8.gif" />
	                   		 </div>
	                   		 <div class="form_row">
                    			<input type="submit" class="register" value="��������" />
                   	   		 </div>   
	                    </div>
	                </form>
					</div><!-- end of messageDiv -->
				<div class="clear"></div>
				</div><!--end of left content-->
				<%@include file="right.jsp"%>
				<!--end of right content-->
				<div class="clear"></div>
			</div>
			<!--end of center content-->
			<%@include file="footer.jsp"%>
		</div>
	</body>
</html>
