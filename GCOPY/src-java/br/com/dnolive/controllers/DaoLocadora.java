package br.com.dnolive.controllers;

import javax.persistence.EntityManager;

import br.com.dnolive.core.ImplementsDAO;
import br.com.dnolive.models.Locadora;

public class DaoLocadora extends ImplementsDAO<Locadora, Long> 
{
	public DaoLocadora(EntityManager em) {
		super(em);
	}
}
