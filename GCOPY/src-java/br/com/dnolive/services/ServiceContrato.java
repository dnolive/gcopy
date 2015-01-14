package br.com.dnolive.services;

import br.com.dnolive.controllers.DaoFactory;
import br.com.dnolive.core.ImplementsService;
import br.com.dnolive.models.Contrato;

public class ServiceContrato extends ImplementsService<Contrato, Integer> 
{
	public ServiceContrato() {
		super(DaoFactory.DAO.CONTRATO);
	}
}
