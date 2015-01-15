package core;

import java.io.Serializable;

public interface InterfaceModel<T extends Serializable> extends Serializable 
{
	T getId();
	void setId(T id);
	String getSema4();
	void setSema4(String sema4);
}
