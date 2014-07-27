<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="erdaolan3">
<div class="erdldh">
  <table width="207" border="0" cellspacing="0">
    <tr>
      <td width="11" height="32">&nbsp;</td>
      <td width="158" align="center" valign="bottom">意见簿</td>
      <td width="32">&nbsp;</td>
    </tr>
  </table>
</div>
<div class="ernr">
<ul>
<li><A href="<%=basePath%>zxly.do">发表留言</A></li>
 </ul>
 <ul>
<li><A href="<%=basePath%>ly.do">查看留言</A></li>
 </ul>
</div>
</div>
<br>
<br>
<div class="erdaolan">
<div class="erdldh">
  <table width="177" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="44" height="31">&nbsp;</td>
      <td width="133" valign="bottom">就医指南</td>
    </tr>
  </table>
</div>
<div class="ernr">
  <ul>
    <c:forEach items="${jyzn }" var="zn">
<li><a href="zxzxnews.do?type=2&typeId=${zn.id }" target="_blank">${zn.fName }</a></li>
</c:forEach>
 </ul>
</div>
</div>