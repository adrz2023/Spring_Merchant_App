package org.jsp.merchantwebapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.merchantwebapp.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MerchantDao {
	@Autowired
	private EntityManager entityManager;

	public Merchant saveMerchant(Merchant merchant) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityManager.persist(merchant);
		entityTransaction.begin();
		entityTransaction.commit();
		return merchant;
	}
	

	public Merchant findById(int id) {
		return entityManager.find(Merchant.class, id);
	}

	public Merchant updateMerchant(Merchant merchant) {
		Merchant dbMerchant = findById(merchant.getId());
		if (dbMerchant != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			dbMerchant.setEmail(merchant.getEmail());
			dbMerchant.setGst_number(merchant.getGst_number());
			dbMerchant.setName(merchant.getName());
			dbMerchant.setPhone(merchant.getPhone());
			dbMerchant.setPassword(merchant.getPassword());
			entityTransaction.begin();
			entityTransaction.commit();
			return dbMerchant;
		}
		return null;
	}
	
	public Merchant verify(int id, String password) {
		Query query = entityManager.createQuery("select m from Merchant m where m.id=?1 and m.password=?2");
		query.setParameter(1, id);
		query.setParameter(2, password);
		try {
			return (Merchant) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public Merchant verify(long phone, String password) {
		Query query = entityManager.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
		query.setParameter(1, phone);
		query.setParameter(2, password);
		try {
			return (Merchant) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Merchant verify(String email, String password) {
		Query query = entityManager.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			return (Merchant) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public boolean deleteById(int id) {
		Merchant dbMerchant = findById(id);
		if (dbMerchant != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityManager.remove(dbMerchant);
			entityTransaction.begin();
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	}
	
