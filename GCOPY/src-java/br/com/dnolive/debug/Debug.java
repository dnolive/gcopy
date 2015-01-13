package br.com.dnolive.debug;

import java.util.Date;

import br.com.dnolive.models.Contrato;
import br.com.dnolive.models.Equipamento;
import br.com.dnolive.models.Locadora;
import br.com.dnolive.models.Operador;
import br.com.dnolive.models.Setor;
import br.com.dnolive.services.ServiceContrato;
import br.com.dnolive.services.ServiceEquipamento;
import br.com.dnolive.services.ServiceLocadora;
import br.com.dnolive.services.ServiceOperador;
import br.com.dnolive.services.ServiceSetor;

public class Debug 
{
	public static void main(String[] args) {
		
		//JpaUtil.getEntityManager("GCOPY");
		
		testesLogin();
		testesSetor();
		testesLocadora();
		testesEquipamento();
		testesContrato();
		
		
	}
	
	@SuppressWarnings("unused")
	private static void testesLogin() {
		Operador o = new Operador();
		o.setNome("DENERSON NOBRE");
		o.setLogin("DNOLIVE");
		o.setSenha("123456");
		ServiceOperador s = new ServiceOperador();
		s.save(o);
	}
	
	@SuppressWarnings("unused")
	private static void testesSetor() {
		Setor o = new Setor();
		o.setNome("TECNOLOGIA DA INFORMAÇÃO");
		ServiceSetor s = new ServiceSetor();
		s.save(o);
	}
	
	@SuppressWarnings("unused")
	private static void testesLocadora() {
		Locadora o = new Locadora();
		o.setNome("MASTERCOPY LTDA.");
		ServiceLocadora s = new ServiceLocadora();
		s.save(o);
	}
	
	@SuppressWarnings("unused")
	private static void testesEquipamento() {
		Locadora l = new Locadora();
		l.setId(1L);
		//...
		Equipamento o = new Equipamento();
		o.setLocadora(l);
		o.setNome("IMPRESSORA HP8600PRO");
		o.setSerie("12345678901234567890");
		ServiceEquipamento s = new ServiceEquipamento();
		s.save(o);
	}
	
	@SuppressWarnings({ "unused", "deprecation" })
	private static void testesContrato() {
		Locadora l = new Locadora();
		l.setId(1L);
		//...
		Contrato o = new Contrato();
		o.setLocadora(l);
		o.setDataInicio(new Date("01/01/2014"));
		o.setDataTermino(new Date("01/01/2015"));
		o.setValorCopia(0.025F);
		ServiceContrato s = new ServiceContrato();
		s.save(o);
	}
	
	@SuppressWarnings("unused")
	private static void testesMovimento() {
		
	}
	
}
