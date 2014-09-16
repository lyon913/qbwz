package net.xqx.controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.web.ClassDao;
import net.xqx.dao.web.NewsDao;
import net.xqx.dao.web.PropertyDao;
import net.xqx.dao.web.WzLinkDao;
import net.xqx.dao.web.XzzxNewsDao;
import net.xqx.models.TClass;
import net.xqx.models.TNews;
import net.xqx.models.TProperty;
import net.xqx.models.TwzLinks;
import net.xqx.models.TxzzxNews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 首页
 * 
 * @author siyi
 * 
 */
@Controller
public class IndexController {

	/**
	 * 属性方法
	 */
	@Autowired
	PropertyDao propertyDao;
	
	@Autowired
	NewsDao newsDao;

	/**
	 * 下载中心
	 */
	@Autowired
	XzzxNewsDao xzzxNewsDao;

	/**
	 * 首页权限链接
	 */
	@Autowired
	ClassDao classDao;
	
	/**
	 * 友情链接
	 */
	@Autowired
	WzLinkDao wzlinkdao;

	@RequestMapping("/main")
	public String main() {
		return "web/main";
	}

	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String getIndex(HttpServletRequest request) {

		Sort sort = new Sort(Direction.DESC, "fSortFlag", "fzdTime", "fSort","ffbTime");
		int page = 0;
		Pageable pageable = new PageRequest(page, 10, sort);
		
		//本站公告 
		Page<TNews> xhgg=newsDao.getNewsBySecendId(1L, 102L, pageable);
		List<TNews> xhggList=xhgg.getContent();
		if(xhggList!=null&&xhggList.size()>0){
			TNews advNew=xhggList.get(0);
			String content=advNew.getfContent();
			if(content!=null&&!"".equals(content)){
				String noHtmlContent = content.replaceAll("<[^>]*>","");
				advNew.setfContent(noHtmlContent);
			}
			request.setAttribute("advNew", xhggList.get(0));
		}
		if(xhggList!=null&&xhggList.size()>1){
			request.setAttribute("advNewTwo", xhggList.get(1));
		}
		
	
		//新闻动态
		Page<TNews> zxzx=newsDao.getNotTopNewsByFirstId(3L,pageable);
		request.setAttribute("zxzx", zxzx.getContent());
		//信息公告 
		Page<TNews> xxgg=newsDao.getNewsByFirstId(51L, pageable);
		request.setAttribute("xxgg", xxgg.getContent());
		//就医指南
		Page<TNews> jyzn=newsDao.getNewsByFirstId(2L, pageable);
		request.setAttribute("jyzn", jyzn.getContent());
		//科室介绍
		List<TProperty> ksjs=propertyDao.getPropertyByFid(4L);
		request.setAttribute("ksjs", ksjs);
		//信息公开
		Page<TNews> xxgk=newsDao.getNewsByFirstId(6L,pageable);
		request.setAttribute("xxgk", xxgk.getContent());
		//健康之苑
		Page<TNews> jkzy=newsDao.getNewsByFirstId(7L,pageable);
		request.setAttribute("jkzy", jkzy.getContent());
		//专家介绍
		List<TNews> zjjs=newsDao.getZjs(52L);
		request.setAttribute("zjjs", zjjs);
		
		//推荐阅读
		Page<TNews> tjyd=newsDao.getTjydNewsByFirstId(2L,pageable);
		request.setAttribute("tjyd", tjyd.getContent());
		
		//资源下载
		Sort xzSort = new Sort(Direction.DESC,"ffbTime");
		Pageable xzPageable = new PageRequest(0, 10, xzSort);
		Page<TxzzxNews> xzzx=xzzxNewsDao.getXzzxNews(xzPageable);
		request.setAttribute("xzzx", xzzx.getContent());
		
		
		//医院机构链接文字
		Sort tpSort = new Sort(Direction.DESC,"fSortFlag");
		Pageable tpPageable = new PageRequest(0, 10, tpSort);
		List<TwzLinks> yylink = wzlinkdao.getWzLinks(tpPageable);
		request.setAttribute("yylink", yylink);
		
				
		
		
		//新闻显示图
		Pageable pageable1 = new PageRequest(0, 5, sort);
		List<TNews> newspic = newsDao.getNewsHasPic(pageable1,3L).getContent();
		//List<TNews> newspic = new ArrayList<TNews>();
		String pics = "";
		String links = "";
		String texts = "";
		if(newspic!=null&&newspic.size()>0){
			for(int i = 0 ;i<newspic.size();i++){
				TNews news = newspic.get(i);
				pics+=request.getContextPath()+"/xwPic/"+news.getfNewsPic()+"|";
				texts+=news.getfTitle()+"|";
				links+="showZxzxNews.do?id="+news.getId()+"|";
			}
			pics = pics.replaceAll("\\|$", "");
			links = links.replaceAll("\\|$", "");
			texts = texts.replaceAll("\\|$", "");
			
			//request.setAttribute("newspic", newspic);
			request.setAttribute("pics", pics);
			request.setAttribute("texts", texts);
			request.setAttribute("links", links);
		}
		return "web/index";
	}

