package app.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import core.ImplementsModel;

@Entity
public class Setor extends ImplementsModel<Integer>
{	private static final long serialVersionUID = 1L;	

	@Column(name="nome", length=100)
	private String nome;

	@Column(name="ativo", insertable=false,	updatable=true, 
		columnDefinition = "varchar(1) default 'S'"
	)
	private String ativo;
	

	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo==null?"S":ativo;
	}

}
