package com.incentives.piggyback.events;

import com.incentives.piggyback.events.serviceImpl.EventServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EventsApplicationTests {

	@InjectMocks
	private EventServiceImpl eventService;

	@Before
	public void setUp() {
		MockMvcBuilders.standaloneSetup(eventService).build();
	}

	@Test
	public void contextLoads() {
	}

}