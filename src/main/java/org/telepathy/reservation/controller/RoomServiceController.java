package org.telepathy.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.telepathy.reservation.exception.InvalidRoomNumberException;
import org.telepathy.reservation.exception.InvalidRoomServiceException;
import org.telepathy.reservation.service.DataService;

/**
 * The type Room service controller.
 */
@RestController
public class RoomServiceController {

	@Autowired
	private DataService dataService;

	/**
	 * Gets available rooms.
	 *
	 * @return the available rooms
	 */
	@GetMapping(value = "/api/rooms")
	public ResponseEntity<List<String>> getAvailableRooms() {
		return ResponseEntity.status(HttpStatus.OK).body(dataService.getAvailableRooms());
	}

	/**
	 * Check in response entity.
	 *
	 * @return the response entity
	 */
	@PostMapping(value = "/api/in")
	public ResponseEntity<String> checkIn() {
		return ResponseEntity.status(HttpStatus.OK).body(dataService.checkIn());
	}

	/**
	 * Check out response entity.
	 *
	 * @param roomNumber the room number
	 * @return the response entity
	 * @throws InvalidRoomNumberException  the invalid room number exception
	 * @throws InvalidRoomServiceException the invalid room service exception
	 */
	@PostMapping(value = "/api/out")
	public ResponseEntity<String> checkOut(@RequestParam(value = "roomNumber", required = true) String roomNumber) {
		return ResponseEntity.status(HttpStatus.OK).body(dataService.checkOut(roomNumber));
	}

	/**
	 * Clean response entity.
	 *
	 * @param roomNumber the room number
	 * @return the response entity
	 * @throws InvalidRoomNumberException  the invalid room number exception
	 * @throws InvalidRoomServiceException the invalid room service exception
	 */
	@PostMapping(value = "/api/clean")
	public ResponseEntity clean(@RequestParam(value = "roomNumber", required = true) String roomNumber) {
		dataService.clean(roomNumber);
		return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.toString());
	}

	/**
	 * Out of service response entity.
	 *
	 * @param roomNumber the room number
	 * @return the response entity
	 * @throws InvalidRoomNumberException  the invalid room number exception
	 * @throws InvalidRoomServiceException the invalid room service exception
	 */
	@PostMapping(value = "/api/outOfService")
	public ResponseEntity outOfService(@RequestParam(value = "roomNumber", required = true) String roomNumber) {
		dataService.outOfService(roomNumber);
		return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.toString());
	}

	/**
	 * Repair response entity.
	 *
	 * @param roomNumber the room number
	 * @return the response entity
	 * @throws InvalidRoomNumberException  the invalid room number exception
	 * @throws InvalidRoomServiceException the invalid room service exception
	 */
	@PostMapping(value = "/api/repair")
	public ResponseEntity repair(@RequestParam(value = "roomNumber", required = true) String roomNumber) {
		dataService.repair(roomNumber);
		return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.toString());
	}
}
