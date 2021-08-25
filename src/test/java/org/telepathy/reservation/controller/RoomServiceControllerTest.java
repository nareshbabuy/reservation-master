package org.telepathy.reservation.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telepathy.reservation.BaseTest;
import org.telepathy.reservation.config.AppConfigTest;
import org.telepathy.reservation.exception.InvalidRoomNumberException;
import org.telepathy.reservation.exception.InvalidRoomServiceException;

import lombok.SneakyThrows;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigTest.class)
@TestPropertySource("classpath:application.properties")
public class RoomServiceControllerTest extends BaseTest {

	@Autowired
	private RoomServiceController roomServiceController;

	@SneakyThrows
	@Test
	public void TestRunThrough() throws InvalidRoomNumberException, InvalidRoomServiceException {
		ResponseEntity availableRooms = roomServiceController.getAvailableRooms();
		Object body = availableRooms.getBody();
		Object room1 = roomServiceController.checkIn().getBody();
		Object room2 = roomServiceController.checkIn().getBody();
		Object room3 = roomServiceController.checkIn().getBody();
		Object room4 = roomServiceController.checkIn().getBody();
		Object room5 = roomServiceController.checkIn().getBody();
		Object room6 = roomServiceController.checkIn().getBody();
		Object room7 = roomServiceController.checkIn().getBody();
		roomServiceController.checkOut(room3.toString());
		roomServiceController.clean(room3.toString());
		Object newRoom3 = roomServiceController.checkIn().getBody();
		assertTrue(room3.toString().equalsIgnoreCase(newRoom3.toString()));
		roomServiceController.checkOut(room5.toString());
		roomServiceController.outOfService(room5.toString());
		roomServiceController.repair(room5.toString());
		roomServiceController.clean(room5.toString());
		Object newRoom5 = roomServiceController.checkIn().getBody();
		assertTrue(room5.toString().equalsIgnoreCase(newRoom5.toString()));

	}

}