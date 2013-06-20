<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>���˶�����ѯ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="style.css">

  </head>
  
  <body>
  	
	<div id="wrap">		
		<%@include file="header.jsp" %>    
       <div class="center_content">
       	<div class="left_content">
       		<div class="crumb_nav">
           		 <a href="index.jsp">��ҳ</a> &gt;&gt; ������Ϣ��������
            </div>
            <div id="managerTop">
			<table width="450">
				  <tr>
				    <td height="40" colspan="4"><div align="center" class="STYLE2">������Ϣ��������</div></td>
				  </tr>
				  <tr>
				    <td width="140"><a href="updateUserAll">�޸����Ƹ�������</a></td>
				    <td width="70"><div align="center"><a href="updatePassword.jsp">�޸�����</a></div></td>
				    <td width="100"><div align="center"><a href="selectOrder">�鿴����</a></div></td>
				    <td width="115" height="30"><div align="center"><a href="index.jsp">������ҳ</a></div></td>
				  </tr>
			</table>
          </div>
          <div id="orderInfo">
     <table border="solid 1px;">
        <tr><td>����id</td>
	        <td>��ʵ����</td>
	        <td>��ϸסַ</td>
	        <td>�ʱ�</td> 
	        <td>����״̬</td>
	        <td>�鿴�Ӷ���</td>
	    </tr>
	    <c:forEach var="order" items="${list}">
	    	<tr>
			    <td>${order.orderId}</td>
		        <td>${order.recvName}</td>
		        <td>${order.user.address}</td>
		        <td>${order.user.postcode}</td> 
		        <td>${order.flag}</td>
		        <td><a href="son?id=${order.orderId}">�鿴</a></td>
	    	</tr>
	    </c:forEach>
	    
     </table>
          </div>
        <div class="clear"></div>
        </div><!--end of left content-->
         <%@include file="right.jsp" %>
         <!--end of right content-->
       <div class="clear"></div>
       </div><!--end of center content-->     
      <%@include file="footer.jsp" %> 
</div>
  </body>
</html>
