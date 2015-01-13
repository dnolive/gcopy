package br.com.dnolive.core;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ImplementsModel<T extends Serializable> implements InterfaceModel<T>
{	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected T id;
	
	public ImplementsModel() {
		super();
	}   
	
	public T getId() {
		return this.id;
	}
	public void setId(T id) {
		this.id = id;
	}
   
}
