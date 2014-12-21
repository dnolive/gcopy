package br.com.dnolive.controllers;

import javax.persistence.EntityManager;

import br.com.dnolive.core.ImplementsDAO;
import br.com.dnolive.models.Equipamento;

public class DaoEquipamento extends ImplementsDAO<Equipamento, Long> 
{
	public DaoEquipamento(EntityManager em) {
		super(em);
	}
}
