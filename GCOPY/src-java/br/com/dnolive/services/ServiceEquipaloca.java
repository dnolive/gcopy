package br.com.dnolive.services;

import br.com.dnolive.controllers.DaoFactory;
import br.com.dnolive.core.ImplementsService;
import br.com.dnolive.models.Equipaloca;

public class ServiceEquipaloca extends ImplementsService<Equipaloca, Long> 
{
	public ServiceEquipaloca() {
		super(DaoFactory.DAO.EQUIPALOCA);
	}
}
