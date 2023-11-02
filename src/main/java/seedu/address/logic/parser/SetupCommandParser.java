package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.SetupCommand.PREFIX_TAG_DELUXE;
import static seedu.address.logic.commands.SetupCommand.PREFIX_TAG_NORMAL;
import static seedu.address.logic.commands.SetupCommand.PREFIX_TAG_PRESIDENTIAL_SUITE;
import static seedu.address.logic.commands.SetupCommand.PREFIX_TAG_STUDIO;
import static seedu.address.logic.commands.SetupCommand.PREFIX_TAG_SUITES;
import static seedu.address.logic.commands.SetupCommand.PREFIX_TAG_VIP;

import java.util.stream.Stream;

import seedu.address.logic.commands.SetupCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates an SetupCommand.
 */
public class SetupCommandParser implements Parser<SetupCommand> {

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

    @Override
    public SetupCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_TAG_NORMAL, PREFIX_TAG_STUDIO, PREFIX_TAG_DELUXE,
                        PREFIX_TAG_SUITES, PREFIX_TAG_PRESIDENTIAL_SUITE, PREFIX_TAG_VIP);

        if (!arePrefixesPresent(argMultimap, PREFIX_TAG_NORMAL, PREFIX_TAG_STUDIO, PREFIX_TAG_DELUXE,
                PREFIX_TAG_SUITES, PREFIX_TAG_PRESIDENTIAL_SUITE, PREFIX_TAG_VIP)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SetupCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_TAG_NORMAL, PREFIX_TAG_STUDIO, PREFIX_TAG_DELUXE,
                PREFIX_TAG_SUITES, PREFIX_TAG_PRESIDENTIAL_SUITE, PREFIX_TAG_VIP);

        int[] roomNumbers = ParserUtil.parseRoomRange(argMultimap.getValue(PREFIX_TAG_NORMAL).get(),
                argMultimap.getValue(PREFIX_TAG_STUDIO).get(), argMultimap.getValue(PREFIX_TAG_DELUXE).get(),
                argMultimap.getValue(PREFIX_TAG_SUITES).get(),
                argMultimap.getValue(PREFIX_TAG_PRESIDENTIAL_SUITE).get(), argMultimap.getValue(PREFIX_TAG_VIP).get());

        return new SetupCommand(roomNumbers);
    }
}
