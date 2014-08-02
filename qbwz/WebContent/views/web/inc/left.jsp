<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<script type="text/javascript">
var marqee;
$(function(){
	marqee = new scrollElement("mar");
	marqee.start("marqee");
});
</script>
<c:if test="${property.id==2 }">
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
</c:if>
<c:if test="${property.id==1 }">
<div class="erdaolan">
<div class="erdldh">
  <table width="177" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="44" height="31">&nbsp;</td>
      <td width="133" valign="bottom">医院概况</td>
    </tr>
  </table>
</div>
<div class="ernr">
  <ul>
    <c:forEach items="${yygk }" var="gk">
<li><a href="zxzxnews.do?type=1&typeId=${gk.id }" target="_blank">${gk.fName }</a></li>
</c:forEach>
 </ul>
</div>
</div>
</c:if>
<c:if test="${property.id==5 }">
<div class="erdaolan3">
<div class="erdldh">
  <table width="177" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="44" height="31">&nbsp;</td>
      <td width="133" valign="bottom">政务栏</td>
    </tr>
  </table>
</div>
<div class="ernr">
  <ul>
    <c:forEach items="${zwl }" var="zw">
<li><a href="zxzxnews.do?type=5&typeId=${zw.id }" target="_blank">${zw.fName }</a></li>
</c:forEach>
 </ul>
</div>
</div>
</c:if>
<c:if test="${property.id==6 }">
<div class="erdaolan3">
<div class="erdldh">
  <table width="177" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="44" height="31">&nbsp;</td>
      <td width="133" valign="bottom">信息公开</td>
    </tr>
  </table>
</div>
<div class="ernr">
  <ul>
    <c:forEach items="${xxgk }" var="gk">
<li><a href="zxzxnews.do?type=6&typeId=${gk.id }" target="_blank">${gk.fName }</a></li>
</c:forEach>
 </ul>
</div>
</div>
</c:if>
<c:if test="${property.id==7 }">
<div class="erdaolan3">
<div class="erdldh">
  <table width="177" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="44" height="31">&nbsp;</td>
      <td width="133" valign="bottom">健康之苑</td>
    </tr>
  </table>
</div>
<div class="ernr">
  <ul>
    <c:forEach items="${jkzy }" var="jk">
<li><a href="zxzxnews.do?type=7&typeId=${jk.id }" target="_blank">${jk.fName }</a></li>
</c:forEach>
 </ul>
</div>
</div>
</c:if>
<c:if test="${property.id==4 }">
 <div class="erlx">
<div class="erlxnrdh">
  <table width="207" border="0" cellspacing="0">
    <tr>
      <td width="44" height="31">&nbsp;</td>
      <td width="133" valign="bottom">科室介绍</td>
      <td width="32">&nbsp;</td>
    </tr>
  </table>
</div>
<div class="erlxnr">
  <table width="205" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>

       <c:forEach items="${ksjs }" var="ks" varStatus="idx">
      <td width="10%" height="35px" align="center" valign="middle" style="padding-left: 10px">
      	<img src="<%=basePath %>views/web/images/wtuj.gif" width="12" height="12" style="margin-right: 5px"/></td><td>
      <div style="width:84px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis">	<a href="keshi.do?type=4&typeId=${ks.id }" class="ks" title="${ks.fName }">${ks.fName }</a></div>
      </td>
		<c:if test="${idx.index%2==1 }">
			</tr><tr> 
		</c:if>
     </c:forEach>
    </tr>
  </table>
</div>
</div>
</c:if>
<c:if test="${property.id==3 }">
 <div class="erlx">
<div class="erlxnrdh">
  <table width="207" border="0" cellspacing="0">
    <tr>
      <td width="44" height="31">&nbsp;</td>
      <td width="133" valign="bottom">导航栏</td>
      <td width="32">&nbsp;</td>
    </tr>
  </table>
</div>
<div class="ernr">
      <ul><c:forEach items="${dh}" var="d">
			<li style="text-align: left;"><a href="<%=basePath %>zxzxnews.do?type=${d.id}">${d.fValue }</a></li>
		</c:forEach>
	</ul>
  
</div>
</div>
</c:if>
<c:if test="${property.id==52 }">
 <div class="kepu1">
						<div class="zjnwdaohang1">
							<table width="100%" border="0" cellspacing="0">
								<tr>
									<td width="99" height="27" align="center" valign="bottom">专家介绍</td>
									<td width="120" valign="bottom">&nbsp;</td>
									<td width="47" valign="middle"><table width="53"
											border="0" cellspacing="0">
											<tr>
												<td width="51" height="19" valign="bottom"></td>
											</tr>
										</table></td>
								</tr>
							</table>
						</div>

						<div class="zjnwnrzong1">
							<div id="mar" class="zjnwnr" style="height: 100%;overflow: hidden;">
								<ul>

									<c:forEach items="${zjjs}" var="zj">
										<li style="text-align: center;">
										
										<a href="<%=basePath %>showZxzxNews.do?id=${zj.id}"
											title="${zj.fTitle }"><img src="<%=basePath %>xwPic/${zj.fNewsPic}" width="96"
											height="120" style="display: block;text-align: center;"/><span>${zj.fTitle }</span></a>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>

					</div>
</c:if>
<div class="erdaolan">
<div class="erdldh">
  <table width="177" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="44" height="31">&nbsp;</td>
      <td width="133" valign="bottom">推荐阅读</td>
    </tr>
  </table>
</div>
<div class="ernr">
  <ul>
    <c:forEach items="${tjyd }" var="n">
<li><div style="width:177px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis"><a href="<%=basePath%>showZxzxNews.do?id=${n.id}"  title="${n.fTitle }">${n.fTitle
															}</a></div></li>
</c:forEach>
 </ul>
</div>
</div>
<c:if test="${property.id!=3 }">
<div class="erlx">
<div class="erlxnrdh">
  <table width="177" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="44" height="31">&nbsp;</td>
      <td width="133" valign="bottom">新闻动态</td>
    </tr>
  </table>
</div>
<div class="ernr">
  <ul>
    <c:forEach items="${xwdt }" var="n">
<li><div style="width:177px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis"><a href="<%=basePath%>showZxzxNews.do?id=${n.id}"  title="${n.fTitle }">${n.fTitle
															}</a></div></li>
</c:forEach>
 </ul>
</div>
</div>
</c:if>