package seedu.address.model;

import java.util.List;

import seedu.address.model.booking.Room;

/**
 * Captures the data in {@code RoomManager}.
 */
public class RoomManagerState {
    private final List<Room> rooms;

    public RoomManagerState(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
