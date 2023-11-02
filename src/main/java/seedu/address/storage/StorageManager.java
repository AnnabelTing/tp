package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ReadOnlyBookingsBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.RoomManagerState;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of AddressBook data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private BookingBookStorage bookingBookStorage;
    private UserPrefsStorage userPrefsStorage;

    private RoomManagerStorage roomManagerStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code AddressBookStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(BookingBookStorage bookingBookStorage, UserPrefsStorage userPrefsStorage,
                          RoomManagerStorage roomManagerStorage) {
        this.bookingBookStorage = bookingBookStorage;
        this.userPrefsStorage = userPrefsStorage;
        this.roomManagerStorage = roomManagerStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataLoadingException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }

    // ================ RoomManager methods ==============================

    @Override
    public Path getRoomManagerFilePath() {
        return roomManagerStorage.getRoomManagerFilePath();
    }

    @Override
    public Optional<RoomManagerState> readRoomManager() throws DataLoadingException {
        return readRoomManager(roomManagerStorage.getRoomManagerFilePath());
    }

    @Override
    public Optional<RoomManagerState> readRoomManager(Path filePath) throws DataLoadingException {
        logger.fine("Attempting to read data from file: " + filePath);
        return roomManagerStorage.readRoomManager(filePath);
    }

    @Override
    public void saveRoomManager(RoomManagerState roomManagerState) throws IOException {
        saveRoomManager(roomManagerState, roomManagerStorage.getRoomManagerFilePath());
    }

    @Override
    public void saveRoomManager(RoomManagerState roomManagerState, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        roomManagerStorage.saveRoomManager(roomManagerState, filePath);
    }

    // ================ AddressBook methods ==============================

    @Override
    public Path getBookingBookFilePath() {
        return bookingBookStorage.getBookingBookFilePath();
    }

    @Override
    public Optional<ReadOnlyBookingsBook> readBookingBook() throws DataLoadingException {
        return readBookingBook(bookingBookStorage.getBookingBookFilePath());
    }

    @Override
    public Optional<ReadOnlyBookingsBook> readBookingBook(Path filePath) throws DataLoadingException {
        logger.fine("Attempting to read data from file: " + filePath);
        return bookingBookStorage.readBookingBook(filePath);
    }

    @Override
    public void saveBookingBook(ReadOnlyBookingsBook addressBook) throws IOException {
        saveBookingBook(addressBook, bookingBookStorage.getBookingBookFilePath());
    }

    @Override
    public void saveBookingBook(ReadOnlyBookingsBook addressBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        bookingBookStorage.saveBookingBook(addressBook, filePath);
    }

}
