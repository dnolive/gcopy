package br.com.dnolive.core;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

public class ImplementsDAO<T, ID extends Serializable> implements InterfaceDAO<T, ID> 
{
	Class<T> oClass;
	Class<ID> oIndex;
	protected EntityManager em;
	
	public ImplementsDAO(EntityManager em) {
		this.oClass = this.getObjectClass();
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Class<T> getObjectClass() {
		return ((Class<T>) ((ParameterizedType) 
			this.getClass().getGenericSuperclass())
			.getActualTypeArguments()[0]
		);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Class<ID> getObjectIndex() {
		return ((Class<ID>) ((ParameterizedType) 
			this.getClass().getGenericSuperclass())
			.getActualTypeArguments()[0]
		);
	}
	
	@Override
	public List<T> fetchAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(oClass);
		Root<T> root = cq.from(oClass);
		cq.select(root);
		TypedQuery <T> tq = em.createQuery(cq); 
		em.getTransaction().begin();
		List<T> result = tq.getResultList() ;
		em.getTransaction().commit();
		return result;
	}

	@Override
	public T fetchByID(ID id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(oClass);
		Root<T> root = cq.from(oClass);
		ParameterExpression<ID> param = cb.parameter(getObjectIndex());
		cq.select(root).where(cb.equal(root.get("id"), param));
		TypedQuery <T> tq = em.createQuery(cq); 
		tq.setParameter(param, id);
		em.getTransaction().begin();
		T result = tq.getSingleResult() ;
		em.getTransaction().commit();
		return result;
	}

	@SuppressWarnings("finally")
	@Override
	public List<T> save(T obj) {
		try {
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			return this.fetchAll();
		}
	}

	@SuppressWarnings("finally")
	@Override
	public List<T> delete(T obj) {
		try {
			em.getTransaction().begin();
			em.remove(em.merge(obj));
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally { 
			return this.fetchAll();
		}
	}

}
