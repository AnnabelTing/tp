package seedu.address.model;

import static seedu.address.model.booking.RoomType.DELUXE;
import static seedu.address.model.booking.RoomType.NORMAL;
import static seedu.address.model.booking.RoomType.PRESIDENTIAL_SUITE;
import static seedu.address.model.booking.RoomType.STUDIO;
import static seedu.address.model.booking.RoomType.SUITES;
import static seedu.address.model.booking.RoomType.VIP;

import java.util.ArrayList;
import java.util.List;

import seedu.address.model.booking.Room;
import seedu.address.model.booking.RoomType;


/**
 * Manages the rooms of the hotel and what type they are.
 */
public class RoomManager {

    private static final List<Room> rooms = new ArrayList<>();

    public static void setUp(int[] roomNumbers) {
        int normalRoomNumber = roomNumbers[0];
        int studioRoomNumber = roomNumbers[1];
        int deluxeRoomNumber = roomNumbers[2];
        int suitesRoomNumber = roomNumbers[3];
        int presidentialSuiteRoomNumber = roomNumbers[4];
        int vipRoomNumber = roomNumbers[5];
        if (normalRoomNumber != 0) {
            assert rangeFinder(roomNumbers, NORMAL) != null;
            for (int i = rangeFinder(roomNumbers, NORMAL)[0]; i <= rangeFinder(roomNumbers, NORMAL)[1]; i++) {
                rooms.add(new Room(i, NORMAL));
            }
        }
        if (studioRoomNumber != 0) {
            assert rangeFinder(roomNumbers, STUDIO) != null;
            for (int i = rangeFinder(roomNumbers, STUDIO)[0]; i <= rangeFinder(roomNumbers, STUDIO)[1]; i++) {
                rooms.add(new Room(i, STUDIO));
            }
        }
        if (deluxeRoomNumber != 0) {
            assert rangeFinder(roomNumbers, DELUXE) != null;
            for (int i = rangeFinder(roomNumbers, DELUXE)[0]; i <= rangeFinder(roomNumbers, DELUXE)[1]; i++) {
                rooms.add(new Room(i, DELUXE));
            }
        }
        if (suitesRoomNumber != 0) {
            assert rangeFinder(roomNumbers, SUITES) != null;
            for (int i = rangeFinder(roomNumbers, SUITES)[0]; i <= rangeFinder(roomNumbers, SUITES)[1]; i++) {
                rooms.add(new Room(i, SUITES));
            }
        }
        if (presidentialSuiteRoomNumber != 0) {
            assert rangeFinder(roomNumbers, PRESIDENTIAL_SUITE) != null;
            for (int i = rangeFinder(roomNumbers, PRESIDENTIAL_SUITE)[0];
                 i <= rangeFinder(roomNumbers, PRESIDENTIAL_SUITE)[1]; i++) {
                rooms.add(new Room(i, PRESIDENTIAL_SUITE));
            }
        }
        if (vipRoomNumber != 0) {
            assert rangeFinder(roomNumbers, VIP) != null;
            for (int i = rangeFinder(roomNumbers, VIP)[0]; i <= rangeFinder(roomNumbers, VIP)[1]; i++) {
                rooms.add(new Room(i, VIP));
            }
        }

    }

    private static int[] rangeFinder(int[] roomNumbers, RoomType roomType) {
        int normalRoomNumber = roomNumbers[0];
        int studioRoomNumber = roomNumbers[1];
        int deluxeRoomNumber = roomNumbers[2];
        int suitesRoomNumber = roomNumbers[3];
        int presidentialSuiteRoomNumber = roomNumbers[4];
        int vipRoomNumber = roomNumbers[5];
        int[] range = new int[2];
        switch (roomType) {
        case NORMAL:
            range[0] = 1;
            range[1] = normalRoomNumber;
            break;
        case STUDIO:
            range[0] = normalRoomNumber + 1;
            range[1] = normalRoomNumber + studioRoomNumber;
            break;
        case DELUXE:
            range[0] = normalRoomNumber + studioRoomNumber + 1;
            range[1] = normalRoomNumber + studioRoomNumber + deluxeRoomNumber;
            break;
        case SUITES:
            range[0] = normalRoomNumber + studioRoomNumber + deluxeRoomNumber + 1;
            range[1] = normalRoomNumber + studioRoomNumber + deluxeRoomNumber + suitesRoomNumber;
            break;
        case PRESIDENTIAL_SUITE:
            range[0] = normalRoomNumber + studioRoomNumber + deluxeRoomNumber + suitesRoomNumber + 1;
            range[1] = normalRoomNumber + studioRoomNumber + deluxeRoomNumber + suitesRoomNumber
                    + presidentialSuiteRoomNumber;
            break;
        case VIP:
            range[0] = normalRoomNumber + studioRoomNumber + deluxeRoomNumber + suitesRoomNumber
                    + presidentialSuiteRoomNumber + 1;
            range[1] = normalRoomNumber + studioRoomNumber + deluxeRoomNumber + suitesRoomNumber
                    + presidentialSuiteRoomNumber + vipRoomNumber;
            break;
        default:
            return null;
        }

        if (range[0] > range[1]) {
            return null;
        }

        return range;
    }

    public static Room getRoom(int roomNumber) {
        return rooms.get(roomNumber - 1);
    }

    public static int getRoomTotal() {
        return rooms.size();
    }

    public static boolean hasSetUp() {
        return getRoomTotal() != 0;
    }

    public static void clearSetUp() {
        rooms.clear();
    }

    public static RoomManagerState getState() {
        return new RoomManagerState(rooms);
    }

    public static void setState(RoomManagerState roomManagerState) {
        rooms.clear();
        rooms.addAll(roomManagerState.getRooms());
    }

}
