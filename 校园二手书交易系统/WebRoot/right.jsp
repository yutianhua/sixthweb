<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@include file="common.jsp" %>
   	 <div class="right_content">
   	 			<div id="news">
   	 				<marquee direction="up" height="130px;" style="padding-top: 20px;" truespeed="truespeed" onmouseover="stop()" onmouseout="start()" >
   	 					<ul>
   	 						<c:choose>
   	 							<c:when test="${empty informList }">
   	 								<font color="red">��ʱ��û�й��</font>
   	 							</c:when>
   	 							<c:otherwise>
   	 								<c:forEach var="inform" items="${informList}">
   	 									<li><a href="#">���⣺${inform.informTitle}</a>&nbsp;&nbsp;&nbsp;&nbsp;[${inform.informTime}]</li>
   	 								</c:forEach>
   	 							</c:otherwise>
   	 						</c:choose>	
   	 					</ul>
   	 				</marquee>
   	 			</div>
              <div>
              	 <img src="images/border.gif" />
              </div> 
                <div class="loginDiv">
                 <form name="login" action="login" method="post">          
					<fieldset>
						<legend id="loginTitle">�˺ŵ�¼</legend>
						<table>
							<tr>
								<td>�˺ţ�</td>
								<td><input type="text" name="name" /></td>
							</tr>
							<tr>
								<td>���룺</td>
								<td><input type="password" name="password" /></td>
							</tr>
							<tr>
								<td><input type="checkbox" name="cookie" />��ס����</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><input type="submit" class="register" value="��¼" /></td>
								<td><a class="register" href="register.jsp">ע��</a></td>
							</tr>
							<tr>
								<td style="padding-left: 55px;"><img src="images/mail.png" name="mail" /></td>
								<td><a href="PwdIndex.jsp">��������?��������һ�����.</a></td>
							</tr>
						</table>
					</fieldset>    
                  </form>     
                </div> 
              <div>
              	 <img src="images/border.gif" />
              </div> 
             <div class="right_box">
             	<div class="title"><span class="title_icon"><img src="images/bullet4.gif" alt="" title="" /></span>�ؼ���&nbsp;&nbsp;<a href="page?type=3" class="more">-����-</a></div> 
                   <c:forEach var="flag" items="${saleList}">
                    <div class="new_prod_box">
                        <a href="details.jsp">${flag.bookName}</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="images/promo_icon.gif" alt="" title="" /></span>
                        <a href="showBookByIdServlet?bookId=${flag.bookId}"><img src="${flag.picture}" alt="" title="" class="thumb" border="0" /></a>
                        <p class="price">ԭ�ۣ���${flag.price}</p>
                 		<p class="nowPrice">�ּۣ���${flag.nowPrice}</p>
                        </div>           
                    </div>
                   </c:forEach>
             </div>
             
             <div class="right_box">
             	<div class="title"><span class="title_icon"><img src="images/categories.gif" alt="" title="" /></span>�鼮����</div> 
                <div class="title"><span class="title_icon"><img src="images/bullet5.gif" alt="" title="" /></span>�����鼮</div> 
                <ul class="list">
                <li><a href="">����Ӣ��</a></li>
                <li><a href="">�߼�Ӣ��</a></li>
                <li><a href="">����Ӣ��</a></li>
                <li><a href="">Ӣ�����</a></li>
                <li><a href="">����Ӣ��</a></li>                                           
                </ul>
                
             	<div class="title"><span class="title_icon"><img src="images/bullet6.gif" alt="" title="" /></span>��ѧ����</div> 
                
                <ul class="list">
                <li><a href="">��̨��ѧ</a></li>
                <li><a href="">�����ѧ</a></li>
                <li><a href="">�ഺ��ѧ</a></li>
                <li><a href="">��ѧ����  </a></li>                      
                </ul>      
				<p>&nbsp;</p>
             	<div class="title"><span class="title_icon"><img src="images/bullet6.gif" alt="" title="" /></span>IT����</div> 
                
                <ul class="list">
                <li><a href="">�������</a></li>
                <li><a href="">�������</a></li>
                <li><a href="">����ϵͳ</a></li>
                <li><a href="">ͼ��ͼ��</a></li>                      
                </ul>      
            </div>  