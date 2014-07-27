package net.xqx.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.admin.TNewsDao;
import net.xqx.dao.admin.TPropertyDao;
import net.xqx.dao.web.ClassDao;
import net.xqx.models.TClass;
import net.xqx.models.TNews;
import net.xqx.models.TProperty;
import net.xqx.util.PageString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ClassController {

	
	@Autowired
	ClassDao classDao;
	@Autowired
	TNewsDao newsDao;
	@Autowired
	TPropertyDao propertyDao;
	/**
	 * 返回添加栏目页面
	 * @return
	 */
	@RequestMapping(value="/addClassUI")
	public String addClassUI(HttpServletRequest request){
		//查询所有栏目
		String topid = request.getParameter("topid");
		List<TClass> classes= classDao.findAll();
		request.setAttribute("classes", classes);
		request.setAttribute("topid", topid);
		return "admin/classManage/addClass";
	}
	
	/**
	 * 返回修改栏目页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/editClassUI")
	public String editClassUI(HttpServletRequest request){
		String classId=request.getParameter("classId");
		if(classId!=null&&!"".equals(classId)){
			TClass c=classDao.findOne(Long.parseLong(classId));
			request.setAttribute("c", c);
		}

		//查询所有栏目组
		List<TClass> classes= classDao.findAll();
		request.setAttribute("classes", classes);
				
		return "admin/classManage/editClass";
	}
	
	/**
	 * 查询栏目
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/classList")
	public String adminList(HttpServletRequest request){
		String p=request.getParameter("page");
		String topid = request.getParameter("topid");
		String ttopid = "0";
		String topclass = "";
		if(topid==null || "".equals(topid)){
			topid = "0";
		}
		if("0".equals(topid)){
			topclass="顶层栏目";
		}else{
		TClass a = classDao.findOne(Long.valueOf(topid));
		topclass = a.getfClassName();
		ttopid = Long.toString(a.getFid());
		}
		Integer page=0;
		if(p!=null&&!"".equals(p)){
			page = Integer.parseInt(p);
		}
		Pageable pageable = new PageRequest(page,15);
		Page<TClass> classes= classDao.getClassesByTopid(Long.parseLong(topid), pageable);
		String pagestring = PageString.getPageString(classes, "classList.do", "&topid="+topid, page);
				//getPageString(classes, "classList.do", page);
		request.setAttribute("pagestring", pagestring);
		request.setAttribute("classList", classes.getContent());
		String message=request.getParameter("message");
		request.setAttribute("message", message);
		request.setAttribute("topclass", topclass);//上级栏目的名称
		request.setAttribute("ttopid", ttopid);//上级栏目的上级栏目，用在返回的链接中。
		request.setAttribute("topid", topid);//上级栏目
		return "admin/classManage/classList";
	}
	
	/**
	 * 添加栏目
	 * @param request
	 * @param tclass
	 * @return
	 */
	@RequestMapping(value="/addClass")
	public String addClass(HttpServletRequest request,@ModelAttribute TClass tclass){
		String fClassName = request.getParameter("fClassName");
		//String fClassMemo = request.getParameter("fClassMemo");
		String fLink = request.getParameter("fLink");
		String fid = request.getParameter("fid");
		String fSortFlag = request.getParameter("fSortFlag");
		
		if(fid==null&&"".equals(fid)){
			fid = "0";
		}
		
		
		TClass c = new TClass();
		
		c.setfClassMemo(fClassName);
		c.setfClassName(fClassName);
		c.setfLink(fLink);
		c.setFid(Long.valueOf(fid));
		c.setfSortFlag(Long.valueOf(fSortFlag));
		classDao.save(c);
		
		return "redirect:classList.do?topid="+fid+"&message=3";
	}
	
	/**
	 * 删除栏目
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delClass")
	public String delClass(HttpServletRequest request){
		String classId=request.getParameter("classId");
		String fid=request.getParameter("fid");
		if(classId!=null&&!"".equals(classId)){
			classDao.delete(Long.parseLong(classId));
		}
		return "redirect:classList.do?topid="+fid+"&message=2";
	}
	
	/**
	 * 修改栏目
	 * @param request
	 * @param admin
	 * @return
	 */
	@RequestMapping(value="/editClass")
	public String editClass(HttpServletRequest request,@ModelAttribute TClass tclass){	
		String fClassName = request.getParameter("fClassName");
		//String fClassMemo = request.getParameter("fClassMemo");
		String fLink = request.getParameter("fLink");
		String fid = request.getParameter("fid");
		String fSortFlag = request.getParameter("fSortFlag");
		String cid = request.getParameter("cid");
		if(fid==null&&"".equals(fid)){
			fid = "0";
		}
		if(cid==null&&"".equals(cid)){
			cid = "0";
		}
		
		
		
		TClass c = new TClass();
		c = classDao.findOne(Long.valueOf(cid));
		c.setfClassMemo(fClassName);
		c.setfClassName(fClassName);
		c.setfLink(fLink);
		c.setFid(Long.valueOf(fid));
		c.setfSortFlag(Long.valueOf(fSortFlag));
		classDao.save(c);
		return "redirect:classList.do?topid="+fid+"&message=3";
	}
	
	
}
