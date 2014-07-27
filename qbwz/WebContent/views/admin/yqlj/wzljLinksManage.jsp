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
<title>友情链接</title>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="17" valign="top" background="<%=basePath%>views/admin/images/mail_leftbg.gif"><img src="<%=basePath%>views/admin/images/left-top-right.gif" width="17" height="29" /></td>
	    <td valign="top" background="<%=basePath%>views/admin/images/content-bg.gif">
	    	<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
		      <tr>
		        <td height="31"><div class="titlebt">友情链接</div></td>
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
  	  	<td valign="top" bgcolor="#F7F8F9" style="padding-top: 2px;">
  	  		<!-- 新增链接 -->
			<div align="right" style="width: 99%">
  	  		  	<strong>
  	  		  		<a href="<%=basePath %>admin/addWzljUI.do" style="font-size: 13px; padding: 0; margin: 0;">新增</a>
  	  		  	</strong>
  	  		</div>	
  	  		<!-- 新增链接结束 -->
  	  		<table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
	          <tr>
	            <td width="1%" height="27" background="<%=basePath%>views/admin/images/news-title-bg.gif"><img src="<%=basePath%>views/admin/images/news-title-bg.gif" width="2" height="27"></td>
	            <td width="99%" background="<%=basePath%>views/admin/images/news-title-bg.gif" class="left_bt2" style="padding-left:1px;">文字链接列表</td>
	          </tr>
	          <tr>
	            <td height="102" colspan="2" valign="top" style="font-size: 13px;">
	            	<!-- 列表开始 -->
	            	<table>
	    				<tr style="font: bold bold 12px/20px Arial;">
	    					<td width="200px;">链接名称</td>
	    					<td width="200px;">链接地址</td>
	    					<td width="100px;" align="center">排序</td>
	    					<td width="100px;">显示状态</td>
	    					<td width="100px;" align="center">操&nbsp;&nbsp;&nbsp;作</td>
	    				</tr>
	    			<!-- 循环开始 -->
	    				<c:forEach items="${links}" var="link" varStatus="status">
	    				<c:if test="${status.index%2==0 }">
	    					<tr bgcolor="#f2f2f2">
	    				</c:if>
	    				<c:if test="${status.index%2!=0 }">
	    					<tr>
	    				</c:if>
	    					<td width="200px;">${link.fName}</td>
	    					<td width="200px;">${link.fLinkAddress}</td>
	    					<td width="100px;" align="center">${link.fSortFlag}</td>
	    					<td width="100px;">
	    						<c:if test="${link.fIsShow==1}">显示</c:if>
	    						<c:if test="${link.fIsShow!=1}">不显示</c:if>
	    					</td>
	    					<td width="100px;" align="center">
	    						<a href="<%=basePath %>admin/editWzljUI.do?id=${link.id}">修改</a>
	    						<a href="javascript:if(confirm('你确定要删除该友情链接吗？')){
	    						window.location.href='<%=basePath %>admin/delWzlj.do?id=${link.id}'}">删除</a>
	    						<a href="<%=basePath %>admin/showWzljLinks.do?id=${link.id}">显示</a>
	    					</td>
	    				</tr>
	    				</c:forEach>
	            	<!-- 循环结束 -->
	            	</table>
	            	<!-- 列表结束 -->
	            </td>
	          </tr>
	          
	          <!-- 分页开始 -->
	          <tr style="font-size: 13px;">
	            <td colspan="2" align="right" style="padding-right:15px;">
	            	${pagestring }
	            </td>
	          </tr>
			  <!-- 分页结束 -->

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
var message="${message}";
if(message!=null&&message!=""&&message!="null"){
	alert("操作成功!");
}

</script>
</html>