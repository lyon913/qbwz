package net.xqx.controller.admin;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.admin.TtpLinksDao;
import net.xqx.dao.admin.TwzLinksDao;

import net.xqx.models.TtpLinks;
import net.xqx.models.TwzLinks;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 友情链接
 * 
 * @author siyi
 * 
 */
@Controller
@RequestMapping("/admin")
public class YqljController implements ServletContextAware {

	@Autowired
	TtpLinksDao tpLinksDao;

	@Autowired
	TwzLinksDao wzLinksDao;

	/**
	 * 返回文字链接发布页面
	 * 
	 * @param request
	 * @param tXhzcNews
	 * @return
	 */
	@RequestMapping("/addWzljUI")
	public String addWzljUI(HttpServletRequest request) {
		return "admin/yqlj/addWzljLinks";
	}

	/**
	 * 返回图片链接发布页面
	 * 
	 * @param request
	 * @param tXhzcNews
	 * @return
	 */
	@RequestMapping("/addTpljUI")
	public String addTpljUI(HttpServletRequest request) {
		return "admin/yqlj/addTpljLinks";
	}

	/**
	 * 返回文字链接编辑页面
	 * 
	 * @param request
	 * @param tXhzcNews
	 * @return
	 */
	@RequestMapping("/editWzljUI")
	public String editWzljUI(HttpServletRequest request) {
		String id=request.getParameter("id");
		TwzLinks wzLinks=null;
		if(id!=null&&!"".equals(id)){
			wzLinks=wzLinksDao.findOne(Long.parseLong(id));
			request.setAttribute("link", wzLinks);
		}
		return "admin/yqlj/editWzljLinks";
	}

	/**
	 * 返回图片链接编辑页面
	 * 
	 * @param request
	 * @param tXhzcNews
	 * @return
	 */
	@RequestMapping("/editTpljUI")
	public String editTpljUI(HttpServletRequest request) {
		String id=request.getParameter("id");
		TtpLinks tpLinks=null;
		if(id!=null&&!"".equals(id)){
			tpLinks=tpLinksDao.findOne(Long.parseLong(id));
			request.setAttribute("link", tpLinks);
		}
		return "admin/yqlj/editTpljLinks";
	}

	/**
	 * 保存文字链接
	 * 
	 * @return
	 */
	@RequestMapping("/saveWzljLinks")
	public String saveWzljLinks(HttpServletRequest request,
			@ModelAttribute TwzLinks tWzLinks) {
		TwzLinks wzLinks=null;
		
		if (tWzLinks != null && tWzLinks.getId() != null) {
			wzLinks = wzLinksDao.findOne(tWzLinks.getId());
		} else {
			wzLinks = new TwzLinks();
			wzLinks.setfIsShow(1L);
		}
		
		if(tWzLinks.getfSortFlag()==null||"".equals(tWzLinks.getfSortFlag())){
			wzLinks.setfSortFlag(0L);
		}else{
			wzLinks.setfSortFlag(tWzLinks.getfSortFlag());
		}
		wzLinks.setfName(tWzLinks.getfName());
		wzLinks.setfLinkAddress(tWzLinks.getfLinkAddress());

		//执行保存操作
		wzLinksDao.save(wzLinks);
		return "redirect:wzljLinksManage.do?message=3";
	}

	/**
	 * 保存图片链接
	 * 
	 * @return
	 */
	@RequestMapping("/saveTpljLinks")
	public String saveTpljLinks(HttpServletRequest request,
			@ModelAttribute TtpLinks tTpLinks,
			@RequestParam("ljPic") CommonsMultipartFile ljPic) {
		
		//定义一个上传成功变量
		boolean isSuccess=true;
		//定义一个图片的路径
		String picAddress=null;
		if (!ljPic.isEmpty()) {
			String path = this.servletContext.getRealPath("/yqPic/");  //获取本地存储路径
			UUID uuid=UUID.randomUUID();//uuid作为文件名
			String name=ljPic.getFileItem().getName();//获得后缀
			String fileType=name.substring(name.lastIndexOf("."));
			File file = new File(path +"\\"+uuid+ fileType); //新建一个文件
			try {
				ljPic.getFileItem().write(file); //将上传的文件写入新建的文件中
				picAddress=uuid+fileType;
			} catch (Exception e) {
				isSuccess=false;
				e.printStackTrace();
			}
		} 

		TtpLinks tpLinks=null;
		
		//如果上传成功
		if(isSuccess)
		{
			if (tTpLinks != null && tTpLinks.getId() != null) {
				tpLinks = tpLinksDao.findOne(tTpLinks.getId());
			} else {
				tpLinks = new TtpLinks();
				tpLinks.setfIsShow(1L);
			}
			
			if(tpLinks.getfSortFlag()==null&&"".equals(tTpLinks.getfSortFlag())){
				tpLinks.setfSortFlag(1L);
			}else{
				tpLinks.setfSortFlag(tTpLinks.getfSortFlag());
			}
			tpLinks.setfName(tTpLinks.getfName());
			tpLinks.setfLinkAddress(tTpLinks.getfLinkAddress());
			tpLinks.setFlx(tTpLinks.getFlx());
			//保存图片路径
			if (picAddress!=null){
				tpLinks.setfPicLinkAddress(picAddress);
			}
			
			//执行保存操作
			tpLinksDao.save(tpLinks);
			return "redirect:tpljLinksManage.do?message=3";
		}else{
			return "redirect:tpljLinksManage.do?error=3";
		}

	}
	
