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
  	  		<table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
	          <tr>
	            <td width="1%" height="27" background="<%=basePath%>views/admin/images/news-title-bg.gif"><img src="<%=basePath%>views/admin/images/news-title-bg.gif" width="2" height="27"></td>
	            <td width="99%" background="<%=basePath%>views/admin/images/news-title-bg.gif" class="left_bt2" style="padding-left:1px;">编辑权限</td>
	          </tr>
	          <tr>
	          	<td colspan="2" valign="top" style="font-size: 13px; text-align: center;">
		          	<form action="<%=basePath%>admin/saveFuncManage.do" method="post" name="form1">
		          		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			              <tr>
			                <td height="30" align="right" bgcolor="#f2f2f2">权限名称：</td>
			                <td bgcolor="#f2f2f2">&nbsp;</td>
			                <td height="30" bgcolor="#f2f2f2"><input name="fFuncName" value="${funcList.fFuncName }" type="text" size="15" /></td>
			                <td height="30" bgcolor="#f2f2f2" class="left_txt">权限的名称</td>
			              </tr>
			              <tr>
			                <td height="30" align="right" class="left_txt2">权限排序：</td>
			                <td>&nbsp;</td>
			                <td height="30"><input name="fFuncSort" type="text" size="15" value="${funcList.fFuncSort }" /></td>
			                <td height="30" class="left_txt">数字越大，排序越靠前</td>
			              </tr>
			               <tr>
			                <td height="30" align="right" bgcolor="#f2f2f2">权限备注：</td>
			                <td bgcolor="#f2f2f2">&nbsp;</td>
			                <td height="30" bgcolor="#f2f2f2"><input name="fFuncMemo" type="text" size="15" value="${funcList.fFuncMemo }" /></td>
			                <td height="30" bgcolor="#f2f2f2" class="left_txt">权限的作用</td>
			              </tr>
	            		</table>
	            		<!-- 隐藏标签 -->
	            		<input type="hidden" value="${funcList.id }" name="id" />
	            		<input type="hidden" value="${funcList.fid }" name="fid"/>
		          	</form>
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
function check(){
	
	if(form1.fFuncName.value==""){
		alert("名称不能为空!");
		return ;
	}
	
	if(form1.fFuncSort.value==""){
		alert("排序不能为空!");
		return ;
	}
	
	form1.submit();
}
</script>
</html>