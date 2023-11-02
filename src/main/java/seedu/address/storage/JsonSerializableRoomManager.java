package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.RoomManagerState;
import seedu.address.model.booking.Room;

/**
 * An Immutable RoomManagerState that is serializable to JSON format.
 */
@JsonRootName(value = "roomManager")
public class JsonSerializableRoomManager {
    private final List<JsonAdaptedRoom> rooms = new ArrayList<>();
    @JsonCreator
    public JsonSerializableRoomManager(@JsonProperty("rooms") List<JsonAdaptedRoom> rooms) {
        this.rooms.addAll(rooms);
    }

    /**
     * Constructs a {@code JsonSerializableRoomManager} with the given state.
     */
    public JsonSerializableRoomManager(RoomManagerState state) {
        state.getRooms().stream()
                .map(JsonAdaptedRoom::new)
                .forEach(rooms::add);
    }

    /**
     * Converts this address book into the model's {@code RoomManagerState} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public RoomManagerState toModelType() throws IllegalValueException {
        List<Room> roomList = new ArrayList<>();
        for (JsonAdaptedRoom jsonAdaptedRoom : rooms) {
            Room room = jsonAdaptedRoom.toModelType();
            roomList.add(room);
        }
        return new RoomManagerState(roomList);
    }
}
