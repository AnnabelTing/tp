package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.BookingsBook;
import seedu.address.model.ReadOnlyBookingsBook;
import seedu.address.model.RoomManager;
import seedu.address.model.RoomManagerState;
import seedu.address.model.booking.Booking;
import seedu.address.model.booking.BookingPeriod;
import seedu.address.model.booking.Remark;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Booking[] getSamplePersons() {
        RoomManager roomManager = new RoomManager();
        roomManager.setUp(new int[] {200, 100, 100, 50, 30, 20});
        return new Booking[] {
            new Booking(roomManager.getRoom(64), new BookingPeriod("2023-01-01 08:00 to 2023-01-02 12:00"),
                    new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                    new Remark("More Bedsheets")),
            new Booking(roomManager.getRoom(420), new BookingPeriod("2023-01-01 08:00 to 2023-01-02 12:00"),
                    new Name("Bernice Yu"), new Phone("99272758"),
                    new Email("berniceyu@example.com"),
                    new Remark("More Pillows")),
            new Booking(roomManager.getRoom(300),
                    new BookingPeriod("2023-01-01 08:00 to 2023-01-02 12:00"),
                    new Name("Charlotte Oliveiro"), new Phone("93210283"),
                    new Email("charlotte@example.com"),
                    new Remark("Do Not Disturb")),
            new Booking(roomManager.getRoom(111),
                    new BookingPeriod("2023-01-01 08:00 to 2023-01-02 12:00"),
                    new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                    new Remark("Extra Bed")),
            new Booking(roomManager.getRoom(500),
                    new BookingPeriod("2023-01-01 08:00 to 2023-01-02 12:00"),
                    new Name("Irfan Ibrahim"), new Phone("92492021"),
                    new Email("irfan@example.com"),
                    new Remark("More Bedsheets")),
            new Booking(roomManager.getRoom(1),
                    new BookingPeriod("2023-01-01 08:00 to 2023-01-02 12:00"),
                    new Name("Roy Balakrishnan"), new Phone("92624417"),
                    new Email("royb@example.com"),
                    new Remark("Overrun Room Service")),
        };
    }

    public static ReadOnlyBookingsBook getSampleAddressBook() {
        BookingsBook sampleAb = new BookingsBook();
        for (Booking sampleBooking : getSamplePersons()) {
            sampleAb.addBooking(sampleBooking);
        }
        return sampleAb;
    }

    public static RoomManagerState getSampleRoomManager() {
        int[] roomNumbers = {200, 200, 50, 30, 10, 10};
        RoomManager.setUp(roomNumbers);
        return RoomManager.getState();
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
