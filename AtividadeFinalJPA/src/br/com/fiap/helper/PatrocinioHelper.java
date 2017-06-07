package br.com.fiap.helper;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Jogador;
import br.com.fiap.entity.Patrocinio;

public class PatrocinioHelper {
	
	private EntityManager em;

	public PatrocinioHelper(EntityManager em){
		this.em = em;
	}

	public void salvar(Patrocinio patrocinio) throws Exception{ 
		try {
			em.getTransaction().begin(); 
			em.merge(patrocinio); 
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback(); 
			throw e;
		} 
	}
	
	public void deletar(Patrocinio patrocinio) throws Exception{ 
		try {
			em.getTransaction().begin(); 
			Patrocinio c= em.merge(patrocinio);
			em.remove(c); 
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback(); 
			throw e;
		} 
	}
	
}
