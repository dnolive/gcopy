package br.com.dnolive.services;

import br.com.dnolive.controllers.DaoFactory;
import br.com.dnolive.core.ImplementsService;
import br.com.dnolive.models.Movimento;

public class ServiceMovimento extends ImplementsService<Movimento, Long> 
{
	public ServiceMovimento() {
		super(DaoFactory.DAO.MOVIMENTO);
	}
}
