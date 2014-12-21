package br.com.dnolive.controllers;

import javax.persistence.EntityManager;

import br.com.dnolive.core.ImplementsDAO;
import br.com.dnolive.models.Movimitem;

public class DaoMovimitem extends ImplementsDAO<Movimitem, Long> 
{
	public DaoMovimitem(EntityManager em) {
		super(em);
	}
}
