package net.xqx.dao.web;


import net.xqx.models.TlyNews;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface LyNewsDao extends JpaRepository<TlyNews, Long>{
	@Query("select a from TlyNews a where a.fIsPass=1 or a.fIsPass=2")
	public Page<TlyNews> getLyPass(Pageable pageable);
	
}
