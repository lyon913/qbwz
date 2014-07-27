package net.xqx.controller.admin;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.admin.TPropertyDao;
import net.xqx.dao.admin.TfilesDao;
import net.xqx.dao.admin.TxzzxNewsDao;
import net.xqx.models.TFiles;
import net.xqx.models.TProperty;
import net.xqx.models.TxzzxNews;
import net.xqx.util.PageString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 下载中心
 * 
 * @author siyi
 * 
 */
@Controller
@RequestMapping("/admin")
public class XzzxController  implements ServletContextAware{

	@Autowired
	TPropertyDao propertyDao;

	@Autowired
	TxzzxNewsDao xzzxNewsDao;
	
	@Autowired
	TfilesDao filesDao;

	/**
	 * 返回下载中心发布页面
	 * 
	 * @param request
	 * @param tXhzcNews
	 * @return
	 */
	@RequestMapping("/addXzzxUI")
	public String addXzzxUI(HttpServletRequest request) {
		
		//加载下拉列表
		List<TProperty> lxs = propertyDao.getPropertyByfName("下载中心");
			request.setAttribute("flxs", lxs);
		

		
		//加载软件等级
		List<TProperty> rjdjs= propertyDao.getPropertyByfName("软件等级");
		TProperty rjdj=null;
		if(rjdjs!=null&&rjdjs.size()>0){
			rjdj=rjdjs.get(0);
			List<TProperty> rj=propertyDao.getPropertyByFid(rjdj.getId());
			request.setAttribute("rjdjs", rj);
		}

		
		return "admin/xzzx/addXzzxNews";
	}

	/**
	 * 返回下载中心编辑页面
	 * 
	 * @param request
	 * @param tXhzcNews
	 * @return
	 */
	@RequestMapping("/editXzzxUI")
	public String editXzzxUI(HttpServletRequest request,
			@ModelAttribute TxzzxNews tXzzxNews) {
		String id=request.getParameter("id");
		TxzzxNews xzzxNews=null;
		if(id!=null&&!"".equals(id)){
			xzzxNews=xzzxNewsDao.findOne(Long.parseLong(id));
			request.setAttribute("news", xzzxNews);
		}
		
		//加载下拉列表
		List<TProperty> propertys= propertyDao.getPropertyByfName("下载中心");
		TProperty property=null;
		if(propertys!=null&&propertys.size()>0){
			property=propertys.get(0);
		}
		List<TProperty> lxs=propertyDao.getPropertyByFid(property.getId());
		request.setAttribute("propertys", propertys);
		
		//加载软件等级
		List<TProperty> rjdjs= propertyDao.getPropertyByfName("软件等级");
		TProperty rjdj=null;
		if(rjdjs!=null&&rjdjs.size()>0){
			rjdj=rjdjs.get(0);
		}
		List<TProperty> rj=propertyDao.getPropertyByFid(rjdj.getId());
		request.setAttribute("rjdjs", rj);
				
		return "admin/xzzx/editXzzxNews";
	}

	
	/**
	 * 返回审核页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/examineXzzxUI")
	public String examineXzzxUI(HttpServletRequest request) {
		// 根据id查询记录
		String id = request.getParameter("id");
		TxzzxNews xzzxNews = null;
		if (id != null && !"".equals(id)) {
			xzzxNews = xzzxNewsDao.findOne(Long.parseLong(id));
			request.setAttribute("news", xzzxNews);
		}
		return "admin/xzzx/examineXzzxNews";
	}
	
	/**
	 * 处理推荐操作
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/tjXzzxNews")
	public String tjXzzxNews(HttpServletRequest request) {
		String id = request.getParameter("id");
		TxzzxNews xhzcNews = null;
		if (id != null && !"".equals(id)) {
			xhzcNews = xzzxNewsDao.findOne(Long.parseLong(id));
			if (xhzcNews.getfIsRecord() == null||xhzcNews.getfIsRecord()==0) {
				// 推荐
				xhzcNews.setfIsRecord(1L);
			} else {
				// 取消推荐
				xhzcNews.setfIsRecord(0L);
			}
			xzzxNewsDao.save(xhzcNews);
		}
		return "redirect:xzzxPassManage.do?message=3";
	}
	
	/**
	 * 处理审核
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/examineXzzx")
	public String examineXzzx(HttpServletRequest request) {
		String id=request.getParameter("id");
		TxzzxNews xzzxNews=null;
		String isPass = request.getParameter("isPass");
		if(id!=null&&!"".equals(id))
		{
			xzzxNews=xzzxNewsDao.findOne(Long.parseLong(id));
			
			if (isPass != null && "1".equals(isPass)) {
				xzzxNews.setfIsPass(1L);// 设置通过
				xzzxNews.setfIsShow(1L);// 设置显示
			} else {
				xzzxNews.setfIsPass(-1L);// 设置不通过
			}
			
			xzzxNewsDao.save(xzzxNews);
		}
		return "redirect:xzzxManage.do?message=3";
	}
	
	/**
	 * 删除新闻
	 * @return
	 */
	@RequestMapping("/delXzzx")
	public String delXzzx(HttpServletRequest request){
		String id=request.getParameter("id");
		if(id!=null&&!"".equals(id))
		{
			xzzxNewsDao.delete(Long.parseLong(id));
		}
		return "redirect:xzzxPassManage.do?message=3";
	}

