package net.xqx.dao.admin;

import net.xqx.models.Tggw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GgwDao extends JpaRepository<Tggw, Long> {

}
