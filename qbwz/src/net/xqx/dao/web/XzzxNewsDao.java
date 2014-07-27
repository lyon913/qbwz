package net.xqx.dao.web;


import net.xqx.models.TxzzxNews;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 下载中心
 * 
 * @author siyi
 * 
 */
@Repository
public interface XzzxNewsDao extends JpaRepository<TxzzxNews, Long> {

	/**
	 * 查询审核通过的记录
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TxzzxNews a where a.fIsPass=1 and a.flxFirst.id=? and a.fIsShow=1")
	public Page<TxzzxNews> getTxzzxNewsPass(Long flxFirst,Pageable pageable);
	
	@Query("select a from TxzzxNews a where a.flxSecond.fId=? and a.fIsShow=1")
	public Page<TxzzxNews> getTxzzxNewsByFid(Long fId,Pageable pageable);
	@Query("select a from TxzzxNews a where a.flxSecond.fId=? and a.flxSecond.id=? and a.fIsShow=1")
	public Page<TxzzxNews> getTxzzxFileByFlx(Long flxFirstId,Long flxSecondId,Pageable pageable);
	
	@Query("select a from TxzzxNews a where a.fIsPass=1 and a.fIsShow=1")
	public Page<TxzzxNews> getXzzxNews(Pageable pageable);
	
	/**
	 * 关键字和类型来搜索
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TxzzxNews a where a.fIsPass=1 and a.fIsShow=1 and a.fTitle like ? ")
	public Page<TxzzxNews> getNewsByTitle(String keyWord,Pageable pageable);
	
	
	
}
