package br.com.dnolive.controllers;

import javax.persistence.EntityManager;

import br.com.dnolive.core.ImplementsDAO;
import br.com.dnolive.models.Operador;

public class DaoOperador extends ImplementsDAO<Operador, Long> 
{
	public DaoOperador(EntityManager em) {
		super(em);
	}
}
