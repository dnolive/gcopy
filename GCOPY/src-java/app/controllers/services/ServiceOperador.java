package app.controllers.services;

import app.controllers.dao.DaoFactory;
import app.controllers.dao.DaoOperador;
import app.models.Operador;
import core.ImplementsService;

public class ServiceOperador extends ImplementsService<Operador, Integer> 
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
