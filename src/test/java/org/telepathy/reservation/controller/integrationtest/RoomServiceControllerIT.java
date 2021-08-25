package org.telepathy.reservation.controller.integrationtest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.telepathy.reservation.ServicesStarter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServicesStarter.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoomServiceControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void testApis() {
		HttpHeaders headers = new HttpHeaders();

		HttpEntity entity = new HttpEntity<>(null, headers);

		ResponseEntity<List> response = restTemplate.exchange(getRootUrl() + "/api/rooms", HttpMethod.GET, entity,
				List.class);
		assertNotNull(response.getBody());
		String[] ar = { "4A", "3A", "4B", "2A", "3B", "4C", "2B", "3C", "4D", "2C", "3D", "4E", "2D", "3E", "1D", "2E",
				"1E" };

		assertTrue(response.getBody().containsAll(Arrays.asList(ar)));

		ResponseEntity<String> response1 = restTemplate.exchange(getRootUrl() + "/api/in", HttpMethod.POST, entity,
				String.class);

		assertTrue(response1.getBody().equals("1A"));

		ResponseEntity<List> response2 = restTemplate.exchange(getRootUrl() + "/api/rooms", HttpMethod.GET, entity,
				List.class);

		assertFalse(response2.getBody().contains("1A"));
	}

}
