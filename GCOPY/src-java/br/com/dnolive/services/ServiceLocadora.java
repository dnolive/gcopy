package br.com.dnolive.services;

import br.com.dnolive.controllers.DaoFactory;
import br.com.dnolive.core.ImplementsService;
import br.com.dnolive.models.Locadora;

public class ServiceLocadora extends ImplementsService<Locadora, Integer> 
{
	public ServiceLocadora() {
		super(DaoFactory.DAO.LOCADORA);
	}
}
