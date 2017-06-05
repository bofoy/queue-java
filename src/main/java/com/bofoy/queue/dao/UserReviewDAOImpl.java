package com.bofoy.queue.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bofoy.queue.domain.Review;
import com.bofoy.queue.exception.StatusCode;

@Repository
public class UserReviewDAOImpl implements UserReviewDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private EntityManagerFactory emFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Review> getReviewsForUser(String userName) {
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Review> query = builder.createQuery(Review.class);
		Root<Review> root = query.from(Review.class);
		
		query.select(root).where(builder.equal(root.get("userName"), userName));
		
		try {
			List<Review> reviews = getCurrentSession().createQuery(query).getResultList();
			return reviews;
		}
		catch (NoResultException e) {
			logger.error(StatusCode.FAILED.toString() + ": " + e.getMessage());
			return null;
		}
	}

	@Override
	public StatusCode addReview(Review review) {
		EntityManager entityManager = emFactory.createEntityManager();
		
		logger.debug("Adding user review");
		
		try {
			entityManager.persist(review);
			return StatusCode.SUCCESS;
		}
		catch (Exception e) {
			logger.error(StatusCode.FAILED.toString() + ": " + e.getMessage());
			logger.debug("Failed to add review...");
			return StatusCode.FAILED;
		}
	}

}
