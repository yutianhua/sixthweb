<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'userManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		table{
			text-align: center;
		}
	</style>
  </head>
  
  <body>
  	��ǰ�û���
  	<font color="red">
  	<c:out value="${user.name}"></c:out>
  	</font>&nbsp;
    <c:choose>
    	<c:when test="${empty userList}">
    		<h1><font color="red">û��ע���û�</font></h1>
    	</c:when>
    	<c:otherwise>
			<table border="1" bordercolor="maroon" align="center">
				<thead><h3>�û�����</h3></thead>
				<tr>
					<th>���</th>
					<th>�û���</th>
					<th>ɾ������</th>
				</tr>
				<c:forEach var="user" items="${page.pageList}">
    				<tr>
    					<td>${user.id}</td>
    					<td>${user.name}</td>
    					<td><a href="delete?id=${user.id}">ɾ��</a></td>
    				</tr>	
    			</c:forEach>
			</table>
    	</c:otherwise>
    </c:choose>
    <pg:pager items="${page.totalNum}" url="page" maxPageItems="3">
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
  </body>
</html>
