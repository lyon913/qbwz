package net.xqx.controller.admin;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.admin.TPropertyDao;
import net.xqx.dao.admin.TUploadFileDao;
import net.xqx.models.TProperty;
import net.xqx.models.TUploadFiles;
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
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 资料上传
 * @author siyi
 *
 */
@Controller
@RequestMapping("/admin")
public class UploadFileController  implements ServletContextAware{
	
	@Autowired
	TPropertyDao propertyDao;
	
	@Autowired
	TUploadFileDao uploadFileDao;
	
	/**
	 * 返回资料上传发布页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addUploadFileUI")
	public String addUploadFileUI(HttpServletRequest request) {
		
		//传递一个父类过来,根据父类获得子类
		String id=request.getParameter("proId");
		List<TProperty> propertys=null;
		if(id!=null&&!"".equals(id)){
			propertys=propertyDao.getPropertyByFid(Long.parseLong(id));
			request.setAttribute("propertys", propertys);
		}
		request.setAttribute("proId", id);
		return "admin/uploadFile/addUploadFile";
	}

	/**
	 * 返回资料上传编辑页面
	 * 
	 * @param request
	 * @param tXhzcNews
	 * @return
	 */
	@RequestMapping("/editUploadFileUI")
	public String editUploadFileUI(HttpServletRequest request) {
		String id=request.getParameter("id");
		Long fId=null;//父类
		TUploadFiles uploadFile=null;
		if(id!=null&&!"".equals(id)){
			uploadFile=uploadFileDao.findOne(Long.parseLong(id));
			fId=uploadFile.getFlx().getfId();
			request.setAttribute("news", uploadFile);
		}
		
		if(fId!=null)
		{
			List<TProperty> lxs=propertyDao.getPropertyByFid(fId);
			request.setAttribute("propertys", lxs);
		}
				
		return "admin/uploadFile/editUploadFile";
	}

	
	/**
	 * 返回审核页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/examineUploadFileUI")
	public String examineUploadFileUI(HttpServletRequest request) {
		// 根据id查询记录
		String id = request.getParameter("id");
		String proId=request.getParameter("proId");
		request.setAttribute("proId", proId);
		TUploadFiles uploadFile = null;
		if (id != null && !"".equals(id)) {
			uploadFile = uploadFileDao.findOne(Long.parseLong(id));
			request.setAttribute("news", uploadFile);
		}
		return "admin/uploadFile/examineUploadFile";
	}
	
	/**
	 * 处理推荐操作
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/tjUploadFile")
	public String tjUploadFile(HttpServletRequest request) {
		String id = request.getParameter("id");
		TUploadFiles uploadFile = null;
		if (id != null && !"".equals(id)) {
			uploadFile = uploadFileDao.findOne(Long.parseLong(id));
			if (uploadFile.getfIsRecord() == null||uploadFile.getfIsRecord()==0) {
				// 推荐
				uploadFile.setfIsRecord(1L);
			} else {
				// 取消推荐
				uploadFile.setfIsRecord(0L);
			}
			uploadFileDao.save(uploadFile);
		}
		return "redirect:uploadFilePassManage.do?message=3&proId="+uploadFile.getfId();
	}
	
	/**
	 * 处理审核
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/examineUploadFile")
	public String examineUploadFile(HttpServletRequest request) {
		String id=request.getParameter("id");
		TUploadFiles uploadFile=null;
		String isPass = request.getParameter("isPass");
		if(id!=null&&!"".equals(id))
		{
			uploadFile=uploadFileDao.findOne(Long.parseLong(id));
			
			if (isPass != null && "1".equals(isPass)) {
				uploadFile.setfIsPass(1L);// 设置通过
				uploadFile.setfIsShow(1L);// 设置显示
			} else {
				uploadFile.setfIsPass(-1L);// 设置不通过
			}
			
			uploadFileDao.save(uploadFile);
		}
		return "redirect:uploadFileManage.do?message=3&proId="+uploadFile.getfId();
	}
	
	/**
	 * 删除新闻
	 * @return
	 */
	@RequestMapping("/delUploadFile")
	public String delUploadFile(HttpServletRequest request){
		String id=request.getParameter("id");
		String proId=request.getParameter("proId");
		if(id!=null&&!"".equals(id))
		{
			uploadFileDao.delete(Long.parseLong(id));
		}
		return "redirect:uploadFileManage.do?message=3&proId="+proId;
	}

