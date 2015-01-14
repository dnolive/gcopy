package br.com.dnolive.core;

import java.io.Serializable;
import java.util.List;

public interface InterfaceService<T, ID extends Serializable> 
{
	List<T> getAll();
	T getById(ID id);
	List<T> save(T obj);
	List<T> delete(T obj);
	List<T> getBySema4(String sema4);
}
