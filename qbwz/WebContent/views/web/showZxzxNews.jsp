<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="inc/top.jsp" />
<script src="<%=basePath %>/views/web/js/lightbox/js/jquery-1.11.0.min.js"></script>
<script src="<%=basePath %>/views/web/js/lightbox/js/lightbox.min.js"></script>
<link href="<%=basePath %>/views/web/js/lightbox/css/lightbox.css" rel="stylesheet" />
<div id="centre-sanji">
			<div id="lefterji">
				<jsp:include page="inc/left.jsp" />
			</div>
	
<div id="right-sanji">
<div class="erweizhi">
  <table width="746" border="0" align="left" cellpadding="0" cellspacing="0">
    <tr>
      <td width="42" height="37" rowspan="2">&nbsp;</td>
      <td width="381" rowspan="2"><span class="STYLE3">${property.fValue }
      </span></td>
      <td width="42" height="28" align="center"><img src="images/wztp.gif" width="13" height="11" /></td>
      <td width="281">您现在的位置：首页 &gt; ${property.fValue }&gt;阅读 </td>
    </tr>
    <tr>
      <td height="16" colspan="2">&nbsp;</td>
    </tr>
  </table>
</div>
<div class="right-sanjinews">
<div class="ttitlenews">${news.fTitle }</div>
<div class="timenews">
  来源：${news.fly}&nbsp; &nbsp; 发布者：${news.fAuth } &nbsp;&nbsp; 点击：${news.fdjTimes }次 &nbsp;&nbsp; 日期：${news.ffbTime }
</div>
<div class="sanji-newsnr">
<c:forEach items="${newsPicList}" var="pic">
     <p  style="text-indent:0px;">
     	<a href="<%=basePath %>newsPic/${pic.fPicAddress}" data-lightbox="img1" data-title="${pic.fName}">
			<img width="100%" height="100%" src="<%=basePath %>newsPic/${pic.fPicAddress}"/>
		</a>
	</p>
</c:forEach>
<p > </p>
 	${news.fContent }
   

</div>

</div>

</div>
</div>
<div id="foot">
	<iframe src="<%=basePath%>views/web/inc/foot.jsp" width="968"
		height="215" scrolling="no" frameborder="0"></iframe>
</div>
</body>
</html>