	/**
	 * 首页子权限
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/topz")
	public List<TClass> getZclass(HttpServletRequest request) {
		String id = request.getParameter("id");
		Sort sort = new Sort(Direction.DESC, "fSortFlag");
		int page = 0;
		Pageable pageable = new PageRequest(page, 100, sort);
		if (id != null && !"".equals(id)) {
			return classDao.getClassByFid(Long.parseLong(id), pageable);
		}
		return null;
	}

	/**
	 * 查询首页权限链接
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/top")
	public List<TClass> top(HttpServletRequest request) {
		Sort sort = new Sort(Direction.DESC, "fSortFlag");
		int page = 0;
		Pageable pageable = new PageRequest(page, 100, sort);
		List<TClass> topClass = classDao.getClassByFid(0L, pageable);
		return topClass;
	}

	@RequestMapping("/bottom")
	public String bottom() {
		return "web/bottom";
	}
	
	
	@RequestMapping("/zyrcindex")
	public String getZyrcIndex(HttpServletRequest request) {
		Sort sort = new Sort(Direction.DESC, "fSortFlag", "fzdTime", "ffbTime");
		int page = 0;
		Pageable pageable = new PageRequest(page, 10, sort);
		//获取考试通知
		Page<TNews> kstz = newsDao.getNewsBySecendId(7L, 111L, pageable);
		request.setAttribute("kstz", kstz.getContent());
		//获取培训通知
		Page<TNews> pxtz = newsDao.getNewsBySecendId(7L, 110L, pageable);
		request.setAttribute("pxtz", pxtz.getContent());
		//获取考试资料
		Sort examMaterialSort = new Sort(Direction.DESC, "fdjTimes", "ffbTime");
		Pageable examMaterialPageable = new PageRequest(page, 6, examMaterialSort);
		List<TxzzxNews> examMaterialList = xzzxNewsDao.getTxzzxFileByFlx(18L,122L,examMaterialPageable).getContent();
		request.setAttribute("examMaterialList", examMaterialList);
		
		
		
		
		//获取培训资料
		Sort practicMaterialSort = new Sort(Direction.DESC, "fdjTimes", "ffbTime");
		Pageable practicMaterialPageable = new PageRequest(page, 6, practicMaterialSort);
		List<TxzzxNews> practicMaterialList = xzzxNewsDao.getTxzzxFileByFlx(18L,121L,practicMaterialPageable).getContent();
		request.setAttribute("practicMaterialList", practicMaterialList);
		
		//推荐
		Page<TNews> tjNewsPage = newsDao.getNewsByFirstId(7L, pageable);
		request.setAttribute("tjNewsList", tjNewsPage.getContent());
		//热门
		Sort hotSort = new Sort(Direction.DESC, "fdjTimes");
		Pageable hotPageable = new PageRequest(page, 18, hotSort);
		Page<TNews> hotNewsPage = newsDao.getExamineNews(hotPageable);
		request.setAttribute("hotNewsList", hotNewsPage.getContent());
		return "web/zyrcindex";
	}
}
