package br.com.dnolive.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.dnolive.core.AbstractModel;

@Entity
public class Equipaloca extends AbstractModel
{	private static final long serialVersionUID = 1L;	

	@ManyToOne
	@JoinColumn(name="id_equipamento")
	private Equipamento equipamento;
	
	@ManyToOne
	@JoinColumn(name="id_locadora")
	private Locadora locadora;
	
	@Column(name="serie", length=30)
	private String serie;
	
	@Column(name="ativo", length=1)
	private String ativo;
	
	
	//..................
	

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

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

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo==null?"S":ativo;
	}

}
