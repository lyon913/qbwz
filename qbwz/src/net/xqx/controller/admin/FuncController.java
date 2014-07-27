package net.xqx.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.admin.FuncGroupDao;
import net.xqx.dao.admin.FuncListDao;
import net.xqx.models.TFuncGroup;
import net.xqx.models.TFuncList;
import net.xqx.service.admin.TFuncListService;
import net.xqx.tempmodels.TempFuncList;
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

@Controller
@RequestMapping("/admin")
public class FuncController {

	@Autowired
	FuncGroupDao funcGroupDao;

	@Autowired
	TFuncListService funcListService;

	@Autowired
	FuncListDao funcListDao;

	
	/**
	 * 返回添加权限组页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/addFuncUI")
	public String addFuncUI(HttpServletRequest request){
		return "admin/funcManage/addFunc";
	}
	
	/**
	 * 返回父类权限的权限列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/funcManageUI")
	public String funcManageUI(HttpServletRequest request) {
		// 查询父类权限
		String p = request.getParameter("page");
		Integer page = 0;
		if (p != null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		Sort sort = new Sort(Direction.DESC, "fFuncSort");
		Pageable pageable = new PageRequest(page, 15, sort);
		Page<TFuncList> pageFuncLists = funcListDao.getFuncGroupByFid(0L,
				pageable);
		String pagestring = PageString.getPageString(pageFuncLists,
				"funcManageUI.do", page);
		request.setAttribute("pagestring", pagestring);
		request.setAttribute("funcLists", pageFuncLists.getContent());
		String message = request.getParameter("message");
		if (message != null && !"".equals(message)) {
			request.setAttribute("message", message);
		}
		
		String error = request.getParameter("error");
		if (error != null && !"".equals(error)) {
			request.setAttribute("error", error);
		}

		return "admin/funcManage/funcManage";
	}

	/**
	 * 返回父类权限的编辑页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/editFuncManageUI")
	public String editFuncManageUI(HttpServletRequest request) {
		String funcId = request.getParameter("funcId");
		TFuncList funcList = null;
		if (funcId != null && !"".equals(funcId)) {
			funcList = funcListDao.findOne(Long.parseLong(funcId));
			request.setAttribute("funcList", funcList);
		}
		return "admin/funcManage/editFuncManage";
	}

	/**
	 * 返回添加页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addFuncManageUI")
	public String addFuncManage(HttpServletRequest request) {
		return "admin/funcManage/editFuncManage";
	}
	
	/**
	 * 删除父类链接
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delFuncManage")
	public String delFuncManage(HttpServletRequest request){
		String funcId=request.getParameter("funcId");
		if(funcId!=null&&!"".equals(funcId)){
			//根据父id查询子类
			List<TFuncList> funcLists=funcListDao.getFuncGroupByFid(Long.parseLong(funcId));
			if(funcLists!=null&&funcLists.size()>0){
				return "redirect:funcManageUI.do?error=9";
			}
			
			funcListDao.delete(Long.parseLong(funcId));
		}
		
		return "redirect:funcManageUI.do?message=2";
	}

	/**
	 * 保存父类权限
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveFuncManage")
	public String saveFuncManage(HttpServletRequest request,
			@ModelAttribute TFuncList tFuncList) {
		if (tFuncList.getFid() == null) {
			tFuncList.setFid(0L);
		}
		// 因为该表没有设置主键为自动增长,所以必须进行判断
		List<TFuncList> funcLists = funcListDao.getFuncGroupByFid();
		TFuncList funcList = null;
		if (funcLists != null && funcLists.size() > 0) {
			funcList = funcLists.get(0);
			//如果是新增
			if(tFuncList.getId()==null||"".equals(tFuncList.getId())){
				tFuncList.setId(funcList.getId() + 1);
			}
			funcListDao.save(tFuncList);
			
		}else{
			tFuncList.setId(1L);
		}
		return "redirect:funcManageUI.do?message=1";
	}

	/**
	 * 处理权限
	 * 
	 * @param request
	 * @param admin
	 * @return
	 */
	@RequestMapping(value = "/func")
	public String func(HttpServletRequest request) {

		// 加载selsect权限组
		List<TFuncGroup> funcGroupOptions = funcGroupDao.findAll();
		request.setAttribute("funcGroupOptions", funcGroupOptions);

		String funcId = request.getParameter("funcGroup");
		TFuncGroup funcGroup = null;
		// 默认加载第一条记录的权限
		if (funcId == null || "".equals(funcId)) {
			funcId = funcGroupOptions.get(0).getId() + "";
		}

		if (funcId != null && !"".equals(funcId)) {
			funcGroup = funcGroupDao.findOne(Long.parseLong(funcId));
			request.setAttribute("funcId", funcGroup);
		}

		if (funcGroup != null) {
			request.setAttribute("ourRights", funcGroup.getfFuncRights());
		}

		// 加载所有权限
		List<TempFuncList> tempFuncLists = new ArrayList<TempFuncList>();
		// 加载父id
		List<TFuncList> funcList = funcListDao.getFuncGroupByFid(0L);

		TempFuncList tempFuncList = null;
		// 根据父id加载子类
		for (TFuncList func : funcList) {
			tempFuncList = new TempFuncList();
			List<TFuncList> fList = funcListDao.getFuncGroupByFid(func.getId());
			tempFuncList.setFuncList(func);
			tempFuncList.setFuncLists(fList);
			tempFuncLists.add(tempFuncList);
		}
		request.setAttribute("tempFuncLists", tempFuncLists);

		String message = request.getParameter("message");
		if (message != null && "1".equals(message)) {
			request.setAttribute("message", message);
		}

		return "admin/funcManage/editFunc";
	}

