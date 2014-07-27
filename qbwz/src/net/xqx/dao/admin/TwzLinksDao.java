package net.xqx.dao.admin;

import net.xqx.models.TwzLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 友情链接，文字链接
 * @author siyi
 *
 */
@Repository
public interface TwzLinksDao extends JpaRepository<TwzLinks, Long>{
	
	
}
