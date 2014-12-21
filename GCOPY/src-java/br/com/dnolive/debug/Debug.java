package br.com.dnolive.debug;

import br.com.dnolive.models.Operador;
import br.com.dnolive.services.ServiceOperador;

public class Debug 
{
	public static void main(String[] args) {
		
		Operador op = new Operador();
		op.setId(1L);
		op.setNome("DENERSON NOBRE");
		op.setLogin("DNOLIVE");
		op.setSenha("JKASDFJASD");
		op.setAtivo("S");
		
		ServiceOperador dao = new ServiceOperador();
		dao.delete(op);

		System.out.println(dao.getAll());
		
	}

}
