package br.com.dnolive.core;

import java.io.Serializable;
import java.util.List;

public interface InterfaceDAO<T, ID extends Serializable> 
{
	List<T> getAll();
	T getById(ID id);
	List<T> save(T obj);
	List<T> delete(T obj);
	Class<T> getObjectClass();
	Class<ID> getObjectIndex();
	List<T> getBySema4(String sema4);
}
