package br.com.dnolive.controllers;

import javax.persistence.EntityManager;

import br.com.dnolive.core.ImplementsDAO;
import br.com.dnolive.models.Equipaloca;

public class DaoEquipaloca extends ImplementsDAO<Equipaloca, Long> 
{
	public DaoEquipaloca(EntityManager em) {
		super(em);
	}
}
