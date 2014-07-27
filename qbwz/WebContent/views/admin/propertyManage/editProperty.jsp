<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath(); 
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>views/admin/js/jquery.js"></script>
<link href="<%=basePath%>views/admin/images/skin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>属性管理</title>

</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="17" valign="top" background="<%=basePath%>views/admin/images/mail_leftbg.gif"><img src="<%=basePath%>views/admin/images/left-top-right.gif" width="17" height="29" /></td>
	    <td valign="top" background="<%=basePath%>views/admin/images/content-bg.gif">
	    	<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
		      <tr>
		        <td height="31"><div class="titlebt">属性管理</div></td>
		      </tr>
	    	</table>
	    </td>
	    <td width="16" valign="top" background="<%=basePath%>views/admin/images/mail_rightbg.gif"><img src="<%=basePath%>views/admin/images/nav-right-bg.gif" width="16" height="29" /></td>
	  </tr>
  	  <!-- 这里是中间代码 -->
  	  <tr>
  	  	<!-- 左边的背景 -->
  	  	<td valign="middle" background="<%=basePath%>views/admin/images/mail_leftbg.gif">&nbsp;</td>
  	  	<!-- 中间的内容 -->
  	  	<td valign="top" bgcolor="#F7F8F9" style="padding-top: 18px;">
  	  		<table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
	          <tr>
	            <td width="1%" height="27" background="<%=basePath%>views/admin/images/news-title-bg.gif"><img src="<%=basePath%>views/admin/images/news-title-bg.gif" width="2" height="27"></td>
	            <td width="99%" background="<%=basePath%>views/admin/images/news-title-bg.gif" class="left_bt2" style="padding-left:1px;">编辑属性</td>
	          </tr>
	          <tr>
	            <td height="102" colspan="2" valign="top" style="font-size: 13px;">
	            	<!-- 表单开始 -->
	            	<!-- 程序在循环控制的时候，如果是单数那么就显示第一个tr，如果是双数就显示第二个tr -->
	            	<form name="form1" method="POST" action="<%=basePath%>admin/editProperty.do">
	            	<input type="hidden" name="pId" value="${property.id }">
		            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			              <tr>
			                <td height="30" align="right" class="left_txt2">所属上级类别：</td>
			                <td>&nbsp;</td>
			                <td height="30">
				                <select name="fId" onChange="changeFName(this.value)">
				                <c:if test="${topid==0}">
				                	<option value="0" selected="selected">顶层类别</option>
				                </c:if>
				                <c:if test="${topid!=0}">
				                	<option value="0">顶层类别</option>
				                </c:if>
				                	<c:forEach items="${propertys}" var="p">
				                		<c:if test="${p.id==property.fId}">
				                			<option value="${p.id}" selected="selected">${p.fValue }</option>
				                		</c:if>
				                		
				                		<c:if test="${p.id!=topid}">
				                			<option value="${p.id}">${p.fValue }</option>
				                		</c:if>
				                	</c:forEach>
				                </select>
			                </td>
			                <td height="30" class="left_txt">选择所属上级类别</td>
			              </tr>
			              
			              <tr>
			                <td height="30" align="right" bgcolor="#f2f2f2">属性值：</td>
			                <td bgcolor="#f2f2f2">&nbsp;</td>
			                <td height="30" bgcolor="#f2f2f2"><input name="fValue" type="text" size="14" value="${property.fValue }"/></td>
			                <td height="30" bgcolor="#f2f2f2" class="left_txt">填写属性值</td>
			              </tr>
			              <c:if test="${property.fId==0 }">
			              <tr id="name1" >
			                <td height="30" align="right" bgcolor="#f2f2f2">属性类型：</td>
			                <td bgcolor="#f2f2f2">&nbsp;</td>
			                <td height="30" bgcolor="#f2f2f2">
			                <select id="n1" name="fName1">
			                <c:if test="${property.fName=='新闻中心' }">
			                <option value="新闻中心" selected="selected">新闻中心</option>
			                <option value="链接类型">链接类型</option>
			                </c:if>
			                <c:if test="${property.fName=='链接类型' }">
			                <option value="新闻中心" >新闻中心</option>
			                <option value="链接类型" selected="selected">链接类型</option>
			                </c:if>
			                <c:if test="${property.fName==''||property.fName==null }">
			                <option value="新闻中心" >新闻中心</option>
			                <option value="链接类型">链接类型</option>
			                </c:if>
			                </select>
			                </td>
			                <td height="30" bgcolor="#f2f2f2" class="left_txt">在网站前台显示文字信息的请选择新闻中心</td>
			              </tr>
			              
			              </c:if>
			              <c:if test="${property.fId!=0 }">
			              <tr id="name1" style="display:none;">
			                <td height="30" align="right" bgcolor="#f2f2f2">属性类型：</td>
			                <td bgcolor="#f2f2f2">&nbsp;</td>
			                <td height="30" bgcolor="#f2f2f2">
			                <select id="n1" name="fName1">
			                <option value="新闻中心">新闻中心</option>
			                <option value="链接类型">链接类型</option>
			                </select>
			                </td>
			                <td height="30" bgcolor="#f2f2f2" class="left_txt">在网站前台显示文字信息的请选择新闻中心</td>
			              </tr>
			           
			              </c:if>
			              
	            		</table>
            		</form>
            		<!-- 表单结束 -->
	            </td>
	          </tr>
	          
	          <!-- 按钮开始 -->
	          <tr style="font-size: 13px;">
	            <td colspan="2" align="center" style="padding-right:15px;">
	            	<input type="button" value="提&nbsp;&nbsp;交" onclick="check()"/>
	            </td>
	          </tr>
			  <!-- 按钮结束 -->

	        </table>
  	  	</td>
  	  	<!-- 右边的背景 -->
  	  	<td background="<%=basePath%>views/admin/images/mail_rightbg.gif">&nbsp;</td>
  	  </tr>
  	  <!-- 中间代码结束 -->
	  <tr>
	    <td valign="bottom" background="<%=basePath%>views/admin/images/mail_leftbg.gif"><img src="<%=basePath%>views/admin/images/buttom_left2.gif" width="17" height="17" /></td>
	    <td background="<%=basePath%>views/admin/images/buttom_bgs.gif"><img src="<%=basePath%>views/admin/images/buttom_bgs.gif" width="17" height="17"></td>
	    <td valign="bottom" background="<%=basePath%>views/admin/images/mail_rightbg.gif"><img src="<%=basePath%>views/admin/images/buttom_right2.gif" width="16" height="17" /></td>
	  </tr>
	</table>
</body>
<script type="text/javascript">
		function check(){
			if(form1.fValue.value==""){
				alert("属性值不能为空!");
				return ;
			}
			
			form1.submit();
		}
		function changeFName(id){
			var name1 = document.getElementById("name1");
			
			if(id==0){
			 	name1.style.display="";
			 	
			}else{
				name1.style.display="none";
			 	
			}
			
		}
</script>
</html>