package net.xqx.dao.web;


import java.util.List;

import net.xqx.models.TNews;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 新闻中心
 * 
 * @author siyi
 * 
 */
@Repository
public interface NewsDao extends JpaRepository<TNews, Long> {

	/**
	 * 查询父类新闻
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsShow=1 and a.id!=? and a.fKeyWord like ?")
	public Page<TNews> getNewsByKeyWord(Long id,String keyWord,Pageable pageable);
	
	
	/**
	 * 搜索栏（依据标题搜索）
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsShow=1 and a.fTitle like ? ")
	public Page<TNews> getNewsByTitle(String keyWord,Pageable pageable);
	
	/**
	 * 搜索栏（依据标题搜索）
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsShow=1 and a.fTitle like ? and a.flxFirst.id=?")
	public Page<TNews> getNewsByTitleAndType(String keyWord,Long newsType,Pageable pageable);
	
	
	
	/**
	 * 查询父类新闻
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1  and a.fIsShow=1 and a.flxFirst.id=?")
	public Page<TNews> getNewsByFirstId(Long firstId,Pageable pageable);
	
	/**
	 * 根据关键字和新闻类别搜索
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsShow=1 and a.flxFirst.id=?")
	public Page<TNews> getNewsByKeyWordType(Long firstId,Pageable pageable);
	
	
	/**
	 * 首页推荐新闻
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsRecord=1 and a.fIsShow=1 and a.flxFirst.id=?")
	public Page<TNews> getTjydNewsByFirstId(Long firstId,Pageable pageable);
	
	
	/**
	 * 查询推荐父类新闻
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsShow=1 and a.fIsRecord=1 and a.flxFirst.id=?")
	public Page<TNews> getTjNewsByFirstId(Long firstId,Pageable pageable);
	
	/**
	 * 查询子类新闻
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsShow=1 and a.flxFirst.id=? and a.flxSecond.id=?")
	public Page<TNews> getNewsBySecendId(Long firstId,Long fsecendId,Pageable pageable);
	
	/**
	 * 推荐子类新闻
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsShow=1 and a.fIsRecord=1 and a.flxFirst.id=? and a.flxSecond.id=?")
	public Page<TNews> getTjNewsBySecendId(Long firstId,Long fsecendId,Pageable pageable);
	
	/**
	 * 查询头条
	 * @param firstId
	 * @param fsecendId
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsShow=1 and a.fIsTop=1 and a.flxFirst.id=?")
	public Page<TNews> getTopNewsByFirstId(Long firstId,Pageable pageable);
	
	/**
	 * 查询首页资讯中心 不包括头条
	 * @param firstId
	 * @param fsecendId
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsShow=1 and (a.fIsTop=0 or a.fIsTop=null) and a.flxFirst.id=?")
	public Page<TNews> getNotTopNewsByFirstId(Long firstId,Pageable pageable);
	
	/**
	 * 查询子类新闻
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.id=?")
	public TNews getNewsById(Long id);
	
	/**
	 * 查询推荐阅读
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsRecord=1 and a.fIsShow=1 and a.flxFirst.id=?")
	public Page<TNews> getNewsRec(Pageable pageable,long lxFirst);
	/**
	 * 下载中心的推荐阅读
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsRecord=1 and a.fIsShow=1 ")
	public Page<TNews> getNewsRec(Pageable pageable);
	
	/**
	 * 查询热门新闻
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsShow=1  and a.flxFirst.id=?")
	public Page<TNews> getNewsHot(Pageable pageable,long lxFirst);
	/**
	 * 查询热门新闻
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsShow=1 ")
	public Page<TNews> getHotNews(Pageable pageable);
	
	/**
	 * 查询相关阅读
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.fIsShow=1 and a.flxFirst.id=?  and  a.flxSecond.id=?")
	public Page<TNews> getNewsRef(Pageable pageable,long lxFirst,long lxSecond);
	
	/**
	 * 查询通过的记录
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1")
	public Page<TNews> getExamineNews(Pageable pageable);
	
	/**
	 * 查询有显示图的新闻
	 */
	@Query("select a from TNews a where a.fIsPass=1 and a.flxFirst.id=? and a.fNewsPic is not null")
	public Page<TNews> getNewsHasPic(Pageable pageable,long lxFirst);
	
	
	/**
	 * 查询父类新闻
	 * 
	 * @param pageable
	 * @return
	 */
	@Query("select a from TNews a where a.fIsPass=1  and a.fIsShow=1 and a.flxFirst.id=? order by fSort Desc")
	public List<TNews> getNewsByFirstId(Long firstId);
}
