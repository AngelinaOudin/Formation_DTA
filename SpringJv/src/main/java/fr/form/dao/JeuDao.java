package fr.form.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.form.model.JeuVideo;

@Repository
@Transactional
public class JeuDao {

	@PersistenceContext
	private EntityManager manager;

	public JeuVideo get(long id) {
		System.out.println("toto");
		return manager.find(JeuVideo.class, id);
	}

	public List<JeuVideo> getAll() {
		List<JeuVideo> jv = (List<JeuVideo>)manager.createQuery("from JeuVideo", JeuVideo.class).getResultList();
		return jv;
	}

	public void insert(JeuVideo jeu) {
		manager.persist(jeu);
		System.out.println(manager.find(JeuVideo.class, jeu.getId()));
	}

	public JeuVideo update(JeuVideo jeu) {
		return manager.merge(jeu);
	}

	public void delete(long id) {
		manager.remove(get(id));
	}
}
