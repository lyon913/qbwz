package net.xqx.dao.web;

import java.util.List;

import net.xqx.models.TClass;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * 首页链接
 * @author siyi
 *
 */
@Repository
public interface ClassDao extends JpaRepository<TClass, Long>{

	/**
	 * 根据fid查询首页权限链接
	 * @param pageable
	 * @return
	 */
	@Query("select a from TClass a where a.fid=?")
	public List<TClass> getClassByFid(Long fid,Pageable pageable);
	
	
	/**
	 * 根据fid查询首页权限链接
	 * @param pageable
	 * @return
	 */
	@Query("select a from TClass a where a.fid=?")
	public List<TClass> getClassByFidNotPage(Long fid);
	
	@Query("select a from TClass a")
	public Page<TClass> getClasses(Pageable pageable);
	@Query("select a from TClass a where a.fid=?")
	public Page<TClass> getClassesByTopid(long topid,Pageable pageable);
	@Query("select count(*) from TClass a")
	public Long getClassesCount();
}
