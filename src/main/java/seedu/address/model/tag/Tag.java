package seedu.address.model.tag;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import seedu.address.model.booking.RoomType;

/**
 * Represents a Tag in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTagName(String)}
 */
public class Tag {

    public static final String MESSAGE_CONSTRAINTS = "Tags names should be alphanumeric";
    public static final String VALIDATION_REGEX = "\\p{Alnum}+";

    public final String tagName;

    /**
     * Constructs a {@code Tag}.
     *
     * @param tagName A valid tag name.
     */
    public Tag(String tagName) {
        requireNonNull(tagName);
        checkArgument(isValidTagName(tagName), MESSAGE_CONSTRAINTS);
        this.tagName = tagName;
    }

    /**
     * Returns true if a given string is a valid tag name.
     *
     * @param test The string to test for validity as a tag name.
     * @return True if the string is a valid tag name, false otherwise.
     */
    public static boolean isValidTagName(String test) {
        if (test.matches(VALIDATION_REGEX)) {
            return true;
        }

        for (RoomType roomType : RoomType.values()) {
            if (test.equalsIgnoreCase(roomType.name())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Indicates whether some other object is "equal to" this tag.
     *
     * @param other The reference object with which to compare.
     * @return True if the other object is equal to this tag, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Tag)) {
            return false;
        }

        Tag otherTag = (Tag) other;
        return tagName.equals(otherTag.tagName);
    }

    /**
     * Returns a hash code value for this tag.
     *
     * @return A hash code value for this tag.
     */
    @Override
    public int hashCode() {
        return tagName.hashCode();
    }

    /**
     * Returns a string representation of this tag.
     *
     * @return A string representation of this tag, enclosed in square brackets.
     */
    public String toString() {
        return '[' + tagName + ']';
    }

}
