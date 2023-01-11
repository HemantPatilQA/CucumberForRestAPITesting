package com.qaautomater.springbootcucumber;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
		classes = TutorialServiceApplication.class,
		webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT
)
public abstract class TutorialServiceApplicationTests {
	@LocalServerPort
	protected int port;
	protected final String BASE_URL = "http://localhost" ;
}
