package com.bofoy.queue.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bofoy.queue.domain.User;
import com.bofoy.queue.exception.StatusCode;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private EntityManagerFactory emFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<User> getAllUsers() {
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		
		query.select(root);
		
		return getCurrentSession().createQuery(query).getResultList();
	}

	@Override
	public User getUser(String userName) {
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		
		query.select(root).where(builder.equal(root.get("userName"), userName));

		try {
			User user = getCurrentSession().createQuery(query).getSingleResult();
			return user;
		}
		catch(NoResultException e) {
			logger.error(StatusCode.USER_DOES_NOT_EXIST.toString() + ": " + e.getMessage());
			return null;
		}
	}

	@Override
	public StatusCode addUser(User user) {
		EntityManager entityManager = emFactory.createEntityManager();
		
		logger.debug("Beginning database transaction...");
		
		try {
			entityManager.getTransaction().begin();
			
			String salt = BCrypt.gensalt();
			String hashedPassword = BCrypt.hashpw(user.getPassword(), salt);
			
			user.setPassword(hashedPassword);
			user.setPasswordSalt(salt);
			
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			
			logger.info("Successfully created user:{}", user.getUserName());
			logger.debug("Ending database transaction...");
			return StatusCode.SIGNUP_SUCCESSFUL;
		}
		catch (IllegalStateException e) {
			logger.error(StatusCode.SIGNUP_FAILED.toString() + ": " + e.getMessage());
			logger.debug("Rolling back transaction...");
			entityManager.getTransaction().rollback();
			return StatusCode.SIGNUP_FAILED;
		} 
		catch (EntityExistsException e) {
			logger.error(StatusCode.USER_ALREADY_EXISTS.toString() + ": " + e.getMessage());
			logger.debug("Rolling back transaction...");
			entityManager.getTransaction().rollback();
			return StatusCode.USER_ALREADY_EXISTS;
		}
		catch (Exception e) {
			logger.error(StatusCode.USER_ALREADY_EXISTS.toString() + ": " + e.getMessage());
			logger.debug("Rolling back transaction...");
			entityManager.getTransaction().rollback();
			return StatusCode.USER_ALREADY_EXISTS;
		}
	}

	@Override
	public StatusCode deleteUser(String username) {
		EntityManager entityManager = emFactory.createEntityManager();
		
		logger.debug("Beginning database transaction...");
		
		try {
			entityManager.remove(username);
			
			logger.info("Successfully created user:{}", username);
			return StatusCode.USER_DELETE_SUCCESS;
		}
		catch (IllegalStateException e) {
			logger.error(StatusCode.USER_DELETE_FAILED.toString() + ": " + e.getMessage());
			logger.debug("Failed to delete user:{}", username);
			entityManager.getTransaction().rollback();
			return StatusCode.USER_DELETE_FAILED;
		} 
		catch (EntityExistsException e) {
			logger.error(StatusCode.USER_ALREADY_EXISTS.toString() + ": " + e.getMessage());
			logger.debug("Failed to delete user:{}", username);
			entityManager.getTransaction().rollback();
			return StatusCode.USER_ALREADY_EXISTS;
		}
		catch (Exception e) {
			logger.error(StatusCode.USER_DELETE_FAILED.toString() + ": " + e.getMessage());
			logger.debug("Failed to delete user:{}", username);
			entityManager.getTransaction().rollback();
			return StatusCode.USER_DELETE_FAILED;
		}
	}
	
}
