package net.xqx.controller.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.admin.GjjgDao;
import net.xqx.dao.web.ClassDao;
import net.xqx.dao.web.LyNewsDao;
import net.xqx.dao.web.LyhfDao;
import net.xqx.dao.web.NewsDao;
import net.xqx.dao.web.PropertyDao;
import net.xqx.dao.web.UploadFileDao;
import net.xqx.dao.web.XzzxNewsDao;
import net.xqx.models.TClass;
import net.xqx.models.TNews;
import net.xqx.models.TProperty;
import net.xqx.models.Tgjjg;
import net.xqx.models.TlyNews;
import net.xqx.models.TlyhfNews;
import net.xqx.models.TxzzxNews;
import net.xqx.service.web.TotleRecService;
import net.xqx.util.PageString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 二级页面
 * 
 * @author siyi
 * 
 */
@SuppressWarnings("unused")
@Controller
public class TwoLevelController
{

	/**
	 * 属性方法
	 */
	@Autowired
	PropertyDao propertyDao;

	/**
	 * 新闻
	 */
	@Autowired
	NewsDao newsDao;

	/**
	 * 下载中心
	 */
	@Autowired
	XzzxNewsDao xzzxNewsDao;

	/**
	 * 资料文件
	 */
	@Autowired
	UploadFileDao uploadFileDao;

	/**
	 * 相关推荐
	 */
	@Autowired
	TotleRecService trs;

	/**
	 * 资料文件
	 */
	@Autowired
	LyNewsDao lyDao;

	@Autowired
	LyhfDao lyhfDao;

	/**
	 * 首页权限链接
	 */
	@Autowired
	ClassDao classDao;

	@Autowired
	GjjgDao gjdao;

	@RequestMapping("/newsOrFileSearch")
	public String newsOrFileSearch(HttpServletRequest request)
	{
		String keyWord = request.getParameter("keyWord");
		String searchType = request.getParameter("searchType");
		String forward = "web/searchNewsList";
		int page = 0;
		if (request.getParameter("page") != null && !"".equals(request.getParameter("page")))
		{
			page = Integer.valueOf(request.getParameter("page"));
		}
		String pageString = null;
		request.setAttribute("keyWord", keyWord);
		request.setAttribute("searchType", searchType);

		Sort searchNewsOrFileSort = new Sort(Direction.DESC, "ffbTime");
		Pageable searchNewsOrFilePageable = new PageRequest(page, 18, searchNewsOrFileSort);

		Page<TNews> searchNewsPage = null;
		List<TNews> searchNewsList = null;

		Page<TxzzxNews> searchFilePage = null;
		List<TxzzxNews> searchFileList = null;

		if ("0".equals(searchType))
		{
			if (keyWord != null && !"".equals(keyWord))
			{
				try
				{
					searchNewsPage = newsDao.getNewsByTitle("%" + keyWord + "%", searchNewsOrFilePageable);// 查询仅含有关键字的新闻
					pageString = PageString.getPageString(searchNewsPage, "newsOrFileSearch.do", "&type=" + searchType + "&keyWord=" + keyWord, page);
					searchNewsList = searchNewsPage.getContent();
				} catch (Exception e)
				{
					e.printStackTrace();
					return "web/error";
				}

			} else
			{
				try
				{
					searchNewsPage = newsDao.getHotNews(searchNewsOrFilePageable);//
					// 查询所有通过审核的新闻
					pageString = PageString.getPageString(searchNewsPage, "newsOrFileSearch.do", "&searchType=" + searchType, page);
					searchNewsList = searchNewsPage.getContent();

				} catch (Exception e)
				{
					e.printStackTrace();
					return "web/error";
				}

			}

		} else
		{
			if (keyWord != null && !"".equals(keyWord))
			{
				try
				{
					if (!"5".equals(searchType))
					{
						try
						{
							searchNewsPage = newsDao.getNewsByTitleAndType("%" + keyWord + "%", Long.parseLong(searchType), searchNewsOrFilePageable);// 查询仅含有关键字的新闻
							pageString = PageString.getPageString(searchNewsPage, "newsOrFileSearch.do", "searchType=" + searchType + "&keyWord=" + keyWord, page);
							searchNewsList = searchNewsPage.getContent();
						} catch (Exception e)
						{
							e.printStackTrace();
							return "web/error";
						}
					} else if ("5".equals(searchType))
					{
						try
						{

							searchFilePage = xzzxNewsDao.getNewsByTitle("%" + keyWord + "%", searchNewsOrFilePageable);// 查询仅含有关键字的新闻
							pageString = PageString.getPageString(searchFilePage, "newsOrFileSearch.do", "&searchType=" + searchType + "&keyWord=" + keyWord, page);
							searchFileList = searchFilePage.getContent();
							forward = "web/searchFileList";

						} catch (Exception e)
						{
							e.printStackTrace();
							return "web/error";
						}

					}

				} catch (Exception e)
				{
					e.printStackTrace();
					return "web/error";
				}
			} else
			{
				try
				{
					if (!"5".equals(searchType))
					{
						try
						{
							searchNewsPage = newsDao.getNewsByFirstId(Long.parseLong(searchType), searchNewsOrFilePageable);// 查询仅含有关键字的新闻
							pageString = PageString.getPageString(searchNewsPage, "newsOrFileSearch.do", "&searchType=" + searchType, page);
							searchNewsList = searchNewsPage.getContent();
						} catch (Exception e)
						{
							e.printStackTrace();
							return "web/error";
						}
					} else

					if ("5".equals(searchType))
					{
						try
						{

							searchFilePage = xzzxNewsDao.getXzzxNews(searchNewsOrFilePageable);// 查询仅含有关键字的新闻
							pageString = PageString.getPageString(searchFilePage, "newsOrFileSearch.do", "&searchType=" + searchType, page);
							searchFileList = searchFilePage.getContent();
							forward = "web/searchFileList";

						} catch (Exception e)
						{
							e.printStackTrace();
							return "web/error";
						}

					}

				} catch (Exception e)
				{
					e.printStackTrace();
					return "web/error";
				}
			}

		}
		request.setAttribute("searchFileList", searchFileList);
		request.setAttribute("searchNewsList", searchNewsList);
		request.setAttribute("pageString", pageString);
		// 热门新闻
		Sort hotNewsSort = new Sort(Direction.DESC, "fdjTimes", "ffbTime");
		Pageable hotNewsRecPageable = new PageRequest(0, 8, hotNewsSort);
		List<TNews> hotNewsList = newsDao.getHotNews(hotNewsRecPageable).getContent();
		request.setAttribute("hotNewsList", hotNewsList);

		// 推荐阅读
		Sort recNewsSort = new Sort(Direction.DESC, "fIsRecord", "ffbTime");
		Pageable recNewsRecPageable = new PageRequest(0, 8, recNewsSort);
		List<TNews> recNewsList = newsDao.getNewsRec(recNewsRecPageable).getContent();
		request.setAttribute("recNewsList", recNewsList);

		return forward;

	}

