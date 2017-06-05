package com.bofoy.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bofoy.queue.dao.UserReviewDAO;

public class UserReviewControllerTests {

	private static final Logger logger = LoggerFactory.getLogger(UserReviewControllerTests.class);
	
	@Mock
	UserReviewDAO userReviewDAO;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(UserReviewControllerTests.class);
	}
	
	@Test
	public void testCreateReview() {
		assertNotNull(null);
	}

}
