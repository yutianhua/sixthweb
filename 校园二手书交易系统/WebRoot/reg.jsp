<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>free-css-templates-211</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript">
	function enable(){
		var terms = document.getElementById("terms");
		var register = document.getElementById("register");
		if(terms.checked){
			register.disabled=false;
		}
	}
	function checkName(){
		var patrn=/^[^`~!@#$%^&*()+-=|\\\[\]\{\}:;\'\,.<>/? 0-9]{2,19}$/; 
		if (!patrn.exec(s)){
			 
			 return false;
		}else{	 
			 return true;
		}
	}	
	function checkAll(){
		document.register_form.register.submit();
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
                    <div class="form_row">
                    <label class="contact"><strong>�û���:</strong></label>
                    <input type="text" id="name" name="name" class="contact_input" />
                    </div>  


                    <div class="form_row">
                    <label class="contact"><strong>����:</strong></label>
                    <input type="password" id="password1" name="password" class="contact_input" />
                    </div> 
					
					<div class="form_row">
                    <label class="contact"><strong>ȷ������:</strong></label>
                    <input type="password" id="password2" name="password" class="contact_input" />
                    </div> 
					
                    <div class="form_row">
                    <label class="contact"><strong>�����ʼ�:</strong></label>
                    <input type="text" id="email" name="email" class="contact_input" />
                    </div>

					<div class="form_row">
                    <label class="contact"><strong>��ʵ����:</strong></label>
                    <input type="text" id="trueName" name="trueName" class="contact_input" />
                    </div>
					
					<div class="form_row">
                    <label class="contact"><strong>�Ա�:</strong></label>
                    <input type="radio" name="sex" checked="checked"/>��
                    <input type="radio" name="sex"  />Ů
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>��������:</strong></label>
                    <input type="text" id="birthday" name="birthday" class="contact_input" />
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>��ַ:</strong></label>
                    <input type="text" id="address" name="address" class="contact_input" />
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>��������:</strong></label>
                    <input type="text" id="mailCode" name="mailcode" class="contact_input" />
                    </div>
					
                    <div class="form_row">
                    <label class="contact"><strong>�̶��绰:</strong></label>
                    <input type="text" id="phone" name="phone" class="contact_input" />
                    </div>
                    
                     <div class="form_row">
                    <label class="contact"><strong>�ƶ��绰:</strong></label>
                    <input type="text" id="mphone" name="mphone" class="contact_input" />
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>����������ʾ:</strong></label>
                    <input type="text" id="question" name="question" class="contact_input" />
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>�����:</strong></label>
                    <input type="text" id="answer" name="answer" class="contact_input" />
                    </div>                  

                    <div class="form_row">
                        <div class="terms">
                        <input type="checkbox" id="terms" name="terms" onclick="enable()" />
                        ��ͬ��������� <a href="">����</a>                        </div>
                    </div> 

                    
                    <div class="form_row">
                    <input type="button" id="register" name="register" class="register" value="ע��" disabled="disabled" onclick="checkAll()" />
                    </div>   
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