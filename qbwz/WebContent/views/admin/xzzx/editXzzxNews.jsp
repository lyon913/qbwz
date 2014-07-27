<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=basePath%>views/admin/images/skin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
</style>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>views/admin/js/jquery.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>views/admin/KingDeditor/kindeditor.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>views/admin/js/canlend.js"></script>
<script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="fContent"]', {
					resizeType : 2,
					width: "700px",
					height:"300px",
					allowPreviewEmoticons : false,
					afterBlur: function(){
						this.sync();
					},
					uploadJson : '<%=basePath%>views/admin/KingDeditor/jsp/upload_json.jsp',
	                fileManagerJson : '<%=basePath%>views/admin/KingDeditor/jsp/file_manager_json.jsp',
									allowFileManager : true,
									allowImageUpload : true,
									items : [ 'fontname', 'fontsize', '|',
											'forecolor', 'bold', 'italic',
											'underline', 'removeformat', '|',
											'justifyleft', 'justifycenter',
											'justifyright',
											'insertorderedlist',
											'insertunorderedlist', '|',
											'image', 'insertfile' ]
								});
			});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载中心</title>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="17" valign="top" background="<%=basePath%>views/admin/images/mail_leftbg.gif"><img src="<%=basePath%>views/admin/images/left-top-right.gif" width="17" height="29" /></td>
			<td valign="top" background="<%=basePath%>views/admin/images/content-bg.gif">
				<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">下载中心</div></td>
					</tr>
				</table>
			</td>
			<td width="16" valign="top" background="<%=basePath%>views/admin/images/mail_rightbg.gif"><img src="<%=basePath%>views/admin/images/nav-right-bg.gif" width="16" height="29" /></td>
		</tr>
		<!-- 这里是中间代码 -->
		<tr>
			<!-- 左边的背景 -->
			<td valign="middle" background="<%=basePath%>views/admin/images/mail_leftbg.gif">&nbsp;</td>
			<!-- 中间的内容 -->
			<td valign="top" bgcolor="#F7F8F9" style="padding-top: 18px;">
				<table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
					<tr>
						<td width="1%" height="27" background="<%=basePath%>views/admin/images/news-title-bg.gif"><img src="<%=basePath%>views/admin/images/news-title-bg.gif" width="2" height="27"></td>
						<td width="99%" background="<%=basePath%>views/admin/images/news-title-bg.gif" class="left_bt2" style="padding-left: 1px;">修改下载信息</td>
					</tr>
					<tr>
						<td height="102" colspan="2" valign="top" style="font-size: 13px;">
							<!-- 表单开始 --> <!-- 程序在循环控制的时候，如果是单数那么就显示第一个tr，如果是双数就显示第二个tr -->
							<form name="form1" method="POST" action="<%=basePath%>admin/saveXzzx.do" enctype="multipart/form-data">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" align="right" bgcolor="#f2f2f2">资料名称：</td>
										<td bgcolor="#f2f2f2">&nbsp;</td>
										<td height="30" bgcolor="#f2f2f2"><input name="fTitle" value="${news.fTitle }" type="text" size="14" /></td>
										<td height="30" bgcolor="#f2f2f2" class="left_txt">填写资料的名称</td>
									</tr>
									<tr>
										<td height="30" align="right" class="left_txt2">资料描述：</td>
										<td bgcolor="#f2f2f2">&nbsp;</td>
										<td height="30"><textarea name="fContent">${news.fContent }</textarea></td>
										<td height="30" class="left_txt">填写资料的描述信息</td>
									</tr>
									<tr>
										<td height="30" align="right" bgcolor="#f2f2f2">关键字：</td>
										<td bgcolor="#f2f2f2">&nbsp;</td>
										<td height="30" bgcolor="#f2f2f2"><input name="fKeyWord" value="${news.fKeyWord }" type="text" size="15" /></td>
										<td height="30" bgcolor="#f2f2f2" class="left_txt">填写关键字</td>
									</tr>

									<!-- 文件信息 -->

									<tr>
										<td height="30" align="right" class="left_txt2">软件名称：</td>
										<td>&nbsp;</td>
										<td height="30"><input type="text" size="15" name="fFile.fName" value="${news.fFile.fName }" /></td>
										<td height="30" class="left_txt">填写软件的名称</td>
									</tr>
									<tr>
										<td height="30" align="right" bgcolor="#f2f2f2">软件语言：</td>
										<td bgcolor="#f2f2f2">&nbsp;</td>
										<td height="30" bgcolor="#f2f2f2"><input name="fFile.fLanguage" value="${news.fFile.fLanguage }" type="text" size="15" /></td>
										<td height="30" bgcolor="#f2f2f2" class="left_txt">软件语言</td>
									</tr>
									<tr>
										<td height="30" align="right" class="left_txt2">文件路径：</td>
										<td>&nbsp;</td>
										<td height="30"><input type="file" size="15" name="mFile" /> <c:if test="${!empty news.fFile.fDownloadAddress }">(已经上传了该软件)</c:if></td>
										<td height="30" class="left_txt">需要上传的文件</td>
									</tr>
									<tr>
										<td height="30" align="right" bgcolor="#f2f2f2">整理时间：</td>
										<td bgcolor="#f2f2f2">&nbsp;</td>
										<td height="30" bgcolor="#f2f2f2"><input name="fFile.fzlTime" id="fzlTime" value="${news.fFile.fzlTime}" onclick="new Calendar('1950', '2100', 0,'yyyy-MM-dd hh:mm:ss').show(fzlTime);"
											readonly="readonly" type="text" size="15" /></td>
										<td height="30" bgcolor="#f2f2f2" class="left_txt">软件上传时间</td>
									</tr>
									<tr>
										<td height="30" align="right" class="left_txt2">运行环境：</td>
										<td>&nbsp;</td>
										<td height="30"><input type="text" size="15" name="fFile.fyxEnvironment" value="${news.fFile.fyxEnvironment }" /></td>
										<td height="30" class="left_txt">填写软件适用的操作系统</td>
									</tr>
									<tr>
										<td height="30" align="right" bgcolor="#f2f2f2">软件大小：</td>
										<td bgcolor="#f2f2f2">&nbsp;</td>
										<td height="30" bgcolor="#f2f2f2"><input name="fFile.fSize" value="${news.fFile.fSize }" id="fSize" type="text" size="15" />M</td>
										<td height="30" bgcolor="#f2f2f2" class="left_txt">填写软件的大小</td>
									</tr>
									<tr>
										<td height="30" align="right" class="left_txt2">软件等级：</td>
										<td>&nbsp;</td>
										<td height="30"><select name="fFile.fGrade.id">
												<c:forEach items="${rjdjs}" var="rjdj">
													<c:if test="${rjdj.id==news.fFile.fGrade.id}">
														<option value="${rjdj.id}" selected="selected">${rjdj.fName}</option>
													</c:if>
													<c:if test="${rjdj.id!=news.fFile.fGrade.id}">
														<option value="${rjdj.id}">${rjdj.fName}</option>
													</c:if>
												</c:forEach>
										</select></td>
										<td height="30" class="left_txt">星级越高越出色</td>
									</tr>
									<tr>
										<td height="30" align="right" bgcolor="#f2f2f2">授权方式：</td>
										<td bgcolor="#f2f2f2">&nbsp;</td>
										<td height="30" bgcolor="#f2f2f2"><select name="fFile.fsqWay">
												<c:if test="${news.fFile.fsqWay==0 }">
													<option value="0" selected="selected">免费</option>
													<option value="1">收费</option>
												</c:if>
												<c:if test="${news.fFile.fsqWay==1 }">
													<option value="0">免费</option>
													<option value="1" selected="selected">收费</option>
												</c:if>
										</select></td>
										<td height="30" bgcolor="#f2f2f2" class="left_txt">填写软件授权方式</td>
									</tr>
									<tr>
										<td height="30" align="right" class="left_txt2">开发商：</td>
										<td>&nbsp;</td>
										<td height="30"><input type="text" name="fFile.fAuth" value="${news.fFile.fAuth }" /></td>
										<td height="30" class="left_txt">填写软件开发商</td>
									</tr>
									<tr>
										<td height="30" align="right" class="left_txt2" >所属类型：</td>
										<td>&nbsp;</td>
										<td height="30" bgcolor="#f2f2f2" colspan="2">
											<!-- 主分类 --> <select name="flxFirst.id" id="flxFirst" onchange="getSecend(this.value),show(this.value)" style="width: 90px;">
												<c:forEach items="${propertys}" var="property">
													<c:if test="${property.id==news.flxFirst.id}">
														<option value="${property.id}" selected="selected">${property.fValue}</option>
													</c:if>
													<c:if test="${property.id!=news.flxFirst.id}">
														<option value="${property.id}">${property.fValue}</option>
													</c:if>
												</c:forEach>
										</select> <!-- 子分类 --> <select name="flxSecond.id" id="flxSecond" style="width: 90px;">
										</select>
										</td>
										<!-- 
										<td height="30"><select name="flx.id">
												<c:forEach items="${flxs }" var="lx">
													<c:if test="${lx.id==news.flxFirst.id }">
														<option value="${lx.id}" selected="selected">${lx.fName}</option>
													</c:if>
													<c:if test="${lx.id!=news.flxSecond.id }">
														<option value="${lx.id}">${lx.fName}</option>
													</c:if>
												</c:forEach>
										</select></td>
										<td height="30" class="left_txt">所属类型</td>
										 -->
									</tr>
									<tr>
										<td height="30" align="right" bgcolor="#f2f2f2">软件简介：</td>
										<td bgcolor="#f2f2f2">&nbsp;</td>
										<td height="30" bgcolor="#f2f2f2"><textarea name="fFile.frjBrief" cols="55" rows="5">${news.fFile.frjBrief}</textarea></td>
										<td height="30" bgcolor="#f2f2f2" class="left_txt">软件描述</td>
									</tr>
									<!-- 文件信息结束 -->
								</table>
								<!-- 隐藏表单 -->
								<input type="hidden" value="${news.id}" name="id" /> <input type="hidden" value="${news.fFile.id}" name="fFile.id" />
								<!-- 文件信息隐藏表单 -->
								<input type="hidden" value="${news.fFile.fDownloadAddress}" name="fFile.fDownloadAddress" /> <input type="hidden" value="${news.fFile.fdownTimes}" name="fFile.fdownTimes" /> <input
									type="hidden" value="${news.fFile.fly}" name="fFile.fly" />
							</form> <!-- 表单结束 -->
						</td>
					</tr>

					<!-- 按钮开始 -->
					<tr style="font-size: 13px;">
						<td colspan="2" align="center" style="padding-right: 15px;"><input type="button" value="保&nbsp;&nbsp;存" onclick="check()" /></td>
					</tr>
					<!-- 按钮结束 -->

				</table>
			</td>
			<!-- 右边的背景 -->
			<td background="<%=basePath%>views/admin/images/mail_rightbg.gif">&nbsp;</td>
		</tr>
		<!-- 中间代码结束 -->
		<tr>
			<td valign="bottom" background="<%=basePath%>views/admin/images/mail_leftbg.gif"><img src="<%=basePath%>views/admin/images/buttom_left2.gif" width="17" height="17" /></td>
			<td background="<%=basePath%>views/admin/images/buttom_bgs.gif"><img src="<%=basePath%>views/admin/images/buttom_bgs.gif" width="17" height="17"></td>
			<td valign="bottom" background="<%=basePath%>views/admin/images/mail_rightbg.gif"><img src="<%=basePath%>views/admin/images/buttom_right2.gif" width="16" height="17" /></td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function check() {
		if (form1.fTitle.value == "") {
			alert("标题不能为空!");
			return;
		}

		var fAddress = "${news.fFile.fDownloadAddress}";
		if (form1.mFile.value == "" && fAddress == "") {
			alert("请选择上传文件!");
			return;
		}

		//软件大小
		var fSize = document.getElementById("fSize").value;
		if (fSize != "" && !isDouble(fSize)) {
			alert("软件大小只能是数字或小数!");
			return;
		}
		form1.submit();
	}

	//验证整数小数和0
	function isDouble(field) {
		var n = /^([1-9]\d*|0)(\.\d*[0-9])?$/;
		if (!n.test(field)) {
			return false;
		}
		return true;
	}
</script>
<script type="text/javascript">
	var message = "${message}";
	if (message != null && message != "" && message != "null") {
		alert(message);
	}
	var flxSecond=form1.flxFirst.value;
	if(flxSecond!=null&&flxSecond!="")
	{	
		getSecend(flxSecond);
	}
	function getSecend(id)
	{	
		var fSecendId="${news.flxSecond.id}";
		$("#flxSecond").empty();
		if(id!=null&&id!=""&&id!="null")
		{
			$.ajax({
				  type: "post",
				  url: "<%=basePath%>admin/getProperty.do?id=" + id,
					dataType : "json",
					sync : false,
					success : function(msg) {
						if (msg.length > 0) {

							for ( var i = 0; i < msg.length; i++) {
								if (msg[i].id == fSecendId) {
									$("#flxSecond").append(
											'<option value="'+msg[i].id+'" selected="selected">'
													+ msg[i].fValue + '</option>');
								} else {
									$("#flxSecond").append(
											'<option value="'+msg[i].id+'">'
													+ msg[i].fValue + '</option>');
								}
							}
						} else {
							$("#flxSecond")
									.append("<option value=''>暂无分类</option>");
						}
					}
				});
			}
		};
	
	
	
</script>
</html>

