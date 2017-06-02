package com.bofoy.queue.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bofoy.queue.domain.UserDTO;
import com.bofoy.queue.domain.UserSignupDTO;
import com.bofoy.queue.exception.StatusCode;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private EntityManager entityManager;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<UserDTO> getAllUsers() {
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<UserDTO> query = builder.createQuery(UserDTO.class);
		Root<UserDTO> root = query.from(UserDTO.class);
		
		query.select(root);
		
		return getCurrentSession().createQuery(query).getResultList();
	}

	@Override
	public UserDTO getUser(String userName) throws NoResultException {
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<UserDTO> query = builder.createQuery(UserDTO.class);
		Root<UserDTO> root = query.from(UserDTO.class);
		
		query.select(root).where(builder.equal(root.get("userName"), userName));

		UserDTO user = getCurrentSession().createQuery(query).getSingleResult();
		
		if (user == null) {
			throw new NoResultException(StatusCode.USER_DOES_NOT_EXIST.toString());
		} 
		else {
			return user;
		}
	}

	@Override
	public StatusCode addUser(UserSignupDTO user) {
		logger.debug("Beginning database transaction...");
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			return StatusCode.SIGNUP_SUCCESSFUL;
		} 
		catch(IllegalStateException e) {
			logger.error(e.getMessage());
			return StatusCode.SIGNUP_FAILED;
		} 
		catch(EntityExistsException e) {
			logger.error(e.getMessage());
			return StatusCode.ALREADY_EXISTS;
		}
	}
	
}
