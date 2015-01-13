package br.com.dnolive.core;

import java.io.Serializable;

public interface InterfaceModel<T extends Serializable> extends Serializable 
{
	T getId();
	void setId(T id);
}
