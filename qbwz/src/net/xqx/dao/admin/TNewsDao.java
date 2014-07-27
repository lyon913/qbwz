package net.xqx.dao.admin;

import net.xqx.models.TNews;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * 新闻dao
 * @author siyi modify by wangyan
 *
 */
@Repository
public interface TNewsDao extends JpaRepository<TNews, Long>{
	
	/**
	 * 查询没有审核和审核不通过的记录
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=0")
	public Page<TNews> getExamineNews(Pageable pageable);
	
	/**
	 * 查询审核通过的记录
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 or a.fIsPass=0 or a.fIsPass=-1")
	public Page<TNews> getNewsManage(Pageable pageable);
	
	/**
	 * 查询子类新闻
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.flxFirst.id=? and a.flxSecond.id=?")
	public Page<TNews> getNewsBySecendId(Long firstId,Long fsecendId,Pageable pageable);
	
	/**
	 * 查询父类新闻
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where  a.flxFirst.id=?")
	public Page<TNews> getNewsByFirstId(Long firstId,Pageable pageable);
}
