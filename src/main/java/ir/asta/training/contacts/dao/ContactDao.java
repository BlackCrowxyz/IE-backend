package ir.asta.training.contacts.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ir.asta.training.contacts.entities.ContactEntity;

@Named("contactDao")
public class ContactDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(ContactEntity entity) {
		entityManager.persist(entity);
	}
	
	public ContactEntity load(Long id) {
		// TODO implement this method
		return new ContactEntity();
	}
	
	public List<ContactEntity> findAll() {
		Query query = entityManager.createQuery("SELECT e from ContactEntity e");
		List<ContactEntity> resultList = query.getResultList();
		return resultList;
	}
	
}
