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
<div id="centreerji">
	<div id="lefterji">
		<jsp:include page="inc/left.jsp" />
	</div>
	<div id="righterji">
		<div class="erweizhi">
			<table width="746" border="0" align="left" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="42" height="37" rowspan="2">&nbsp;</td>
					<td width="381" rowspan="2"><span class="STYLE3">${property.fValue
							} </span></td>
					<td width="42" height="28" align="center"><img
						src="images/wztp.gif" width="13" height="11" /></td>
					<td width="281">您现在的位置：首页 &gt; ${property.fValue } <c:if
							test="${property1!=null }">&gt;${property1.fValue }</c:if></td>
				</tr>
				<tr>
					<td height="16" colspan="2">&nbsp;</td>
				</tr>
			</table>
		</div>
		<div class="erxinxnr">
			<div class="lanmu2">
				<table width="100%">
					<c:forEach items="${newsList }" var="news">
						<tr>
							<td width="5%" align="right"><img
								src="<%=basePath%>views/web/images/jg_icon1.gif" /></td>
							<td width="80%" height="25"><c:choose>
									<c:when test="${fn:length(news.fTitle) > 30}">
										<a href="<%=basePath%>showZxzxNews.do?id=${news.id}"
											title="${news.fTitle}"><c:out
												value="${fn:substring(news.fTitle, 0, 30)}..." /> </a>
									</c:when>
									<c:otherwise>
										<a href="<%=basePath%>showZxzxNews.do?id=${news.id}"
											title="${news.fTitle}"><c:out value="${news.fTitle}" />
										</a>
									</c:otherwise>
								</c:choose></td>
							<td><fmt:formatDate value="${news.ffbTime}" type="date" />
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>

			${pageString }

		</div>
	</div>

</div>
<div id="foot">
	<iframe src="<%=basePath%>views/web/inc/foot.jsp" width="968"
		height="215" scrolling="no" frameborder="0"></iframe>
</div>
</body>
</html>