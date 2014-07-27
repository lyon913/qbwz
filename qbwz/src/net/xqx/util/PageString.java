package net.xqx.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.data.domain.Page;

public class PageString {
	/**
	 * 不带参数条件的分页函数（使用JPA）
	 * @param page Jpa Page对象
	 * @return 分页字符串
	 */
	public static String getPageString(Page page,String forword,int pagenum){
		StringBuffer str =new StringBuffer("");
		str.append("<div class='yema'>  <table width='717' height='39' border='0' align='center' cellpadding='0' cellspacing='0'><tr>"
				);
		str.append("<td height='39' align='center'><span style='WIDTH: 100%'>共计：<font color='#ff0000'>"+page.getTotalPages()+"</font>");
		if(page.getTotalPages()==0){
			str.append("&nbsp;&nbsp;&nbsp;分页：<font color='#ff0000'>0/"+page.getTotalPages()+"</font>&nbsp;&nbsp; ");
		}else{
			str.append("&nbsp;&nbsp;&nbsp;分页：<font color='#ff0000'>"+(page.getNumber()+1)+"/"+page.getTotalPages()+"</font>&nbsp;&nbsp; ");
		}
			str.append(""+"【<a href='"+forword+"?page=0'"+">第一页</a>&nbsp;&nbsp;");
		if(page.hasPreviousPage()){
			str.append("<a href='"+forword+"?page="+(pagenum-1)+"'"+">上一页&nbsp;&nbsp;</a>");
		}else{
			str.append("上一页&nbsp;&nbsp;");
		}
		if(page.hasNextPage()){
			str.append("<a href='"+forword+"?page="+(pagenum+1)+"'"+">下一页</a>&nbsp;&nbsp;");
		}else{
			str.append("下一页&nbsp;&nbsp;");
		}
		if(page.getTotalPages()>1){
			str.append("<a href='"+forword+"?page="+(page.getTotalPages()-1)+"'"+">最后页 </a>】");	
		}
		else{
			str.append("<a href='"+forword+"?page=0'>最后页</a>】");
		}
		str.append("<select onchange='location=this.value;'name='pageSe'>");
		if(page.getTotalPages()==1){
			str.append("<option value='?page=0' selected='selected'>1</option>");
		}else{
			for(int i = 0;i<page.getTotalPages();i++){
				if(i== pagenum){
					str.append("<option value='?page="+i+"' selected='selected'>"+(i+1)+"</option>");
				}else{
					str.append("<option value='?page="+i+"' >"+(i+1)+"</option>");
				}
				
			}
		}
		str.append("</select></span></td></tr></table></div>");
		return str.toString();
	}
	/**
	 * 不带参数条件的分页函数（使用JPA）
	 * @param page Jpa Page对象
	 * @return 分页字符串
	 */
	public static String getPageStringParas(Page page,String forword,int pagenum,Map<String,String> paras){
		String paradd = "?";
		StringBuffer str =new StringBuffer("");
			Set keyset = paras.entrySet();
			Iterator iter =keyset.iterator();
			str.append("<form action='SXmXX.do' method='post' id='f1'>");
			while(iter.hasNext()){
				Entry entry = (Entry) iter.next();
				String key = (String) entry.getKey();
				String value = (String) entry.getValue();
				str.append("<input type='hidden' name='"+key+"' value='"+value+ "'  />");
			} 
			str.append("<input type='hidden' name='page' value='0' id='page'/>");
			str.append("</form>");
		str.append("<div class='yema'>  <table width='570' height='35' border='0' align='center' cellpadding='0' cellspacing='0'><tr>"
				);
		str.append("<td height='35' align='center'><span style='WIDTH: 100%'>共计：<font color='#ff0000'>"+page.getTotalPages()+"</font>");
		if(page.getTotalPages()==0){
			str.append("&nbsp;&nbsp;&nbsp;分页：<font color='#ff0000'>0/"+page.getTotalPages()+"</font>&nbsp;&nbsp; ");
		}else{
			str.append("&nbsp;&nbsp;&nbsp;分页：<font color='#ff0000'>"+(page.getNumber()+1)+"/"+page.getTotalPages()+"</font>&nbsp;&nbsp; ");
		}
			str.append("【"+"<a href='javascript:to(0)'"+">第一页</a>&nbsp;&nbsp;");
		if(page.hasPreviousPage()){
			str.append("<a href='javascript:to("+(pagenum-1)+")'"+">上一页&nbsp;&nbsp;</a>");
		}else{
			str.append("上一页&nbsp;&nbsp;");
		}
		if(page.hasNextPage()){
			str.append("<a href='javascript:to("+(pagenum+1)+")'"+">下一页</a>");
		}else{
			str.append("下一页&nbsp;&nbsp;");
		}
		if(page.getTotalPages()!=1){
			str.append("<a href='javascript:to("+(page.getTotalPages()-1)+")'"+">最后页 </a>】");
		}else{
			str.append("<a href='javascript:to(0)'>最后页</a>】");
		}
		str.append("<select onchange='location=this.value;'name='pageSe'>");
		if(page.getTotalPages()==1){
			str.append("<option value='?page=0' selected='selected'>1</option>");
		}else{
			for(int i = 0;i<page.getTotalPages();i++){
				if(i== pagenum){
					str.append("<option value='?page="+i+"' selected='selected'>"+(i+1)+"</option>");
				}else{
					str.append("<option value='?page="+i+"' >"+(i+1)+"</option>");
				}
				
			}
		}
		str.append("</select></span></td></tr></table></div>");
		str.append("<script type='text/javascript'>");
		str.append("function to(page){");
		str.append("document.getElementById('page').value=page;");
		str.append("f1.submit();");
		str.append("}</script>");
		return str.toString();
	}
	
	
	/**
	 * siyi改写
	 * 不带参数条件的分页函数（使用JPA）
	 * @param page Jpa Page对象
	 * @return 分页字符串
	 */
	public static String getPageString(Page page,String forword,String param,int pagenum){
		StringBuffer str =new StringBuffer("");
		str.append("<div class='yema'>  <table width='717' height='39' border='0' align='center' cellpadding='0' cellspacing='0'><tr>"
				);
		str.append("<td height='39' align='center'><span style='WIDTH: 100%'>共计：<font color='#ff0000'>"+page.getTotalPages()+"</font>");
		if(page.getTotalPages()==0){
			str.append("&nbsp;&nbsp;&nbsp;分页：<font color='#ff0000'>0/"+page.getTotalPages()+"</font>&nbsp;&nbsp; ");
		}else{
			str.append("&nbsp;&nbsp;&nbsp;分页：<font color='#ff0000'>"+(page.getNumber()+1)+"/"+page.getTotalPages()+"</font>&nbsp;&nbsp; ");
		}
			str.append(""+"【<a href='"+forword+"?page=0"+param+"'"+">第一页</a>&nbsp;&nbsp;");
		if(page.hasPreviousPage()){
			str.append("<a href='"+forword+"?page="+(pagenum-1)+param+"'"+">上一页&nbsp;&nbsp;</a>");
		}else{
			str.append("上一页&nbsp;&nbsp;");
		}
		if(page.hasNextPage()){
			str.append("<a href='"+forword+"?page="+(pagenum+1)+param+"'"+">下一页</a>&nbsp;&nbsp;");
		}else{
			str.append("下一页&nbsp;&nbsp;");
		}
		if(page.getTotalPages()>1){
			str.append("<a href='"+forword+"?page="+(page.getTotalPages()-1)+param+"'"+">最后页 </a>】");	
		}
		else{
			str.append("<a href='"+forword+"?page=0"+param+"'>最后页</a>】");
		}
		str.append("<select onchange='location=this.value;'name='pageSe'>");
		if(page.getTotalPages()==1){
			str.append("<option value='?page=0+"+param+"' selected='selected'>1</option>");
		}else{
			for(int i = 0;i<page.getTotalPages();i++){
				if(i== pagenum){
					str.append("<option value='?page="+i+param+"' selected='selected'>"+(i+1)+"</option>");
				}else{
					str.append("<option value='?page="+i+param+"' >"+(i+1)+"</option>");
				}
				
			}
		}
		str.append("</select></span></td></tr></table></div>");
		return str.toString();
	}
}
