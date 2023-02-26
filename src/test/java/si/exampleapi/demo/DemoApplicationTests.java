package si.exampleapi.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import si.exampleapi.api.MainController;

@SpringBootTest(classes = DemoApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Value(value="${local.server.port}")
	private int port;

	@Autowired
	private MainController mainController;
	
	@Test
	void contextLoads() {
		assertThat(mainController).isNotNull();
	}

	@Autowired
	private TestRestTemplate restTemplate;

	/*
	 @Test
	 public void greetingShouldReturnDefaultMessage() throws Exception {
		 assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
		 String.class)).contains("Hello, World");
		}
		*/
}