	/**
	 * 新闻二级页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/news")
	public String news(HttpServletRequest request)
	{
		String type = request.getParameter("type");
		String typeId = request.getParameter("typeId");
		if (typeId != null && !"".equals(typeId))
		{
			TProperty property = propertyDao.findOne(Long.valueOf(typeId));
			request.setAttribute("property", property);
			request.setAttribute("typeId", Long.valueOf(typeId));
		} else
		{
			TProperty property = propertyDao.findOne(Long.valueOf(type));
			request.setAttribute("property", property);
			request.setAttribute("typeId", "");
		}
		if (type.equals("1"))
		{
			request.setAttribute("fName", "协会之窗");
		}
		if (type.equals("4"))
		{
			request.setAttribute("fName", "会员中心");
		}
		if (type.equals("7"))
		{
			request.setAttribute("fName", "专业人才");
		}
		if (type.equals("9"))
		{
			request.setAttribute("fName", "行业评优");
		}
		// 查找新闻
		Sort sort = new Sort(Direction.DESC, "fSortFlag", "fzdTime", "ffbTime");
		int page = 0;
		if (request.getParameter("page") != null && !"".equals(request.getParameter("page")))
		{
			page = Integer.valueOf(request.getParameter("page"));
		}
		Pageable pageable = new PageRequest(page, 18, sort);

		// 热门排行
		Sort hotSort = new Sort(Direction.DESC, "fdjTimes");
		Pageable hotPageable = new PageRequest(page, 18, hotSort);

		Page<TNews> newsPage = null;// 新闻
		Page<TNews> tjNewsPage = null;// 推荐新闻
		Page<TNews> hotNewsPage = null;// 热门新闻
		if (type != null && !"".equals(type) && typeId != null && !"".equals(typeId))
		{
			try
			{
				newsPage = newsDao.getNewsBySecendId(Long.parseLong(type), Long.parseLong(typeId), pageable);
				// 查找推荐
				tjNewsPage = newsDao.getTjNewsByFirstId(Long.parseLong(type), pageable);
				// 热门新闻
				hotNewsPage = newsDao.getExamineNews(hotPageable);
			} catch (Exception e)
			{
				return "web/error";
			}
		}

		if (newsPage == null && type != null && !"".equals(type))
		{
			try
			{
				newsPage = newsDao.getNewsByFirstId(Long.parseLong(type), pageable);
				// 查找推荐
				tjNewsPage = newsDao.getTjNewsByFirstId(Long.parseLong(type), pageable);
				// 热门新闻
				hotNewsPage = newsDao.getExamineNews(hotPageable);
			} catch (Exception e)
			{
				return "web/error";
			}
		}
		String pageString = "";
		if (typeId != null && !"".equals(typeId))
		{
			pageString = PageString.getPageString(newsPage, "news.do", "&type=" + type + "&typeId=" + typeId, page);
		} else
		{
			pageString = PageString.getPageString(newsPage, "news.do", "&type=" + type, page);
		}
		request.setAttribute("newsList", newsPage.getContent());
		request.setAttribute("tjNewsList", tjNewsPage.getContent());
		request.setAttribute("hotNewsList", hotNewsPage.getContent());
		request.setAttribute("pageString", pageString);
		// 读取子类
		if (type != null && !"".equals(type))
		{
			List<TClass> classlist = classDao.getClassByFidNotPage(Long.valueOf(type));
			request.setAttribute("classlist", classlist);
		}
		return "web/news";
	}

	/**
	 * 资讯中心二级页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/zxzxnews")
	public String zxzxnews(HttpServletRequest request)
	{
		String type = request.getParameter("type");
		String typeId = request.getParameter("typeId");
		if (typeId != null && !"".equals(typeId))
		{
			TProperty property1 = propertyDao.findOne(Long.valueOf(typeId));
			request.setAttribute("property1", property1);
			request.setAttribute("typeId", Long.valueOf(typeId));
		} else
		{
			request.setAttribute("typeId", "");
		}

		if (type != null && !"".equals(type))
		{
			TProperty property = propertyDao.findOne(Long.valueOf(type));
			request.setAttribute("property", property);
		}

		// 查找新闻
		Sort sort = new Sort(Direction.DESC, "fSortFlag", "fzdTime","fSort", "ffbTime");
		int page = 0;
		if (request.getParameter("page") != null && !"".equals(request.getParameter("page")))
		{
			page = Integer.valueOf(request.getParameter("page"));
		}
		Pageable pageable = new PageRequest(page, 18, sort);

		// 科室介绍
		List<TProperty> ksjs=propertyDao.getPropertyByFid(4L);
		request.setAttribute("ksjs", ksjs);
		//就医指南
		if("2".equals(type)){
		List<TProperty> jyzn=propertyDao.getPropertyByFid(2L);
		request.setAttribute("jyzn", jyzn);
		}
		//医院概况
		if("1".equals(type)){
			List<TProperty> yygk=propertyDao.getPropertyByFid(1L);
			request.setAttribute("yygk", yygk);
			}
		//政务栏
		if("5".equals(type)){
			List<TProperty> zwl=propertyDao.getPropertyByFid(5L);
			request.setAttribute("zwl", zwl);
			}
		//信息公开
		if("6".equals(type)){
			List<TProperty> xxgk=propertyDao.getPropertyByFid(6L);
			request.setAttribute("xxgk", xxgk);
		}
		//健康之苑
		if("7".equals(type)){
			List<TProperty> jkzy=propertyDao.getPropertyByFid(7L);
			request.setAttribute("jkzy", jkzy);
		}
		Page<TNews> newsPage = null;// 新闻
		
		if (type != null && !"".equals(type) && typeId != null && !"".equals(typeId))
		{
			try
			{
				newsPage = newsDao.getNewsBySecendId(Long.parseLong(type), Long.parseLong(typeId), pageable);
				
			} catch (Exception e)
			{
				return "web/error";
			}
		}

		if (newsPage == null && type != null && !"".equals(type))
		{
			try
			{
				newsPage = newsDao.getNewsByFirstId(Long.parseLong(type), pageable);
				
			} catch (Exception e)
			{
				return "web/error";
			}
		}
		String pageString = "";
		if (typeId != null && !"".equals(typeId))
		{
			pageString = PageString.getPageString(newsPage, "zxzxnews.do", "&type=" + type + "&typeId=" + typeId, page);
		} else
		{
			pageString = PageString.getPageString(newsPage, "zxzxnews.do", "&type=" + type, page);
		}
		request.setAttribute("newsList", newsPage.getContent());
		request.setAttribute("pageString", pageString);
//		// 读取子类
//		if (type != null && !"".equals(type))
//		{
//			List<TClass> classlist = classDao.getClassByFidNotPage(Long.valueOf(type));
//			request.setAttribute("classlist", classlist);
//		}
		return "web/zxzxnews";
	}

	/**
	 * 投诉二级页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/tousu")
	public String tousu(HttpServletRequest request)
	{
		

		// 科室介绍
		List<TProperty> ksjs=propertyDao.getPropertyByFid(4L);
		request.setAttribute("ksjs", ksjs);
		
		//投诉新闻
		Sort sort = new Sort(Direction.DESC, "fSortFlag", "fzdTime", "ffbTime");
		Pageable pageable = new PageRequest(0, 1, sort);
		List<TProperty> firstIdList = propertyDao.getPropertyByfValue("新闻中心","投诉");
		if(firstIdList!=null&&firstIdList.size()>0){
			TProperty p = firstIdList.get(0);
		Page<TNews> n = newsDao.getNewsByFirstId(p.getId(), pageable);
		if(n!=null){
			List<TNews> nlist = n.getContent();
			TNews news = nlist.get(0);
			request.setAttribute("news", news);
		}
		
		}	
		return "web/tousu";
	}

	
	
	/**
	 * 下载中心 所有文件
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/xzzx")
	public String xzzx(HttpServletRequest request)
	{
		int page = 0;
		if (request.getParameter("page") != null && !"".equals(request.getParameter("page")))
		{
			page = Integer.valueOf(request.getParameter("page"));
		}
		Sort allUploadFileSort = new Sort(Direction.DESC, "ffbTime");
		Pageable allUploadFilePageable = new PageRequest(page, 18, allUploadFileSort);
		Page<TxzzxNews> allUploadFilePage = xzzxNewsDao.getXzzxNews(allUploadFilePageable);
		List<TxzzxNews> allUploadFileList = allUploadFilePage.getContent();
		String pageString = PageString.getPageString(allUploadFilePage, "xzzx.do", page);
		request.setAttribute("xzzxNews", allUploadFileList);
		request.setAttribute("pageString", pageString);
		// 热门新闻
		Sort hotNewsSort = new Sort(Direction.DESC, "fdjTimes", "ffbTime");
		Pageable hotNewsRecPageable = new PageRequest(page, 8, hotNewsSort);
		List<TNews> hotNewsList = newsDao.getHotNews(hotNewsRecPageable).getContent();
		request.setAttribute("hotNewsList", hotNewsList);

		// 推荐阅读
		Sort recNewsSort = new Sort(Direction.DESC, "fIsRecord", "ffbTime");
		Pageable recNewsRecPageable = new PageRequest(0, 8, recNewsSort);
		List<TNews> recNewsList = newsDao.getNewsRec(recNewsRecPageable, 7L).getContent();
		request.setAttribute("recNewsList", recNewsList);
		System.out.println("推荐：" + recNewsList.size());

		return "web/xzzx";
	}

	/**
	 * 下载中心 人才相关或者文件子类
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/xzzxPersonOrFile")
	public String xzzxPersonOrFile(HttpServletRequest request)
	{
		int page = 0;
		String type = request.getParameter("type");
		String typeId = request.getParameter("typeId");
		if (request.getParameter("page") != null && !"".equals(request.getParameter("page")))
		{
			page = Integer.valueOf(request.getParameter("page"));
		}
		Sort allUploadFileSort = new Sort(Direction.DESC, "ffbTime");
		Pageable allUploadFilePageable = new PageRequest(page, 18, allUploadFileSort);
		try
		{
			Page<TxzzxNews> allUploadFilePage = xzzxNewsDao.getTxzzxFileByFlx(Long.parseLong(type), Long.parseLong(typeId), allUploadFilePageable);
			List<TxzzxNews> allUploadFileList = allUploadFilePage.getContent();
			String pageString = PageString.getPageString(allUploadFilePage, "xzzx.do", page);
			request.setAttribute("xzzxNews", allUploadFileList);
			request.setAttribute("pageString", pageString);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		// 热门新闻
		Sort hotNewsSort = new Sort(Direction.DESC, "fdjTimes", "ffbTime");
		Pageable hotNewsRecPageable = new PageRequest(page, 8, hotNewsSort);
		List<TxzzxNews> hotNewsList = xzzxNewsDao.getTxzzxNewsPass(210L, hotNewsRecPageable).getContent();
		request.setAttribute("hotNewsList", hotNewsList);

		// 推荐阅读
		Sort recNewsSort = new Sort(Direction.DESC, "fIsRecord", "ffbTime");
		Pageable recNewsRecPageable = new PageRequest(0, 8, recNewsSort);
		List<TNews> recNewsList = newsDao.getNewsRec(recNewsRecPageable).getContent();
		request.setAttribute("recNewsList", recNewsList);

		return "web/xzzx";
	}



	
	
	// 发留言
	@RequestMapping("/addly")
	public String addLy(HttpServletRequest request, @ModelAttribute TlyNews lynews)
	{
		lynews.setfIp(request.getRemoteAddr());
		lyDao.save(lynews);
		return "redirect:ly.do";
	}

	// 获取留言列表
	@RequestMapping("/ly")
	public String getLyList(HttpServletRequest request)
	{
		String p = request.getParameter("page");
		Integer page = 0;
		if (p != null && !"".equals(p))
		{
			page = Integer.parseInt(p);
		}
		Sort sort1 = new Sort(Direction.DESC, "ffbTime");
		Pageable pageable = new PageRequest(page, 3, sort1);
		Page<TlyNews> lypage = lyDao.getLyPass(pageable);
		List<TlyNews> lylist = lypage.getContent();
		List<TlyNews> ly = new ArrayList<TlyNews>();
		for (int i = 0; i < lylist.size(); i++)
		{
			TlyNews ly1 = lylist.get(i);
			List<TlyhfNews> hflist = lyhfDao.findByLyid(ly1.getId());
			if (hflist != null && hflist.size() > 0)
			{
				ly1.setFhf(hflist);
				ly.add(ly1);
			} else
			{
				ly1.setFhf(null);
				ly.add(ly1);
			}
		}
		String pageString = PageString.getPageString(lypage, "ly.do", page);
		request.setAttribute("pageString", pageString);
		request.setAttribute("ly", ly);
		//就医指南
				List<TProperty> jyzn=propertyDao.getPropertyByFid(2L);
				request.setAttribute("jyzn", jyzn);
		// 导航
		Sort sort = new Sort(Direction.DESC, "fSortFlag");
		Pageable pageable1 = new PageRequest(page, 100, sort);
		List<TClass> classlist = classDao.getClassByFid(7L, pageable1);
		request.setAttribute("class", classlist);
		String message=request.getParameter("message");
		if(message!=null&&"1".equals(message)){
			request.setAttribute("message", "发表成功，等待管理员审核!");
		}
		return "web/ly";
	}

	@RequestMapping("/gjjg")
	public String getGjjg(HttpServletRequest request)
	{
		String p = request.getParameter("page");
		Integer page = 0;
		if (p != null && !"".equals(p))
		{
			page = Integer.parseInt(p);
		}
		Pageable pageable = new PageRequest(page, 17);
		Page<Tgjjg> gjpage = gjdao.findAll(pageable);
		request.setAttribute("gjjg", gjpage.getContent());
		String pageString = PageString.getPageString(gjpage, "gjjg.do", page);
		request.setAttribute("pageString", pageString);
		// 热门新闻
		Sort hotNewsSort = new Sort(Direction.DESC, "fdjTimes", "ffbTime");
		Pageable hotNewsRecPageable = new PageRequest(0, 8, hotNewsSort);
		List<TNews> hotNewsList = newsDao.getHotNews(hotNewsRecPageable).getContent();
		request.setAttribute("hotNewsList", hotNewsList);

		// 推荐阅读
		Sort recNewsSort = new Sort(Direction.DESC, "fIsRecord", "ffbTime");
		Pageable recNewsRecPageable = new PageRequest(0, 8, recNewsSort);
		List<TNews> recNewsList = newsDao.getNewsRec(recNewsRecPageable).getContent();
		request.setAttribute("recNewsList", recNewsList);
		return "web/gjjg";
	}
}
