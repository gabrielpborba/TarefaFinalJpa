package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.core.Helper;
import br.com.fiap.entity.Jogador;
import br.com.fiap.entity.Patrocinio;
import br.com.fiap.entity.Time;

public class Main {

	private EntityManager em;
	public Main(EntityManager em){
		this.em = em;
	}

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AtividadeFinalJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

		Helper dao = new Helper(em);
		
		int option = 0;  

		do {  
			option = menu();  
			TimeHelper timeHelper = new TimeHelper(em);
			JogadorHelper jogadorHelper = new JogadorHelper(em);
			PatrocinioHelper patrocinioHelper = new PatrocinioHelper(em);
			switch (option) {  
			case 1:  
				List<Object> listTimes = dao.listarTodos("Time");
				for (Object time : listTimes) {
					System.out.println(((Time) time).getId() + " - " + ((Time) time).getNomeTime());
				}
				break;
			case 2:
				List<Object> listJogadores = dao.listarTodos("Jogador");
				for (Object Jogador : listJogadores) {
					System.out.println(((Jogador) Jogador).getId() + " - " + ((Jogador) Jogador).getNome() + " - " + ((Jogador) Jogador).getTime().getNomeTime());
				}
				break;
			case 3:
				List<Object> listPatrocinios = dao.listarTodos("Patrocinio");
				for (Object patrocinio : listPatrocinios) {
					System.out.println(((Patrocinio) patrocinio).getId() + " - " + ((Patrocinio) patrocinio).getNome() + " - " + ((Patrocinio) patrocinio).getJogador().getNome());
				}
				break;
			case 4:
				Time time = new Time();
				time.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do Time")));
				time.setNomeTime(JOptionPane.showInputDialog("Digite o nome do Time"));
				try {
					timeHelper.salvar(time);
				} catch (Exception e) {
					System.err.println("erro ao gravar o Time");
				}
				break;
			case 5:
				Time timeEx = new Time();
				timeEx.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do Time a ser excluído")));
				
				timeHelper = new TimeHelper(em);
				try {
					timeHelper.deletar(timeEx);
				} catch (Exception e) {
					System.err.println("erro ao deletar o Time");
				}
				break;
			case 6:
				Jogador jogador = new Jogador();
				Time timeJogador = new Time();
				jogador.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do Jogador")));
				jogador.setNome(JOptionPane.showInputDialog("Digite o nome do Jogador"));
				timeJogador.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do Time do Jogador")));
				jogador.setTime(timeJogador);
				try {
					jogadorHelper.salvar(jogador);
				} catch (Exception e) {
					System.err.println("erro ao gravar o Time");
				}
				break;
			case 7:
				Jogador jogadorEx = new Jogador();
				jogadorEx.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do Jogador a ser excluído")));
				
				jogadorHelper = new JogadorHelper(em);
				try {
					jogadorHelper.deletar(jogadorEx);
				} catch (Exception e) {
					System.err.println("erro ao deletar o Time");
				}
				break;
			case 8:
				Patrocinio patrocinio = new Patrocinio();
				Jogador jogadorPat = new Jogador();
				patrocinio.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do Patrocínio")));
				patrocinio.setNome(JOptionPane.showInputDialog("Digite o nome do Patropcínio"));
				jogadorPat.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do Jogador")));
				patrocinio.setJogador(jogadorPat);
				try {
					patrocinioHelper.salvar(patrocinio);
				} catch (Exception e) {
					System.err.println("erro ao gravar o Patropcínio");
				}
				break;
			case 9:
				Patrocinio patrocinioEx = new Patrocinio();
				patrocinioEx.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do Patrocínio a ser excluído")));
				
				jogadorHelper = new JogadorHelper(em);
				try {
					patrocinioHelper.deletar(patrocinioEx);
				} catch (Exception e) {
					System.err.println("erro ao deletar o Patrocínio");
				}
				break;
			}  
		} while (option != 0);  

	}  

	public static int menu()  
	{  
		return   Integer.parseInt(javax.swing.JOptionPane.showInputDialog("" +  
                "1 - Buscar Times.\n" +  
                "2 - Buscar Jogadores.\n" +  
                "3 - Buscar Patrocios.\n" +  
                "4 - Gravar Time.\n" +  
                "5 - Excluir Time.\n" +  
                "6 - Gravar Jogador.\n" +  
                "7 - Excluir Jogador.\n" +  
                "8 - Gravar Patrocínio.\n" +  
                "9 - Excluir Patrocínio.\n" +  
                "10 - Sair."));  

	}  
	
}
