package com.bofoy.queue;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bofoy.queue.domain.UserSignupDTO;

public class DataSourceTests {
	
	private static final Logger logger = LoggerFactory.getLogger(DataSourceTests.class);
	
	@Mock
	private UserSignupDTO testUser;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMockCreation() {
		assertNotNull(testUser);
	}
	
	@Test
	public void testDataSource() {
		
	}
	
}
