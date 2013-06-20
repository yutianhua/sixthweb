<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@include file="common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'PwdIndex.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style.css">
	<script type="text/javascript">
	//����û����Ƿ�Ϸ�,ֻ����Ӣ����ĸ�����ֺ��»�����ɣ��ҿ�ͷ����Ϊ����
	function checkName(){
		var name = document.getElementById("name");
		var checkName = document.getElementById("checkName");
		var patrn=/^[a-zA-Z_]{1}\w{5,16}$/; 
		if (!patrn.exec(name.value)){
			 checkName.style.color="red";
			 checkName.innerHTML="�û�����������!";
			 return false;
		}else{	
			 checkName.style.color="green";
			 checkName.innerHTML="�� ������ȷ";
			 document.f1.submit();
			 return true;
		}
	}
			//����û����Ƿ����
	var req;
	function checkNE(){
		var name = document.getElementById("name");
		if(checkName()){
			if(window.XMLHttpRequest){
				req = new XMLHttpRequest();
			}else if(window.ActiveXObject){
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
			//���ûص�����
			req.onreadystatechange = callbackForName;
			var url = "checkNameExist?name="+name.value;
			req.open("get",url,true);
			req.send(null);
			return true;
		}else{
			return false;
		}
		
	}
	function callbackForName(){
		var state = req.readyState;
		if(state==4){
			var doms = req.responseXML;
			var user = doms.getElementsByTagName("user");
			if(user[0].getElementsByTagName("name")[0].firstChild.data=="exist"){//�û����Ѿ�����
				window.open("findAnswer.jsp","fail","width=180,height=120,left=200,top=180");
			}else{
				window.open("notExist.jsp","success","width=180,height=120,left=200,top=180");
			}
		}
	}
	</script>
  </head>
  
  <body>
  	<div id="wrap">
		<%@include file="header.jsp" %>
       <div class="center_content">
       	<div class="left_content">
       		
       		<form action="findUser" method="get" name="f1">
       			<table>
       				<tr>
       					<td class="form_row"><strong> ����������ʺţ�<br /></strong></td>
       					<td class="form_row"><input type="text" id="name" name="name" class="contact_input" onblur="checkName()" /></td>
       				</tr>
       				<tr>
       					<td>&nbsp;</td>
       					<td id="checkName">&nbsp;</td>
       				</tr>
       				<tr>
       					<td>&nbsp;</td>
       					<td class="form_row"><input type="button" class="register" value="�ύ" onclick="checkNE()" /></td> 
       				</tr>
       			</table>  
		    </form>
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
