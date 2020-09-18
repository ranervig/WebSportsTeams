package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.SportsTeam;

public class SportsTeamHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SportsTeams");

	public void insertTeam(SportsTeam st) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(st);
		em.getTransaction().commit();
		em.close();
	}

	public List<SportsTeam> showAllTeams() {
		EntityManager em = emfactory.createEntityManager();
		List<SportsTeam> allTeams = em.createQuery("SELECT a FROM SportsTeam a").getResultList();
		return allTeams;
	}

	public void deleteTeam(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		SportsTeam toDelete = em.find(SportsTeam.class, id);
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
	}

	public void updateTeam(SportsTeam toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public SportsTeam searchforTeamById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		SportsTeam found = em.find(SportsTeam.class, id);
		em.close();
		return found;
	}

	public List<SportsTeam> searchforTeamByName(String teamName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SportsTeam> typedQuery = em.createQuery("select st from SportsTeam st where st.teamName =:selectedName",
				SportsTeam.class);
		typedQuery.setParameter("selectedName", teamName);
		List<SportsTeam> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}

	public List<SportsTeam> searchforTeamByCity(String city) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SportsTeam> typedQuery = em.createQuery("select st from SportsTeam st where st.city =:selectedCity",
				SportsTeam.class);
		typedQuery.setParameter("selectedCity", city);
		List<SportsTeam> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}

	public List<SportsTeam> searchforTeamByPlayerNumber(int playerNumber) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SportsTeam> typedQuery = em.createQuery("select st from SportsTeam st where st.playerCount =:selectedPlayers",
				SportsTeam.class);
		typedQuery.setParameter("selectedPlayers", playerNumber);
		List<SportsTeam> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}

	public void cleanUp() {
		emfactory.close();
	}

}
