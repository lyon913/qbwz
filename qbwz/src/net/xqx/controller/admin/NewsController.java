package net.xqx.controller.admin;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.admin.TNewsDao;
import net.xqx.dao.admin.TNewsPicDao;
import net.xqx.dao.admin.TPropertyDao;
import net.xqx.models.TNews;
import net.xqx.models.TNewsPic;
import net.xqx.models.TProperty;
import net.xqx.util.PageString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 新闻中心
 * 
 * @author siyi
 * 
 */
@Controller
@RequestMapping("/admin")
public class NewsController implements ServletContextAware {

	@Autowired
	TPropertyDao propertyDao;

	@Autowired
	TNewsDao newsDao;

	@Autowired
	TNewsPicDao newsPicDao;

	/**
	 * 返回协会信息发布页面
	 * 
	 * @param request
	 * @param TNews
	 * @return
	 */
	@RequestMapping("/addNewsUI")
	public String addNewsUI(HttpServletRequest request) {
		// 查询分类
		String lxfirst = request.getParameter("lxfirst");
		String lxsecond = request.getParameter("lxsecond");
		List<TProperty> propertys = propertyDao.getPropertyByfName("新闻中心");
		request.setAttribute("propertys", propertys);
		request.setAttribute("lxfirst", lxfirst);
		request.setAttribute("lxsecond", lxsecond);
		return "admin/news/addNews";
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getProperty")
	@ResponseBody
	public List<TProperty> getProperty(HttpServletRequest request) {
		String fId = request.getParameter("id");
		List<TProperty> propertys = propertyDao.getPropertyByFid(Long
				.parseLong(fId));
		System.out.println("二级数目："+propertys.size());
		return propertys;
	}

	/**
	 * 返回新闻编辑页面
	 * 
	 * @param request
	 * @param TNews
	 * @return
	 */
	@RequestMapping("/editNewsUI")
	public String editNewsUI(HttpServletRequest request) {
		// 根据id查询记录
		String id = request.getParameter("id");
		TNews news = null;
		if (id != null && !"".equals(id)) {
			news = newsDao.findOne(Long.parseLong(id));
			request.setAttribute("news", news);
		}

		// 加载下拉列表
		List<TProperty> propertys = propertyDao.getPropertyByfName("新闻中心");
		request.setAttribute("propertys", propertys);
		return "admin/news/editNews";
	}

	/**
	 * 删除协会新闻
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/delNews")
	public String delXhzcNews(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (id != null && !"".equals(id)) {
			try {
				newsDao.delete(Long.parseLong(id));
			} catch (Exception e) {
				return "redirect:newsManage.do?error=1";
			}
		}
		return "redirect:newsManage.do?message=2";
	}

	/**
	 * 返回审核页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/examineNewsUI")
	public String examineNewsUI(HttpServletRequest request) {
		// 根据id查询记录
		String id = request.getParameter("id");
		TNews news = null;
		if (id != null && !"".equals(id)) {
			news = newsDao.findOne(Long.parseLong(id));
			request.setAttribute("news", news);
		}
		return "admin/news/examineNews";
	}

	/**
	 * 处理审核
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/examineNews")
	public String examineNews(HttpServletRequest request) {
		// 根据id查询记录
		String id = request.getParameter("id");
		String isPass = request.getParameter("isPass");
		TNews news = null;
		if (id != null && !"".equals(id)) {
			news = newsDao.findOne(Long.parseLong(id));
			if (isPass != null && "1".equals(isPass)) {
				news.setfIsPass(1L);// 设置通过
				news.setfIsShow(1L);// 设置显示
			} else {
				news.setfIsPass(-1L);// 设置不通过
			}

			newsDao.save(news);
		}
		return "redirect:examineManage.do?message=3";
	}

	/**
	 * 查询没有审核通过或没有审核的协会信息
	 * 
	 * @return
	 */
	@RequestMapping("/examineManage")
	public String examineManage(HttpServletRequest request) {
		String p = request.getParameter("page");
		
		Integer page = 0;
		if (p != null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		Sort sort = new Sort(Direction.DESC,"ffbTime");
		Pageable pageable = new PageRequest(page, 15, sort);
		Page<TNews> pageNews = newsDao.getExamineNews(pageable);
		
		String pagestring = PageString.getPageString(pageNews,
				"examineManage.do", page);
		request.setAttribute("pagestring", pagestring);
		request.setAttribute("newsList", pageNews.getContent());

		// 成功消息
		String message = request.getParameter("message");
		if (message != null && !"".equals(message)) {
			request.setAttribute("message", message);
		}

		// 错误消息
		String error = request.getParameter("error");
		if (error != null && !"".equals(error)) {
			request.setAttribute("error", error);
		}

		return "admin/news/examineManage";
	}

	/**
	 * 查询没有审核通过或没有审核的协会信息
	 * 
	 * @return
	 */
	@RequestMapping("/newsManage")
	public String newsManage(HttpServletRequest request) {
		String p = request.getParameter("page");
		String lxfirst = request.getParameter("lxfirst");
		String lxsecond = request.getParameter("lxsecond");
		Integer page = 0;
		if (p != null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		Sort sort = new Sort(Direction.DESC, "ffbTime");
		Pageable pageable = new PageRequest(page, 15, sort);
		//Page<TNews> pageNews = newsDao.getNewsManage(pageable);
		Page<TNews> pageNews;
		if(lxsecond!=null&&!"".equals(lxsecond)){
			pageNews = newsDao.getNewsBySecendId(Long.valueOf(lxfirst), Long.valueOf(lxsecond), pageable);
		}else if(lxfirst!=null&&!"".equals(lxfirst)){
			pageNews = newsDao.getNewsByFirstId(Long.valueOf(lxfirst), pageable);
		}else{
			pageNews = newsDao.getNewsManage(pageable);
		}
		String pagestring = PageString.getPageString(pageNews, "newsManage.do",
				page);
		request.setAttribute("pagestring", pagestring);
		request.setAttribute("newsList", pageNews.getContent());
		request.setAttribute("lxfirst", lxfirst);
		request.setAttribute("lxsecond", lxsecond);

		// 成功消息
		String message = request.getParameter("message");
		if (message != null && !"".equals(message)) {
			request.setAttribute("message", message);
		}

		// 错误消息
		String error = request.getParameter("error");
		if (error != null && !"".equals(error)) {
			request.setAttribute("error", error);
		}

		return "admin/news/newsManage";
	}

	/**
	 * 处理显示和不显示的方法
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showNews")
	public String showNews(HttpServletRequest request) {
		String id = request.getParameter("id");
		TNews news = null;
		if (id != null && !"".equals(id)) {
			news = newsDao.findOne(Long.parseLong(id));
			if (news.getfIsShow() == null || news.getfIsShow() == 0L) {
				news.setfIsShow(1L);
			} else {
				news.setfIsShow(0L);
			}
			newsDao.save(news);
		}
		return "redirect:newsManage.do?message=3";
	}

	/**
	 * 处理推荐操作
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/tjNews")
	public String tjNews(HttpServletRequest request) {
		String id = request.getParameter("id");
		TNews news = null;
		if (id != null && !"".equals(id)) {
			news = newsDao.findOne(Long.parseLong(id));
			if (news.getfIsRecord() == null || news.getfIsRecord() == 0) {
				// 推荐
				news.setfIsRecord(1L);
			} else {
				// 取消推荐
				news.setfIsRecord(0L);
			}
			newsDao.save(news);
		}
		return "redirect:newsManage.do?message=3";
	}

	/**
	 * 处理置顶操作
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/zdNews")
	public String zdNews(HttpServletRequest request) {
		String id = request.getParameter("id");
		TNews news = null;
		if (id != null && !"".equals(id)) {
			news = newsDao.findOne(Long.parseLong(id));
			if (news.getfSortFlag() == 1) {
				// 取消置顶
				news.setfSortFlag(0L);
				// 还原置顶时间为发表时间
				news.setFzdTime(null);
			} else {
				news.setfSortFlag(1L);
				news.setFzdTime(new Date());
			}
			newsDao.save(news);
		}
		return "redirect:newsManage.do?message=3";
	}
	
	/**
	 * 设置头条
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/ttNews")
	public String ttNews(HttpServletRequest request) {
		String id = request.getParameter("id");
		TNews news = null;
		if (id != null && !"".equals(id)) {
			news = newsDao.findOne(Long.parseLong(id));
			if (news!=null&&news.getfIsTop()!=null&&news.getfIsTop() == 1) {
				// 取消置顶
				news.setfIsTop(0L);
			} else {
				news.setfIsTop(1L);
			}
			newsDao.save(news);
		}
		return "redirect:newsManage.do?message=3";
	}

	/**
	 * 保存协会信息
	 * 
	 * @param request
	 * @param TNews
	 * @param xhPic
	 *            协会新闻显示图
	 * @return
	 */
	@RequestMapping("/saveNews")
	@Transactional
	public String saveNews(HttpServletRequest request,
			@ModelAttribute TNews tNews,
			@RequestParam("newsPic") CommonsMultipartFile newsPic) {

		// 定义一个上传成功变量
		boolean isSuccess = true;
		
		String lxfirst ="";
		String lxsecond="";
		
		// 定义一个图片的路径
		String picAddress = null;
		if (!newsPic.isEmpty()) {
			String path = this.servletContext.getRealPath("/xwPic/"); // 获取本地存储路径
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String uuid = sdf.format(new Date());
			String name = newsPic.getFileItem().getName();// 获得后缀
			String fileType = name.substring(name.lastIndexOf("."));
			
			if(".bmp".equals(fileType))
			{
				fileType=".jpg";
			}
			File file = new File(path + "\\" + uuid + fileType); // 新建一个文件
			try {
				newsPic.getFileItem().write(file); // 将上传的文件写入新建的文件中
				picAddress = uuid + fileType;
			} catch (Exception e) {
				isSuccess = false;
				e.printStackTrace();
			}
		}

		// 如果上传成功
		if (isSuccess) {
			tNews.setfIsPass(0L);
			tNews.setfIsShow(0L);
			tNews.setfSortFlag(0L);
			tNews.setfIsTop(0L);
			tNews.setFfbTime(new Date());

			// 保存图片路径
			if (picAddress != null) {
				tNews.setfNewsPic(picAddress);
			}

			if (tNews.getFlxSecond() != null 
					&& tNews.getFlxSecond().getId() != null
					&& tNews.getFlxSecond().getId() == -1) {
				tNews.setFlxSecond(null);
			}
			
			
			if(tNews.getFlxFirst().getId()!=3)
			{
				tNews.setfDocumentNo(null);
				tNews.setfBeginValidDate(null);
				tNews.setfEndValidDate(null);
				tNews.setfPublishOrganization(null);
				tNews.setfDocumentType(null);
			}	

			newsDao.save(tNews);
			if(tNews.getFlxFirst()!=null){
				lxfirst = Long.toString(tNews.getFlxFirst().getId());
			}
			
			
			return "redirect:newsManage.do?message=1&lxfirst="+lxfirst;
		} else {
			return "redirect:newsManage.do?error=1";
		}
	}

	/**
	 * 保存信息
	 * 
	 * @param request
	 * @param TNews
	 * @param xhPic
	 *            新闻显示图
	 * @return
	 */
	@RequestMapping("/editSaveNews")
	public String editSaveNews(HttpServletRequest request,
			@ModelAttribute TNews tNews,
			@RequestParam("newsPic") CommonsMultipartFile newsPic) {
		TNews news = null;
		String lxfirst ="";
		String lxsecond="";

		// 定义一个上传成功变量
		boolean isSuccess = true;
		// 定义一个图片的路径
		String picAddress = null;
		if (!newsPic.isEmpty()) {
			String path = this.servletContext.getRealPath("/xwPic/"); // 获取本地存储路径
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String uuid = sdf.format(new Date());
			String name = newsPic.getFileItem().getName();// 获得后缀
			String fileType = name.substring(name.lastIndexOf("."));
			File file = new File(path + "\\" + uuid + fileType); // 新建一个文件
			try {
				newsPic.getFileItem().write(file); // 将上传的文件写入新建的文件中
				picAddress = uuid + fileType;
			} catch (Exception e) {
				isSuccess = false;
				e.printStackTrace();
			}
		}

		// 如果上传成功
		if (isSuccess) {
			news = newsDao.findOne(tNews.getId());

			news.setfAuth(tNews.getfAuth());
			news.setfContent(tNews.getfContent());
			news.setFfbTime(new Date());
			news.setfIsPass(0L);
			news.setfIsShow(0L);
			news.setfIsRecord(0L);
			news.setfKeyWord(tNews.getfKeyWord());
			news.setFly(tNews.getFly());
			// 保存图片路径
			if (picAddress != null) {
				news.setfNewsPic(picAddress);
			}
			news.setfTitle(tNews.getfTitle());
			news.setFlxFirst(tNews.getFlxFirst());
			news.setFlxSecond(tNews.getFlxSecond());
			news.setfSort(tNews.getfSort());//20140726
			if(tNews.getFlxFirst().getId()==3)
			{
			news.setfDocumentNo(tNews.getfDocumentNo());
			news.setfBeginValidDate(tNews.getfBeginValidDate());
			news.setfEndValidDate(tNews.getfEndValidDate());
			news.setfPublishOrganization(tNews.getfPublishOrganization());
			news.setfDocumentType(tNews.getfDocumentType());
			}else
			{
				news.setfDocumentNo(null);
				news.setfBeginValidDate(null);
				news.setfEndValidDate(null);
				news.setfPublishOrganization(null);
				news.setfDocumentType(null);
			}
			if (news.getFlxSecond() != null
					&& news.getFlxSecond().getId() != null
					&& news.getFlxSecond().getId() == -1) {
				news.setFlxSecond(null);
			}

			if (news.getFlxSecond() != null
					&& news.getFlxSecond().getId() == null) {
				news.setFlxSecond(null);
			}

			newsDao.save(news);
			if(tNews.getFlxFirst()!=null){
				lxfirst = Long.toString(tNews.getFlxFirst().getId());
			}
			
			return "redirect:newsManage.do?message=1&lxfirst="+lxfirst;
		} else {
			return "redirect:newsManage.do?error=1";
		}
	}

	// 新闻图片

	@RequestMapping("/newsPicManage")
	public String newsPicManage(HttpServletRequest request) {
		String newsId = request.getParameter("id");
		TNews news=null;
		String p = request.getParameter("page");
		Integer page = 0;
		if (p != null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, 4, sort);
		if (newsId != null && !"".equals(newsId)) {
			news=newsDao.findOne(Long.parseLong(newsId));
//			修改图片后修改其相关状态
			news.setfSortFlag(0L);
			news.setfIsPass(0L);
			news.setfIsShow(0L);
			news.setfIsRecord(0L);
			news.setfIsTop(0L);
			newsDao.save(news);
			Page<TNewsPic> newsPicList = newsPicDao.getByNewsId(
					Long.parseLong(newsId), pageable);
			String pagestring = PageString.getPageString(newsPicList, "newsPicManage.do","&id="+newsId,
					page);
			request.setAttribute("pagestring", pagestring);
			request.setAttribute("news", news);
			request.setAttribute("newsPicList", newsPicList.getContent());
		}
		return "admin/news/newsPicManage";
	}

	@RequestMapping("/uploadNewsPic")
	public String uploadNewsPic(HttpServletRequest request,
			@ModelAttribute TNewsPic tNewsPic,
			@RequestParam("newsPic") CommonsMultipartFile newsPic) {
		// 定义一个上传成功变量
		boolean isSuccess = true;
		// 定义一个图片的路径
		String picAddress = null;
		if (!newsPic.isEmpty()) {
			String path = this.servletContext.getRealPath("/newsPic/"); // 获取本地存储路径
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String uuid = sdf.format(new Date());
			String name = newsPic.getFileItem().getName();// 获得后缀
			String fileType = name.substring(name.lastIndexOf("."));
			File file = new File(path + "\\" + uuid + fileType); // 新建一个文件
			try {
				newsPic.getFileItem().write(file); // 将上传的文件写入新建的文件中
				picAddress = uuid + fileType;
			} catch (Exception e) {
				isSuccess = false;
				e.printStackTrace();
			}
		}

		if (picAddress != null) {
			tNewsPic.setfPicAddress(picAddress);
			newsPicDao.save(tNewsPic);
			return "redirect:newsPicManage.do?id="
					+ tNewsPic.getfNewsId().getId();
		}
		return null;
	}
	
	@RequestMapping("/delNewsPic")
	public String delNewsPic(HttpServletRequest request){
		String newsPicId=request.getParameter("id");
		TNewsPic newsPic=null;
		if(newsPicId!=null&&!"".equals(newsPicId)){
			newsPic=newsPicDao.findOne(Long.parseLong(newsPicId));
			newsPicDao.delete(Long.parseLong(newsPicId));
			return "redirect:newsPicManage.do?message=1&id="
			+ newsPic.getfNewsId().getId();
		}
		return null;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	// 实现接口中的setServletContext方法
	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
