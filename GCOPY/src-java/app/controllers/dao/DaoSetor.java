package app.controllers.dao;

import javax.persistence.EntityManager;

import app.models.Setor;
import core.ImplementsDAO;

public class DaoSetor extends ImplementsDAO<Setor, Long> 
{
	public DaoSetor(EntityManager em) {
		super(em);
	}
}
