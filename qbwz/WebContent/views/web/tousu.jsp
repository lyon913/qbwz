<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="inc/top.jsp" />
<div id="centre-sanji">
	
			<div id="lefterji">
				<jsp:include page="inc/left.jsp" />
			</div>
	
	<div id="right-sanji">
		<div class="erweizhi">
			<table width="746" border="0" align="left" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="42" height="37" rowspan="2">&nbsp;</td>
					<td width="381" rowspan="2"><span class="STYLE3">投诉</span></td>
					<td width="42" height="28" align="center"><img
						src="images/wztp.gif" width="13" height="11" /></td>
					<td width="281">您现在的位置：首页 &gt;投诉</td>
				</tr>
				<tr>
					<td height="16" colspan="2">&nbsp;</td>
				</tr>
			</table>
		</div>
		<div class="right-sanjinews">
  <div class="sanji-newsnr">

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