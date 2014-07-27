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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>丘北县人民医院</title>
<link href="<%=basePath %>views/web/css/qb.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=basePath%>views/web/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>views/web/js/scroll.js"></script>

<style type="text/css">
<!--
.STYLE2 {
	color: #2D2B2B;
	font-weight: bold;
}
.STYLE3 {color: #2D62D6}
-->
</style>
</head>
<body>
<div id="top"><div id="head"><img src="<%=basePath %>views/web/images/top.jpg" width="968" height="270" /></div>
<div id="daohang">
  <table width="968" height="43"  border="0" cellspacing="0">
    <tr>
      <td width="103" height="43" align="center"><a href="index.do" class="a3">首页</a></td>
      <td width="5" align="center"><span class="STYLE1"><strong>|</strong></span></td>
      <td width="103" align="center"><a href="zxzxnews.do?type=1" class="a3">医院概况</a></td>
       <td width="5" align="center"><span class="STYLE1"><strong>|</strong></span></td>
      <td width="103" align="center"><a href="zxzxnews.do?type=2" class="a3">就医指南</a></td>
       <td width="5" align="center"><span class="STYLE1"><strong>|</strong></span></td>
      <td width="103" align="center"><a href="zxzxnews.do?type=3" class="a3">新闻动态</a></td>
       <td width="5" align="center"><span class="STYLE1"><strong>|</strong></span></td>
      <td width="103" align="center"><a href="zxzxnews.do?type=4" class="a3">科室介绍</a></td>
       <td width="5" align="center"><span class="STYLE1"><strong>|</strong></span></td>
      <td width="103" align="center"><a href="zxzxnews.do?type=5" class="a3">政务栏</a></td>
       <td width="5" align="center"><span class="STYLE1"><strong>|</strong></span></td>
      <td width="103" align="center"><a href="zxzxnews.do?type=6" class="a3">信息公开</a></td>
       <td width="5" align="center"><span class="STYLE1"><strong>|</strong></span></td>
      <td width="103" align="center"><a href="zxzxnews.do?type=7" class="a3">健康之苑</a></td>
      
    </tr>
  </table>
</div>
</div>

