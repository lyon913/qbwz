package net.xqx.dao.admin;

import net.xqx.models.TAdmin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminDao extends JpaRepository<TAdmin, Long>{

	@Query("select a from TAdmin a")
	public Page<TAdmin> getAdmins(Pageable pageable);
}
