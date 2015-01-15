package app.controllers.services;

import app.controllers.dao.DaoFactory;
import app.models.Setor;
import core.ImplementsService;

public class ServiceSetor extends ImplementsService<Setor, Integer> 
{
	public ServiceSetor() {
		super(DaoFactory.DAO.SETOR);
	}
}
