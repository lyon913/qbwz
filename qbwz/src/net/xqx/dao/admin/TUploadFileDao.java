package net.xqx.dao.admin;

import java.util.List;

import net.xqx.models.TUploadFiles;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 资料上传
 * 
 * @author siyi
 * 
 */
@Repository
public interface TUploadFileDao extends JpaRepository<TUploadFiles, Long> {

	/**
	 * 
	 * @param fName
	 * @return
	 */
	@Query("select a from TUploadFiles a where a.flx.id=?")
	public List<TUploadFiles> getUploadFiles(Long propertyId);
	
	/**
	 * 查询没有审核和审核不通过的记录
	 * @param pageable
	 * @return
	 */
	@Query("select a from TUploadFiles a where a.fId=? and (a.fIsPass=0 or a.fIsPass=-1)")
	public Page<TUploadFiles> getUploadFiles(Long fid,Pageable pageable);
	
	/**
	 * 查询审核通过的记录
	 * @param pageable
	 * @return
	 */
	@Query("select a from TUploadFiles a where a.fIsPass=1 and a.fId=?")
	public Page<TUploadFiles> getUploadFilesPass(Long fid,Pageable pageable);
}
