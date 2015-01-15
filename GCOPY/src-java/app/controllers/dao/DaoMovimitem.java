package app.controllers.dao;

import javax.persistence.EntityManager;

import app.models.Movimitem;
import core.ImplementsDAO;

public class DaoMovimitem extends ImplementsDAO<Movimitem, Long> 
{
	public DaoMovimitem(EntityManager em) {
		super(em);
	}
}
