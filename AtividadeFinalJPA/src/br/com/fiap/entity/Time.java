package br.com.fiap.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQuery(name="Time.findAll", query="select t from Time t")
@Entity
@Table(name="times")
public class Time implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NOMETIME", length=50)
	private String nomeTime;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER,
			mappedBy="time")
	private Set<Jogador> jogadores = new LinkedHashSet<Jogador>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeTime() {
		return nomeTime;
	}
	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}
	public Set<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(Set<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
}
