<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
    <script type="text/javascript">
    	function b1(){
		
		var timeId = document.getElementById("timeId");
		var x  = new Array("������", "����һ", "���ڶ�","������","������", "������","������");
		var e = new Date();
		var day = e.getUTCDay();
		timeId.innerHTML = "���ڣ�"+e.getFullYear()+"��"+(e.getMonth()+1)+"��"+e.getDate()+"��   " +x[day];
	}
	</script>
    <body onload="b1()">
     <div class="header">
       		<div class="logo"><a href="index.htm"><img src="images/logo.gif" alt="" title="" border="0" /></a></div>            
        <div id="menu">
            <ul>                                                                       
            <li class="selected"><a href="index.jsp">��ҳ</a></li>
            <li><a href="about.jsp">��������</a></li>
            <li><a href="page?type=0">�鼮��</a></li>
            <li><a href="page?type=4">�ر��Ƽ�</a></li>
            <li><a href="okLoggin">��������</a></li>
            <li><a href="pageNoteServlet">�û�����</a></li>
            <li><a href="contact.jsp">��ϵ����</a></li>
             <li><a href="userLoginOut">ע��</a></li>
            </ul>
        </div>                        
       </div> 
       <div id="serachDiv">
       	<div style="padding-left:50px">
       	 <form action="pageSearchServlet" method="post" id="searchForm">
       	 	<table>
       	 		<tr>
       				<td><input type="text" name="keywords" id="keywords" /></td>
       				<td><input type="image" src="images/search.gif" name="submit" /></td>
       				<td><img src="images/gjsearch.png" name="gjsearch" /></td>    
       				<td><a href="showSuperTypeServlet">�߼�����</a></td>
       				<td id="timeId" style="padding-left: 250px;"></td>   				
       			</tr>
       		</table>
       	 </form>
       	</div> 		
       </div>
       <!--end of leftTop content-->
      </body> 