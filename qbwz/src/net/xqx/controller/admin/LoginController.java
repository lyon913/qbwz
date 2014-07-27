package net.xqx.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.admin.AdminDao;
import net.xqx.dao.admin.FuncGroupDao;
import net.xqx.dao.admin.LoginDao;
import net.xqx.models.TAdmin;
import net.xqx.models.TFuncGroup;
import net.xqx.models.TFuncList;
import net.xqx.service.admin.TFuncListService;
import net.xqx.tempmodels.TempFuncList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LoginController{
	

	@Autowired
	LoginDao loginDao;
	
	@Autowired
	TFuncListService funcListService;
	
	@Autowired
	FuncGroupDao funcGroupDao;
	
	@Autowired
	AdminDao adminDao;
	
	/**
	 * 返回登录页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/loginUI")
	public String loginUI(HttpServletRequest request){
		String message=request.getParameter("error");
		if(message!=null&&"1".equals(message)){
			request.setAttribute("message", "用户名或密码错误!");
		}

		return "admin/login";
	}
	
	/**
	 * 用户登录处理
	 * @param request
	 * @param admin
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request){	
		User u=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName=u.getUsername();
		List<TAdmin> admins=loginDao.getAdmins(userName);
		TAdmin admin=null;
		if(admins!=null&&admins.size()>0){
			admin=admins.get(0);
			request.getSession().setAttribute("admin", admin);
			
			//查询权限组
			TFuncGroup fgroup=admin.getfFuncGroup();
			
			//包装权限
			List<TempFuncList> tempFuncLists=new ArrayList<TempFuncList>();
			TempFuncList tempFuncList=null;
			//读取父权限
			List<TFuncList> fFuncList= funcListService.getFuncList(0L, fgroup.getfFuncRights());
			//根据父权限读取子权限
			for(TFuncList func:fFuncList){
				tempFuncList=new TempFuncList();
				List<TFuncList> funcList=funcListService.getFuncList(func.getId(), fgroup.getfFuncRights());
				tempFuncList.setFuncList(func);
				tempFuncList.setFuncLists(funcList);
				tempFuncLists.add(tempFuncList);
			}
			//登录记录
			Object tempObject=request.getSession().getAttribute("tempFuncLists");
			if(tempObject==null){
				admin.setfLoginTime(new Date());
				if(admin.getfLoginTimes()==null){
					admin.setfLoginTimes(0L);
				}
				admin.setfLoginTimes(admin.getfLoginTimes()+1);
				adminDao.save(admin);
			}
			
			request.getSession().setAttribute("tempFuncLists",tempFuncLists);
			
		}
		return "admin/index";
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/loginOut")
	public String loginOut(HttpServletRequest request){
		request.getSession().removeAttribute("admin");
		request.getSession().removeAttribute("tempFuncLists");
		SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
		return "admin/loginOut";
	}
	
}
