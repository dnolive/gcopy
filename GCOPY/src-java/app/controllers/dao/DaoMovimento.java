package app.controllers.dao;

import java.util.List;

import javax.persistence.EntityManager;

import app.models.Movimento;
import app.models.Movimitem;
import core.ImplementsDAO;

public class DaoMovimento extends ImplementsDAO<Movimento, Long> 
{
	public DaoMovimento(EntityManager em) {
		super(em);
	}
	
	@Override
	public List<Movimento> save(Movimento mov) {
		String sema4 = mov.getSema4();
		List<Movimento> result = super.save(mov);
		mov = this.getBySema4(sema4).get(0);
		DaoMovimitem dao = new DaoMovimitem(em);
		List<Movimitem> itens = dao.getBySema4(sema4);
		for (Movimitem item:itens) {
			item.setMovimento(mov);
		}
		dao.save(itens);
		return result;
	}
	
}
