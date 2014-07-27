<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理界面</title>
<link href="css/yh.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	background-image:url("<%=basePath%>views/admin/images/logo.png");
	background-repeat:no-repeat;
	background-color:#E6E6FF;
	width: 100%;
	height: 100%;
	
}
</style>
</head>
<body >
   
  <table width="100%" height="100%" border="0" align="center" cellspacing="0" >

    <tr>
      <td align="center" >
      <div class="qb-nerong">
      <table width="580" height="436" border="0" align="center" cellspacing="0">
       <tr><th align="center">&nbsp;</th></tr>
        <tr>
          <td width="569" height="429" align="left" valign="top" ><p>&nbsp;&nbsp;</p>
              <p>&nbsp;</p>
            <p>&nbsp;</p>      
             <p>&nbsp;</p>
            <p>&nbsp;</p>   
             <p>&nbsp;</p>
            <p>&nbsp;</p>           
              <table width="458" border="0" align="center" cellspacing="0">
                  
                <tr>
                  <td width="140" height="253" rowspan="2">&nbsp;</td>
                  <td width="314" height="102" align=center>&nbsp;&nbsp;&nbsp;<font size="12px"></font></td>
                </tr>
               
                <tr>
                  <td height="141"><table width="382" height="153" border="0" 
            align="center" cellpadding="0" cellspacing="0">
                    <tbody>
                      <tr>
                        <td height="153">
                       <form 
                  action="<%=basePath %>j_spring_security_check" method="post" name="form1" id="form1">                            <table height="146" align="center">
                              <tbody>
                                <tr>
                                  <td height="28"><span class="STYLE1">用户名：</span> </td>
                                  <td><input width="110" height="25" type="text"  name="j_username" size="18"/>
                                  </td>
                                </tr>
                                <tr>
                                  <td height="28" class="STYLE1">密 码： </td>
                                  <td><input width="110" height="25" type="password"  name="j_password" size="19.8"/>
                                  </td>
                                </tr>
                     
                                <tr>
                                  <td height="47" colspan="2" align="center"><input name="button" type="button" class="boxttx" value="提交" onclick="check()"/>                                    &nbsp;&nbsp;
                                    <input name="reset" type="reset" class="boxttx" " value="重置" />
                                  &nbsp;&nbsp;</td>
                                </tr>
                              </tbody>
                            </table>
                        </form></td>
                      </tr>
                    </tbody>
                  </table></td>
                </tr>
              </table>            
          <p>&nbsp;</p></td>
        </tr>
        
      </table></div></td>
    </tr>
</table>
</body>
<script type="text/javascript">
	var message="${message}";
	if(message!=null&&message!=""){
		alert(message);
	}

function check(){
	var form1=document.getElementsByName("form1")[0];
	if(form1.j_username.value==""){
		alert("用户名不能为空!");
		return ;
	}
	
	if(form1.j_password.value==""){
		alert("密码不能为空!");
		return ;
	}
	
	form1.submit();
}

function rest(){
	form1.j_username.value="";
	form1.j_password.value="";
}
</script>
</html>
