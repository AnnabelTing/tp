package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.RoomManager;
import seedu.address.model.booking.BookingPeriod;
import seedu.address.model.booking.Remark;
import seedu.address.model.booking.Room;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";
    public static final String MESSAGE_INVALID_ROOM = "Room is not between 1 and " + RoomManager.getRoomTotal()
            + " inclusive.";
    public static final String MESSAGE_INVALID_TOTAL_ROOM_RANGE = "Total number of rooms is not between "
            + "1 and 500 inclusive.";
    public static final String MESSAGE_INVALID_ROOM_RANGE = "Number of rooms is not between 1 and 500 inclusive.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses room range for each room type into an array of integer containing all room type.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given room range is invalid.
     */
    public static int[] parseRoomRange(String normalRoomRange, String studioRoomRange, String deluxeRoomRange,
                                     String suitesRoomRange, String presidentialSuitesRoomRange, String vipRoomRange)
            throws ParseException {
        int normalRoomNumber = Integer.parseInt(normalRoomRange.trim());
        int studioRoomNumber = Integer.parseInt(studioRoomRange.trim());
        int deluxeRoomNumber = Integer.parseInt(deluxeRoomRange.trim());
        int suitesRoomNumber = Integer.parseInt(suitesRoomRange.trim());
        int presidentialSuitesRoomNumber = Integer.parseInt(presidentialSuitesRoomRange.trim());
        int vipRoomNumber = Integer.parseInt(vipRoomRange.trim());
        int[] roomRange = {normalRoomNumber, studioRoomNumber, deluxeRoomNumber, suitesRoomNumber,
            presidentialSuitesRoomNumber, vipRoomNumber};
        int sum = 0;
        for (int roomNumber : roomRange) {
            if (roomNumber < 0 || roomNumber > 500) {
                throw new ParseException(MESSAGE_INVALID_ROOM_RANGE);
            }
            sum = sum + roomNumber;
        }
        if (sum > 500 || sum == 0) {
            throw new ParseException(MESSAGE_INVALID_TOTAL_ROOM_RANGE);
        }
        return roomRange;
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Room parseRoom(String room) throws ParseException {
        requireNonNull(room);
        String trimmedRoom = room.trim();
        int roomNumber = Integer.parseInt(trimmedRoom);
        if (Room.isValidRoom(roomNumber)) {
            throw new ParseException(MESSAGE_INVALID_ROOM);
        }
        return RoomManager.getRoom(roomNumber);
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static BookingPeriod parseBookingPeriod(String bookingPeriod) throws ParseException {
        requireNonNull(bookingPeriod);
        String trimmedBookingPeriod = bookingPeriod.trim();
        if (!BookingPeriod.isValidBookingPeriod(trimmedBookingPeriod)) {
            throw new ParseException(BookingPeriod.MESSAGE_CONSTRAINTS);
        }
        return new BookingPeriod(trimmedBookingPeriod);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String remark} into a {@code Remark}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code remark} is invalid.
     */
    public static Remark parseRemark(String remark) throws ParseException {
        requireNonNull(remark);
        String trimmedRemark = remark.trim();
        if (!Remark.isValidRemark(trimmedRemark)) {
            throw new ParseException(Remark.MESSAGE_CONSTRAINTS);
        }
        return new Remark(trimmedRemark);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }
}
