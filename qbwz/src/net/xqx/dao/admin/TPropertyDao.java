package net.xqx.dao.admin;

import java.util.List;

import net.xqx.models.TProperty;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * 属性dao
 * @author siyi
 *
 */
@Repository
public interface TPropertyDao extends JpaRepository<TProperty, Long>{
	
	/**
	 * 根据fname查询属性
	 * @param fName
	 * @return
	 */
	@Query("select p from TProperty p where p.fName=?")
	public List<TProperty> getPropertyByfName(String fName);
	
	
	/**
	 * 根据fid查询属性
	 * @param fId
	 * @return
	 */
	@Query("select p from TProperty p where p.fId=?")
	public List<TProperty> getPropertyByFid(Long fId);
	
	/**
	 * 根据fid和Name查询属性
	 * @param fId Name
	 * @return
	 */
	@Query("select p from TProperty p where p.fId=? and p.fName=?")
	public List<TProperty> getPropertyByFidAndFname(Long fId,String fName);
	
	/**
	 * 根据fid查询属性
	 * @param fId
	 * @return
	 */
	@Query("select p from TProperty p where p.fId=?")
	public Page<TProperty> getPropertyByFid(Long fId,Pageable pageable);
	
	/**
	 * 查记录数
	 * @return
	 */
	@Query("select count(*) from TProperty a")
	public Long getPropertysCount();
}
