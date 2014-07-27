package net.xqx.dao.admin;


import net.xqx.models.TlyNews;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * 留言审核
 * @author siyi
 *
 */
@Repository
public interface TlyshNewsDao extends JpaRepository<TlyNews, Long>{
	
	/**
	 * 查询没有审核和审核不通过的记录
	 * @param pageable
	 * @return
	 */
	@Query("select a from TlyNews a where a.fIsPass=0 or a.fIsPass=-1")
	public Page<TlyNews> getLyshNews(Pageable pageable);
	
	/**
	 * 查询审核通过的记录
	 * @param pageable
	 * @return
	 */
	@Query("select a from TlyNews a where a.fIsPass=1 or a.fIsPass=2")
	public Page<TlyNews> getLyshNewsPass(Pageable pageable);
}
