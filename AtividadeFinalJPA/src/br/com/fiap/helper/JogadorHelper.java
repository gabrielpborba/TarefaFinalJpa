package br.com.fiap.helper;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Jogador;

public class JogadorHelper {

	 

	
	private EntityManager em;

	public JogadorHelper(EntityManager em){
		this.em = em;
	}

	public void salvar(Jogador jogador) throws Exception{ 
		try {
			em.getTransaction().begin(); 
			em.merge(jogador); 
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback(); 
			throw e;
		} 
	}
	
	public void deletar(Jogador jogador) throws Exception{ 
		try {
			em.getTransaction().begin(); 
			Jogador c= em.merge(jogador);
			em.remove(c); 
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback(); 
			throw e;
		} 
	}
	
}
