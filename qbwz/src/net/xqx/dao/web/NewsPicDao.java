package net.xqx.dao.web;

import java.util.List;

import net.xqx.models.TNewsPic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 行业评优
 * 
 * @author siyi
 * 
 */
@Repository
public interface NewsPicDao extends JpaRepository<TNewsPic, Long>
{

	/**
	 * 
	 * @param fName
	 * @return
	 */
	// 图片新闻
	@Query("select a from TNewsPic a where a.fNewsId.id=?")
	public Page<TNewsPic> getByNewsId(Long newsId, Pageable pageable);

	 @Query("select a from TNewsPic a where a.fNewsId.id=?")
	 public List<TNewsPic> getByNewsId(Long newsId);
}
