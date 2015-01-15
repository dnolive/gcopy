package app.controllers.services;

import app.controllers.dao.DaoFactory;
import app.models.Locadora;
import core.ImplementsService;

public class ServiceLocadora extends ImplementsService<Locadora, Integer> 
{
	public ServiceLocadora() {
		super(DaoFactory.DAO.LOCADORA);
	}
}
