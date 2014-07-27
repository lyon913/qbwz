package net.xqx.controller.web;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.admin.TNewsPicDao;
import net.xqx.dao.admin.TUploadFileDao;
import net.xqx.dao.web.ClassDao;
import net.xqx.dao.web.NewsDao;
import net.xqx.dao.web.PropertyDao;
import net.xqx.dao.web.XzzxNewsDao;
import net.xqx.models.TClass;
import net.xqx.models.TNews;
import net.xqx.models.TNewsPic;
import net.xqx.models.TProperty;
import net.xqx.models.TxzzxNews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 二级页面
 * 
 * @author siyi
 * 
 */
@Controller
public class ThreeLevelController
{

	/**
	 * 新闻dao
	 */
	@Autowired
	NewsDao newsDao;

	/**
	 * 属性方法
	 */
	@Autowired
	PropertyDao propertyDao;

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
	 * 资料文件
	 */
	@Autowired
	TUploadFileDao uploadFileDao;
	/**
	 * 新闻图片
	 */
	@Autowired
	TNewsPicDao newsPicDao;

	/**
	 * 协会简介三级页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showXhjj")
	public String showXhjj(HttpServletRequest request)
	{
		long djTimes=1L;
		Sort sort = new Sort(Direction.DESC, "fSortFlag", "fzdTime", "ffbTime");
		int page = 0;
		Pageable pageable = new PageRequest(page, 1, sort);
		Page<TNews> pageNews = newsDao.getNewsBySecendId(1L, 104L, pageable);
		List<TNews> newsList = pageNews.getContent();
		if (newsList != null && newsList.size() > 0)
		{
			request.setAttribute("news", newsList.get(0));
			TNews news = newsList.get(0);
			if(null==news.getFdjTimes()||"".equals(news.getFdjTimes()))
			{
				news.setFdjTimes(djTimes);
			}else
			{
				djTimes = news.getFdjTimes();
				news.setFdjTimes(++djTimes);
			}
			newsDao.save(news);
			
			// 相关阅读
			String keyWord = news.getfKeyWord();
			Sort xgSort = new Sort(Direction.DESC, "ffbTime");
			List<TNews> refNewsList = new ArrayList<TNews>();
			Pageable xgPageable = new PageRequest(0, 5, xgSort);
			if (keyWord != null && !"".equals(keyWord))
			{
				if (keyWord.contains("，"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("，"));
				}

				if (keyWord.contains(","))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf(","));
				}

				if (keyWord.contains("|"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("|"));
				}
				try
				{
					refNewsList = newsDao.getNewsByKeyWord(news.getId(),"%" + keyWord + "%", xgPageable).getContent();
					request.setAttribute("refNewsList", refNewsList);
				} catch (Exception e)
				{
					
				}
			}
		}

		// 推荐阅读
		Pageable pageable1 = new PageRequest(page, 15, sort);
		Page<TNews> recommandNewsList = newsDao.getNewsByFirstId(1L, pageable1);// 推荐阅读
		request.setAttribute("recommandNewsList", recommandNewsList.getContent());
		// 热门新闻
		Sort newsHotSort = new Sort(Direction.DESC, "fdjTimes", "fIsRecord");
		Pageable newsHotPageable = new PageRequest(0, 15, newsHotSort);
		List<TNews> hotNewsList = newsDao.getNewsHot(newsHotPageable, 1).getContent();// 热门新闻
		request.setAttribute("hotNewsList", hotNewsList);
		
		String type = String.valueOf(1);
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
		
		
		List<TClass> classlist = classDao.getClassByFidNotPage(1L);
		request.setAttribute("classlist", classlist);
		request.setAttribute("typeId", 104L);
		request.setAttribute("fName", "协会简介");
		return "web/show";
	}

	/**
	 * 组织机构三级页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showZzjg")
	public String showZzjg(HttpServletRequest request)
	{
		long djTimes=1L;
		Sort sort = new Sort(Direction.DESC, "fSortFlag", "fzdTime", "ffbTime");
		int page = 0;
		Pageable pageable = new PageRequest(page, 1, sort);
		// 先查询出所有协会简介
		Page<TNews> pageNews = newsDao.getNewsBySecendId(1L, 105L, pageable);
		List<TNews> newsList = pageNews.getContent();
		if (newsList != null && newsList.size() > 0)
		{
			request.setAttribute("news", newsList.get(0));
			
			TNews news = newsList.get(0);
			if(null==news.getFdjTimes()||"".equals(news.getFdjTimes()))
			{
				news.setFdjTimes(djTimes);
			}else
			{
				djTimes = news.getFdjTimes();
				news.setFdjTimes(++djTimes);
			}
			newsDao.save(news);
			
			// 相关阅读
			String keyWord = news.getfKeyWord();
			Sort xgSort = new Sort(Direction.DESC, "ffbTime");
			List<TNews> refNewsList = new ArrayList<TNews>();
			Pageable xgPageable = new PageRequest(0, 5, xgSort);
			if (keyWord != null && !"".equals(keyWord))
			{
				if (keyWord.contains("，"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("，"));
				}

				if (keyWord.contains(","))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf(","));
				}

				if (keyWord.contains("|"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("|"));
				}
				try
				{
					refNewsList = newsDao.getNewsByKeyWord(news.getId(),"%" + keyWord + "%", xgPageable).getContent();
					request.setAttribute("refNewsList", refNewsList);
				} catch (Exception e)
				{
								
				}
			}
		}
		
		
		
		// 推荐阅读
		Pageable pageable1 = new PageRequest(page, 15, sort);
		Page<TNews> recommandNewsList = newsDao.getNewsByFirstId(1L, pageable1);// 推荐阅读
		request.setAttribute("recommandNewsList", recommandNewsList.getContent());
		// 热门新闻
		Sort newsHotSort = new Sort(Direction.DESC, "fdjTimes", "fIsRecord");
		Pageable newsHotPageable = new PageRequest(0, 15, newsHotSort);
		List<TNews> hotNewsList = newsDao.getNewsHot(newsHotPageable, 1).getContent();// 热门新闻
		request.setAttribute("hotNewsList", hotNewsList);
				
		String type = String.valueOf(1);
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
				
				
		List<TClass> classlist = classDao.getClassByFidNotPage(1L);
		request.setAttribute("classlist", classlist);
		request.setAttribute("typeId", 104L);
		request.setAttribute("fName", "组织机构");
		return "web/show";
	}

	/**
	 * 入会须知三级页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showRhxz")
	public String showRhxz(HttpServletRequest request)
	{
		Sort sort = new Sort(Direction.DESC, "fSortFlag", "fzdTime", "ffbTime");
		int page = 0;
		Pageable pageable = new PageRequest(page, 1, sort);
		// 先查询出所有协会简介
		Page<TNews> pageNews = newsDao.getNewsBySecendId(5L, 160L, pageable);
		List<TNews> newsList = pageNews.getContent();
		if (newsList != null && newsList.size() > 0)
		{
			request.setAttribute("news", newsList.get(0));
		}
		return "web/show";
	}

	/**
	 * 入会申请三级页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showRhsq")
	public String showRhsq(HttpServletRequest request)
	{
		Sort sort = new Sort(Direction.DESC, "fSortFlag", "fzdTime", "ffbTime");
		int page = 0;
		Pageable pageable = new PageRequest(page, 1, sort);
		// 先查询出所有协会简介
		Page<TNews> pageNews = newsDao.getNewsBySecendId(4L, 161L, pageable);
		List<TNews> newsList = pageNews.getContent();
		if (newsList != null && newsList.size() > 0)
		{
			request.setAttribute("news", newsList.get(0));
			TNews news = newsList.get(0);
			if(null==news.getFdjTimes()||"".equals(news.getFdjTimes()))
			{
				news.setFdjTimes(1L);
			}else
			{
				news.setFdjTimes(news.getFdjTimes()+1L);
			}
			newsDao.save(news);
			TProperty property = propertyDao.findOne(news.getFlxSecond().getId());
			request.setAttribute("property", property);
			// 推荐阅读
			Sort newsRecSort = new Sort(Direction.DESC, "fIsRecord", "fzdTime");
			Pageable newsRecPageable = new PageRequest(0, 15, newsRecSort);
			List<TNews> recommandNewsList = newsDao.getNewsRec(newsRecPageable, news.getFlxFirst().getId()).getContent();// 推荐阅读
			request.setAttribute("recommandNewsList", recommandNewsList);
			// 热门新闻
			Sort newsHotSort = new Sort(Direction.DESC, "fdjTimes", "fIsRecord");
			Pageable newsHotPageable = new PageRequest(0, 15, newsHotSort);
			List<TNews> hotNewsList = newsDao.getNewsHot(newsHotPageable, news.getFlxFirst().getId()).getContent();// 热门新闻
			request.setAttribute("hotNewsList", hotNewsList);
			// 相关阅读
			String keyWord = news.getfKeyWord();
			Sort xgSort = new Sort(Direction.DESC, "ffbTime");
			List<TNews> refNewsList = new ArrayList<TNews>();
			Pageable xgPageable = new PageRequest(0, 5, xgSort);
			if (keyWord != null && !"".equals(keyWord))
			{
				if (keyWord.contains("，"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("，"));
				}

				if (keyWord.contains(","))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf(","));
				}

				if (keyWord.contains("|"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("|"));
				}
				try
				{
					refNewsList = newsDao.getNewsByKeyWord(news.getId(),"%" + keyWord + "%", xgPageable).getContent();
					request.setAttribute("refNewsList", refNewsList);
				} catch (Exception e)
				{
				}	
			}
			
		}
		List<TClass> classlist = classDao.getClassByFidNotPage(4L);
		request.setAttribute("classlist", classlist);
		request.setAttribute("typeId", 161L);

		return "web/showRhsq";
	}

	/**
	 * 会员管理制度三级页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showHygl")
	public String showHygl(HttpServletRequest request)
	{
		Sort sort = new Sort(Direction.DESC, "fSortFlag", "fzdTime", "ffbTime");
		int page = 0;
		Pageable pageable = new PageRequest(page, 1, sort);
		// 先查询出所有协会简介
		Page<TNews> pageNews = newsDao.getNewsBySecendId(4L, 162L, pageable);
		List<TNews> newsList = pageNews.getContent();
		if (newsList != null && newsList.size() > 0)
		{
			request.setAttribute("news", newsList.get(0));
			TNews news = newsList.get(0);
			if(null==news.getFdjTimes()||"".equals(news.getFdjTimes()))
			{
				news.setFdjTimes(1L);
			}else
			{
				news.setFdjTimes(news.getFdjTimes()+1L);
			}
			newsDao.save(news);
			TProperty property = propertyDao.findOne(news.getFlxSecond().getId());
			request.setAttribute("property", property);
			// 推荐阅读
			Sort newsRecSort = new Sort(Direction.DESC, "fIsRecord", "fzdTime");
			Pageable newsRecPageable = new PageRequest(0, 15, newsRecSort);
			List<TNews> recommandNewsList = newsDao.getNewsRec(newsRecPageable, news.getFlxFirst().getId()).getContent();// 推荐阅读
			request.setAttribute("recommandNewsList", recommandNewsList);
			// 热门新闻
			Sort newsHotSort = new Sort(Direction.DESC, "fdjTimes", "fIsRecord");
			Pageable newsHotPageable = new PageRequest(0, 15, newsHotSort);
			List<TNews> hotNewsList = newsDao.getNewsHot(newsHotPageable, news.getFlxFirst().getId()).getContent();// 热门新闻
			request.setAttribute("hotNewsList", hotNewsList);
			// 相关阅读
			String keyWord = news.getfKeyWord();
			Sort xgSort = new Sort(Direction.DESC, "ffbTime");
			List<TNews> refNewsList = new ArrayList<TNews>();
			Pageable xgPageable = new PageRequest(0, 5, xgSort);
			if (keyWord != null && !"".equals(keyWord))
			{
				if (keyWord.contains("，"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("，"));
				}

				if (keyWord.contains(","))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf(","));
				}

				if (keyWord.contains("|"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("|"));
				}
				try
				{
					refNewsList = newsDao.getNewsByKeyWord(news.getId(),"%" + keyWord + "%", xgPageable).getContent();
					request.setAttribute("refNewsList", refNewsList);
				} catch (Exception e)
				{
				}
			}
			request.setAttribute("refNewsList", refNewsList);
		}
		List<TClass> classlist = classDao.getClassByFidNotPage(4L);
		request.setAttribute("classlist", classlist);
		request.setAttribute("typeId", 162L);
		return "web/showRhsq";
	}

	/**
	 * 根据id查询新闻内容
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showNews")
	public String showNews(HttpServletRequest request)
	{
		long djTimes = 1L;
		String id = request.getParameter("id");
		TNews news = null;
		if (id != null)
		{
			try
			{
				news = newsDao.findOne(Long.parseLong(id));
				List<TClass> classlist = classDao.getClassByFidNotPage(news.getFlxFirst().getId());
				request.setAttribute("classlist", classlist);
				if (news.getFdjTimes() == null || "".equals(news.getFdjTimes()))
				{
					news.setFdjTimes(djTimes);
				} else
				{
					djTimes = news.getFdjTimes();
					try
					{
						news.setFdjTimes(++djTimes);
					} catch (Exception e)
					{
					}
				}
				newsDao.save(news);
				List<TNewsPic> newsPicList = null;
				newsPicList = newsPicDao.getByNewsId(Long.parseLong(id));
				request.setAttribute("newsPicList", newsPicList);
				request.setAttribute("news", news);
				String type = String.valueOf(news.getFlxFirst().getId());
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
			} catch (Exception e)
			{
				// e.printStackTrace();
				return "web/error";
			}

			// 推荐阅读
			Sort newsRecSort = new Sort(Direction.DESC, "fIsRecord", "fzdTime");
			Pageable newsRecPageable = new PageRequest(0, 15, newsRecSort);
			List<TNews> recommandNewsList = newsDao.getNewsRec(newsRecPageable, news.getFlxFirst().getId()).getContent();// 推荐阅读
			request.setAttribute("recommandNewsList", recommandNewsList);
			// 热门新闻
			Sort newsHotSort = new Sort(Direction.DESC, "fdjTimes", "fIsRecord");
			Pageable newsHotPageable = new PageRequest(0, 15, newsHotSort);
			List<TNews> hotNewsList = newsDao.getNewsHot(newsHotPageable, news.getFlxFirst().getId()).getContent();// 热门新闻
			request.setAttribute("hotNewsList", hotNewsList);
			// 相关阅读
			String keyWord = news.getfKeyWord();
			Sort xgSort = new Sort(Direction.DESC, "ffbTime");
			List<TNews> refNewsList = new ArrayList<TNews>();
			Pageable xgPageable = new PageRequest(0, 5, xgSort);
			if (keyWord != null && !"".equals(keyWord))
			{
				if (keyWord.contains("，"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("，"));
				}

				if (keyWord.contains(","))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf(","));
				}

				if (keyWord.contains("|"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("|"));
				}
				try
				{
					refNewsList = newsDao.getNewsByKeyWord(news.getId(),"%" + keyWord + "%", xgPageable).getContent();
					request.setAttribute("refNewsList", refNewsList);
				} catch (Exception e)
				{
				}
			}
			request.setAttribute("refNewsList", refNewsList);
		}

		return "web/show";
	}

	/**
	 * 房协刊物三级
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showFxkwNews")
	public String showFxkwNews(HttpServletRequest request)
	{
		long djTimes = 1L;
		String id = request.getParameter("id");
		TNews news = null;
		if (id != null)
		{
			try
			{
				news = newsDao.findOne(Long.parseLong(id));
				List<TClass> classlist = classDao.getClassByFidNotPage(news.getFlxFirst().getId());
				request.setAttribute("classlist", classlist);
				if (news.getFdjTimes() == null || "".equals(news.getFdjTimes()))
				{
					news.setFdjTimes(djTimes);
				} else
				{
					djTimes = news.getFdjTimes();
					try
					{
						news.setFdjTimes(++djTimes);
					} catch (Exception e)
					{
					}
				}
				newsDao.save(news);
				List<TNewsPic> newsPicList = null;
				newsPicList = newsPicDao.getByNewsId(Long.parseLong(id));
				request.setAttribute("newsPicList", newsPicList);
				request.setAttribute("news", news);
			} catch (Exception e)
			{
				// e.printStackTrace();
				return "web/error";
			}

			// 推荐阅读
			Sort newsRecSort = new Sort(Direction.DESC, "fIsRecord", "fzdTime");
			Pageable newsRecPageable = new PageRequest(0, 15, newsRecSort);
			List<TNews> recommandNewsList = newsDao.getNewsRec(newsRecPageable, news.getFlxFirst().getId()).getContent();// 推荐阅读
			request.setAttribute("recommandNewsList", recommandNewsList);
			// 热门新闻
			Sort newsHotSort = new Sort(Direction.DESC, "fdjTimes", "fIsRecord");
			Pageable newsHotPageable = new PageRequest(0, 15, newsHotSort);
			List<TNews> hotNewsList = newsDao.getNewsHot(newsHotPageable, news.getFlxFirst().getId()).getContent();// 热门新闻
			request.setAttribute("hotNewsList", hotNewsList);
			// 相关阅读
			String keyWord = news.getfKeyWord();
			Sort xgSort = new Sort(Direction.DESC, "ffbTime");
			List<TNews> refNewsList = new ArrayList<TNews>();
			Pageable xgPageable = new PageRequest(0, 5, xgSort);
			if (keyWord != null && !"".equals(keyWord))
			{
				if (keyWord.contains("，"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("，"));
				}

				if (keyWord.contains(","))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf(","));
				}

				if (keyWord.contains("|"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("|"));
				}
				try
				{
					refNewsList = newsDao.getNewsByKeyWord(news.getId(),"%" + keyWord + "%", xgPageable).getContent();
					request.setAttribute("refNewsList", refNewsList);
				} catch (Exception e)
				{
				}
			}
			request.setAttribute("refNewsList", refNewsList);
		}

		return "web/showFxkw";
	}

	/**
	 * 资讯中心三级页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showZxzxNews")
	public String showZxzxNews(HttpServletRequest request)
	{
		long djTimes = 1L;
		String id = request.getParameter("id");
		TNews news = null;
		if (id != null)
		{
			try
			{
				news = newsDao.findOne(Long.parseLong(id));
				if (news.getFdjTimes() == null || "".equals(news.getFdjTimes()))
				{
					news.setFdjTimes(djTimes);
				} else
				{
					djTimes = news.getFdjTimes();
					try
					{
						news.setFdjTimes(++djTimes);
					} catch (Exception e)
					{
					}
				}
				newsDao.save(news);
				
				request.setAttribute("property", news.getFlxFirst());
				request.setAttribute("property1", news.getFlxSecond());
				//就医指南
				if(news.getFlxFirst()!=null&&news.getFlxFirst().getId()==2){
					List<TProperty> jyzn=propertyDao.getPropertyByFid(2L);
					request.setAttribute("jyzn", jyzn);
					}
				//医院概况
				if(news.getFlxFirst()!=null&&news.getFlxFirst().getId()==1){
						List<TProperty> yygk=propertyDao.getPropertyByFid(1L);
						request.setAttribute("yygk", yygk);
				}
				//政务栏
				if(news.getFlxFirst()!=null&&news.getFlxFirst().getId()==5){
					List<TProperty> zwl=propertyDao.getPropertyByFid(5L);
					request.setAttribute("zwl", zwl);
			}
				//信息公开
				if(news.getFlxFirst()!=null&&news.getFlxFirst().getId()==6){
					List<TProperty> xxgk=propertyDao.getPropertyByFid(6L);
					request.setAttribute("xxgk", xxgk);
			}
				//健康之苑
				if(news.getFlxFirst()!=null&&news.getFlxFirst().getId()==7){
					List<TProperty> jkzy=propertyDao.getPropertyByFid(7L);
					request.setAttribute("jkzy", jkzy);
			}
				List<TNewsPic> newsPicList = null;
				newsPicList = newsPicDao.getByNewsId(Long.parseLong(id));
				request.setAttribute("newsPicList", newsPicList);
				request.setAttribute("news", news);
				
			} catch (Exception e)
			{
				// e.printStackTrace();
				return "web/error";
			}

			// 科室介绍
			List<TProperty> ksjs=propertyDao.getPropertyByFid(4L);
			request.setAttribute("ksjs", ksjs);
		
			// 相关阅读
			String keyWord = news.getfKeyWord();
			Sort xgSort = new Sort(Direction.DESC, "ffbTime");
			List<TNews> refNewsList = new ArrayList<TNews>();
			Pageable xgPageable = new PageRequest(0, 5, xgSort);
			if (keyWord != null && !"".equals(keyWord))
			{
				if (keyWord.contains("，"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("，"));
				}

				if (keyWord.contains(","))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf(","));
				}

				if (keyWord.contains("|"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("|"));
				}
				try
				{
					refNewsList = newsDao.getNewsByKeyWord(news.getId(),"%" + keyWord + "%", xgPageable).getContent();
					request.setAttribute("refNewsList", refNewsList);
				} catch (Exception e)
				{
				}
			}
			request.setAttribute("refNewsList", refNewsList);

		}

		return "web/showZxzxNews";
	}

	/**
	 * 科室介绍三级页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/keshi")
	public String keshi(HttpServletRequest request)
	{
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(0, 1, sort);
		// 科室介绍
		String type = request.getParameter("type");
	String typeId = request.getParameter("typeId");

	if(type!=null&&typeId!=null){
		TProperty property = propertyDao.findOne(Long.parseLong(type));
		request.setAttribute("property", property);
		List<TNews> newsList = newsDao.getNewsBySecendId(Long.parseLong(type),Long.parseLong(typeId), pageable).getContent();
		if(newsList!=null&&newsList.size()>0){
			TNews news = (TNews)newsList.get(0);
			List<TNewsPic> newsPicList = null;
			newsPicList = newsPicDao.getByNewsId(news.getId());
			request.setAttribute("newsPicList", newsPicList);
			request.setAttribute("news", news);
		}
		// 科室介绍
					List<TProperty> ksjs=propertyDao.getPropertyByFid(4L);
					request.setAttribute("ksjs", ksjs);
		
	}
		
		return "web/showZxzxNews";
	}
	
	/**
	 * 资讯中心三级页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showZcfgNews")
	public String showZcfgNews(HttpServletRequest request)
	{
		long djTimes = 1L;
		String id = request.getParameter("id");
		TNews news = null;
		if (id != null)
		{
			try
			{
				news = newsDao.findOne(Long.parseLong(id));
				if (news.getFdjTimes() == null || "".equals(news.getFdjTimes()))
				{
					news.setFdjTimes(djTimes);
				} else
				{
					djTimes = news.getFdjTimes();
					try
					{
						news.setFdjTimes(++djTimes);
					} catch (Exception e)
					{
					}
				}
				newsDao.save(news);
				List<TNewsPic> newsPicList = null;
				newsPicList = newsPicDao.getByNewsId(Long.parseLong(id));
				request.setAttribute("newsPicList", newsPicList);
				request.setAttribute("news", news);
			} catch (Exception e)
			{
				// e.printStackTrace();
				return "web/error";
			}

			// 推荐阅读
			Sort newsRecSort = new Sort(Direction.DESC, "fIsRecord", "fzdTime");
			Pageable newsRecPageable = new PageRequest(0, 15, newsRecSort);
			List<TNews> recommandNewsList = newsDao.getNewsRec(newsRecPageable, news.getFlxFirst().getId()).getContent();// 推荐阅读
			request.setAttribute("recommandNewsList", recommandNewsList);
			// 热门新闻
			Sort newsHotSort = new Sort(Direction.DESC, "fdjTimes", "fIsRecord");
			Pageable newsHotPageable = new PageRequest(0, 15, newsHotSort);
			List<TNews> hotNewsList = newsDao.getExamineNews(newsHotPageable).getContent();// 热门新闻
			request.setAttribute("hotNewsList", hotNewsList);
			// 相关阅读
			String keyWord = news.getfKeyWord();
			Sort xgSort = new Sort(Direction.DESC, "ffbTime");
			List<TNews> refNewsList = new ArrayList<TNews>();
			Pageable xgPageable = new PageRequest(0, 5, xgSort);
			if (keyWord != null && !"".equals(keyWord))
			{
				if (keyWord.contains("，"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("，"));
				}

				if (keyWord.contains(","))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf(","));
				}

				if (keyWord.contains("|"))
				{
					keyWord = keyWord.substring(0, keyWord.indexOf("|"));
				}
				try
				{
					refNewsList = newsDao.getNewsByKeyWord(news.getId(),"%" + keyWord + "%", xgPageable).getContent();
					request.setAttribute("refNewsList", refNewsList);
				} catch (Exception e)
				{
				}
			}
			request.setAttribute("refNewsList", refNewsList);

		}

		return "web/showzcfgnews";
	}

	/**
	 * 下载中心
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/showXzzxNews")
	public String showXzzxNews(HttpServletRequest request)
	{
		long id;
		long djTimes = 1L;
		TxzzxNews xzzxNews = null;
		if (request.getParameter("id") != null)
		{
			// 先查询出所有协会简介
			id = Long.valueOf(request.getParameter("id"));
			xzzxNews = xzzxNewsDao.findOne(id);
			if(null==xzzxNews.getFdjTimes()||"".equals(xzzxNews.getFdjTimes()))
			{
				xzzxNews.setFdjTimes(djTimes);
			}else
			{
				djTimes = xzzxNews.getFdjTimes();
				xzzxNews.setFdjTimes(++djTimes);
			}
			xzzxNewsDao.save(xzzxNews);
			request.setAttribute("xzzxNews", xzzxNews);
			request.setAttribute("file", xzzxNews.getfFile());

		}
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
		return "web/showXzzx";
	}
}
