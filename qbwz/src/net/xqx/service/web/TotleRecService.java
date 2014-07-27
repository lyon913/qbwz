package net.xqx.service.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class TotleRecService {
	@PersistenceContext
	EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	//读取推荐新闻列表，父类。
	public List getXhzcRecList(String classname,String proids){
		Session session=(Session)em.getDelegate();
		if(session.isOpen()==false){
			session=session.getSessionFactory().openSession();
		}
		String hql="from "+classname+" f where f.flx.id in ("+proids+") and f.fIsShow=1 and f.fIsRecord=1 order by f.fSortFlag,f.fzdTime,f.ffbTime desc";
		Query query=session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(10);
		return query.list();
	}
	//读取热门新闻列表，父类。
		public List getXhzcHotList(String classname,String proids){
			Session session=(Session)em.getDelegate();
			if(session.isOpen()==false){
				session=session.getSessionFactory().openSession();
			}
			String hql="from "+classname+" f where f.flx.id in ("+proids+") and f.fIsShow=1 order by f.fdjTimes, f.fSortFlag,f.fzdTime,f.ffbTime desc";
			Query query=session.createQuery(hql);
			query.setFirstResult(0);
			query.setMaxResults(10);
			return query.list();
		}
}
