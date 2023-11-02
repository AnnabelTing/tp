package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.booking.Room;
import seedu.address.model.booking.RoomType;
import seedu.address.model.tag.Tag;


/**
 * Jackson-friendly version of {@link Room}.
 */
public class JsonAdaptedRoom {
    private final int roomNumber;
    private final String roomType;
    private final String tag;

    /**
     * Converts a given {@code Room} into this class for Jackson use.
     */
    public JsonAdaptedRoom(Room source) {
        this.roomNumber = source.getRoomNumber();
        this.roomType = source.getRoomType().name();
        this.tag = source.getTag().toString();
    }

    /**
     * Constructs a {@code JsonAdaptedRoom} with the given room details.
     */
    @JsonCreator
    public JsonAdaptedRoom(@JsonProperty("roomNumber") int roomNumber,
                           @JsonProperty("roomType") String roomType,
                           @JsonProperty("tag") String tag) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.tag = tag;
    }

    /**
     * Converts this Jackson-friendly adapted room object into the model's {@code Room} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted room.
     */
    public Room toModelType() throws IllegalValueException {
        if (!Room.isValidRoom(roomNumber)) {
            throw new IllegalValueException(Room.MESSAGE_CONSTRAINTS);
        }
        if (!Tag.isValidTagName(tag)) {
            throw new IllegalValueException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Room(roomNumber, RoomType.valueOf(roomType));
    }
}
