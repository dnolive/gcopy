package app.controllers.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import app.models.Equipamento;
import app.models.Locadora;
import core.ImplementsDAO;

public class DaoEquipamento extends ImplementsDAO<Equipamento, Long> 
{
	public DaoEquipamento(EntityManager em) {
		super(em);
	}
	
	public List<Equipamento> getAll(Locadora locadora) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Equipamento> cq = cb.createQuery(Equipamento.class);
		Root<Equipamento> root = cq.from(Equipamento.class);
		//...
		Predicate pId = cb.equal(root.get("id"), locadora.getId());  
		//...
		cq.select(root).where(pId);
		//...
		TypedQuery<Equipamento> tq = em.createQuery(cq); 
		//...
		em.getTransaction().begin();
		List<Equipamento> result = tq.getResultList();
		em.getTransaction().commit();
		//...
		return result;
	}
}
