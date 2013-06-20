<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@include file="common.jsp"%>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>�鼮����</title>
<link rel="stylesheet" type="text/css" href="style.css" />

</head>
<body>
<div id="wrap">&nbsp; 
 
      <%@include file="header.jsp" %>
       <div class="center_content">
       	<div class="left_content">
        	<div class="crumb_nav">
            <a href="index.jsp">��ҳ</a> &gt;&gt; �������
            </div>
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>��������鼮</div>
           <div class="new_products">
           	    <c:choose>
    			<c:when test="${empty page.pageList}">
    				<font color="red">${NoRelativeBooksException}</font>
    			</c:when>
    			<c:otherwise>
           		<c:forEach var="book" items="${page.pageList}">
                    <div class="new_prod_box">
                        <a href="showBookByIdServlet?bookId=${book.bookId}">${book.bookName }</a>
                        <div class="new_prod_bg">
                        <a href="showBookByIdServlet?bookId=${book.bookId}"><img src="${book.picture}" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>
                </c:forEach>
			</c:otherwise>
		</c:choose>
		 <div class="pagination">
            <span class="disabled">
     <pg:pager items="${page.totalNum}" url="pageSearchServlet" maxPageItems="6" maxIndexPages="5">
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
     </div> 
          
            
        <div class="clear"></div>
        </div><!--end of left content-->
         <%@include file="right.jsp" %>
        <!--end of right content-->
        
        
       
       
       <div class="clear"></div>
       </div><!--end of center content-->
        <%@include file="footer.jsp" %> 
                
</body>
</html>