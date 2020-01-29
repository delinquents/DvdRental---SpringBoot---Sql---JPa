package com.example.demo.repositories;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDAOWithJPA<T, ID extends Serializable> {
	
	
	@Autowired
	protected EntityManager entityManager;
	
	private Class<T> persistentClass;
	
	
	
	public <T,ID> T findById(Class<T> type, ID id) {
		return entityManager.find(type, id);
	}
	


	@SuppressWarnings("unchecked")
	public GenericDAOWithJPA() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public T find(ID id) {
		return entityManager.find(persistentClass, id);
	}

	public void persist(T entity) {
		entityManager.persist(entity);
	}

	public void merge(T entity) {
		entityManager.merge(entity);
	}

	public void remove(T entity) {
		entityManager.remove(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery("Select t from " + persistentClass.getSimpleName() + " t").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findInRange(int firstResult, int maxResults) {
		return entityManager.createQuery("Select t from " + persistentClass.getSimpleName() + " t").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}

	public long count() {
		return (Long) entityManager.createQuery("Select count(t) from " + persistentClass.getSimpleName() + " t").getSingleResult();
	}
}
