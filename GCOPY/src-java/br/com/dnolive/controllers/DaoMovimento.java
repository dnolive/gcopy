package br.com.dnolive.controllers;

import javax.persistence.EntityManager;

import br.com.dnolive.core.ImplementsDAO;
import br.com.dnolive.models.Movimento;

public class DaoMovimento extends ImplementsDAO<Movimento, Long> 
{
	public DaoMovimento(EntityManager em) {
		super(em);
	}
}
