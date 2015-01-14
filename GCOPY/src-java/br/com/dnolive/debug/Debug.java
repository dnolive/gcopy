package br.com.dnolive.debug;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.dnolive.core.JpaUtil;
import br.com.dnolive.models.Contrato;
import br.com.dnolive.models.Equipamento;
import br.com.dnolive.models.Locadora;
import br.com.dnolive.models.Movimento;
import br.com.dnolive.models.Movimitem;
import br.com.dnolive.models.Operador;
import br.com.dnolive.models.Setor;
import br.com.dnolive.services.ServiceContrato;
import br.com.dnolive.services.ServiceEquipamento;
import br.com.dnolive.services.ServiceLocadora;
import br.com.dnolive.services.ServiceMovimento;
import br.com.dnolive.services.ServiceMovimitem;
import br.com.dnolive.services.ServiceOperador;
import br.com.dnolive.services.ServiceSetor;

public class Debug 
{
	public static void main(String[] args) {
		
		JpaUtil.getEntityManager("GCOPY");
		
		testesLogin();
		testesSetor();
		testesLocadora();
		testesEquipamento();
		testesContrato();
		testesMovimento();
		//testesMovimitem();
		
		System.exit(0);
		
	}
	
	@SuppressWarnings("unused")
	private static void testesLogin() {
		Operador o = new Operador();
		o.setNome("DENERSON NOBRE");
		o.setLogin("DNOLIVE");
		o.setSenha("123456");
		//...
		ServiceOperador s = new ServiceOperador();
		s.save(o);
	}
	
	@SuppressWarnings("unused")
	private static void testesSetor() {
		Setor o = new Setor();
		o.setNome("TECNOLOGIA DA INFORMAÇÃO");
		//...
		ServiceSetor s = new ServiceSetor();
		s.save(o);
	}
	
	@SuppressWarnings("unused")
	private static void testesLocadora() {
		Locadora o = new Locadora();
		o.setNome("MASTERCOPY LTDA.");
		//...
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
		//...
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
		//...
		ServiceContrato s = new ServiceContrato();
		s.save(o);
	}
	
	@SuppressWarnings("unused")
	private static void testesMovimento() {
		String sema4 = JpaUtil.getSema4();
		//...
		Operador o = new Operador();
		o.setId(1L);
		Contrato c = new Contrato();
		c.setId(1);
		c = (new ServiceContrato()).getById(1);
		//...
		Equipamento eq = new Equipamento();
		eq.setId(1);
		Setor st = new Setor();
		st.setId(1);
		//...
		Movimitem mi = new Movimitem();
		mi.setEquipamento(eq);
		mi.setLeituraAnterior(1000);
		mi.setLeituraAtual(1100);
		mi.setSetor(st);
		mi.setSema4(sema4);
		
		List<Movimitem> itens = new ArrayList<Movimitem>();
		itens.add(mi);
		//...
		//...
		Movimento m = new Movimento();
		m.setContrato(c);
		m.setOperador(o);
		m.setData(new Date());
		m.setReferencia("01/2015");
		m.setLeiturista("FULANO DE TAL E COISA");
		m.setQuantCopia(1000);
		m.setValorCopia(c.getValorCopia());
		m.setValorTotal(m.getValorCopia()*m.getQuantCopia());
		m.setItensMovimento(itens);
		m.setSema4(sema4);
		//...
		ServiceMovimento s = new ServiceMovimento();
		s.save(m);
		m = s.getBySema4(sema4).get(0);
		//...
		ServiceMovimitem smi = new ServiceMovimitem();
		itens = smi.getBySema4(sema4);
		
		for (Movimitem item:itens) {
			item.setMovimento(m);
			smi.save(item);
		}
		
	}
	
	
	
	
	@SuppressWarnings("unused")
	private static void testesMovimitem() {
		Movimento mv = new Movimento();
		mv.setId(1);
		Equipamento eq = new Equipamento();
		eq.setId(1);
		Setor st = new Setor();
		st.setId(1);
		//...
		Movimitem m = new Movimitem();
		m.setMovimento(mv);
		m.setEquipamento(eq);
		m.setLeituraAnterior(1000);
		m.setLeituraAtual(1100);
		m.setSetor(st);
		//...
		ServiceMovimitem s = new ServiceMovimitem();
		s.save(m);
	}
	
}
