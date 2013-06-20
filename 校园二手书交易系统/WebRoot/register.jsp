<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>�û�ע��</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript">
	//����ͬ��Э���ſ�ע��
	function enable(){
		var terms = document.getElementById("terms");
		var register = document.getElementById("register");
		if(terms.checked){
			register.disabled=false;
		}else{
			register.disabled=true;
		}
	}
	//����û����Ƿ�Ϸ�,ֻ����Ӣ����ĸ�����ֺ��»�����ɣ��ҿ�ͷ����Ϊ����
	function checkName(){
		var name = document.getElementById("name");
		var pic = document.getElementById("pic");
		var checkName = document.getElementById("checkName");
		var patrn=/^[a-zA-Z_]{1}\w{5,16}$/; 
		if (!patrn.exec(name.value)){
			 checkName.style.color="red";
			 checkName.innerHTML="�û�����������!";
			 return false;
		}else{	
			 checkName.style.color="green";
			 checkName.innerHTML="�� ������ȷ";
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
				var name = document.getElementById("name");
				name.focus();
				window.open("exist.jsp","fail","width=180,height=120,left=200,top=180");
			}else{
				window.open("notExist.jsp","success","width=180,height=120,left=200,top=180");
			}
		}
	}
	//�������,ֻ����Ӣ����ĸ���������
	function checkPassword(){
		var password1 = document.getElementById("password1");
		var pwdRemind = document.getElementById("pwdRemind");
		var patrn=/^[a-z,A-Z,0-9]{6,15}$/;
		if (!patrn.exec(password1.value)){
			pwdRemind.style.color="red";
			pwdRemind.innerHTML="�����ʽ��������!";
			return false;
		}else{
			pwdRemind.style.color="green";
			pwdRemind.innerHTML="�� ������ȷ";
			return true;
		}
	}
	//ȷ������
	function checkPwd(){
		var password1 = document.getElementById("password1");
		var password2 = document.getElementById("password2");
		var checkPwd = document.getElementById("checkPwd");
		if(password1.value!=password2.value){
			checkPwd.style.color="red";
			checkPwd.innerHTML="�����������벻һ��!";
			return false;
		}else{
			checkPwd.style.color="green";
			checkPwd.innerHTML="������������һ��!";
			return true;
		}
	}
	//��֤�����ʽ
	function checkMail(){
		var email = document.getElementById("email");
		var patrn=/((\w)|[-]|[.])+@(((\w)|[-])+[.])+[a-z]{2,4}$/;
		var checkMail = document.getElementById("checkMail");
		if(!patrn.exec(email.value)){
			checkMail.style.color="red";
			checkMail.innerHTML="�����ʽ��������!";
			return false;
		}else{
			checkMail.style.color="green";
			checkMail.innerHTML="�� ����������ȷ!";
			return true;
		}
	}
	//У����������,��������λ���֣��ҵ�һλ����Ϊ0
	function isPostalCode()
	{
	var postCode = document.getElementById("postCode");
	var remindPostCode = document.getElementById("remindPostCode");
	var patrn=/^[1-9]{1}(\d){5}$/;
	if (!patrn.exec(postCode.value)){
		remindPostCode.style.color="red";
		remindPostCode.innerHTML="����������������";
		return false;
	}else{
		remindPostCode.style.color="green";
		remindPostCode.innerHTML="�� ������ȷ";
		return true
	}
	}
	//У��̶��绰����
	function checkPhone(){
		var phone = document.getElementById("phone");
		var checkPhone = document.getElementById("checkPhone");
		var patrn=/^[+]{0,1}\d{3,5}-?\d{5,9}$/;
		if (!patrn.exec(phone.value)){
			checkPhone.style.color="red";
			checkPhone.innerHTML="�绰��ʽ����ȷ";
			return false;
		}else{
			checkPhone.style.color="green";
			checkPhone.innerHTML="�� ������ȷ";
			return true;
		}
	}
	//У���ƶ��绰����
	function checkMPhone(){
		var phone = document.getElementById("mphone");
		var checkMphone = document.getElementById("checkMphone");
		var patrn=/^1[356]\d{9}|01[356]\d{9}$/;
		if (!patrn.exec(phone.value)){
			checkMphone.style.color="red";
			checkMphone.innerHTML="�ֻ���ʽ����ȷ";
			return false;
		}else{
			checkMphone.style.color="green";
			checkMphone.innerHTML="�� ������ȷ";
			return true;
		}
	}
	//�����֤���Ƿ���ȷ
	function checkCode(){
		var code = document.getElementById("code");
		var codeR = document.getElementById("codeR");
		if(code.value != null){
			if(window.XMLHttpRequest){
				req = new XMLHttpRequest();
			}else if(window.ActiveXObject){
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
			//���ûص�����
			req.onreadystatechange = callbackForCode;
			var url = "checkRandomCode?code="+code.value;
			req.open("get",url,true);
			req.send(null);
			return true;
		}else{
			codeR.style.color="red";
			codeR.innerHTML="��������֤��";
			return false;
		}
		
	}
	function callbackForCode(){
		var state = req.readyState;
		var codeR = document.getElementById("codeR");
		if(state==4){
			var doms = req.responseXML;
			var code = doms.getElementsByTagName("code");
			var message = code[0].getElementsByTagName("message")[0].firstChild.data;
			if(code[0].getElementsByTagName("message")[0].firstChild.data=="correct"){//��֤��������ȷ
				codeR.style.color="green";
				codeR.innerHTML="�� ������ȷ";
			}else{
				codeR.style.color="red";
				codeR.innerHTML="�������";
			}
		}
	}
	//����������Ϣ��д��ȷ���ܳɹ��ύ��Ϣ
	function checkAll(){
		document.register_form.submit();
	}
	//����û���������ʾ
	function clearRN(){
		var checkName = document.getElementById("checkName");
		checkName.style.color="black";
		checkName.innerHTML="Ӣ����ĸ���»���(6-15)�ַ����";
	}
	//���������֤������ʾ
	function clearPwd(){
		var checkPwd = document.getElementById("checkPwd");
		var pwdRemind = document.getElementById("pwdRemind");
		checkPwd.style.color="black";
		checkPwd.innerHTML="��Ӣ����ĸ������(6-15)�ַ����";
		pwdRemind.innerHTML="";
	}
	//������������ʾ
	function clearMail(){
		var checkMail = document.getElementById("checkMail");
		checkMail.style.color="black";
		checkMail.innerHTML="��������ȷ�������ַ";
	}
	//����������������ʾ
	function clearPostR(){
		var remindPostCode = document.getElementById("remindPostCode");
		remindPostCode.innerHTML="";
	}
	//����̶��绰������ʾ
	function clearPhoneR(){
		var checkPhone = document.getElementById("checkPhone");
		checkPhone.innerHTML="";
	}
	function clearMphoneR(){
		var checkMphone = document.getElementById("checkMphone");
		checkMphone.innerHTML="";
	}
	//ˢ����֤��
	function refreshCode(){
		var safeCode = document.getElementById("safeCode");
		safeCode.src = "code";
	}
</script>
</head>
<body>
<div id="wrap">		
		<%@include file="header.jsp" %>    
       <div class="center_content">
       	<div class="left_content">
       		<div class="crumb_nav">
           		 <a href="index.jsp">��ҳ</a> &gt;&gt; ע��
            </div>
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>ע���˺�</div>
        
        	<div class="feat_prod_box_details">
            <p class="details">
            </p>
              	<div class="contact_form">
                <div class="form_subtitle">�������˺�</div>
                 <form name="register_form" action="register" method="post">          
                    <table>
                    	<tr>
                    		<td class="label">�û���:</td>
                    		<td><input type="text" id="name" name="name" onblur="checkName()" onfocus="clearRN()"/></td>
                    		<td id="checkName" class="remind"><span style="color: red">*</span><span style="color:black">��Ӣ����ĸ�����ֻ��»���(6-16)�ַ����,�Ҳ��������ֿ�ͷ</span></td>
                    	</tr>
                    	<tr>
                    		<td>&nbsp;</td>
                    		<td><input type="button" value="����û����Ƿ����" id="checkNameExist" onclick="checkNE()" /></td>
                    		<td>&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">����:</td>
                    		<td><input type="password" id="password1" name="password" class="contact_input" onfocus="clearPwd()" onblur="checkPassword()" /></td>
                    		<td class="remind" id="pwdRemind"><span style="color: red">*</span><span style="color:black">��Ӣ����ĸ������(6-16)�ַ����</span></td>
                    	</tr>
                    	<tr>
                    		<td class="label">ȷ������:</td>
                    		<td> <input type="password" id="password2" name="password" class="contact_input" onblur="checkPwd()" /></td>
                    		<td id="checkPwd" class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">�����ʼ�:</td>
                    		<td><input type="text" id="email" name="email" class="contact_input" onblur="checkMail()" onfocus="clearMail()" /></td>
                    		<td id="checkMail" class="remind"><span style="color: red">*</span><span style="color:black">��������ȷ�������ַ����:<span style="color: aqua">lovo@gmail.cn</span></td>
                    	</tr>
                    	<tr>
                    		<td class="label">��ʵ����:</td>
                    		<td><input type="text" id="trueName" name="trueName" class="contact_input" /></td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">�Ա�:</td>
                    		<td>
                    			 <input type="radio" name="sex" value="��" checked="checked"/>��
                    			 <input type="radio" name="sex"  value="Ů" />Ů
                    		</td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">��������:</td>
                    		<td><input type="text" id="birthday" name="birthday" class="contact_input" /></td>
                    		<td class="remind" style="color: black">��ʽ�磺1986-07-12</td>
                    	</tr>
                    	<tr>
                    		<td class="label">��ַ:</td>
                    		<td><input type="text" id="address" name="address" class="contact_input" /></td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">��������:</td>
                    		<td><input type="text" id="postCode" name="postCode" class="contact_input" onblur="isPostalCode()" onfocus="clearPostR()" /></td>
                    		<td class="remind" id="remindPostCode">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">�̶��绰:</td>
                    		<td><input type="text" id="phone" name="phone" class="contact_input" onblur="checkPhone()" onfocus="clearPhoneR()" /></td>
                    		<td id="checkPhone" class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">�ƶ��绰:</td>
                    		<td><input type="text" id="mphone" name="mphone" class="contact_input" onblur="checkMPhone()" onfocus="clearMphoneR()" /></td>
                    		<td id="checkMphone" class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">����������ʾ:</td>
                    		<td>
                    			<select id="question" name="question" class="contact_input" style="width: 155px;">
                    				<option value="empty">--��ѡ����ʾ����--</option>
                    				<option value="������˵����ֽ�ʲô">������˵����ֽ�ʲô</option>
                    				<option value="����ϲ����ҵ�మ����ʲô">����ϲ����ҵ�మ����ʲô</option>
                    				<option value="�������������ʲôʱ��">�������������ʲôʱ��</option>
                    				<option value="����">����</option>
                    			</select>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">�����:</td>
                    		<td><input type="text" id="answer" name="answer" class="contact_input" /></td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td>��֤��:</td>
                    		<td><input type="text" id="code" name="code"  style="width: 50px;" onblur="checkCode()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="code" id="safeCode" onclick="refreshCode()" /></td>
                    		<td> <span id="codeR"></span></td>
                    	</tr>
                    	<tr>
                    		<td class="label">&nbsp;</td>
                    		<td class="terms"><input type="checkbox" id="terms" name="terms" onclick="enable()" />
                        ��ͬ��������� <a href="">����</a> </td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">&nbsp;</td>
                    		<td>&nbsp;</td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    		<tr>
                    		<td class="label">&nbsp;</td>
                    		<td>&nbsp;</td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    	<tr>
                    		<td class="label">&nbsp;</td>
                    		<td><input type="button" id="register" name="register" class="register" value="ע��" disabled="disabled" onclick="checkAll()" /></td>
                    		<td class="remind">&nbsp;</td>
                    	</tr>
                    </table> 
                  </form>     
                </div>           
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