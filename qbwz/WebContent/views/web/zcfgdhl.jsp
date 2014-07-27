<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>政策法规</title>
<link href="<%=basePath%>views/web/css/ynfx.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.STYLE13 {
	color: #333333
}

.STYLE14 {
	color: #FFFFFF
}
-->
</style>
<body>

	<div class="er-leftnewsnr1-3w">
		<div class="er-leftnewsnr1dh-4w">
			<table width="181" border="0" align="center" cellspacing="0">
				<tr>
					<td width="167" height="24" align="center" valign="bottom"><span class="STYLE14" target="_parent">政策法规</span></td>
				</tr>
			</table>
		</div>
		<div class="er-leftnewsnrfeinr-5w">
			<div class="er-leftnewsnrfeinr-2w">
				<table width="195" height="24" border="0" align="center" cellspacing="0">
					<tr>
						<td height="21" align="center" valign="bottom"><span class="STYLE13" target="_parent">法律法规</span></td>
					</tr>
				</table>
			</div>
			<ul class="nav">
				<c:if test="${180 == typeId }">
				<li class="hover"><a href="<%=basePath%>zcfgnews.do?type=3&typeId=180" target="_parent">法律</a></li>
				</c:if>
				<c:if test="${180 != typeId }">
				<li ><a href="<%=basePath%>zcfgnews.do?type=3&typeId=180" target="_parent">法律</a></li>
				</c:if>
				<c:if test="${typeId==182 }">
				<li class="hover"><a href="<%=basePath%>zcfgnews.do?type=3&typeId=182" target="_parent">行政法规</a></li>
				</c:if>
				<c:if test="${typeId!=182 }">
				<li ><a href="<%=basePath%>zcfgnews.do?type=3&typeId=182" target="_parent">行政法规</a></li>
				</c:if>
				<c:if test="${typeId==181 }">
				<li class="hover"><a href="<%=basePath%>zcfgnews.do?type=3&typeId=181" target="_parent">地方法规</a></li>
				</c:if>
				<c:if test="${typeId!=181 }">
				<li ><a href="<%=basePath%>zcfgnews.do?type=3&typeId=181" target="_parent">地方法规</a></li>
				</c:if>

			</ul>
			<div class="er-leftnewsnrfeinr-2w">
				<table width="195" height="24" border="0" align="center" cellspacing="0">
					<tr>
						<td height="21" align="center" valign="bottom"><span class="STYLE13">文件</span></td>
					</tr>
				</table>
			</div>
			<ul class="nav">
				<li><a href="<%=basePath%>zcfgFile.do?type=16&typeId=200" target="_parent">国务院文件</a></li>

				<li><a href="<%=basePath%>zcfgFile.do?type=16&typeId=201" target="_parent">建设部文件</a></li>

				<li><a href="<%=basePath%>zcfgFile.do?type=16&typeId=202" target="_parent">相关部委文件</a></li>

				<li><a href="<%=basePath%>zcfgFile.do?type=16&typeId=203" target="_parent">省政府文件</a></li>

				<li><a href="<%=basePath%>zcfgFile.do?type=16&typeId=206" target="_parent">省住房和城乡建设厅文件</a></li>

				<li><a href="<%=basePath%>zcfgFile.do?type=16&typeId=204" target="_parent">相关厅局文件</a></li>

				<li><a href="<%=basePath%>zcfgFile.do?type=16&typeId=205" target="_parent">地方文件</a></li>

			</ul>
		</div>
	</div>
</html>