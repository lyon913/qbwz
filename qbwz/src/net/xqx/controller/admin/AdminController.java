package net.xqx.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.admin.AdminDao;
import net.xqx.dao.admin.FuncGroupDao;
import net.xqx.models.TAdmin;
import net.xqx.models.TFuncGroup;
import net.xqx.util.Md5Util;
import net.xqx.util.PageString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理员管理
 * @author siyi
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController{
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	FuncGroupDao funcGroupDao;
	
	@RequestMapping(value="/index")
	public String index(){
		return "admin/index";
	}
	
	/**
	 * 返回添加管理员页面
	 * @return
	 */
	@RequestMapping(value="/addAdminUI")
	public String addAdminUI(HttpServletRequest request){
		//查询所有权限组
		List<TFuncGroup> funcGroups= funcGroupDao.findAll();
		request.setAttribute("funcGroups", funcGroups);
		return "admin/adminManage/addAdmin";
	}
	
	/**
	 * 返回修改管理员页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/editAdminUI")
	public String editAdminUI(HttpServletRequest request){
		String adminId=request.getParameter("adminId");
		if(adminId!=null&&!"".equals(adminId)){
			TAdmin admin=adminDao.findOne(Long.parseLong(adminId));
			request.setAttribute("admin", admin);
		}

		//查询所有权限组
		List<TFuncGroup> funcGroups= funcGroupDao.findAll();
		request.setAttribute("funcGroups", funcGroups);
				
		return "admin/adminManage/editAdmin";
	}
	
	/**
	 * 查询管理员
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/adminList")
	public String adminList(HttpServletRequest request){
		String p=request.getParameter("page");
		Integer page=0;
		if(p!=null&&!"".equals(p)){
			page = Integer.parseInt(p);
		}
		Pageable pageable = new PageRequest(page,15);
		Page<TAdmin> pageAdmin= adminDao.getAdmins(pageable);
		String pagestring = PageString.getPageString(pageAdmin, "adminList.do", page);
		request.setAttribute("pagestring", pagestring);
		request.setAttribute("adminList", pageAdmin.getContent());
		String message=request.getParameter("message");
		request.setAttribute("message", message);
		
		return "admin/adminManage/adminList";
	}
	
	/**
	 * 添加管理员
	 * @param request
	 * @param tAdmin
	 * @return
	 */
	@RequestMapping(value="/addAdmin")
	public String addAdmin(HttpServletRequest request,@ModelAttribute TAdmin tAdmin){
		if(tAdmin.getfAdminPassword()!=null&&!"".equals(tAdmin)){
			tAdmin.setfAdminPassword(Md5Util.MD5Encode(tAdmin.getfAdminPassword()));
		}
		adminDao.save(tAdmin);
		return "redirect:adminList.do";
	}
	
	/**
	 * 删除管理员
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delAdmin")
	public String delAdmin(HttpServletRequest request){
		String adminId=request.getParameter("adminId");
		if(adminId!=null&&!"".equals(adminId)){
			adminDao.delete(Long.parseLong(adminId));
		}
		return "redirect:adminList.do?message=2";
	}
	
	/**
	 * 修改管理员
	 * @param request
	 * @param admin
	 * @return
	 */
	@RequestMapping(value="/editAdmin")
	public String editAdmin(HttpServletRequest request,@ModelAttribute TAdmin tAdmin){	
		if(tAdmin!=null&&tAdmin.getId()!=null&&!"".equals(tAdmin.getId())){
			TAdmin admin=adminDao.findOne(tAdmin.getId());
			admin.setfAdminName(tAdmin.getfAdminName());
			admin.setfAdminPassword(Md5Util.MD5Encode(tAdmin.getfAdminPassword()));
			admin.setfFuncGroup(tAdmin.getfFuncGroup());
			adminDao.save(admin);
		}
		return "redirect:adminList.do?message=3";
	}
	
	
}
