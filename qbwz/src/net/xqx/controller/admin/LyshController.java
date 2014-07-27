package net.xqx.controller.admin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.admin.TPropertyDao;
import net.xqx.dao.admin.TlyhfNewsDao;
import net.xqx.dao.admin.TlyshNewsDao;
import net.xqx.models.TlyNews;
import net.xqx.models.TlyhfNews;
import net.xqx.util.PageString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 留言审核
 * @author siyi
 *
 */
@Controller
@RequestMapping("/admin")
public class LyshController{
	
	@Autowired
	TPropertyDao propertyDao;
	
	@Autowired
	TlyshNewsDao lyshNewsDao;
	
	@Autowired
	TlyhfNewsDao lyhfNewsDao;
	
	
	
	
	/**
	 * 返回审核页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/examineLyshNewsUI")
	public String examineLyshNewsUI(HttpServletRequest request){
		//根据id查询记录
		String id=request.getParameter("id");
		TlyNews zyrcNews=null;
		if(id!=null&&!"".equals(id)){
			zyrcNews=lyshNewsDao.findOne(Long.parseLong(id));
			request.setAttribute("news", zyrcNews);
		}
		return "admin/lysh/examineLyshNews";
	}
	
	/**
	 * 处理审核
	 * @param request
	 * @return
	 */
	@RequestMapping("/examineLyshNews")
	public String examineLyshNews(HttpServletRequest request){
		//根据id查询记录
		String id=request.getParameter("id");
		String isPass=request.getParameter("isPass");
		TlyNews zyrcNews=null;
		if(id!=null&&!"".equals(id)){
			zyrcNews=lyshNewsDao.findOne(Long.parseLong(id));
			if(isPass!=null&&"1".equals(isPass)){
				zyrcNews.setfIsPass(1L);//设置通过
			}else{
				zyrcNews.setfIsPass(-1L);//设置不通过
			}
			
			lyshNewsDao.save(zyrcNews);
		}
			return "redirect:lyshNewsManage.do?message=3";
	}

	/**
	 * 查询没有审核通过或没有审核的协会信息
	 * @return
	 */
	@RequestMapping("/lyshNewsManage")
	public String zyrcNewsManage(HttpServletRequest request){
		String p = request.getParameter("page");
		Integer page = 0;
		if (p != null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		Sort sort = new Sort(Direction.DESC, "ffbTime");
		Pageable pageable = new PageRequest(page, 15, sort);
		Page<TlyNews> pageZyrcNews = lyshNewsDao.getLyshNews(pageable);
		String pagestring = PageString.getPageString(pageZyrcNews,
				"lyshNewsManage.do", page);
		request.setAttribute("pagestring", pagestring);
		request.setAttribute("newsList", pageZyrcNews.getContent());
		
		
		//消息出来
		String message=request.getParameter("message");
		if(message!=null&&!"".equals(message)){
			request.setAttribute("message", message);
		}
		
		return "admin/lysh/lyshNewsManage";
	}
	
	/**
	 * 查询审核通过协会信息
	 * @return
	 */
	@RequestMapping("/lyshNewsPassManage")
	public String lyshNewsPassManage(HttpServletRequest request){
		String p = request.getParameter("page");
		Integer page = 0;
		if (p != null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		Sort sort = new Sort(Direction.DESC, "ffbTime");
		Pageable pageable = new PageRequest(page, 15, sort);
		Page<TlyNews> pageXhzcNews = lyshNewsDao.getLyshNewsPass(pageable);
		String pagestring = PageString.getPageString(pageXhzcNews,
				"lyshNewsPassManage.do", page);
		request.setAttribute("pagestring", pagestring);
		request.setAttribute("newsList", pageXhzcNews.getContent());
		
		
		//消息出来
		String message=request.getParameter("message");
		if(message!=null&&!"".equals(message)){
			request.setAttribute("message", message);
		}
		
		return "admin/lysh/lyshNewsPassManage";
	}
	
	/**
	 * 返回留言回复页面
	 * @return
	 */
	@RequestMapping("/lyhfExamineUI")
	public String lyhfExamineUI(HttpServletRequest request){
		//根据id查询记录
		String id=request.getParameter("id");
		TlyNews zyrcNews=null;
		if(id!=null&&!"".equals(id)){
			zyrcNews=lyshNewsDao.findOne(Long.parseLong(id));
			request.setAttribute("news", zyrcNews);
		}
				
		return "admin/lysh/lyhfExamine";
	}
	
	/**
	 * 处理回复内容
	 * @param request
	 * @return
	 */
	@RequestMapping("/lyhfExamine")
	public String lyhfExamine(HttpServletRequest request,@ModelAttribute TlyhfNews tLyhfNews){
		//根据id查询记录
		tLyhfNews.setFhfTime(new Date());
		lyhfNewsDao.save(tLyhfNews);
		
		TlyNews lyNews=lyshNewsDao.findOne(tLyhfNews.getFlyId().getId());
		lyNews.setfIsPass(2L);//设置该调留言的状态为2，表示已回复
		lyshNewsDao.save(lyNews);
		return "redirect:lyshNewsPassManage.do";
	}
	
}
