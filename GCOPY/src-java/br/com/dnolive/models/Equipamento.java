package br.com.dnolive.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.dnolive.core.ImplementsModel;

@Entity
public class Equipamento extends ImplementsModel<Integer>
{	private static final long serialVersionUID = 1L;	

	@ManyToOne
	@JoinColumn(name="id_locadora")
	private Locadora locadora;
	
	@Column(name="serie", length=30)
	private String serie;
	
	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="ativo", insertable=false,	updatable=true, 
		columnDefinition = "varchar(1) default 'S'"
	)
	private String ativo;
	
	//.................
	//getters & setters
	//.................
	
	public Locadora getLocadora() {
		return locadora;
	}

	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

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
