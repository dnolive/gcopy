package br.com.dnolive.core;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;

@MappedSuperclass
public class AbstractModel implements Serializable 
{	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	

	public AbstractModel() {
		super();
	}   
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
   
}
