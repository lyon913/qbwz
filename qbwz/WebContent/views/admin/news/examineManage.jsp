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
<title>新闻中心</title>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="17" valign="top" background="<%=basePath%>views/admin/images/mail_leftbg.gif"><img src="<%=basePath%>views/admin/images/left-top-right.gif" width="17" height="29" /></td>
	    <td valign="top" background="<%=basePath%>views/admin/images/content-bg.gif">
	    	<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
		      <tr>
		        <td height="31"><div class="titlebt">新闻中心</div></td>
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
  	  		<!-- 新增链接结束 -->
  	  		<table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
	          <tr>
	            <td width="1%" height="27" background="<%=basePath%>views/admin/images/news-title-bg.gif"><img src="<%=basePath%>views/admin/images/news-title-bg.gif" width="2" height="27"></td>
	            <td width="99%" background="<%=basePath%>views/admin/images/news-title-bg.gif" class="left_bt2" style="padding-left:1px;">待审核新闻列表</td>
	          </tr>
	          <tr>
	            <td height="102" colspan="2" valign="top" style="font-size: 13px;">
	            	<!-- 列表开始 -->
	            	<table>
	    				<tr style="font: bold bold 12px/20px Arial;">
	    					<td width="200px;">新闻标题</td>
	    					<td width="50px">排序</td>
	    					<td width="100px;">来源</td>
	    					<td width="100px;">作者</td>
	    					<td width="200px;">发表时间</td>
	    					<td width="200px;">所属分类</td>
	    					<td width="100px;">状态</td>
	    					<td width="100px;" align="center">操&nbsp;&nbsp;&nbsp;作</td>
	    				</tr>
	    			<!-- 循环开始 -->
	    				<c:forEach items="${newsList}" var="news" varStatus="status">
	    				<c:if test="${status.index%2==0 }">
	    					<tr bgcolor="#f2f2f2">
	    				</c:if>
	    				<c:if test="${status.index%2!=0 }">
	    					<tr>
	    				</c:if>
	    					<td width="200px;">${news.fTitle}</td>
	    					<td width="50px;">${news.fSort}</td>
	    					<td width="100px;">${news.fly}</td>
	    					<td width="100px;">${news.fAuth}</td>
	    					<td width="200px;"><fmt:formatDate value="${news.ffbTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    					<td width="200px;">${news.flxFirst.fValue}
	    						<c:if test="${!empty news.flxSecond}">
	    							/${news.flxSecond.fValue}
	    						</c:if>
	    					</td>
	    					<td width="100px;">
	    						<c:if test="${news.fIsPass==0}">待审核</c:if>
	    						<c:if test="${news.fIsPass==-1}">未通过</c:if>
	    					</td>
	    					<td width="100px;" align="center">
	    						<a href="<%=basePath %>admin/examineNewsUI.do?id=${news.id}">审核</a>
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
var message="${requestScope.message}";
if(message!=null&&message!=""&&message!="null"){
	alert("操作成功!");
}

</script>
</html>