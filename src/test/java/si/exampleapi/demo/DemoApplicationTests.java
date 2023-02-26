package si.exampleapi.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import si.exampleapi.api.MainController;
import si.exampleapi.object.MatchRet;

@SpringBootTest(classes = DemoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Value(value = "${local.server.port}")
	private int port;

	@Autowired
	private MainController mainController;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		// Checks if context loads
		assertThat(mainController).isNotNull();
	}

	@Test
	public void testAPIall() throws Exception {
		ResponseEntity<List<MatchRet>> rateResponse = restTemplate.exchange("http://localhost:" + port + "/all",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<MatchRet>>() {
				});
		List<MatchRet> list = rateResponse.getBody();
		assertThat(list.size() == 6).isTrue();
	}

	@Test
	public void testAPIcompleted() throws Exception {
		ResponseEntity<List<MatchRet>> rateResponse = restTemplate.exchange("http://localhost:" + port + "/completed",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<MatchRet>>() {
				});
		List<MatchRet> list = rateResponse.getBody();
		assertThat(list.size() == 4).isTrue();
	}

	@Test
	public void testAPIlive() throws Exception {
		ResponseEntity<List<MatchRet>> rateResponse = restTemplate.exchange("http://localhost:" + port + "/live",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<MatchRet>>() {
				});
		List<MatchRet> list = rateResponse.getBody();
		assertThat(list.size() == 1).isTrue();
	}

	@Test
	public void testAPIfilter() throws Exception {
		ResponseEntity<List<MatchRet>> rateResponse = restTemplate.exchange("http://localhost:" + port + "/filter?teamName=red",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<MatchRet>>() {
				});
		List<MatchRet> list = rateResponse.getBody();
		assertThat(list.size() == 2).isTrue();
	}
}
