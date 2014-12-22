package br.com.dnolive.debug;

import br.com.dnolive.models.*;
import br.com.dnolive.services.*;

public class Debug 
{
	public static void main(String[] args) {
		
		Setor o = new Setor();
		//o.setId(1L);
		o.setNome("TECNOLOGIA DA INFORMAÇÃO");
		o.setAtivo("S");
		
		ServiceSetor dao = new ServiceSetor();
		dao.save(o);

		System.out.println(dao.getAll());
		
	}

}
