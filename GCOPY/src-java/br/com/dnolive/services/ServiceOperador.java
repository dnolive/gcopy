package br.com.dnolive.services;

import br.com.dnolive.controllers.DaoFactory;
import br.com.dnolive.controllers.DaoOperador;
import br.com.dnolive.core.ImplementsService;
import br.com.dnolive.models.Operador;

public class ServiceOperador extends ImplementsService<Operador, Long> 
{
	public ServiceOperador() {
		super(DaoFactory.DAO.OPERADOR);
	}
	
	public Operador login(Operador operador) {
		return ((DaoOperador)dao).login(operador);
	}
	
	public boolean logout(Operador operador) {
		return true;
	}
}
