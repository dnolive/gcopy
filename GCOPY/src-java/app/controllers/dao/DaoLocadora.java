package app.controllers.dao;

import javax.persistence.EntityManager;

import app.models.Locadora;
import core.ImplementsDAO;

public class DaoLocadora extends ImplementsDAO<Locadora, Long> 
{
	public DaoLocadora(EntityManager em) {
		super(em);
	}
}
