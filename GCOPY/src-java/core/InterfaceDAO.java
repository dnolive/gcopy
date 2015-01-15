package core;

import java.io.Serializable;
import java.util.List;

public interface InterfaceDAO<T, ID extends Serializable> 
{
	T getById(ID id);
	List<T> getAll();
	List<T> getBySema4(String sema4);
	List<T> save(T obj);
	List<T> save(List<T> list);
	List<T> delete(T obj);
	List<T> delete(List<T> list);
	Class<T> getObjectClass();
	Class<ID> getObjectIndex();
}
