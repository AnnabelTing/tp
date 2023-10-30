package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.UnflagCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new UnflagCommand object
 */
public class UnflagCommandParser implements Parser<UnflagCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the UnflagCommand
     * and returns a UnflagCommand object for execution.
     *
     * @throws ParseException if the user input does not conform to the expected format
     */
    public UnflagCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new UnflagCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, UnflagCommand.MESSAGE_USAGE), pe);
        }
    }
}
