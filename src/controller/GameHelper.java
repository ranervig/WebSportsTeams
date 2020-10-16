package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Game;

public class GameHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SportsTeams");
	
	public void insertNewGame(Game g) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteGame(int idToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Game toDelete = em.find(Game.class, idToDelete);
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Game> getGames(){
		EntityManager em = emfactory.createEntityManager();
		List<Game> allGames = em.createQuery("SELECT g FROM Game g").getResultList();
		return allGames;
	}
}
