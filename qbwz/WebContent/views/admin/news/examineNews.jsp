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
<script type="text/javascript" charset="utf-8" src="<%=basePath%>views/admin/KingDeditor/kindeditor.js"></script> 
		<script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="fContent"]', {
					height : '315px',
					width : '600px',
					resizeType : 0,
					allowPreviewEmoticons : false,
					afterBlur: function(){
						this.sync();
					},
					uploadJson : '<%=basePath%>views/admin/KingDeditor/jsp/upload_json.jsp',
	                fileManagerJson : '<%=basePath%>views/admin/KingDeditor/jsp/file_manager_json.jsp',
	                allowFileManager : true,
					allowImageUpload : true,
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|','image']
				});
			});
		</script>
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
  	  	<td valign="top" bgcolor="#F7F8F9" style="padding-top: 18px;">
  	  		<table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
	          <tr>
	            <td width="1%" height="27" background="<%=basePath%>views/admin/images/news-title-bg.gif"><img src="<%=basePath%>views/admin/images/news-title-bg.gif" width="2" height="27"></td>
	            <td width="99%" background="<%=basePath%>views/admin/images/news-title-bg.gif" class="left_bt2" style="padding-left:1px;">审核新闻信息</td>
	          </tr>
	          <tr>
	            <td height="102" colspan="2" valign="top" style="font-size: 13px;">
	            	<!-- 表单开始 -->
	            	<!-- 程序在循环控制的时候，如果是单数那么就显示第一个tr，如果是双数就显示第二个tr -->
	            	<form name="form1" method="POST" action="<%=basePath%>admin/saveXhxxNews.do">
		            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			              <tr>
			                <td colspan="2" height="30" align="center" bgcolor="#f2f2f2"><strong>${news.fTitle }</strong></td>
			              </tr>
			              <tr><td colspan="2" height="30" align="center">来源:${news.fly}&nbsp;&nbsp;作者:${news.fAuth}&nbsp;&nbsp;
			              	发表时间:<fmt:formatDate value="${news.ffbTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			              </tr>
			              <tr>
			              	<td width="10">&nbsp;</td>
			                <td height="30" align="left" class="left_txt2">${news.fContent}</td>
			              </tr>
	            		</table>
	            		<!-- 隐藏标签 -->
	            		<input type="hidden" value="${news.id}" name="id" />
	            		<!-- 隐藏标签结束 -->
            		</form>
            		<!-- 表单结束 -->
	            </td>
	          </tr>
	          
	          <!-- 按钮开始 -->
	          <tr style="font-size: 13px;">
	            <td colspan="2" align="center" style="padding-right:15px;">
	            	<input type="button" value="通&nbsp;&nbsp;过" onclick="javascript:window.location.href='<%=basePath%>admin/examineNews.do?isPass=1&id=${news.id}'"/>&nbsp;
	            	<input type="button" value="不通过"  onclick="javascript:window.location.href='<%=basePath%>admin/examineNews.do?isPass=-1&id=${news.id}'"/>
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
			if(form1.fTitle.value==""){
				alert("标题不能为空!");
				return ;
			}
			
			if(form1.fContent.value==""){
				alert("简介内容不能为空!");
				return ;
			}
			
			if(form1.fly.value==""){
				alert("来源不能为空!");
				return ;
			}
			
			if(form1.fAuth.value==""){
				alert("作者不能为空!");
				return ;
			}
			
			form1.submit();
		}
</script>
<script type="text/javascript">
var message="${message}";
if(message!=null&&message!=""&&message!="null"){
	alert(message);
}
</script>
</html>