	/**
	 * 查询没有审核通过或没有审核的协会信息
	 * 
	 * @return
	 */
	@RequestMapping("/uploadFileManage")
	public String uploadFileManage(HttpServletRequest request) {
		String p = request.getParameter("page");
		String proId=request.getParameter("proId");
		request.setAttribute("proId", proId);
		Integer page = 0;
		if (p != null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		Sort sort = new Sort(Direction.DESC, "fuploadTime");
		Pageable pageable = new PageRequest(page, 15, sort);
		if(proId==null||"".equals(proId)){
			proId="0";
		}
		Page<TUploadFiles> pageUploadFile = uploadFileDao.getUploadFiles(Long.parseLong(proId),pageable);
		String pagestring = PageString.getPageString(pageUploadFile,
				"uploadFileManage.do","&proId="+proId,page);
		request.setAttribute("pagestring", pagestring);
		request.setAttribute("newsList", pageUploadFile.getContent());

		// 消息出来
		String message = request.getParameter("message");
		if (message != null && !"".equals(message)) {
			request.setAttribute("message", message);
		}

		return "admin/uploadFile/uploadFileManage";
	}

	/**
	 * 查询审核通过协会信息
	 * 
	 * @return
	 */
	@RequestMapping("/uploadFilePassManage")
	public String uploadFilePassManage(HttpServletRequest request) {
		String p = request.getParameter("page");
		String proId=request.getParameter("proId");
		request.setAttribute("proId", proId);
		Integer page = 0;
		if (p != null && !"".equals(p)) {
			page = Integer.parseInt(p);
		}
		Sort sort = new Sort(Direction.DESC,"fSortFlag","fzdTime","fuploadTime" );
		Pageable pageable = new PageRequest(page, 15, sort);
		if(proId==null||"".equals(proId)){
			proId="0";
		}
		Page<TUploadFiles> pageUploadFiles= uploadFileDao.getUploadFilesPass(Long.parseLong(proId),pageable);
		String pagestring = PageString.getPageString(pageUploadFiles,
				"uploadFilePassManage.do","&proId="+proId, page);
		request.setAttribute("pagestring", pagestring);
		request.setAttribute("newsList", pageUploadFiles.getContent());

		// 消息出来
		String message = request.getParameter("message");
		if (message != null && !"".equals(message)) {
			request.setAttribute("message", message);
		}

		return "admin/uploadFile/uploadFilePassManage";
	}

	/**
	 * 处理显示和不显示的方法
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showUploadFile")
	public String showUploadFile(HttpServletRequest request) {
		String id = request.getParameter("id");
		TUploadFiles uploadFile = null;
		if (id != null && !"".equals(id)) {
			uploadFile = uploadFileDao.findOne(Long.parseLong(id));
			if (uploadFile.getfIsShow() != 1) {
				uploadFile.setfIsShow(1L);
			} else {
				uploadFile.setfIsShow(0L);
			}
			uploadFileDao.save(uploadFile);
		}
		return "redirect:uploadFilePassManage.do?message=3&proId="+uploadFile.getfId();
	}

	/**
	 * 处理置顶操作
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/zdUploadFile")
	public String zdUploadFile(HttpServletRequest request) {
		String id = request.getParameter("id");
		TUploadFiles uploadFile = null;
		if (id != null && !"".equals(id)) {
			uploadFile = uploadFileDao.findOne(Long.parseLong(id));
			if (uploadFile.getfSortFlag() == 1) {
				// 取消置顶
				uploadFile.setfSortFlag(0L);
				// 还原置顶时间为发表时间
				uploadFile.setFzdTime(null);
			} else {
				uploadFile.setfSortFlag(1L);
				uploadFile.setFzdTime(new Date());
			}
			uploadFileDao.save(uploadFile);
		}
		return "redirect:uploadFilePassManage.do?message=3&proId="+uploadFile.getfId();
	}

	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
	
	/**
	 * 保存协会信息
	 * 
	 * @param request
	 * @param tXhzcNews
	 * @return
	 */
	@RequestMapping("/saveUploadFile")
	public String saveUploadFile(HttpServletRequest request,
			@ModelAttribute TUploadFiles tUploadFile,
			@RequestParam("myFile") CommonsMultipartFile myFile) {
		
		String proId=request.getParameter("proId");
		// 定义一个上传成功变量
		boolean isSuccess = true;
		// 定义一个图片的路径
		String fileAddress = null;
		if (!myFile.isEmpty()) {
			String path = this.servletContext.getRealPath("/files/"); // 获取本地存储路径
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
			String uuid=sdf.format(new Date());
			String name = myFile.getFileItem().getName();// 获得后缀
			String fileType = name.substring(name.lastIndexOf("."));
			File file = new File(path + "\\" + uuid + fileType); // 新建一个文件
			try {
				myFile.getFileItem().write(file); // 将上传的文件写入新建的文件中
				fileAddress = uuid + fileType;
			} catch (Exception e) {
				isSuccess = false;
				e.printStackTrace();
			}
		}

		
		//如果上传成功
		if(isSuccess)
		{	
			if(fileAddress!=null)
			{
				tUploadFile.setfDownloadAddress(fileAddress);
			}
			
			if(tUploadFile!=null&&tUploadFile.getId()!=null&&!"".equals(tUploadFile.getId()))
			{
				//如果是修改
				TUploadFiles uploadFile=uploadFileDao.findOne(tUploadFile.getId());
				uploadFile.setfName(tUploadFile.getfName());//标题
				if(tUploadFile.getfDownloadAddress()!=null&&!"".equals(tUploadFile.getfDownloadAddress())){
					uploadFile.setfDownloadAddress(tUploadFile.getfDownloadAddress());
				}
				uploadFile.setfContent(tUploadFile.getfContent());//资料描述
				uploadFile.setfKeyWord(tUploadFile.getfKeyWord());//关键字
				uploadFile.setfId(tUploadFile.getfId());
				uploadFile.setFlx(tUploadFile.getFlx());
				uploadFile.setfAuth(tUploadFile.getfAuth());
				uploadFile.setFly(tUploadFile.getFly());
				uploadFile.setFuploadTime(new Date());//发表时间
				uploadFile.setFzdTime(new Date());
				uploadFile.setfIsPass(0L);
				uploadFileDao.save(uploadFile);
			}else{
				//如果是添加
				tUploadFile.setfSortFlag(0L);//排序
				tUploadFile.setfIsPass(0L);//是否审核通过
				tUploadFile.setFzdTime(new Date());//置顶时间
				tUploadFile.setFuploadTime(new Date());//上传时间
				tUploadFile.setfId(Long.parseLong(proId));
				uploadFileDao.save(tUploadFile);
			}
			

			
			return "redirect:uploadFileManage.do?message=1&proId="+tUploadFile.getfId();
		}else{
			return "redirect:uploadFileManage.do?error=1&proId="+tUploadFile.getfId();
		}
	}
	
	// 实现接口中的setServletContext方法
	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

		
}
