package net.xqx.dao.admin;

import java.util.List;

import net.xqx.models.TAdmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginDao extends JpaRepository<TAdmin, Long>{
	
	/**
	 * 用户登录验证
	 * @param adminName 用户名
	 * @return
	 */
	@Query("select a from TAdmin a where a.fAdminName=?")
	public List<TAdmin> getAdmins(String adminName);
}