	/**
	 * 保存权限
	 * 
	 * @return
	 */
	@RequestMapping(value = "saveFunc")
	public String saveFunc(HttpServletRequest request) {
		// 获得权限组
		String rightGroupId = request.getParameter("funcGroups");
		// 获得权限
		String rights = request.getParameter("funcRights");

		// 根据权限组id查询权限组
		if (rightGroupId != null && !"".equals(rightGroupId) && rights != null) {
			if (rights.endsWith(",")) {
				rights = rights.substring(0, rights.length() - 1);
			}
			TFuncGroup funcGroup = funcGroupDao.findOne(Long
					.parseLong(rightGroupId));
			funcGroup.setfFuncRights(rights);
			funcGroupDao.save(funcGroup);
		}

		return "redirect:func.do?message=1&funcGroup=" + rightGroupId;
	}
	
	
	//以下为子类权限处理
	@RequestMapping(value="zFuncManageUI")
	public String  zFuncManageUI(HttpServletRequest request){
		String funcId=request.getParameter("funcId");
		Page<TFuncList> funcList=null;
		String p = request.getParameter("page");
		Integer page = 0;
		if (p != null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		Sort sort = new Sort(Direction.DESC, "fFuncSort");
		Pageable pageable = new PageRequest(page, 15, sort);
		
		if(funcId!=null&&!"".equals(funcId)){
			//查询出父类权限
			TFuncList fList=funcListDao.findOne(Long.parseLong(funcId));
			request.setAttribute("fList", fList);
			//根据父类查询子类权限
			funcList=funcListDao.getFuncGroupByFid(Long.parseLong(funcId), pageable);
			String pagestring = PageString.getPageString(funcList,
					"zFuncManageUI.do", page);
			request.setAttribute("funcLists", funcList.getContent());
			request.setAttribute("pagestring", pagestring);
		}
		return "admin/funcManage/zfuncManage";
	}
	
	/**
	 * 返回子类类权限的编辑页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/editzFuncManageUI")
	public String editzFuncManageUI(HttpServletRequest request) {
		String funcId = request.getParameter("funcId");
		TFuncList funcList = null;
		if (funcId != null && !"".equals(funcId)) {
			funcList = funcListDao.findOne(Long.parseLong(funcId));
			request.setAttribute("funcList", funcList);
		}
		return "admin/funcManage/editzFuncManage";
	}
	
	/**
	 * 删除父类链接
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delzFuncManage")
	public String delzFuncManage(HttpServletRequest request){
		String funcId=request.getParameter("funcId");
		TFuncList funcList=null;

		if(funcId!=null&&!"".equals(funcId)){
			funcList=funcListDao.findOne(Long.parseLong(funcId));
			funcListDao.delete(Long.parseLong(funcId));
		}
		
		return "redirect:zFuncManageUI.do?message=2&funcId="+funcList.getFid();
	}
	
	/**
	 * 保存子类权限
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/savezFuncManage")
	public String savezFuncManage(HttpServletRequest request,
			@ModelAttribute TFuncList tFuncList) {
		if (tFuncList.getFid() == null) {
			tFuncList.setFid(0L);
		}
		// 因为该表没有设置主键为自动增长,所以必须进行判断
		List<TFuncList> funcLists = funcListDao.getzFunc();
		TFuncList funcList = null;
		if (funcLists != null && funcLists.size() > 0) {
			funcList = funcLists.get(0);
			//如果是新增
			if(tFuncList.getId()==null||"".equals(tFuncList.getId())){
				tFuncList.setId(funcList.getId() + 1);
			}
			funcListDao.save(tFuncList);
			
		}else{
			tFuncList.setId(1L);
		}
		return "redirect:zFuncManageUI.do?message=1&funcId="+tFuncList.getFid();
	}
	
	/**
	 * 保存权限组
	 * @param request
	 * @param funcGroup
	 * @return
	 */
	@RequestMapping("/saveFuncGroup")
	public String saveFuncGroup(HttpServletRequest request,@ModelAttribute TFuncGroup funcGroup){
		Sort sort=new Sort(Direction.DESC,"id");
		Pageable pageable=new PageRequest(0, 999,sort);
		Page<TFuncGroup> funcGroups=funcGroupDao.findAll(pageable);
		List<TFuncGroup> funcGroupList=funcGroups.getContent();
		Long sumId=null;
		if(funcGroupList!=null&&funcGroupList.size()>0){
			sumId=funcGroupList.get(0).getId();
		}
		funcGroup.setId(sumId+1);
		funcGroupDao.save(funcGroup);
		return "redirect:func.do?message=1";
		
	}
	
	/**
	 * 返回添加页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addzFuncManageUI")
	public String addzFuncManage(HttpServletRequest request) {
		String fid=request.getParameter("fid");
		if(fid!=null&&!"".equals(fid))
		{
			TFuncList funcList=new TFuncList();
			funcList.setFid(Long.parseLong(fid));
			request.setAttribute("funcList", funcList);
		}
		return "admin/funcManage/editzFuncManage";
	}


}
