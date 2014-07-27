package net.xqx.controller.web;

import java.sql.SQLException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPFaultException;

import net.xqx.dao.web.NewsDao;
import net.xqx.models.TNews;
import net.xqx.service.achievement.Achievement;
import net.xqx.service.achievement.AchievementService;
import net.xqx.tempmodels.TMark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 成绩查询
 * 
 * @author siyi
 * 
 */
@Controller
public class MarkQueryController {
	/**
	 * 新闻
	 */
	@Autowired
	NewsDao newsDao;

	/**
	 * 成绩查询
	 * 
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/markList")
	public String markList(HttpServletRequest request) throws SQLException {
		// 热门新闻
		Sort hotNewsSort = new Sort(Direction.DESC, "fdjTimes", "ffbTime");
		Pageable hotNewsRecPageable = new PageRequest(0, 8, hotNewsSort);
		List<TNews> hotNewsList = newsDao.getHotNews(hotNewsRecPageable)
				.getContent();
		request.setAttribute("hotNewsList", hotNewsList);

		// 推荐阅读
		Sort recNewsSort = new Sort(Direction.DESC, "fIsRecord", "ffbTime");
		Pageable recNewsRecPageable = new PageRequest(0, 8, recNewsSort);
		List<TNews> recNewsList = newsDao.getNewsRec(recNewsRecPageable)
				.getContent();
		request.setAttribute("recNewsList", recNewsList);
		return "web/markList";
	}

	/**
	 * 成绩查询
	 * 
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/markQuery")
	public String markQuery(HttpServletRequest request) throws SQLException {
		TMark mark = null;
		String userName = request.getParameter("userName");
		String admissionNo = request.getParameter("admissionNo");
		String licenseNo = request.getParameter("licenseNo");
		String year = request.getParameter("year");
		
		String input = request.getParameter("rand");
		
		String rand = (String) request.getSession().getAttribute("rand");
		if(input !=null && rand !=null)
		{
			if(!input.equals(rand))
			{
				request.setAttribute("CodeError2", "验证码输入错误！");
				return "redirect:markList.do";
			}
		}
		System.out.println(System.getProperty("java.endorsed.dirs"));
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring/services.xml" });
		AchievementService achievementService = (AchievementService) context
				.getBean("achievement");
		List<Achievement> list = null;
		try {
			list = (List<Achievement>) achievementService.getAchievements(
					userName, admissionNo, licenseNo, year);
		} catch (SOAPFaultException e) {
			request.setAttribute("error", "你没有权限!");
		} catch (WebServiceException ex) {
			request.setAttribute("error", "链接超时,请稍后再试!");
		}
		Achievement achievement = null;
		if (list != null && list.size() > 0) {
			achievement = list.get(0);
		}
		request.setAttribute("achievement", achievement);
		// 热门新闻
		Sort hotNewsSort = new Sort(Direction.DESC, "fdjTimes", "ffbTime");
		Pageable hotNewsRecPageable = new PageRequest(0, 8, hotNewsSort);
		List<TNews> hotNewsList = newsDao.getHotNews(hotNewsRecPageable)
				.getContent();
		request.setAttribute("hotNewsList", hotNewsList);

		// 推荐阅读
		Sort recNewsSort = new Sort(Direction.DESC, "fIsRecord", "ffbTime");
		Pageable recNewsRecPageable = new PageRequest(0, 8, recNewsSort);
		List<TNews> recNewsList = newsDao.getNewsRec(recNewsRecPageable)
				.getContent();
		request.setAttribute("recNewsList", recNewsList);
		request.setAttribute("mark", mark);
		return "web/markDetail";
	}
}
