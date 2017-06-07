package br.com.fiap.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQuery(name="Jogador.findAll", query="select j from Jogador j")
@Entity
@Table(name="jogadores")
public class Jogador {
	
	@Id
	@Column(name="IDJOGADOR")
	private int id;

	@Column(name="NOMEJOGADOR", length=50)
	private String nome;
			
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IDTIME")
	private Time time;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="jogador")
	private Set<Patrocinio> patrocinios = new LinkedHashSet<Patrocinio>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Set<Patrocinio> getPatrocinios() {
		return patrocinios;
	}
	public void setPatrocinios(Set<Patrocinio> patrocinios) {
		this.patrocinios = patrocinios;
	}
}
