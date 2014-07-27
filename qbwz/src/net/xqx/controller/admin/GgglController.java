package net.xqx.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import net.xqx.dao.admin.GgglDao;
import net.xqx.dao.admin.GgwDao;
import net.xqx.dao.admin.TPropertyDao;
import net.xqx.models.TAdv;
import net.xqx.models.Tggw;
import net.xqx.util.PageString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/admin")
public class GgglController {
	@Autowired
	TPropertyDao propertyDao;
	
	@Autowired
	GgglDao ggdao;
	
	@Autowired
	GgwDao ggwdao;
	
	@RequestMapping("/readysavegg")
	public String readySaveGgNews(HttpServletRequest request,Model m){
		List<Tggw> ggwlist = ggwdao.findAll();
		m.addAttribute("ggwlist", ggwlist);
		return "admin/gggl/addgg";
	}
	//添加
	@RequestMapping("/savegg")
	public String saveGgNews(HttpServletRequest request,@ModelAttribute TAdv adv) throws IOException{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
		if((CommonsMultipartFile) multipartRequest.getFile("file")!=null){
	        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest  
	                .getFile("file");  
	        String name = multipartRequest.getParameter("name");  
	        System.out.println("name: " + name);  
	        // 获得文件名：  
	        String realFileName = file.getOriginalFilename();  
	        System.out.println("获得文件名：" + realFileName);  
	        // 获取路径  
	        String ctxPath = request.getSession().getServletContext().getRealPath(  
	                "/")  
	                + "xwPic/";  
	        // 创建文件  
	        File dirPath = new File(ctxPath);  
	        if (!dirPath.exists()) {  
	            dirPath.mkdir();  
	        }  
	        UUID uuid = UUID.randomUUID();
	        File uploadFile = new File(ctxPath + uuid.toString());  
	        FileCopyUtils.copy(file.getBytes(), uploadFile);  
	        request.setAttribute("files", loadFiles(request));
	    	adv.setfURL(uuid.toString());
		}
		ggdao.save(adv);
		request.getSession().setAttribute("message", "操作成功!");
		return "redirect:ggchecklist.do";
	}
	
	@RequestMapping("/ggchecklist")
	public String ggNewsCheckList(HttpServletRequest request,Model m){
		int page = 0;
		if(request.getParameter("page")!=null&&!"".equals(request.getParameter("page"))){
			page = Integer.valueOf(request.getParameter("page"));
		}
		Pageable pageable = new PageRequest(page,15);
		Page<TAdv> ggpage = ggdao.findAll(pageable);
		m.addAttribute("gglist", ggpage.getContent());
		String pagestring = PageString.getPageString(ggpage, "ggchecklist.do", page);
		m.addAttribute("pagestring", pagestring);
		return "admin/gggl/ggchecklist";
	}
	
	//删
	@RequestMapping("/deletegg")
	public String deleteggNews(HttpServletRequest request){
		Long id = Long.valueOf(request.getParameter("id"));
		ggdao.delete(id);
		request.getSession().setAttribute("message", "操作成功!");
		return "redirect:ggchecklist.do";
}
			
	//获单条信息
	@RequestMapping("/showgg")
	public String showggNews(HttpServletRequest request,Model m){
		Long id = Long.valueOf(request.getParameter("id"));
		TAdv adv =  ggdao.findOne(id);
		m.addAttribute("gg",adv);
		return "admin/gggl/editgg";
	}
	
	//设置为显示
	@RequestMapping("/ggtoshow")
	public String ggtoShow(HttpServletRequest request){
		Long id = Long.valueOf(request.getParameter("id"));
		TAdv adv = new TAdv();
		adv = ggdao.findOne(id);
		adv.setfIsShow(1L);
		ggdao.save(adv);
		request.getSession().setAttribute("message", "操作成功!");
			return "redirect:ggchecklist.do";
		}
//设置为不显示
@RequestMapping("/ggtonotshow")
public String ggtoNotShow(HttpServletRequest request){
	Long id = Long.valueOf(request.getParameter("id"));
	TAdv adv = new TAdv();
	adv = ggdao.findOne(id);
	adv.setfIsShow(0L);
	ggdao.save(adv);
	request.getSession().setAttribute("message", "操作成功!");
		return "redirect:ggchecklist.do";
}
//@ModelAttribute("files")//此属性用于初始类时调用,但上传文件后不能时时反应上传文件个数,不适合动态数据  
public List<String> loadFiles(HttpServletRequest request) {  
    List<String> files = new ArrayList<String>();  
    String ctxPath = request.getSession().getServletContext().getRealPath(  
            "/")  
            + "\\" + "images\\";  
    File file = new File(ctxPath);  
    if (file.exists()) {  
        File[] fs = file.listFiles();  
        String fname = null;  
        for (File f : fs) {  
            fname = f.getName();  
            if (f.isFile()) {  
                files.add(fname);  
            }  
        }  
    }  
    return files;  
}
//修改
	@RequestMapping("/updategg")
	public String updateGgNews(HttpServletRequest request,@ModelAttribute TAdv adv) throws IOException{
		ggdao.save(adv);
		request.getSession().setAttribute("message", "操作成功!");
		return "redirect:ggchecklist.do";
	}
}
