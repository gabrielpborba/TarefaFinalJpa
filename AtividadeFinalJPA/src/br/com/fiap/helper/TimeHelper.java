package br.com.fiap.helper;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Time;

public class TimeHelper {

	 

	
	private EntityManager em;

	public TimeHelper(EntityManager em){
		this.em = em;
	}

	public void salvar(Time time) throws Exception{ 
		try {
			em.getTransaction().begin(); 
			em.merge(time); 
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback(); 
			throw e;
		} 
	}
	
	public void deletar(Time time) throws Exception{ 
		try {
			em.getTransaction().begin(); 
			Time c= em.merge(time);
			em.remove(c); 
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback(); 
			throw e;
		} 
	}
	
}
