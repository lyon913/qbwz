package net.xqx.controller.admin;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import net.xqx.dao.admin.GjjgDao;
import net.xqx.models.Tgjjg;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Controller
@RequestMapping("/admin")
public class ExcelImportController {
	
	@Autowired
	GjjgDao gjdao;
	@PersistenceContext
	EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	@RequestMapping("/import")
	public String importExcel(HttpServletRequest request,Model m,@RequestParam("file") CommonsMultipartFile file) throws SQLException{
		try {
			Session session=(Session)em.getDelegate();
			if(session.isOpen()==false){
				session=session.getSessionFactory().openSession();
			}
			String version = "";
			String message= "";
			version = request.getParameter("version");
			if(version.equals("07")){
				XSSFWorkbook wbs = new XSSFWorkbook(file.getInputStream());   
			    XSSFSheet cs = wbs.getSheetAt(0);   
			    
			    int rowNum  = cs.getLastRowNum();
			    List<Tgjjg> list = gjdao.findAll();
				if(list!=null && list.size()>0){
					gjdao.deleteAll();
				}
				for(int i =1 ;i<=rowNum;i++){
					XSSFRow row = cs.getRow(i);
					    Tgjjg gjjg = new Tgjjg();
					    if(row.getCell((short)6)!=null){
					    	message="所导入文件有冗余数据，系统将只导入前6列的数据，自动忽略多余数据，详情见注意事项！";
					    	m.addAttribute("message", message);
					    }
					    if(row.getCell((short)0)!=null){
					    	gjjg.setFname(row.getCell((short)0).toString());
					    }
					    if(row.getCell((short)1)!=null){
					    	gjjg.setFfr(row.getCell((short)1).toString());
					    }
					    if(row.getCell((short)2)!=null){
					    	
					    	gjjg.setFzzdj(row.getCell((short)2).toString());
					    }
					    if(row.getCell((short)3)!=null){
					    	gjjg.setFkssj(row.getCell((short)3).toString());
					    
					    }
					    if(row.getCell((short)4)!=null){
					    	gjjg.setFjssj(row.getCell((short)4).toString());
					    	
					    }
					    if(row.getCell((short)5)!=null){
					    	gjjg.setFzzzh(row.getCell((short)5).toString());
					    }
						gjdao.save(gjjg);
						if(message.equals("")){
							m.addAttribute("message", "导入成功！");
						}
				}
			}
			if(version.equals("03")){
				HSSFWorkbook wbs = new HSSFWorkbook(file.getInputStream());   
			    HSSFSheet cs = wbs.getSheetAt(0);   
			    
			    int rowNum  = cs.getLastRowNum();
			    List<Tgjjg> list = gjdao.findAll();
				if(list!=null && list.size()>0){
					gjdao.deleteAll();
				}
				for(int i =1 ;i<=rowNum;i++){
					HSSFRow row = cs.getRow(i);
					    Tgjjg gjjg = new Tgjjg();
					    if(row.getCell(6)!=null){
					    	message="所导入文件有冗余数据，系统将只导入前6列的数据，自动忽略多余数据，详情见注意事项！";
					    	m.addAttribute("message", message);
					    }
					    if(row.getCell(0)!=null){
					    	gjjg.setFname(row.getCell(0).toString());
					    }
					    if(row.getCell(1)!=null){
					    	gjjg.setFfr(row.getCell(1).toString());
					    }
					    if(row.getCell(2)!=null){
					    	
					    	gjjg.setFzzdj(row.getCell(2).toString());
					    }
					    if(row.getCell(3)!=null){
					    	gjjg.setFkssj(row.getCell(3).toString());
					    
					    }
					    if(row.getCell(4)!=null){
					    	gjjg.setFjssj(row.getCell(4).toString());
					    	
					    }
					    if(row.getCell(5)!=null){
					    	gjjg.setFzzzh(row.getCell(5).toString());
					    }
						gjdao.save(gjjg);
						if(message.equals("")){
							m.addAttribute("message", "导入成功！");
						}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute("message", "导入失败！");
		}catch (IOException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			m.addAttribute("message", "导入失败，请注意文件格式！");
		}catch (NullPointerException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			m.addAttribute("message", "导入失败,请注意Excel表格格式，详见注意事项！");
		}catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			m.addAttribute("message", "导入失败,请注意Excel表格格式，详见注意事项！");
		}
		return "admin/importExcel";
	}
}
