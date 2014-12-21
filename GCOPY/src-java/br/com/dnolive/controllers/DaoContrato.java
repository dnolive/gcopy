package br.com.dnolive.controllers;

import javax.persistence.EntityManager;

import br.com.dnolive.core.ImplementsDAO;
import br.com.dnolive.models.Contrato;

public class DaoContrato extends ImplementsDAO<Contrato, Long> 
{
	public DaoContrato(EntityManager em) {
		super(em);
	}
}
