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
<script type="text/javascript" charset="utf-8" src="<%=basePath%>views/admin/js/jquery.js"></script>
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
<script type="text/javascript" charset="utf-8" src="<%=basePath%>views/admin/js/canlend.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>views/admin/KingDeditor/kindeditor.js"></script>
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
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|','image','insertfile']
				});
			});
		</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻中心</title>
</head>
<body>
	<!-- 引入属性文件 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="17" valign="top" background="<%=basePath%>views/admin/images/mail_leftbg.gif"><img src="<%=basePath%>views/admin/images/left-top-right.gif" width="17" height="29" /></td>
			<td valign="top" background="<%=basePath%>views/admin/images/content-bg.gif">
				<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">新闻中心</div></td>
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
						<td width="99%" background="<%=basePath%>views/admin/images/news-title-bg.gif" class="left_bt2" style="padding-left: 1px;">新闻发布</td>
					</tr>
					<tr>
						<td height="102" colspan="2" valign="top" style="font-size: 13px;">
							<!-- 表单开始 --> <!-- 程序在循环控制的时候，如果是单数那么就显示第一个tr，如果是双数就显示第二个tr -->
							<form name="form1" method="POST" action="<%=basePath%>admin/saveNews.do" enctype="multipart/form-data">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" align="right" bgcolor="#f2f2f2">标题：</td>
										<td bgcolor="#f2f2f2">&nbsp;</td>
										<td height="30" bgcolor="#f2f2f2"><input name="fTitle" type="text" size="111" /><font color="red">*</font></td>
									</tr>
										<tr>
										<td height="30" align="right" bgcolor="#f2f2f2">所属分类：</td>
										<td height="30" bgcolor="#f2f2f2" colspan="2">
											<!-- 主分类 --> <select name="flxFirst.id" id="flxFirst" onchange="getSecend(this.value),show(this.value)" style="width: 90px;">
												<c:forEach items="${propertys}" var="property">
												<c:if test="${property.id==lxfirst }">
													<option value="${property.id}" selected="selected">${property.fValue}</option>
												</c:if>
												<c:if test="${property.id!=lxfirst }">
													<option value="${property.id}" >${property.fValue}</option>
												</c:if>
												</c:forEach>
										</select> <!-- 子分类 --> <select name="flxSecond.id" id="flxSecond" style="width: 90px;">
										</select>
										</td>
									</tr>
									<tr>
										<td height="30" align="right" bgcolor="#f2f2f2">顺序：</td>
										<td bgcolor="#f2f2f2">&nbsp;</td>
										<td height="30" bgcolor="#f2f2f2"><input name="fSort" type="text" size="15"  value="1"/><font color="red">*</font>数字越大越排在前面</td>
									</tr>
								
									<tr>
										<td height="30" align="right" class="left_txt2">内容：</td>
										<td bgcolor="#f2f2f2">&nbsp;</td>
										<td height="30"><textarea name="fContent"></textarea><font color="red">*</font></td>
									</tr>
									<tr>
										<td height="30" align="right" class="left_txt2">效果图：</td>
										<td bgcolor="#f2f2f2">&nbsp;</td>
										<td height="30"><input type="file" name="newsPic" /></td>
									</tr>
									<tr>
										<td height="30" align="right" bgcolor="#f2f2f2">来源：</td>
										<td bgcolor="#f2f2f2">&nbsp;</td>
										<td height="30" bgcolor="#f2f2f2"><input name="fly" type="text" size="15" /><font color="red">*</font></td>
									</tr>
									<tr>
										<td height="30" align="right" class="left_txt2">作者：</td>
										<td>&nbsp;</td>
										<td height="30"><input type="text" size="15" name="fAuth" /><font color="red">*</font></td>
									</tr>
								
									<tr id="law1" style="display: none;">
										<td height="30" align="right" class="left_txt2">发布文号：</td>
										<td>&nbsp;</td>
										<td height="30"><input type="text" size="15" name="fDocumentNo" /></td>
									</tr>
									<tr id="law2" style="display: none;">
									<td height="30" align="right" class="left_txt2">生效日期：</td>
									<td>&nbsp;</td>
									<td height="30"><input name="fBeginValidDate" readonly="readonly" type="text" size="14" onclick="new Calendar('1950', '2100', 0,'yyyy-MM-dd hh:mm:ss').show(fBeginValidDate);" /></td>
									</tr>
									<tr id="law3" style="display: none;">
									<td height="30" align="right" class="left_txt2">失效日期：</td>
									<td>&nbsp;</td>
									<td height="30"><input name="fEndValidDate" readonly="readonly" type="text" size="14" onclick="new Calendar('1950', '2100', 0,'yyyy-MM-dd hh:mm:ss').show(fEndValidDate);" /></td>
									</tr>
									<tr id="law4" style="display: none;">
									<td height="30" align="right" class="left_txt2">发布机关：</td>
									<td>&nbsp;</td>
									<td height="30"><input type="text" size="15" name="fPublishOrganization" /></td>
									</tr>
									<tr id="law5" style="display: none;">
									<td height="30" align="right" class="left_txt2">文件类型：</td>
									<td>&nbsp;</td>
									<td height="30"><input type="text" size="15" name="fDocumentType" /></td>
									</tr>
									<tr>
										<td height="30" align="right" class="left_txt2">关键字：</td>
										<td>&nbsp;</td>
										<td height="30"><input type="text" size="15" name="fKeyWord" /><font color="red">*注意：该字段请使用“，”“|”等分隔多个关键字。如：云南|丘北，科室介绍</font></td>
									</tr>
								</table>
							</form> <!-- 表单结束 -->
						</td>
					</tr>

					<!-- 按钮开始 -->
					<tr style="font-size: 13px;">
						<td colspan="2" align="center" style="padding-right: 15px;"><input type="button" value="提&nbsp;&nbsp;交" onclick="check()" /></td>
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
function show(value)
{
	var law1 = document.getElementById("law1");
	var law2 = document.getElementById("law2");
	var law3 = document.getElementById("law3");
	var law4 = document.getElementById("law4");
	var law5 = document.getElementById("law5");

	law1.style.display = "none";
	law2.style.display = "none";
	law3.style.display = "none";
	law4.style.display = "none";
	law5.style.display = "none";
	
	if (value == "3")
	{
		law1.style.display = "";
		law2.style.display = "";
		law3.style.display = "";
		law4.style.display = "";
		law5.style.display = "";
	}

}
		function check(){
			if(form1.fTitle.value==""){
				alert("标题不能为空!");
				return ;
			}
			
			if(form1.fContent.value==""){
				alert("简介内容不能为空!");
				return ;
			}
			
			if(form1.fly.value==""){
				alert("来源不能为空!");
				return ;
			}
			
			if(form1.fAuth.value==""){
				alert("作者不能为空!");
				return ;
			}
			
			if(form1.fKeyWord.value==""){
				alert("关键字不能为空!");
				return ;
			}
			
			form1.submit();
		}
</script>
<script type="text/javascript">
var message="${message}";
if(message!=null&&message!=""&&message!="null"){
	alert(message);
}

var flxSecond=form1.flxFirst.value;
if(flxSecond!=null&&flxSecond!="")
{	
	getSecend(flxSecond);
}

function getSecend(id)
{	
	var fSecendId="${lxsecond}";
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
								.append("<option value='-1'>暂无分类</option>");
					}
				}
			});
		}
	};
</script>
</html>

