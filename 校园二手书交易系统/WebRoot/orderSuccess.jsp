<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@include file="common.jsp" %>
<%@include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>���׳ɹ�</title>
<link rel="stylesheet" type="text/css" href="style.css" />

</head>
<body>
<div id="wrap">
		
		<%@include file="header.jsp" %>
       <div class="center_content">
       	<div class="left_content">
       	<pre>
        	���׳ɹ�
       	     ������ˮ��Ϊ��<font color="red">1986${order.orderId}0712</font>	
       	     �ջ��ˣ�<font color="red">${order.recvName}</font>
              �ջ���ַ��<font color="red">${user.address }</font>
             �������룺 <font color="red">${user.postcode }</font>
             email:<font color="red">${user.email}</font>
       	     ��ϵ�绰��<font color="red">${user.phone }</font>
       	     �ֻ���<font color="red">${user.mphone }</font>
       	 <%
       	 	out.print("5���ҳ�潫�Զ���ת����ҳ....");
       	 	response.setHeader("refresh","5;url='index.jsp'");
       	  %>
       	 </pre>
 		</div><!--end of left content-->
        <%@include file="right.jsp" %> 
       <!--end of right content-->
   
       <div class="clear"></div>
       </div><!--end of center content-->
       
       <%@include file="footer.jsp"%>
</div>

</body>
</html>