package net.xqx.dao.web;

import java.util.List;

import net.xqx.models.TtpLinks;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TpLinkDao extends JpaRepository<TtpLinks, Long>{
	@Query("from TtpLinks a where a.flx.id=?")
	public List<TtpLinks> getTpLinksByLx(Long lxid);
	
	@Query("from TtpLinks a where a.flx.id=?")
	public List<TtpLinks> getTpLinksByLxP(Long lxid ,Pageable pageable);
}
