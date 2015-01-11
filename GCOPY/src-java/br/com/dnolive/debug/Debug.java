package br.com.dnolive.debug;

import br.com.dnolive.models.*;
import br.com.dnolive.services.*;

public class Debug 
{
	public static void main(String[] args) {
		
		Operador o = new Operador();
		//o.setId(1L);
		o.setLogin("FLVO");
		o.setSenha("JKASDFJASD");
		
		ServiceOperador dao = new ServiceOperador();
		o = dao.login(o);

		System.out.println(o);
		
	}

}
