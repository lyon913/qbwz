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
 <div id="centre-sanji">
 <div id="lefterji">
				<jsp:include page="inc/leftzx.jsp" />
</div>
<br>
<br>
<div id="right-sanji">
<div class="erweizhi">
  <table width="746" border="0" align="left" cellpadding="0" cellspacing="0">
    <tr>
      <td width="42" height="37" rowspan="2">&nbsp;</td>
      <td width="381" rowspan="2">留言簿</td>
      <td width="42" height="28" align="center"><img src="images/wztp.gif" width="13" height="11" /></td>
      <td width="281">您现在的位置：首页 &gt; 留言簿 </td>
    </tr>
    <tr>
      <td height="16" colspan="2">&nbsp;</td>
    </tr>
  </table>
</div>
<div class="right-sanjinews">
<div class="sanji-newsnr">
<c:forEach items="${ly }" var="ly" begin="0" end="2">
<div class="er-chakanlyzong">
<div class="er-chakanlydh">
  <table width="600" height="36" border="0" cellspacing="0">
    <tr>
      <td width="12" height="12"><img src="<%=basePath %>views/web/images/jg_icon1.gif"></td>
      <td width="135" align="left"><span class="STYLE7">${ly.fNick }：</span></td>
      <td width="304" ><span class="STYLE7">${ly.fTitle }</span>&nbsp;</td>
      <td width="160"><span class="STYLE8"><fmt:formatDate value="${ly.ffbTime}" pattern="yyyy-MM-dd HH:mm:ss" /></span></td>
    </tr>
  </table>
</div>
<div class="er-chakanlywen">
${ly.fContent}
</div>
<div class="er-chakanlyda">
<c:choose>
						<c:when test="${!empty ly.fhf}">
							<i>回复：${ly.fhf[0].fContent }</i>
						</c:when>
						<c:otherwise>
							<i>回复：暂无回复</i>
						</c:otherwise>
					</c:choose>
</div>
</div>
</c:forEach>
${pageString }
  </div>
</div>
 </div>
 </div>
<div id="foot">
	<iframe src="<%=basePath%>views/web/inc/foot.jsp" width="968"
		height="215" scrolling="no" frameborder="0"></iframe>
</div>

<script language='javascript'>
var message="${message}";
if(message!=null&&message!=""&&message!="null"){
	alert(message);
}
</script>

