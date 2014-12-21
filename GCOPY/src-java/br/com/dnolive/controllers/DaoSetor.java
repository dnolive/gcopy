package br.com.dnolive.controllers;

import javax.persistence.EntityManager;

import br.com.dnolive.core.ImplementsDAO;
import br.com.dnolive.models.Setor;

public class DaoSetor extends ImplementsDAO<Setor, Long> 
{
	public DaoSetor(EntityManager em) {
		super(em);
	}
}
