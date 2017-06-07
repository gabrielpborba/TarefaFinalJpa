package br.com.fiap.core;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.entity.Jogador;
import br.com.fiap.entity.Time;

public class Helper {
	private EntityManager em;
	public Helper(EntityManager em){
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<Object> listarTodos(String objeto){
		Query query = em.createNamedQuery(objeto+".findAll");
		return query.getResultList();
	}
}
