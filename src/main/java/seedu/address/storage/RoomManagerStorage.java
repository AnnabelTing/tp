package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.RoomManagerState;

/**
 * Represents a storage for {@link RoomManagerState}.
 */
public interface RoomManagerStorage {
    Path getRoomManagerFilePath();

    Optional<RoomManagerState> readRoomManager() throws DataLoadingException;

    Optional<RoomManagerState> readRoomManager(Path filePath) throws DataLoadingException;

    void saveRoomManager(RoomManagerState roomManagerState) throws IOException;

    void saveRoomManager(RoomManagerState roomManagerState, Path filePath) throws IOException;

}
