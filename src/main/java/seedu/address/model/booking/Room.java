package seedu.address.model.booking;

import static java.util.Objects.requireNonNull;

import seedu.address.model.RoomManager;
import seedu.address.model.tag.Tag;

/**
 * Represents a hotel room that a client is staying in.
 */
public class Room {
    public static final String MESSAGE_CONSTRAINTS = "Room is not between 1 and "
            + RoomManager.getRoomTotal() + " inclusive.";

    public final int roomNumber;

    public final RoomType roomType;

    public final Tag tag;

    /**
     * Constructs a Room object with the specified room number.
     *
     * @param roomNumber The room number.
     * @param roomType
     */
    public Room(int roomNumber, RoomType roomType) {
        requireNonNull(roomNumber);
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.tag = new Tag(this.roomType.name());
    }

    /**
     * Constructs a room with specified details for test cases.
     * @param roomDetails Details of room.
     */
    public Room(String roomDetails) {
        String[] roomDetail = roomDetails.split(", ");
        this.roomNumber = Integer.parseInt(roomDetail[0]);
        this.roomType = RoomType.valueOf(roomDetail[1]);
        this.tag = new Tag(this.roomType.name());
    }

    /**
     * Checks if the room number is valid, which means it should be between 1 and 500 inclusive.
     *
     * @param roomNumber The room number to validate.
     * @return True if the room number is within the valid range, false otherwise.
     */
    public static boolean isValidRoom(int roomNumber) {
        return roomNumber >= 1 && roomNumber <= RoomManager.getRoomTotal();
    }

    /**
     * Checks if this Room is equal to another object.
     *
     * @param other The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if the same object
                || (other instanceof Room // instanceof handles nulls
                && this.roomNumber == ((Room) other).roomNumber); // state check
    }
    /**
     * Method to get the room number
     * @return the room number
     */
    public int getRoomNumber() {
        return this.roomNumber;
    }

    public RoomType getRoomType() {
        return this.roomType;
    }

    public Tag getTag() {
        return this.tag;
    }

    /**
     * Returns a string representation of the room number.
     *
     * @return The room number as a string.
     */
    public String toString() {
        return String.valueOf(roomNumber);
    }
}
