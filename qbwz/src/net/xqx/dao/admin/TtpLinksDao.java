package net.xqx.dao.admin;

import net.xqx.models.TtpLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 友情链接，图片链接
 * @author siyi
 *
 */
@Repository
public interface TtpLinksDao extends JpaRepository<TtpLinks, Long>{
	
	
}
