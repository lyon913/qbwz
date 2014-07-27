package net.xqx.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPFaultException;

import net.xqx.dao.web.NewsDao;
import net.xqx.models.TNews;
import net.xqx.service.certificate.CertificateReg;
import net.xqx.service.certificate.CertificateRegService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CertificateController {

	/**
	 * 新闻
	 */
	@Autowired
	NewsDao newsDao;

	@RequestMapping("/getcertificate")
	public String getCertificates(HttpServletRequest request) {
		String name = request.getParameter("name");
		String licenseNo = request.getParameter("licenseNo");

		String input = request.getParameter("rand");
		String rand = (String) request.getSession().getAttribute("rand");
		if (input != null && rand != null) {
			if (!input.equals(rand)) {
				request.setAttribute("CodeError1", "验证码输入错误！");
				return "redirect:zyrcindex.do";
			}
		}

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring/services.xml" });
		CertificateRegService certificateService = (CertificateRegService) context
				.getBean("certificate");

		List<CertificateReg> list = null;
		try {
			list = (List<CertificateReg>) certificateService.getCertificates(
					name, licenseNo);
		} catch (SOAPFaultException e) {
			request.setAttribute("error", "你没有权限!");
		} catch (WebServiceException ex) {
			request.setAttribute("error", "链接超时,请稍后再试!");
		}
		request.setAttribute("certificateList", list);

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
		return "web/certificate/certificateDetail";
	}
}
