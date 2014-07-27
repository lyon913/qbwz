package net.xqx.controller.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.xqx.dao.web.NewsDao;
import net.xqx.dao.web.PageDao;
import net.xqx.models.TNews;
import net.xqx.tempmodels.TCompanyInfo;
import net.xqx.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 企业资质
 * 
 * @author siyi
 * 
 */
@Controller
public class QyzzController
{
	/**
	 * 新闻
	 */
	@Autowired
	NewsDao newsDao;

	/**
	 * 企业资质查询
	 * 
	 * @return
	 */
	@RequestMapping("/fdckfqy")
	public String fdckfqy(HttpServletRequest request)
	{
		PageDao pageDao = new PageDao();
		String pageCount = request.getParameter("pageCount");// 从页面取得页码
		if (pageCount == null || "".equals(pageCount))
		{
			pageCount = "1";
		}
		int totalRow = 0;// 获取总记录数目
		String total =request.getParameter("totalRow"); 
		int totalrow=0;
		if(null!=total && !"".equals(total))
		{
			totalrow=Integer.parseInt(total);	
		}
		
		Page page = null;
		String companyName = request.getParameter("companyName");
		if(companyName!=null&&!"".equals(companyName)){
			companyName=companyName.trim();
		}
		String certificateLevel = request.getParameter("certificateLevel");
		request.setAttribute("companyName", companyName);
		request.setAttribute("certificateLevel", certificateLevel);
		
		Connection conn = pageDao.getAptitudeConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		String hql = "";
		try
		{

			if (companyName != null && !"".equals(companyName) && (certificateLevel == null || "".equals(certificateLevel)))
			{
				hql = "select count(*) from TCompanyInfo c left join TCertificate cer " + "on c.fCompanyId=cer.fCompanyId left join TRegInfo r "
						+ "on c.fCompanyId=r.fCompanyInfoId where c.fChecked=1 and c.fCompanyName like " + "'" + "%" + companyName + "%" + "'";
				String sql = "select c.fCompanyName,c.fCompanyType,c.fRightMan,r.fCapital,r.fPaiclUpCapital,r.fRegLicenseNo,"
						+ "cer.fCertificateLevel,cer.fCertificateNo,c.fOperatingDate,cer.fCertifyDate,"
						+ "cer.fValidBeginDate,cer.fValidEndDate,c.fAddress,c.fDetails,c.fCompanyId from TCompanyInfo c left join TCertificate cer "
						+ "on c.fCompanyId=cer.fCompanyId left join TRegInfo r " + "on c.fCompanyId=r.fCompanyInfoId where c.fChecked=1 and c.fCompanyName like ? order by c.fCompanyId desc";
				totalRow = pageDao.getAmount(hql);// 通过select count 取得总记录数
				if(totalRow!=totalrow)
				{
					pageCount="1";
				}
				page = new Page(totalRow, pageCount, 11);
				statement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				statement.setMaxRows(page.getEndIndex());
				statement.setString(1, "%" + companyName + "%");
				rs = statement.executeQuery();
				rs.first();
				rs.relative(page.getBeginIndex() - 1);
				request.setAttribute("totalPage", page.getTotal());// 总页码
				request.setAttribute("pageCount", page.getCount());// 当前页码
				request.setAttribute("companyName", companyName);// 保留查询条件
			} else if (companyName != null && !"".equals(companyName) && certificateLevel != null && !"".equals(certificateLevel))
			{
				hql = "select count(*) from TCompanyInfo c left join TCertificate cer " + "on c.fCompanyId=cer.fCompanyId left join TRegInfo r "
						+ "on c.fCompanyId=r.fCompanyInfoId where c.fChecked=1 and c.fCompanyName like " + "'" + "%" + companyName + "%" + "'" + " and cer.fCertificateLevel=" + "'" + certificateLevel
						+ "'";

				String sql = "select c.fCompanyName,c.fCompanyType,c.fRightMan,r.fCapital,r.fPaiclUpCapital,r.fRegLicenseNo,"
						+ "cer.fCertificateLevel,cer.fCertificateNo,c.fOperatingDate,cer.fCertifyDate,"
						+ "cer.fValidBeginDate,cer.fValidEndDate,c.fAddress,c.fDetails,c.fCompanyId from TCompanyInfo c left join TCertificate cer "
						+ "on c.fCompanyId=cer.fCompanyId left join TRegInfo r "
						+ "on c.fCompanyId=r.fCompanyInfoId where c.fChecked=1 and c.fCompanyName like ? and cer.fCertificateLevel=? order by c.fCompanyId desc";
				totalRow = pageDao.getAmount(hql);// 通过select count 取得总记录数
				if(totalRow!=totalrow)
				{
					pageCount="1";
				}
				page = new Page(totalRow, pageCount, 11);
				statement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				statement.setMaxRows(page.getEndIndex());
				statement.setString(1, "%" + companyName + "%");
				statement.setString(2, certificateLevel);
				rs = statement.executeQuery();
				rs.first();
				rs.relative(page.getBeginIndex() - 1);
				request.setAttribute("totalPage", page.getTotal());// 总页码
				request.setAttribute("pageCount", page.getCount());// 当前页码说
				request.setAttribute("companyName", companyName);// 保留查询条件
				request.setAttribute("certificateLevel", certificateLevel);// 保留查询条件
			}

			TCompanyInfo companyInfo = null;
			List<TCompanyInfo> companyInfos = new ArrayList<TCompanyInfo>();
			if (rs != null)
			{
				while (rs.next())
				{
					companyInfo = new TCompanyInfo();
					companyInfo.setfCompanyName(rs.getString(1));
					companyInfo.setfCompanyType(rs.getString(2));
					companyInfo.setfRightMan(rs.getString(3));
					companyInfo.setfCapitals(rs.getString(4));
					companyInfo.setfCapitalsUp(rs.getString(5));
					companyInfo.setfLicenseNo(rs.getString(6));
					companyInfo.setfCertificateLevel(rs.getString(7));
					companyInfo.setfCertificateNo(rs.getString(8));
					companyInfo.setfOperatingDate(rs.getString(9));
					companyInfo.setfCertificateDate(rs.getString(10));
					companyInfo.setfCertificateBeginDate(rs.getString(11));
					companyInfo.setfCertificateEndDate(rs.getString(12));
					companyInfo.setfRegAddress(rs.getString(13));
					companyInfo.setfDetails(rs.getString(14));
					companyInfo.setfCompanyId(rs.getInt(15));
					companyInfos.add(companyInfo);
				}
			}
			request.setAttribute("companyInfos", companyInfos);
			// rs.close();
			// statement.close();
			// conn.close();

		} catch (SQLException e)
		{
			System.out.println("查询出错!");
			e.printStackTrace();
			return "web/qycx";
		}finally{
			pageDao.closeConnection(rs, statement, conn);
			
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
		request.setAttribute("totalRow", totalRow);
		return "web/qycx";
	}

	/**
	 * 显示企业信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("showCompany")
	public String showCompany(HttpServletRequest request)
	{
		PageDao pageDao = new PageDao();
		String id = request.getParameter("id");
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement=null;
		if (id != null && !"".equals(id))
		{
			try
			{
				conn = pageDao.getAptitudeConnection();
				String sql = "select c.fCompanyName,c.fCompanyType,c.fRightMan,r.fCapital,r.fPaiclUpCapital,r.fRegLicenseNo,"
						+ "cer.fCertificateLevel,cer.fCertificateNo,c.fOperatingDate,cer.fCertifyDate,"
						+ "cer.fValidBeginDate,cer.fValidEndDate,c.fAddress,c.fDetails,c.fCompanyId from TCompanyInfo c left join TCertificate cer "
						+ "on c.fCompanyId=cer.fCompanyId left join TRegInfo r " + "on c.fCompanyId=r.fCompanyInfoId where c.fCompanyId=?";
				statement= conn.prepareStatement(sql);
				statement.setInt(1, Integer.parseInt(id));
				rs = statement.executeQuery();
				TCompanyInfo companyInfo = null;
				if (rs != null)
				{
					while (rs.next())
					{
						companyInfo = new TCompanyInfo();
						companyInfo.setfCompanyName(rs.getString(1));
						companyInfo.setfCompanyType(rs.getString(2));
						companyInfo.setfRightMan(rs.getString(3));
						companyInfo.setfCapitals(rs.getString(4));
						companyInfo.setfCapitalsUp(rs.getString(5));
						companyInfo.setfLicenseNo(rs.getString(6));
						companyInfo.setfCertificateLevel(rs.getString(7));
						companyInfo.setfCertificateNo(rs.getString(8));
						companyInfo.setfOperatingDate(rs.getString(9));
						companyInfo.setfCertificateDate(rs.getString(10));
						companyInfo.setfCertificateBeginDate(rs.getString(11));
						companyInfo.setfCertificateEndDate(rs.getString(12));
						companyInfo.setfRegAddress(rs.getString(13));
						companyInfo.setfDetails(rs.getString(14));
						companyInfo.setfCompanyId(rs.getInt(15));
					}
				}
				request.setAttribute("companyInfo", companyInfo);
				rs.close();
				statement.close();
				conn.close();
			} catch (SQLException e)
			{
				System.out.println("查询出错!");
				e.printStackTrace();
			}finally{
				pageDao.closeConnection(rs, statement, conn);
			}
		}

		return "web/showCompany";
	}

}
