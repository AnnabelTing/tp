package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.RoomManagerState;


/**
 * A class to access RoomManagerState data stored as a json file on the hard disk.
 */
public class JsonRoomManagerStorage implements RoomManagerStorage {
    private static final Logger logger = LogsCenter.getLogger(JsonRoomManagerStorage.class);

    private Path filePath;

    public JsonRoomManagerStorage(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public Path getRoomManagerFilePath() {
        return filePath;
    }

    @Override
    public Optional<RoomManagerState> readRoomManager() throws DataLoadingException {
        return readRoomManager(filePath);
    }

    @Override
    public Optional<RoomManagerState> readRoomManager(Path filePath) throws DataLoadingException {
        requireNonNull(filePath);

        Optional<JsonSerializableRoomManager> jsonRoomManager = JsonUtil.readJsonFile(
                filePath, JsonSerializableRoomManager.class);
        if (!jsonRoomManager.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonRoomManager.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataLoadingException(ive);
        }
    }

    @Override
    public void saveRoomManager(RoomManagerState roomManagerState) throws IOException {
        saveRoomManager(roomManagerState, filePath);
    }

    @Override
    public void saveRoomManager(RoomManagerState roomManagerState, Path filePath) throws IOException {
        requireNonNull(roomManagerState);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableRoomManager(roomManagerState), filePath);
    }
}
