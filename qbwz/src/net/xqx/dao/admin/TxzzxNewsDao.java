package net.xqx.dao.admin;

import java.util.List;

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
public interface TxzzxNewsDao extends JpaRepository<TxzzxNews, Long> {
	/**
	 * 
	 * @param fName
	 * @return
	 */
	@Query("select a from TxzzxNews a where a.flxSecond.id=?")
	public List<TxzzxNews> getTxzzxNews(Long propertyId);

	/**
	 * 查询没有审核和审核不通过的记录
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TxzzxNews a where a.fIsPass=0")
	public Page<TxzzxNews> getTxzzxNews(Pageable pageable);

	/**
	 * 查询审核通过的记录
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TxzzxNews a where a.fIsPass=1 or a.fIsPass=-1 or a.fIsPass=0")
	public Page<TxzzxNews> getTxzzxNewsPass(Pageable pageable);
}
