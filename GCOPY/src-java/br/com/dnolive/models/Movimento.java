package br.com.dnolive.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.dnolive.core.AbstractModel;

@Entity
public class Movimento extends AbstractModel
{	private static final long serialVersionUID = 1L;	

	@ManyToOne
	@JoinColumn(name="id_locadora")
	private Locadora locadora;
	
	@ManyToOne
	@JoinColumn(name="id_contrato")
	private Contrato contrato;

	@ManyToOne
	@JoinColumn(name="id_operador")
	private Operador operador;
	
	@Column(name="data")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Column(name="referencia")
	@Temporal(TemporalType.DATE)
	private Date referencia;
	
	@Column(name="leiturista")
	private String leiturista;
	
	@Column(name="valor_copia")
	private Float valorCopia;
	
	@Column(name="quant_copia")
	private Integer quantCopia;
	
	@Column(name="valor_total")
	private Float valorTotal;
	
	@Column(name="status", insertable=false, updatable=true, 
		columnDefinition = "varchar(1) default 'S'"
	)
	private String status;

	@OneToMany(mappedBy="movimento",
		targetEntity=Movimitem.class,
		cascade=CascadeType.ALL
	) 	
	private Collection<Movimitem> itensMovimento;
	

	//................
	
	
	public Locadora getLocadora() {
		return locadora;
	}
	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}

	public Contrato getContrato() {
		return contrato;
	}
	public void setIdContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Operador getOperador() {
		return operador;
	}
	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public Date getReferencia() {
		return referencia;
	}
	public void setReferencia(Date referencia) {
		this.referencia = referencia;
	}

	public String getLeiturista() {
		return leiturista;
	}
	public void setLeiturista(String leiturista) {
		this.leiturista = leiturista;
	}

	public Float getValorCopia() {
		return valorCopia;
	}
	public void setValorCopia(Float valorCopia) {
		this.valorCopia = valorCopia;
	}

	public Integer getQuantCopia() {
		return quantCopia;
	}
	public void setQuantCopia(Integer quantCopia) {
		this.quantCopia = quantCopia;
	}

	public Float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status==null?"A":status;
	}

	public Collection<Movimitem> getItensMovimento() {
		return itensMovimento;
	}

}
