package br.com.dnolive.services;

import br.com.dnolive.controllers.DaoFactory;
import br.com.dnolive.core.ImplementsService;
import br.com.dnolive.models.Setor;

public class ServiceSetor extends ImplementsService<Setor, Long> 
{
	public ServiceSetor() {
		super(DaoFactory.DAO.SETOR);
	}
}
