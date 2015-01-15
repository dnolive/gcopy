package app.controllers.services;

import app.controllers.dao.DaoFactory;
import app.models.Equipamento;
import core.ImplementsService;

public class ServiceEquipamento extends ImplementsService<Equipamento, Integer>
{
	public ServiceEquipamento() {
		super(DaoFactory.DAO.EQUIPAMENTO);
	}

}
