package app.models;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import core.ImplementsModel;

@Entity
public class Locadora extends ImplementsModel<Long>
{	private static final long serialVersionUID = 1L;	

	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="ativo", insertable=false,	updatable=true, 
		columnDefinition = "varchar(1) default 'S'"
	)
	private String ativo;
	
	@OneToMany(mappedBy="locadora",
		targetEntity=Equipamento.class,
		cascade=CascadeType.ALL
	) 	
	private Collection<Equipamento> equipamento;
		
	@OneToMany(mappedBy="locadora",
		targetEntity=Contrato.class,
		cascade=CascadeType.ALL
	) 	
	private List<Contrato> contratos;
		
	//.................
	//getters & setters
	//.................
	
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

	public Collection<Equipamento> getEquipamento() {
		return this.equipamento;
	}
	public void setEquipamento(List<Equipamento> equipamento) {
		this.equipamento = equipamento;
	}

	public Collection<Contrato> getContratos() {
		return contratos;
	}
	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

}
