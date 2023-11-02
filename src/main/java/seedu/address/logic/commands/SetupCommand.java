package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.Prefix;
import seedu.address.model.Model;

/**
 * Sets up the type and number of rooms available.
 */
public class SetupCommand extends Command {

    public static final String COMMAND_WORD = "setup";

    public static final Prefix PREFIX_TAG_NORMAL = new Prefix("NORMAL/");
    public static final Prefix PREFIX_TAG_STUDIO = new Prefix("STUDIO/");
    public static final Prefix PREFIX_TAG_DELUXE = new Prefix("DELUXE/");
    public static final Prefix PREFIX_TAG_SUITES = new Prefix("SUITES/");
    public static final Prefix PREFIX_TAG_PRESIDENTIAL_SUITE = new Prefix("PRESIDENTIAL_SUITE/");
    public static final Prefix PREFIX_TAG_VIP = new Prefix("VIP/");

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sets up the number of rooms required for each type of rooms\n"
            + "Parameters: "
            + PREFIX_TAG_NORMAL + "NORMAL "
            + PREFIX_TAG_STUDIO + "STUDIO "
            + PREFIX_TAG_DELUXE + "DELUXE "
            + PREFIX_TAG_SUITES + "SUITES "
            + PREFIX_TAG_PRESIDENTIAL_SUITE + "PRESIDENTIAL SUITE "
            + PREFIX_TAG_VIP + "VIP\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TAG_NORMAL + "50 "
            + PREFIX_TAG_STUDIO + "20 "
            + PREFIX_TAG_DELUXE + "20 "
            + PREFIX_TAG_SUITES + "10 "
            + PREFIX_TAG_PRESIDENTIAL_SUITE + "5 "
            + PREFIX_TAG_VIP + "3";

    public static final String MESSAGE_SUCCESS = "Set-up complete: %1$s";
    public static final String MESSAGE_DUPLICATE_SETUP = "Set-up has already concluded.";
    private int[] roomNumbers;

    public SetupCommand(int[] roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (model.hasSetUp()) {
            throw new CommandException(MESSAGE_DUPLICATE_SETUP);
        }
        model.setUp(roomNumbers);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(roomNumbers)));
    }
}
