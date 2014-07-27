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
<form action="<%=basePath%>savely.do" method="post" id="form1">
  <table width="100%" height="379" border="0" align="center" cellpadding="3" cellspacing="0">    
  <tbody>
          <tr>
        <td width="40%" height="30" align="center">标题：</td>
        <td width="60%" height="30" align="left"><input type="text" name="fTitle" size="60"/>
          <font color="red">*</font></td>
      </tr>
      <tr>
        <td align="center">您的称呼：</td>
        <td  height="30" align="left"><input type="text" name="fNick" size="60"/>
          <font color="red">*</font></td>
      </tr>
      <tr>
        <td align="center">联系电话：</td>
        <td height="27" align="left"><input type="text" name="fContact" size="60"/>
         <font color="red">*</font> </td>
      </tr>
      <tr>
        <td align="center">电子邮箱：</td>
        <td height="27" align="left"><input type="text" name="fEmail" size="60"/>
        <font color="red">*</font></td>
      </tr>
	  
	     <tr>
        <td height="187" align="center">内容：</td>
        <td align="left"><textarea rows="10" cols="45" name="fContent"></textarea>
          <font color="red">*</font>（请填写您的留言内容！）</td>
      </tr>
      
      <tr>
        <td height="32" colspan="2" align="center"><input name="button" type="button" onclick="check();" value="发表留言" />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input name="reset" type="reset"  onclick="clear()" value="清除留言" />        </td>
      </tr>
	  	       
    </tbody>
  </table>
  </form>
  </div>
</div>
 </div>
 </div>
<div id="foot">
	<iframe src="<%=basePath%>views/web/inc/foot.jsp" width="968"
		height="215" scrolling="no" frameborder="0"></iframe>
</div>

<script type="text/javascript">
		function check(){
			if(form1.fTitle.value==""){
				alert("标题不能为空!");
				return ;
			}
			
			if(form1.fNick.value==""){
				alert("称呼不能为空!");
				return ;
			}
			
			if(form1.fContact.value==""){
				alert("联系电话不能为空!");
				return ;
			}
			if(form1.fEmail.value==""){
				alert("邮箱不能为空!");
				return ;
			}
			
			if(form1.fContent.value==""){
				alert("内容不能为空!");
				return ;
			}

			form1.submit();
		}
</script>
