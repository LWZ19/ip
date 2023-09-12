package duke.command;

import duke.util.Storage;
import duke.util.TaskList;
import duke.util.Ui;
import duke.exception.DukeException;

/**
 * Represents a command that lists all tasks in the task list.
 * A <code>ListCommand</code> object corresponds to an executable command
 * to list all tasks in the task list.
 */
public class ListCommand extends Command {

    /**
     * Constructs a <code>ListCommand</code> object.
     */
    public ListCommand() {
        super(false);
    }

    /**
     * Executes the command to list all tasks in the task list.
     *
     * @param taskList task list to be listed
     * @param ui       the user interface to print messages to the user
     * @param storage  the storage
     * @return
     * @throws DukeException if there is nothing in the list
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        return taskList.listTask(ui);
    }
}
