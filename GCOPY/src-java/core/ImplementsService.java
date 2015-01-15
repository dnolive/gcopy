package core;

import java.io.Serializable;
import java.util.List;

import app.controllers.dao.DaoFactory;
import app.controllers.dao.DaoFactory.DAO;

public class ImplementsService<T, ID extends Serializable> implements InterfaceService<T, ID> 
{
	protected InterfaceDAO<T, ID> dao;
	
	@SuppressWarnings("unchecked")
	protected ImplementsService(DAO enumDao) {
		this.dao = DaoFactory.get(enumDao);
	}
	
	public ImplementsService() {
	}
	
	@Override
	public List<T> getAll() {
		return this.dao.getAll();
	}

	@Override
	public T getById(ID id) {
		return this.dao.getById(id);
	}

	@Override
	public List<T> getBySema4(String sema4) {
		return this.dao.getBySema4(sema4);
	}

	@Override
	public List<T> save(T obj) {
		return this.dao.save(obj);
	}

	@Override
	public List<T> save(List<T> list) {
		return this.dao.save(list);
	}

	@Override
	public List<T> delete(T obj) {
		return this.dao.delete(obj);
	}

	@Override
	public List<T> delete(List<T> list) {
		return this.dao.delete(list);
	}

}
