package net.xqx.controller.admin;



import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.admin.GgwDao;

import net.xqx.models.Tggw;
import net.xqx.util.PageString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class GgwController {
	@Autowired
	GgwDao ggwdao;
	
	//添加广告位
		@RequestMapping("/saveggw")
		public String saveGgw(HttpServletRequest request ,@ModelAttribute Tggw ggw){
			ggwdao.save(ggw);
			return "redirect:ggwlist.do";
		}
		
	//列表
		@RequestMapping("/ggwlist")
		public String ggwList(HttpServletRequest request,Model m){
			String p = request.getParameter("page");
			Integer page = 0;
			if (p != null && !"".equals(p)) {
				page = Integer.parseInt(p);
			}
			Pageable pageable = new PageRequest(page, 15);
			Page<Tggw> ggwpage = ggwdao.findAll(pageable);
			m.addAttribute("ggwlist",ggwpage.getContent());
			String pagestring = PageString.getPageString(ggwpage,
					"ggwlist.do", page);
			request.setAttribute("pagestring", pagestring);
			return "admin/ggw/ggwlist";
		}
		//添加广告位
		@RequestMapping("/deleteggw")
		public String deleteGgw(HttpServletRequest request ){
			Long id = Long.valueOf(request.getParameter("id"));
			ggwdao.delete(id);
			return "redirect:ggwlist.do";
		}
		
		//获单条信息
		@RequestMapping("/showggw")
		public String showggwNews(HttpServletRequest request,Model m){
			Long id = Long.valueOf(request.getParameter("id"));
			Tggw ggw = ggwdao.findOne(id);
			m.addAttribute("ggw",ggw);
			return "admin/ggw/editggw";
		}
}
