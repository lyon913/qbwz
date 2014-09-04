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
<title>丘北县人民医院</title>
<link href="<%=basePath %>views/web/css/qb.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="foot">
  <div class="footnr">
    <p>版权所有&nbsp; &nbsp;丘北县人民医院  保留所有权利
    &nbsp; &nbsp; 单位地址：云南省文山壮族苗族自治州丘北县锦屏镇石缸坝普碳路旁

&nbsp; &nbsp;  邮政编码：663200    </p>
    <p> 投诉电话：0876-4121447   &nbsp;  &nbsp;咨询电话：0876-4121447 
      &nbsp; &nbsp;  邮箱：qbrmyy@126.com</p>
    <p>&nbsp; &nbsp; 备案/许可证号:&nbsp;&nbsp;  </p>
  </div>
</div>
</body>
</html>