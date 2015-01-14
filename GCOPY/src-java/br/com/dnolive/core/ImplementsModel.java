package br.com.dnolive.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ImplementsModel<T extends Serializable> implements InterfaceModel<T>
{	private static final long serialVersionUID = 1L;

	//constructor
	public ImplementsModel() {
		super();
	}   
	
	//...............

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected T id;
	
	@Column(name="sema4", length=20)
	protected String sema4;
	
	//...............
	
	public T getId() {
		return this.id;
	}
	public void setId(T id) {
		this.id = id;
	}

	public String getSema4() {
		return this.sema4;
	}
	
	public void setSema4(String sema4) {
		this.sema4 = sema4;
	}
	
	//...............
	
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @SuppressWarnings("unchecked")
	@Override
    public boolean equals(Object object) {
        if (!(object instanceof ImplementsModel)) {
            return false;
        }
        ImplementsModel<T> other = (ImplementsModel<T>) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