	/**
	 * 查询没有审核通过或没有审核的协会信息
	 * 
	 * @return
	 */
	@RequestMapping("/xzzxManage")
	public String xzzxManage(HttpServletRequest request) {
		String p = request.getParameter("page");
		Integer page = 0;
		if (p != null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		Sort sort = new Sort(Direction.DESC, "ffbTime");
		Pageable pageable = new PageRequest(page, 15, sort);
		Page<TxzzxNews> pageZyrcNews = xzzxNewsDao.getTxzzxNews(pageable);
		String pagestring = PageString.getPageString(pageZyrcNews,
				"xhzcNewsManage.do", page);
		request.setAttribute("pagestring", pagestring);
		request.setAttribute("newsList", pageZyrcNews.getContent());

		// 消息出来
		String message = request.getParameter("message");
		if (message != null && !"".equals(message)) {
			request.setAttribute("message", message);
		}

		return "admin/xzzx/xzzxNewsManage";
	}

	/**
	 * 查询审核通过协会信息
	 * 
	 * @return
	 */
	@RequestMapping("/xzzxPassManage")
	public String xzzxPassManage(HttpServletRequest request) {
		String p = request.getParameter("page");
		Integer page = 0;
		if (p != null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		Sort sort = new Sort(Direction.DESC,"ffbTime" );
		Pageable pageable = new PageRequest(page, 15, sort);
		Page<TxzzxNews> pageXhzcNews = xzzxNewsDao.getTxzzxNewsPass(pageable);
		String pagestring = PageString.getPageString(pageXhzcNews,
				"xzzxPassManage.do", page);
		request.setAttribute("pagestring", pagestring);
		request.setAttribute("newsList", pageXhzcNews.getContent());

		// 消息出来
		String message = request.getParameter("message");
		if (message != null && !"".equals(message)) {
			request.setAttribute("message", message);
		}

		return "admin/xzzx/xzzxNewsPassManage";
	}

	/**
	 * 处理显示和不显示的方法
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showXzzx")
	public String showXzzx(HttpServletRequest request) {
		String id = request.getParameter("id");
		TxzzxNews xzzxNews = null;
		if (id != null && !"".equals(id)) {
			xzzxNews = xzzxNewsDao.findOne(Long.parseLong(id));
			if (xzzxNews.getfIsShow() != 1) {
				xzzxNews.setfIsShow(1L);
			} else {
				xzzxNews.setfIsShow(0L);
			}
			xzzxNewsDao.save(xzzxNews);
		}
		return "redirect:xzzxPassManage.do?message=3";
	}

	/**
	 * 处理置顶操作
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/zdXzzx")
	public String zdXzzx(HttpServletRequest request) {
		String id = request.getParameter("id");
		TxzzxNews xzzxNews = null;
		if (id != null && !"".equals(id)) {
			xzzxNews = xzzxNewsDao.findOne(Long.parseLong(id));
			if (xzzxNews.getfSortFlag() == 1) {
				// 取消置顶
				xzzxNews.setfSortFlag(0L);
				// 还原置顶时间为发表时间
				xzzxNews.setFzdTime(null);
			} else {
				xzzxNews.setfSortFlag(1L);
				xzzxNews.setFzdTime(new Date());
			}
			xzzxNewsDao.save(xzzxNews);
		}
		return "redirect:xzzxPassManage.do?message=3";
	}

	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
	
	/**
	 * 保存下载中心信息
	 * 
	 * @param request
	 * @param tXhzcNews
	 * @return
	 */
	@RequestMapping("/saveXzzx")
	public String saveXzzx(HttpServletRequest request,
			@ModelAttribute TxzzxNews tXzzxNews,
			@RequestParam("mFile") CommonsMultipartFile mFile) {
		// 定义一个上传成功变量
		boolean isSuccess = true;
		// 定义一个图片的路径
		String picAddress = null;
		if (!mFile.isEmpty()) {
			String path = this.servletContext.getRealPath("/files/"); // 获取本地存储路径
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
			String name = mFile.getFileItem().getName();// 获得后缀
			String fileType = name.substring(name.lastIndexOf("."));
			File file = new File(path + "\\" + sdf.format(new Date()) + fileType); // 新建一个文件
			try {
				mFile.getFileItem().write(file); // 将上传的文件写入新建的文件中
				picAddress = sdf.format(new Date()) + fileType;
			} catch (Exception e) {
				isSuccess = false;
				e.printStackTrace();
			}
		}

		
		//如果上传成功
		if(isSuccess)
		{	
			if(picAddress!=null)
			{
				tXzzxNews.getfFile().setfDownloadAddress(picAddress);
			}
			
			TFiles file=tXzzxNews.getfFile();
			
			filesDao.save(file);
			
			if(tXzzxNews!=null&&tXzzxNews.getId()!=null&&!"".equals(tXzzxNews.getId()))
			{
				TxzzxNews xzzxNews=xzzxNewsDao.findOne(tXzzxNews.getId());
				xzzxNews.setfTitle(tXzzxNews.getfTitle());//标题
				xzzxNews.setfContent(tXzzxNews.getfContent());//资料描述
				xzzxNews.setfKeyWord(tXzzxNews.getfKeyWord());//关键字

				xzzxNews.setFlxFirst(tXzzxNews.getFlxFirst());
				xzzxNews.setFlxSecond(tXzzxNews.getFlxSecond());
				xzzxNews.setfFile(file);
				xzzxNews.setFfbTime(new Date());//发表时间
				xzzxNews.setfIsPass(0L);
				xzzxNews.setfIsShow(0L);
				xzzxNewsDao.save(xzzxNews);
			}else{
				tXzzxNews.setFfbTime(new Date());//发表时间
				tXzzxNews.setfSortFlag(0L);//排序
				tXzzxNews.setfIsPass(0L);//是否审核通过
				tXzzxNews.setfIsShow(0L);
				tXzzxNews.setFzdTime(null);//置顶时间
				tXzzxNews.setfFile(file);
				xzzxNewsDao.save(tXzzxNews);
			}
			

			
			return "redirect:xzzxPassManage.do?message=1";
		}else{
			return "redirect:xzzxPassManage.do?error=1";
		}
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPropertyx")
	@ResponseBody
	public List<TProperty> getPropertyx(HttpServletRequest request) {
		String fId = request.getParameter("id");
		List<TProperty> propertys = propertyDao.getPropertyByFid(Long
				.parseLong(fId));
		return propertys;
	}
	// 实现接口中的setServletContext方法
	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
