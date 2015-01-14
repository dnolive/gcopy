package br.com.dnolive.services;

import br.com.dnolive.controllers.DaoFactory;
import br.com.dnolive.core.ImplementsService;
import br.com.dnolive.models.Equipamento;

public class ServiceEquipamento extends ImplementsService<Equipamento, Integer>
{
	public ServiceEquipamento() {
		super(DaoFactory.DAO.EQUIPAMENTO);
	}

}
