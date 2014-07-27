package net.xqx.dao.admin;

import java.util.List;

import net.xqx.models.TFuncList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface FuncListDao extends JpaRepository<TFuncList, Long>{

	/**
	 * 根据fid查询记录
	 * @param fid
	 * @return
	 */
	@Query("select f from TFuncList f where f.fid=?")
	public List<TFuncList> getFuncGroupByFid(Long fid);
	
	/**
	 * 根据fid查询记录并分页
	 * @param fid
	 * @param page
	 * @return
	 */
	@Query("select f from TFuncList f where f.fid=?")
	public Page<TFuncList> getFuncGroupByFid(Long fid,Pageable page);
	
	/**
	 * 查询所有父类
	 * @return
	 */
	@Query("select f from TFuncList f where f.fid=0 order by f.id desc")
	public List<TFuncList> getFuncGroupByFid();
	
	/**
	 * 查询所有子类
	 * @return
	 */
	@Query("select f from TFuncList f where f.fid!=0 order by f.id desc")
	public List<TFuncList> getzFunc();
}
