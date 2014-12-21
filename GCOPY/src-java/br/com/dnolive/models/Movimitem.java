package br.com.dnolive.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.dnolive.core.AbstractModel;

@Entity
public class Movimitem extends AbstractModel
{	private static final long serialVersionUID = 1L;	

	@ManyToOne 
	@JoinColumn(name="id_movimento")
	private Movimento movimento;
	
	@ManyToOne 
	@JoinColumn(name="id_equipaloca")
	private Equipaloca equipamento;

	@ManyToOne 
	@JoinColumn(name="id_setor")
	private Setor setor;
	
	@Column(name="leitura_ant")
	private Integer leituraAnterior;;
	
	@Column(name="leitura_atu")
	private Integer leituraAtual;

	
	//..............
	
	
	public Movimento getMovimento() {
		return movimento;
	}
	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

	public Equipaloca getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipaloca equipamento) {
		this.equipamento = equipamento;
	}
	
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Integer getLeituraAnterior() {
		return leituraAnterior;
	}
	public void setLeituraAnterior(Integer leituraAnterior) {
		this.leituraAnterior = leituraAnterior;
	}

	public Integer getLeituraAtual() {
		return leituraAtual;
	}
	public void setLeituraAtual(Integer leituraAtual) {
		this.leituraAtual = leituraAtual;
	}

	
}
