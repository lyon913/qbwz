package net.xqx.dao.admin;

import net.xqx.models.TAdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GgglDao extends JpaRepository<TAdv, Long> {
	
}
