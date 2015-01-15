package app.controllers.dao;

import javax.persistence.EntityManager;

import core.InterfaceDAO;
import core.JpaUtil;


public final class DaoFactory 
{
	public enum DAO {
		OPERADOR(0),
		SETOR(1),
		LOCADORA(2),
		EQUIPAMENTO(3),
		CONTRATO(4),
		MOVIMENTO(5),
		MOVIMITEM(6);

		public int dao;
		
		DAO(int dao) {
			this.dao = dao;
		}
	}
	
	private static EntityManager em;
	
	private DaoFactory() {
		em = JpaUtil.getEntityManager("GCOPY");
	}
	
	@SuppressWarnings("rawtypes")
	public static InterfaceDAO get(DAO dao) {
		if (em == null) {
			new DaoFactory();
		}
		switch (dao) {
			case OPERADOR: return new DaoOperador(em);
			case SETOR: return new DaoSetor(em);
			case LOCADORA: return new DaoLocadora(em);
			case EQUIPAMENTO: return new DaoEquipamento(em);
			case CONTRATO: return new DaoContrato(em);
			case MOVIMENTO: return new DaoMovimento(em);
			case MOVIMITEM: return new DaoMovimitem(em);
			default: return null;
		}
	}
	
}
