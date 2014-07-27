package net.xqx.dao.web;

import java.util.List;

import net.xqx.models.TtpLinks;
import net.xqx.models.TwzLinks;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WzLinkDao extends JpaRepository<TwzLinks, Long> {
	@Query("from TwzLinks a")
	public List<TwzLinks> getWzLinks();
	
	@Query("from TwzLinks a")
	public List<TwzLinks> getWzLinks(Pageable pageable);
}
