package net.xqx.dao.admin;

import net.xqx.models.TFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 专业人才
 * 
 * @author siyi
 * 
 */
@Repository
public interface TfilesDao extends JpaRepository<TFiles, Long> {

}
