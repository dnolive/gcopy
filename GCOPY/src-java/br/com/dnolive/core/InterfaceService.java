package br.com.dnolive.core;

import java.io.Serializable;
import java.util.List;

public interface InterfaceService<T, ID extends Serializable> 
{
	List<T> getAll();
	T getByID(ID id);
	List<T> save(T obj);
	List<T> delete(T obj);
}
