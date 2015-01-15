package app.controllers.dao;

import javax.persistence.EntityManager;

import app.models.Contrato;
import core.ImplementsDAO;

public class DaoContrato extends ImplementsDAO<Contrato, Long> 
{
	public DaoContrato(EntityManager em) {
		super(em);
	}
}
