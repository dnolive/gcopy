package app.controllers.services;

import app.controllers.dao.DaoFactory;
import app.models.Movimento;
import core.ImplementsService;

public class ServiceMovimento extends ImplementsService<Movimento, Integer> 
{
	public ServiceMovimento() {
		super(DaoFactory.DAO.MOVIMENTO);
	}
	
}
