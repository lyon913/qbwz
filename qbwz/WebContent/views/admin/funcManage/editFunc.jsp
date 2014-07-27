<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	 response.setContentType("text/html;charset=utf-8");
	 request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<title>权限管理</title>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="17" valign="top" background="<%=basePath%>views/admin/images/mail_leftbg.gif"><img src="<%=basePath%>views/admin/images/left-top-right.gif" width="17" height="29" /></td>
	    <td valign="top" background="<%=basePath%>views/admin/images/content-bg.gif">
	    	<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
		      <tr>
		        <td height="31"><div class="titlebt">权限管理</div></td>
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
  	  		<!-- 新增链接 -->
			<div align="right" style="width: 99%">
  	  		  	<strong>
  	  		  		<a href="<%=basePath %>admin/addFuncUI.do" style="font-size: 13px; padding: 0; margin: 0;">新增</a>
  	  		  	</strong>
  	  		</div>	
  	  		<!-- 新增链接结束 -->
  	  		<table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
	          <tr>
	            <td width="1%" height="27" background="<%=basePath%>views/admin/images/news-title-bg.gif"><img src="<%=basePath%>views/admin/images/news-title-bg.gif" width="2" height="27"></td>
	            <td width="99%" background="<%=basePath%>views/admin/images/news-title-bg.gif" class="left_bt2" style="padding-left:1px;">编辑权限</td>
	          </tr>
	          <tr>
	          	<td colspan="2" valign="top" style="font-size: 13px; text-align: center; background-color:#f2f2f2;">
		          	<form action="<%=basePath%>admin/func.do" method="post" id="searchForm" name="searchForm">
		          	请选择权限组:
		          	<select name="funcGroup" id="funcGroup" onchange="document.getElementById('searchForm').submit()">
		          		<c:forEach items="${funcGroupOptions}" var="funcGroup">
		          		<c:if test="${funcId.id==funcGroup.id}">
		          			<option value="${funcGroup.id}" selected="selected">${funcGroup.fFuncGroupName }</option>
		          		</c:if>
		          		<c:if test="${funcId.id!=funcGroup.id}">
		          			<option value="${funcGroup.id}">${funcGroup.fFuncGroupName }</option>
		          		</c:if>
		          		</c:forEach>
		          	</select>
		          	</form>
	          	</td>
	          </tr>
	          <tr>
	          	<td colspan="2" valign="top" style="font-size: 13px; text-align: center;">
		          	&nbsp;
	          	</td>
	          </tr>
	          <tr>
	            <td colspan="2" valign="top" style="font-size: 13px;">
	            	<!-- 表单开始 -->
	            	<!-- 程序在循环控制的时候，如果是单数那么就显示第一个tr，如果是双数就显示第二个tr -->
	            	<c:forEach items="${tempFuncLists}" var="func">
		            	<div style="width: 200px;float: left; margin-bottom: 10px;">
		            		<div><strong><input type="checkbox" id="right${func.funcList.id}" value="${func.funcList.id}" />${func.funcList.fFuncName}</strong></div>
		            		<div>
		            			<c:forEach items="${func.funcLists}" var="f">
		            				<div><input type="checkbox" id="right${f.id}" value="${f.id}" />${f.fFuncName}</div>
		            			</c:forEach>
		            		</div>
		            	</div>
		            </c:forEach>
		            <!-- 表单 -->
            		<form name="saveForm" id="saveForm" method="POST" action="<%=basePath %>admin/saveFunc.do">
            			<input type="hidden" value=""  name="funcRights" id="funcRights"/>
            			<input type="hidden" value="" name="funcGroups" id="funcGroups" />
            		</form>
            		<!-- 表单结束 -->
	            </td>
	          </tr>
	          
	          <!-- 按钮开始 -->
	          <tr style="font-size: 13px;">
	            <td colspan="2" align="center" style="padding-right:15px;">
	            	<input type="button" value="保&nbsp;&nbsp;存" onclick="check()"/>
	            	<input type="button" value="返&nbsp;&nbsp;回" />
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
var rights="${ourRights}";
if(rights!=null&&rights!=""){
	var right=rights.split(",");
	for(var i=0;i<right.length;i++){
		if(document.getElementById("right"+right[i])!=null){
			document.getElementById("right"+right[i]).checked=true;
		}
	}
}

var message="${message}";
if(message!=null&&message!=""&&message!="null"){
	alert("操作成功!");
}

function check(){
	var ys=document.getElementsByTagName("input");
	var funcRights="";
	for(var i=0;i<ys.length;i++){
		if(ys[i].type=="checkbox"){
			if(ys[i].checked==true){
				funcRights+=ys[i].value+",";
			}
		}
	}
	document.getElementById("funcGroups").value=document.getElementById("funcGroup").value;
	document.getElementById("funcRights").value=funcRights;
	document.getElementById("saveForm").submit();
}
</script>
</html>