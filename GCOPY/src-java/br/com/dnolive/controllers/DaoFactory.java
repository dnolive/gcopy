package br.com.dnolive.controllers;

import javax.persistence.EntityManager;

import br.com.dnolive.core.InterfaceDAO;
import br.com.dnolive.core.JpaUtil;


public final class DaoFactory 
{
	public enum DAO {
		OPERADOR(0),
		EQUIPAMENTO(1),
		SETOR(2),
		LOCADORA(3),
		MOVIMENTO(4);

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
			case EQUIPAMENTO: return new DaoEquipamento(em);
			default: return null;
		}
	}
	
}
