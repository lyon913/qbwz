package net.xqx.service.admin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.xqx.models.TFuncList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class TFuncListService {


	@PersistenceContext
	EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * 根据fid查询权限
	 * @param fid
	 * @return
	 */
	public List<TFuncList> getFuncList(Long fid,String rights){
		Session session=(Session)em.getDelegate();
		if(session.isOpen()==false){
			session=session.getSessionFactory().openSession();
		}
		String hql="from TFuncList f where f.fid=? and f.id in ("+rights+") order by f.fFuncSort desc";
		Query query=session.createQuery(hql);
		query.setParameter(0, fid);
		return query.list();
	}
	
	/**
	 * 根据权限列表查询权限
	 * @param rights
	 * @return
	 */
	public List<TFuncList> getFuncList(String rights){
		Session session=(Session)em.getDelegate();
		if(session.isOpen()==false){
			session=session.getSessionFactory().openSession();
		}
		String hql="from TFuncList f where f.id in ("+rights+") order by f.fFuncSort desc";
		Query query=session.createQuery(hql);
		return query.list();
	}
	
}
