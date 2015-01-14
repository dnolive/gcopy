package br.com.dnolive.services;

import br.com.dnolive.controllers.DaoFactory;
import br.com.dnolive.core.ImplementsService;
import br.com.dnolive.models.Movimitem;

public class ServiceMovimitem extends ImplementsService<Movimitem, Integer> 
{
	public ServiceMovimitem() {
		super(DaoFactory.DAO.MOVIMITEM);
	}
}
