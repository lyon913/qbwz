package net.xqx.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xqx.dao.admin.TUploadFileDao;
import net.xqx.models.TUploadFiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
/**
 * 资料下载的下载方法
 * @author siyi
 *
 */
public class UploadFileUtil {

	@Autowired
	TUploadFileDao uploadFileDao;

	@RequestMapping("/uploadFileDown")
	/**
	 * 所需要参数为
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView download(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		TUploadFiles uploadFile = null;
		String fileName = null;
		if (id != null && !"".equals(id)) {
			uploadFile = uploadFileDao.findOne(Long.parseLong(id));
			fileName = uploadFile.getfDownloadAddress();
		}

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;
		

		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" + "files\\";
		String downLoadPath = ctxPath + fileName;
		try {
			long fileLength = new File(downLoadPath).length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileName);
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;
	}
}
