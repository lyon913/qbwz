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
<div id="centre">
	<div class="middle1">
		<div class="middle1zuo">
			<table width="558" height="353" border="0" align="center"
				cellpadding="0" cellspacing="0">
				<tr>
					<td width="558" height="353" align="center">
<script type="text/javascript">
      
 var focus_width=558;
 var focus_height=340;
 var text_height=22;
 var swf_height = focus_height+text_height;
 
 var pics="${pics}";
 var links=escape('${links}');
 var texts="${texts}";

 //document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ focus_width +'" height="'+ swf_height +'">');
 //document.write('<param name="allowScriptAccess" value="sameDomain"><param name="movie" value="<%=basePath%>views/web/images/focus1.swf"><param name="quality" value="high"><param name="bgcolor" value="#F0F0F0">');
								//document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
								//document.write('<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'">');
								//document.write('</object>');

								document.write('<object type="application/x-shockwave-flash" width="'+ focus_width +'" height="'+ swf_height +'">');
								document.write('<param name="allowScriptAccess" value="sameDomain"><param name="movie" value="<%=basePath%>views/web/images/focus1.swf"><param name="quality" value="high"><param name="bgcolor" value="#F0F0F0">');
								document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
								document.write('<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'">');
								document.write('</object>');

var marqee;
$(function(){
	marqee = new scrollElement("mar");
	marqee.start("marqee");
});
								</script></td>
				</tr>
			</table>

		</div>
		<div class="middle1you">
			<div class="xinwendaohang">
				<table width="381" border="0" cellspacing="0">
					<tr>
						<td width="32" height="27">&nbsp;</td>
						<td width="277" valign="bottom">新闻动态</td>
						<td width="67" align="left" valign="bottom"><a
							href="<%=basePath%>zxzxnews.do?type=3" target="_blank">更多</a></td>
					</tr>
				</table>
			</div>
			<div class="xwnerong">
				<table width="100%">
				<c:forEach items="${zxzx }" var="zx" begin="0" end="5">
				<tr>
				<td width="5%" height="29px" align="center"><img src="<%=basePath%>views/web/images/lxjt.gif" /></td>
			<td width="70%"><div style="width:270px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis"><a
							href="<%=basePath%>showZxzxNews.do?id=${zx.id}" title="${zx.fTitle}">${zx.fTitle}
						</a>
						</div>
				</td>
				<td><fmt:formatDate value="${zx.ffbTime }"
								pattern="yyyy-MM-dd" /></td>
				</tr>
				</c:forEach>
				</table>
			</div>

		</div>
	</div>
	<div class="middle2">
		<div class="rightzong5">
			<div class="zndaohang">
				<table width="676" border="0" cellspacing="0">
					<tr>
						<td width="42" height="37" align="center"><img
							src="<%=basePath%>views/web/images/xtp.gif" width="16"
							height="14" /></td>
						<td width="630" valign="middle">就医指南<a
							href="<%=basePath%>zxzxnews.do?type=2" target="_blank"><img
								src="<%=basePath%>views/web/images/more3.gif" width="40"
								height="11" border="0" /></a></td>

					</tr>
				</table>
			</div>
			<div class="znnr">
				<table width="952" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
					<tr>
						<c:forEach items="${jyzn }" var="zn" begin="0" end="8">
							<td><img src="<%=basePath%>xwPic/${zn.fNewsPic }" width="51"
								height="70" /><br> <div style="width:100px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis"><a
								href="<%=basePath%>showZxzxNews.do?id=${zn.id}" title="${zn.fTitle }"> ${zn.fTitle
									}</a></div></td>
						</c:forEach>

					</tr>
				</table>
			</div>
		</div>

	</div>
	<div class="">
		<table>
			<tr>
				<td  style="vertical-align: top;">
					<table>
						<tr>
							<td>
								<div class="ksjs">
									<div class="ksdh">
										<table width="235" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="25" height="25">&nbsp;</td>
												<td width="210" valign="bottom">科室介绍</td>
											</tr>
										</table>
									</div>
									<div class="ksnr">
									
										<table width="235" border="0" align="center" cellpadding="0"
											cellspacing="0">
											
											<tr>
												<c:forEach items="${ksjs }" var="ks" varStatus="idx">

													<td width="8%" height="27" align="center" valign="middle"><img
														src="<%=basePath%>views/web/images/wtuj.gif" width="12"
														height="12" style="padding-left: 10px;margin-right: 5px"/></td><td><div style="width:90px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis"> <a href="keshi.do?type=4&typeId=${ks.id }"
														class="ks" title="${ks.fName }">${ks.fName
															}</a></div></td>
													<c:if test="${idx.index%2==1 }">
											</tr>
											<tr>
												</c:if>
												</c:forEach>
											</tr>


										</table>
										
									</div>

								</div>
							</td>
						</tr>
						<tr>
							<td><div class="lianxi">
									<div class="lianxidh">
										<table width="217" height="37" border="0" cellspacing="0">
											<tr>
												<td width="37" height="37" align="center"><img
													src="<%=basePath%>views/web/images/xtp.gif" width="16"
													height="14" /></td>
												<td width="131">联系我们</td>
												<td width="43"><a href="#" target="_blank"><img
														src="<%=basePath%>views/web/images/more2.gif" width="43"
														height="19" border="0" /></a></td>
											</tr>
										</table>
									</div>
									<div class="lianxinr">
										<table width="227" border="0" align="center" cellspacing="0">
											<tr>
												<td width="54" height="83" rowspan="7">&nbsp;</td>
												<td width="19" height="25" align="center" valign="middle"><img
													src="<%=basePath%>views/web/images/lxjt.gif" width="5"
													height="5" /></td>
												<td height="25" colspan="2" valign="middle"><span
													class="STYLE2">丘北县人民医院</span></td>
											</tr>
											<tr>
												<td height="29" align="center" valign="middle"><img
													src="<%=basePath%>views/web/images/lxjt.gif" width="5"
													height="5" /></td>
												<td height="29" colspan="2" valign="middle">电话：0876-4121447</td>
											</tr>
											<tr>
												<td height="24" align="center" valign="middle"><img
													src="<%=basePath%>views/web/images/lxjt.gif" width="5"
													height="5" /></td>
												<td height="24" colspan="2" valign="middle">地址：云南省文山壮族苗</td>
											</tr>
											<tr>
												<td height="20" align="center" valign="middle">&nbsp;</td>
												<td height="24" colspan="2" valign="middle">族自治州丘北县锦屏镇石</td>
											</tr>
											<tr>
												<td height="15" align="center" valign="middle">&nbsp;</td>
												<td height="24" colspan="2" valign="middle">缸坝普碳路旁</td>
											</tr>
											<tr>
												<td height="29" align="center" valign="middle"><img
													src="<%=basePath%>views/web/images/lxjt.gif" width="5"
													height="5" /></td>
												<td height="29" colspan="2" valign="middle">邮箱：qbrmyy@126.com</td>
											</tr>
											<tr>
												<td height="36" align="center" valign="middle"><a
													href="#" target="_blank"></a><a href="#" target="_blank"></a></td>
												<td width="71" height="36" align="center" valign="middle"><a
													href="zxly.do"><img
														src="<%=basePath%>views/web/images/anniu.gif" width="72"
														height="29" border="0" /></a></td>
												<td width="75" height="36" align="center" valign="middle"><a
													href="tousu.do"><img
														src="<%=basePath%>views/web/images/anniu2.gif" width="72"
														height="29" border="0" /></a></td>
											</tr>
										</table>
									</div>

								</div></td>
						</tr>
					</table>
				</td>
				<td style="vertical-align: top;">
					<table style="height: 100%">
						<tr>
							<td  style="height: 33%">
							<div class="jiankan-z">
									<div class="gzdh">
										<table width="431" border="0" cellspacing="0" height=100%>
											<tr>
												<td width="54" height="34" align="center"><img
													src="<%=basePath%>views/web/images/laba.gif" width="38"
													height="29" /></td>
												<td width="304" valign="middle">信息公告</td>
												<td width="67" valign="middle"><a
													href="<%=basePath%>zxzxnews.do?type=51" target="_blank"><img
														src="<%=basePath%>views/web/images/more3.gif" width="40"
														height="11" border="0" /></a></td>
											</tr>
										</table>
									</div>
									<div class="gzdhnr">
										<div class="lanmu">
										<table width="100%">
										<c:forEach items="${xxgg}" var="g" begin="0" end="7">
										<tr>
										<td width="5%" height="25" align="center">
										<img src="<%=basePath%>views/web/images/jg_icon1.gif">
										</td>
										<td width="70%">
										<div style="width:280px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis"><a href="<%=basePath%>showZxzxNews.do?id=${g.id}"  title="${g.fTitle }">${g.fTitle
															}</a></div>
										</td>
										<td align="right">
										<fmt:formatDate value="${g.ffbTime}"
															pattern="yyyy-MM-dd" />
										</td>
										</tr>
										</c:forEach>
										</table>
											
										</div>

									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td style="height: 33%"><div class="jiankan-z2">
									<div class="gzdh">
										<table width="431" border="0" cellspacing="0">
											<tr>
												<td width="54" height="34" align="center"><img
													src="<%=basePath%>views/web/images/zwbz.gif" width="24"
													height="20" /></td>
												<td width="304" valign="middle">信息公开</td>
												<td width="67" valign="middle"><a
													href="<%=basePath%>zxzxnews.do?type=6" target="_blank"><img
														src="<%=basePath%>views/web/images/more3.gif" width="40"
														height="11" border="0" /></a></td>
											</tr>
										</table>
									</div>
									<div class="gzdhnrz2">
										<div class="lanmu">
											<table width="100%">
												<c:forEach items="${xxgk}" var="gk" begin="0" end="7">
												<tr>
												<td width="5%" height="25" align="center">
												<img
													src="<%=basePath%>views/web/images/jg_icon1.gif"  />
												</td>
												<td width="70%">
												<div style="width:280px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis"><a
														href="<%=basePath%>showZxzxNews.do?id=${gk.id}" title="${gk.fTitle }">${gk.fTitle
															}</a></div>
												</td>
												<td align="right">
												<fmt:formatDate value="${gk.ffbTime}"
															pattern="yyyy-MM-dd" />
												</td>
												</tr>
												</c:forEach>
											</table>
										</div>

									</div>
								</div></td>
						</tr>
						<tr>
							<td style="height: 33%"><div class="jiankan-z3">
									<div class="gzdh">
										<table width="431" border="0" cellspacing="0">
											<tr>
												<td width="54" height="34" align="center"><img
													src="<%=basePath%>views/web/images/zwbz.gif" width="24"
													height="20" /></td>
												<td width="304" valign="middle">健康之苑</td>
												<td width="67" valign="middle"><a
													href="<%=basePath%>zxzxnews.do?type=7" target="_blank"><img
														src="<%=basePath%>views/web/images/more3.gif" width="40"
														height="11" border="0" /></a></td>
											</tr>
										</table>
									</div>
									<div class="gzdhnrz2">
										<div class="lanmu">
											<table width="100%">									
												<c:forEach items="${jkzy}" var="jk" begin="0" end="7">
													<tr>
													<td width="5%" height="25" align="center">
													<img
													src="<%=basePath%>views/web/images/jg_icon1.gif"  />
													</td>
													<td width="70%"><div style="width:280px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis">
													<a
														href="<%=basePath%>showZxzxNews.do?id=${jk.id}" title="${jk.fTitle }">${jk.fTitle
															}</a></div>
													</td>
													<td align="right">
													<fmt:formatDate value="${jk.ffbTime}"
															pattern="yyyy-MM-dd" />
													</td>
													</tr>
												</c:forEach>

											</table>
										</div>

									</div>
								</div></td>
						</tr>
					</table>
				</td>
				<td  style="vertical-align: top;">
				<div class="kepu">
						<div class="zjnwdaohang">
							<table width="272" border="0" cellspacing="0">
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

						<div class="zjnwnrzong">
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

					</div></td>
			</tr>
		</table>


	</div>
	<div class="youqingw">
		<div class="yqdhw">
			<table width="215" border="0" cellspacing="0">
				<tr>
					<td width="9" height="27">&nbsp;</td>
					<td width="23" align="center">&nbsp;</td>
					<td width="177" valign="bottom">医疗机构链接</td>
				</tr>
			</table>
		</div>
		<div class="qynrw">
			<table width="968" border="0" cellspacing="0">
				<tr>
					<c:forEach items="${yylink }" var="lk" varStatus="idx">
						<c:if test="${idx.index%5==0 }">
				</tr>
				<tr>
					</c:if>
					<td width="20%" height="40" align="center" valign="middle"><a
						href="${lk.fLinkAddress }" class="ks" target="_blank">${lk.fName
							}</a></td>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>

</div>
<jsp:include page="inc/foot.jsp" />

</body>
</html>