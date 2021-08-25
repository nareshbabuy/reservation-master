package org.telepathy.reservation.model;

import org.telepathy.reservation.enums.RoomStatus;

/**
 * The type Room.
 */

public class Room {

	/**
	 * Instantiates a new Room.
	 *
	 * @param roomId     the room id
	 * @param roomNumber the room number
	 * @param roomStatus the room status
	 */
	public Room(Integer roomId, String roomNumber, RoomStatus roomStatus) {
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.roomStatus = roomStatus;
	}

	public Room() {

	}

	private Integer roomId;
	private String roomNumber;
	private RoomStatus roomStatus;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public RoomStatus getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
	}

}
