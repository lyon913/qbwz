package net.xqx.controller.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.web.LyNewsDao;
import net.xqx.dao.web.PropertyDao;
import net.xqx.models.TProperty;
import net.xqx.models.TlyNews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 咨询留言
 * @author gwang
 *
 */

@Controller
public class ZxlyController {	
	
	@Autowired
	LyNewsDao lydao;
	
	/**
	 * 新闻
	 */
	@Autowired
	PropertyDao propertyDao;
	
	//咨询留言添加准备
	@RequestMapping("/zxly")
	public String zxly(HttpServletRequest request){
		//就医指南
		List<TProperty> jyzn=propertyDao.getPropertyByFid(2L);
		request.setAttribute("jyzn", jyzn);
		return "web/addzxly";
	}
	//添加留言
	@RequestMapping("/savely")
	public String saveZxly(HttpServletRequest request ,@ModelAttribute TlyNews tlynews){
		tlynews.setFdjTimes(0L);
		tlynews.setFfbTime(new Date());
		tlynews.setfIsPass(0L);
		tlynews.setfIp(request.getRemoteAddr());
		lydao.save(tlynews);
		return "redirect:ly.do?message=1";
	}
	//留言列表（公开）
	@RequestMapping("/lylist")
	public String zxlyList(HttpServletRequest request,Model m ){
		String p = request.getParameter("page");
		Integer page = 0;
		if (p != null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		Sort sort = new Sort(Direction.DESC, "ffbTime");
		Pageable pageable = new PageRequest(page, 15, sort);
		Page<TlyNews> lypage = lydao.findAll(pageable);
		m.addAttribute("lylist", lypage.getContent());
		return "web/lylist";
	}
}	