	/**
	 * 删除图片链接
	 * @param request
	 * @return
	 */
	@RequestMapping("/delTplj")
	public String delTplj(HttpServletRequest request){
		String id=request.getParameter("id");
		if(id!=null&&!"".equals(id)){
			tpLinksDao.delete(Long.parseLong(id));
		}
		return "redirect:tpljLinksManage.do?message=3";
	}
	
	/**
	 * 删除文字链接
	 * @param request
	 * @return
	 */
	@RequestMapping("/delWzlj")
	public String deWzlj(HttpServletRequest request){
		String id=request.getParameter("id");
		if(id!=null&&!"".equals(id)){
			wzLinksDao.delete(Long.parseLong(id));
		}
		return "redirect:wzljLinksManage.do?message=3";
	}

	/**
	 * 查询没有审核通过或没有审核的协会信息
	 * 
	 * @return
	 */
	@RequestMapping("/wzljLinksManage")
	public String wzljLinksManage(HttpServletRequest request) {
		String p = request.getParameter("page");
		Integer page = 0;
		if (p != null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		Sort sort = new Sort(Direction.DESC, "fSortFlag");
		Pageable pageable = new PageRequest(page, 15, sort);
		Page<TwzLinks> pageWzLinks = wzLinksDao.findAll(pageable);
		String pagestring = PageString.getPageString(pageWzLinks,
				"wzljLinksManage.do", page);
		request.setAttribute("pagestring", pagestring);
		request.setAttribute("links", pageWzLinks.getContent());

		// 消息出来
		String message = request.getParameter("message");
		if (message != null && !"".equals(message)) {
			request.setAttribute("message", message);
		}

		return "admin/yqlj/wzljLinksManage";
	}

	/**
	 * 查询审核通过协会信息
	 * 
	 * @return
	 */
	@RequestMapping("/tpljLinksManage")
	public String tpljLinksPassManage(HttpServletRequest request) {
		String p = request.getParameter("page");
		Integer page = 0;
		if (p != null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		Sort sort = new Sort(Direction.DESC, "fSortFlag");
		Pageable pageable = new PageRequest(page, 15, sort);
		Page<TtpLinks> pageTpLinks = tpLinksDao.findAll(pageable);
		String pagestring = PageString.getPageString(pageTpLinks,
				"tpljLinksManage.do", page);
		request.setAttribute("pagestring", pagestring);
		request.setAttribute("links", pageTpLinks.getContent());

		// 消息出来
		String message = request.getParameter("message");
		if (message != null && !"".equals(message)) {
			request.setAttribute("message", message);
		}

		return "admin/yqlj/tpljLinksManage";
	}

	/**
	 * 处理文字链接显示和不显示的方法
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showWzljLinks")
	public String showWzljLinks(HttpServletRequest request) {
		String id = request.getParameter("id");
		TwzLinks wzLinks = null;
		if (id != null && !"".equals(id)) {
			wzLinks = wzLinksDao.findOne(Long.parseLong(id));
			if (wzLinks.getfIsShow() != 1) {
				wzLinks.setfIsShow(1L);
			} else {
				wzLinks.setfIsShow(0L);
			}
			wzLinksDao.save(wzLinks);
		}
		return "redirect:wzljLinksManage.do?message=3";
	}

	/**
	 * 处理图片链接显示和不显示的方法
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showTpljLinks")
	public String showTpljLinks(HttpServletRequest request) {
		String id = request.getParameter("id");
		TtpLinks tpLinks = null;
		if (id != null && !"".equals(id)) {
			tpLinks = tpLinksDao.findOne(Long.parseLong(id));
			if (tpLinks.getfIsShow() != 1) {
				tpLinks.setfIsShow(1L);
			} else {
				tpLinks.setfIsShow(0L);
			}
			tpLinksDao.save(tpLinks);
		}
		return "redirect:tpljLinksManage.do?message=3";
	}

	// 实现接口中的setServletContext方法
	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
