<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>������Ϣ��������</title>
    
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
          <div id="archive">
          	 <table>
        <tr>
         <td>���֣�</td>
         <td>${user.score}</td>
       </tr>
       <tr> 
           <td>�û�����</td>
            <td>${user.name}</td>
       </tr>
       <tr> 
           <td>E-mail��</td>
           <td>${user.email}</td>
       </tr>
       <tr> 
           <td>�� ����</td>
           <td>${user.trueName}</td>
       </tr>
         <tr> 
           <td>�� ��</td>
            <td>${user.sex}</td>
       </tr>
         <tr> 
           <td>�� �գ�</td>
            <td>${user.birthday}</td>
       </tr>
         <tr> 
           <td>�� ַ��</td>
            <td>${user.address}</td>
       </tr>
       <tr> 
           <td>�� �ࣺ</td>
           <td>${user.postcode}</td>
       </tr>
       <tr> 
           <td>�� ����</td>
           <td>${user.phone}</td>
       </tr>
         <tr> 
           <td>�� ����</td>
            <td>${user.mphone}</td>
       </tr>
       <tr>
         <td>��ȫ����:</td>
         <td>${user.question}</td>
       </tr>
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
