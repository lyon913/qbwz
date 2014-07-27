package net.xqx.dao.admin;

import java.util.List;

import net.xqx.models.TNewsPic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 新闻图片
 * 
 * @author siyi
 * 
 */
@Repository
public interface TNewsPicDao extends JpaRepository<TNewsPic, Long>
{

	/**
	 * 
	 * @param fName
	 * @return
	 */
	@Query("select a from TNewsPic a where a.fNewsId.id=?")
	public Page<TNewsPic> getByNewsId(Long newsId, Pageable pageable);

	 @Query("select a from TNewsPic a where a.fNewsId.id=?")
	 public List<TNewsPic> getByNewsId(Long newsId);
}
