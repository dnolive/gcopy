package app.controllers.services;

import app.controllers.dao.DaoFactory;
import app.models.Movimitem;
import core.ImplementsService;

public class ServiceMovimitem extends ImplementsService<Movimitem, Integer> 
{
	public ServiceMovimitem() {
		super(DaoFactory.DAO.MOVIMITEM);
	}
}
