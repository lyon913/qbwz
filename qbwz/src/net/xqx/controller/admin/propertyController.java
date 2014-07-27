package net.xqx.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.admin.TNewsDao;
import net.xqx.dao.admin.TPropertyDao;
import net.xqx.models.TClass;
import net.xqx.models.TProperty;
import net.xqx.util.PageString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class propertyController {
	@Autowired
	TNewsDao newsDao;
	@Autowired
	TPropertyDao propertyDao;
	/**
	 * 返回添加属性页面
	 * @return
	 */
	@RequestMapping(value="/addPropertyUI")
	public String addPropertyUI(HttpServletRequest request){
		//查询所有属性
		String topid = request.getParameter("topid");
		List<TProperty> propertys= propertyDao.findAll();
		request.setAttribute("propertys", propertys);
		request.setAttribute("topid", topid);
		return "admin/propertyManage/addProperty";
	}
	
	/**
	 * 返回修改属性页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/editPropertyUI")
	public String editPropertyUI(HttpServletRequest request){
		String pId=request.getParameter("pId");
		if(pId!=null&&!"".equals(pId)){
			TProperty p=propertyDao.findOne(Long.parseLong(pId));
			request.setAttribute("property", p);
		}

		//查询所有属性
		List<TProperty> propertys= propertyDao.findAll();
		request.setAttribute("propertys", propertys);
				
		return "admin/propertyManage/editProperty";
	}
	
	/**
	 * 查询属性
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/propertyList")
	public String adminList(HttpServletRequest request){
		String p=request.getParameter("page");
		String topid = request.getParameter("topid");
		String ttopid = "0";
		String topproperty = "";
		if(topid==null || "".equals(topid)){
			topid = "0";
		}
		if("0".equals(topid)){
			topproperty="顶层";
		}else{
		TProperty a = propertyDao.findOne(Long.valueOf(topid));
		topproperty = a.getfValue();
		ttopid = Long.toString(a.getfId());
		}
		Integer page=0;
		if(p!=null&&!"".equals(p)){
			page = Integer.parseInt(p);
		}
		Pageable pageable = new PageRequest(page,15);
		Page<TProperty> propertys= propertyDao.getPropertyByFid(Long.valueOf(topid),pageable);
		String pagestring = PageString.getPageString(propertys, "propertyList.do", "&topid="+topid, page);
				//getPageString(classes, "classList.do", page);
		request.setAttribute("pagestring", pagestring);
		request.setAttribute("propertyList", propertys.getContent());
		String message=request.getParameter("message");
		if("havenews".equals(message)){
			message = "该类别有文章内容，不能删除！";
		}else if(message!=null&&!"".equals(message)){
			message = "操作成功！";
		}
		request.setAttribute("message", message);
		request.setAttribute("topproperty", topproperty);//上级栏目的名称
		request.setAttribute("ttopid", ttopid);//上级栏目的上级栏目，用在返回的链接中。
		request.setAttribute("topid", topid);//上级栏目
		return "admin/propertyManage/propertyList";
	}
	
	/**
	 * 添加栏目
	 * @param request
	 * @param tclass
	 * @return
	 */
	@RequestMapping(value="/addProperty")
	public String addProperty(HttpServletRequest request,@ModelAttribute TProperty tproperty){
		String fName1 = request.getParameter("fName1");
	
		//String fClassMemo = request.getParameter("fClassMemo");
		String fValue = request.getParameter("fValue");
		String fId = request.getParameter("fId");
		
		if(fId==null&&"".equals(fId)){
			fId = "0";
		}
	
		TProperty p = new TProperty();
		
		p.setfId(Long.valueOf(fId));
		
		if("0".equals(fId)){
			p.setfName(fName1);
		}else{
			p.setfName(fValue);
		}
		
		p.setfValue(fValue);
		propertyDao.save(p);
		
//		TNews n = new TNews();
//		n.setfContent(fContent);
//		n.setfTitle(fValue);
//		if("0".equals(fId)){
//			n.setFlxFirst(p);
//		}
//		else{
//			n.setFlxFirst(p1);
//			n.setFlxSecond(p);
//		}
		
		return "redirect:propertyList.do?topid="+fId;
	}
	
	/**
	 * 删除栏目
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/delProperty")
	public String delProperty(HttpServletRequest request) throws Exception{
		String pId=request.getParameter("pId");
		String fId=request.getParameter("fId");
		String message = "2";
		if(pId!=null&&!"".equals(pId)){
			try{
			propertyDao.delete(Long.parseLong(pId));
			}catch(DataIntegrityViolationException e){

					message = "havenews";

			}
		}
		return "redirect:propertyList.do?topid="+fId+"&message="+message;
	}
	
	/**
	 * 修改栏目
	 * @param request
	 * @param admin
	 * @return
	 */
	@RequestMapping(value="/editProperty")
	public String editProperty(HttpServletRequest request,@ModelAttribute TClass tclass){	
		String fName = request.getParameter("fName1");
		//String fClassMemo = request.getParameter("fClassMemo");
		String fValue = request.getParameter("fValue");
		String fId = request.getParameter("fId");
		String pId = request.getParameter("pId");
		
		if(fId==null&&"".equals(fId)){
			fId = "0";
		}

		TProperty p = new TProperty();
		p = propertyDao.findOne(Long.valueOf(pId));
		p.setfId(Long.valueOf(fId));
		if(!"0".equals(fId)){
			p.setfName(fValue);
		}else{
			p.setfName(fName);
		}
		p.setfValue(fValue);
		propertyDao.save(p);
		return "redirect:propertyList.do?message=3&topid="+fId;
	}
	
}
