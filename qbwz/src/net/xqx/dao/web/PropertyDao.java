package net.xqx.dao.web;

import java.util.List;

import net.xqx.models.TProperty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * 属性dao
 * @author siyi
 *
 */
@Repository
public interface PropertyDao extends JpaRepository<TProperty, Long>{
	
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
	 * 根据fvalue查询属性
	 * @param fvalue
	 * @return
	 */
	@Query("select p from TProperty p where p.fName=? and p.fValue=?")
	public List<TProperty> getPropertyByfValue(String fName,String fValue);
	
}
