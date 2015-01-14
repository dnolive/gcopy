package br.com.dnolive.controllers;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.dnolive.core.ImplementsDAO;
import br.com.dnolive.models.Operador;

public class DaoOperador extends ImplementsDAO<Operador, Integer> 
{
	public DaoOperador(EntityManager em) {
		super(em);
	}
	
	public Operador login(Operador operador) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Operador> cq = cb.createQuery(Operador.class);
		Root<Operador> root = cq.from(Operador.class);
		//...
		Predicate pLogin = cb.equal(root.get("login"), operador.getLogin());  
		Predicate pSenha = cb.equal(root.get("senha"), operador.getSenha());
		//...
		cq.select(root).where(pLogin, pSenha);
		//...
		TypedQuery<Operador> tq = em.createQuery(cq); 
		//...
		em.getTransaction().begin();
		operador = tq.getSingleResult() ;
		em.getTransaction().commit();
		//...
		return operador;
	}
}
