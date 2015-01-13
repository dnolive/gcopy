package br.com.dnolive.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.dnolive.core.ImplementsModel;

@Entity
public class Operador extends ImplementsModel<Long>
{	private static final long serialVersionUID = 1L;	

	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="login", length=15)
	private String login;
	
	@Column(name="senha", length=15)
	private String senha;
	
	@Column(name="ativo", insertable=false,	updatable=true, 
		columnDefinition = "varchar(1) default 'S'"
	)
	private String ativo;
	
	//.................
	//getters & setters
	//.................
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo==null?"S":ativo;
	}
	
	@Override
	public String toString() {
		return "id:"+this.id+
				",nome:"+this.nome+
				",login:"+this.login+
				",senha:"+this.senha+
				",ativo:"+this.ativo;
	}
	
}
