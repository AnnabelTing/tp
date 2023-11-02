package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ReadOnlyBookingsBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.RoomManagerState;
import seedu.address.model.UserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends BookingBookStorage, UserPrefsStorage, RoomManagerStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataLoadingException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getRoomManagerFilePath();

    @Override
    Optional<RoomManagerState> readRoomManager() throws DataLoadingException;

    @Override
    void saveRoomManager(RoomManagerState roomManagerState) throws IOException;

    @Override
    Path getBookingBookFilePath();

    @Override
    Optional<ReadOnlyBookingsBook> readBookingBook() throws DataLoadingException;

    @Override
    void saveBookingBook(ReadOnlyBookingsBook addressBook) throws IOException;

}
