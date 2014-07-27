package net.xqx.dao.web;

import java.util.List;

import net.xqx.models.TlyhfNews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LyhfDao extends JpaRepository<TlyhfNews, Long> {
	@Query("select a  from TlyhfNews a where a.flyId.id=?")
	public List<TlyhfNews> findByLyid(Long id);
}
