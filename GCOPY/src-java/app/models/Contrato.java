package app.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import core.ImplementsModel;

@Entity
public class Contrato extends ImplementsModel<Integer>
{	private static final long serialVersionUID = 1L;	

	@ManyToOne
	@JoinColumn(name="id_locadora")
	private Locadora locadora;
	
	@Column(name="data_ini")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Column(name="data_fim")
	@Temporal(TemporalType.DATE)
	private Date dataTermino;
	
	@Column(name="valor_copia")
	private Float valorCopia;
	
	@Column(name="ativo", insertable=false,	updatable=true, 
		columnDefinition = "varchar(1) default 'S'"
	)
	private String ativo;

	
	//.......................
	
	
	public Locadora getLocadora() {
		return locadora;
	}
	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}

	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Float getValorCopia() {
		return valorCopia;
	}
	public void setValorCopia(Float valorCopia) {
		this.valorCopia = valorCopia;
	}

	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo==null?"S":ativo;
	}

}
