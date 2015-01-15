package app.controllers.services;

import app.controllers.dao.DaoFactory;
import app.models.Contrato;
import core.ImplementsService;

public class ServiceContrato extends ImplementsService<Contrato, Integer> 
{
	public ServiceContrato() {
		super(DaoFactory.DAO.CONTRATO);
	}
}
