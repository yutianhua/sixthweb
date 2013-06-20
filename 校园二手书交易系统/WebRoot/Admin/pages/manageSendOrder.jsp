<%@ page language="java" pageEncoding="GB18030"%>
<%@ include file="tools.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��������</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="Admin/css/body.css">
	<link rel="stylesheet" type="text/css" href="Admin/css/td_fontSize.css">
	<link rel="stylesheet" type="text/css" href="Admin/css/tab.css">
	<style type="text/css"> 
		table {
			text-align: center;
			margin: 0px;
			padding: 0px;
		}
	</style>
	<script type="text/javascript">
		function selectAll() {
			var deletes =document.getElementsByName("delete");
			var selectAll = document.getElementById("selectAll");
			for(var i = 0;i<deletes.length;i++) {
				if(selectAll.checked == true) {
				 	deletes[i].checked = true;
				}
				else {
					deletes[i].checked = false;
				}
			}
		}
		
		function removeOrder(pageOffset,pageSize) {
			var deletes = document.getElementsByName("delete");
			var count = 0;
			var orders = new Array();
			for(var i = 0;i<deletes.length;i++) {
				if(deletes[i].checked) {
					count++;
					orders.push(deletes[i].value);
				}
			}
			if(count == 0) {
				alert("��û��ѡ�ж�����");
				return false;
			}
			var oform = document.getElementsByTagName("form")[0];
			oform.action = "deleteOrderServlet?orderIds="+orders+"&pageOffset="+pageOffset+"&pageSize="+pageSize;
			oform.submit();
		}
		function freezeOrder(pageOffset,pageSize) {
			var deletes = document.getElementsByName("delete");
			var count = 0;
			var orders = new Array();
			for(var i = 0;i<deletes.length;i++) {
				if(deletes[i].checked) {
					count++;
					orders.push(deletes[i].value);
				}
			}
			if(count == 0) {
				alert("��û��ѡ�ж�����");
				return false;
			}
			var oform = document.getElementsByTagName("form")[0];
			oform.action = "freezeOrderServlet?orderIds="+orders+"&pageOffset="+pageOffset+"&pageSize="+pageSize;
			oform.submit();
		}
	</script>
  </head>
  
  <body> 
  
  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="Admin/images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="Admin/images/tab_05.gif">&nbsp;</td>
        <td width="281" background="Admin/images/tab_05.gif"><table border="0" align="right" cellpadding="0" cellspacing="0">
            <tr>
              <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"></div></td>
                    <td class="STYLE1"><div align="center"></div></td>
                  </tr>
              </table></td>
              <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><br></div></td>
                    <td class="STYLE1"></td>
                  </tr>
              </table></td>
              <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><br></div></td>
                    <td class="STYLE1"><div align="center"><br></div></td>
                  </tr>
              </table></td>
              <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><br></div></td>
                    <td class="STYLE1"><div align="center"><br></div></td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
        <td width="14"><img src="Admin/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="Admin/images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
  
  
    	<table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98">
    	<tr>
    		<th background="Admin/images/tab_14.gif">����ID</th>
    		<th background="Admin/images/tab_14.gif">�û���</th>
    		<th background="Admin/images/tab_14.gif">��ʵ��</th>
    		<th background="Admin/images/tab_14.gif">��ַ</th>
    		<th background="Admin/images/tab_14.gif">�ʱ�</th>
    		<th background="Admin/images/tab_14.gif">Email</th>
    		<th background="Admin/images/tab_14.gif">ʱ��</th>
    		<th background="Admin/images/tab_14.gif">״̬</th>
    		<td background="Admin/images/tab_14.gif"><input type="checkbox" id="selectAll" onclick="selectAll()">ȫ/��ѡ</td>
    		<th background="Admin/images/tab_14.gif"></th>
    	</tr>
    	<form method="post" name="sendForm">
    	<c:forEach var="order" items="${ orderList}">
    		<tr>
    			<td bgcolor="#FFFFFF" class="STYLE2">${order.orderId }</td>
    			<td bgcolor="#FFFFFF" class="STYLE2">${order.user.name }</td>
    			<td bgcolor="#FFFFFF" class="STYLE2">${order.recvName }</td>
    			<td bgcolor="#FFFFFF" class="STYLE2">${order.user.address }</td>
    			<td bgcolor="#FFFFFF" class="STYLE2">${order.user.postcode}</td>
    			<td bgcolor="#FFFFFF" class="STYLE2">${order.user.email}</td>
    			<td bgcolor="#FFFFFF" class="STYLE2" width="100px">${order.orderDate }</td>
    			<td bgcolor="#FFFFFF" class="STYLE2">${order.flag }</td>
    			<td bgcolor="#FFFFFF" class="STYLE2"><input type="checkbox" name="delete" value="${order.orderId }"></td>
    			<td bgcolor="#FFFFFF" class="STYLE2"><a href="getOneOrderServlet?orderId=${order.orderId}">����</a></td>
    		</tr>
    	</c:forEach>
    	</form>
    </table>
    
    
    </td>
        <td width="9" background="Admin/images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
<td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="Admin/images/tab_20.gif" width="15" height="29" /></td>
        <td background="Admin/images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
           <td>
    			 <pg:pager items="${orderPager.totalNum }" maxPageItems="${orderPager.pageSize}" export="currentPageNo = pageNumber" url="getOrderSendPagerServlet">
			         <pg:param name="pageSize" value="${orderPager.pageSize }"/>
			         <pg:param name="pageNo" value="${currentPageNo}"/> 
			         <pg:first>
			            <a href="${pageUrl}"><img src="Admin/images/first.gif" border="0"></a>
			         </pg:first>
			         <pg:prev>
			            <a href="${pageUrl}"><img src="Admin/images/back.gif" border="0" /></a>
			         </pg:prev>
			         <pg:pages>
				         <c:choose>
				            <c:when test="${orderPager.pagecurrentPageNo eq pageNumber}">
				              <font color="red">${pageNumber}</font>
				            </c:when>
				            <c:otherwise>
				            <a href="${pageUrl}">${pageNumber}</a>
				            </c:otherwise>
				         </c:choose>
			         </pg:pages>
			         <pg:next>
			            <a href="${pageUrl}"><img src="Admin/images/next.gif" border="0"/></a>
			         </pg:next>
			         <pg:last>
			            <a href="${pageUrl}"><img src="Admin/images/last.gif" border="0"/></a>
			         </pg:last>
			      </pg:pager>
    		</td>
    		<td colspan="1" align="right">
    		<input type="button" value="����" onclick="freezeOrder(${orderPager.pageOffset},${orderPager.pageSize})">
    		</td>
    		<td colspan="1" align="center">
    		<input type="button" value="ɾ��" onclick="removeOrder(${orderPager.pageOffset},${orderPager.pageSize})">
    		</td>
        <td width="14"><img src="Admin/images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</td>
</tr>
</table>
  </body>
</html>
