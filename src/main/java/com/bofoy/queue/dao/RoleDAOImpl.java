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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bofoy.queue.domain.Role;
import com.bofoy.queue.exception.StatusCode;

@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private EntityManagerFactory emFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Role> findAllRoles() {
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Role> query = builder.createQuery(Role.class);
		Root<Role> root = query.from(Role.class);
		
		query.select(root);
		
		return getCurrentSession().createQuery(query).getResultList();
	}

	@Override
	public Role findRole(String roleName) {
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Role> query = builder.createQuery(Role.class);
		Root<Role> root = query.from(Role.class);
		
		query.select(root).where(builder.equal(root.get("userName"), roleName));

		try {
			Role role = getCurrentSession().createQuery(query).getSingleResult();
			logger.info("Found user:{}", role.toString());
			return role;
		}
		catch(NoResultException e) {
			logger.error(StatusCode.USER_DOES_NOT_EXIST.toString() + ": " + e.getMessage());
			return null;
		}
	}

	@Override
	public StatusCode addRole(Role role) {
		EntityManager entityManager = emFactory.createEntityManager();
		
		logger.debug("Creating role:{}", role.getRoleName());
		
		try {
			entityManager.persist(role);
			
			logger.info("Successfully created role:{}", role.getRoleName());
			return StatusCode.SUCCESS;
		}
		catch (IllegalStateException e) {
			logger.error(StatusCode.FAILED.toString() + ": " + e.getMessage());
			return StatusCode.FAILED;
		} 
		catch (EntityExistsException e) {
			logger.error(StatusCode.ROLE_ALREADY_EXISTS.toString() + ": " + e.getMessage());
			return StatusCode.ROLE_ALREADY_EXISTS;
		}
		catch (Exception e) {
			logger.error(StatusCode.ROLE_ALREADY_EXISTS.toString() + ": " + e.getMessage());
			return StatusCode.ROLE_ALREADY_EXISTS;
		}
	}

}
