import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class TaskList {

    private List<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
        System.out.printf("%sGot it. I've added this task:%n" +
                        "%s  %s%n" +
                        "%sNow you have %d tasks in the list.%n",
                Duke.INDENT, Duke.INDENT, task, Duke.INDENT, taskList.size());
    }

    public void listTask() {
        if (taskList.isEmpty()) {
            System.out.printf("%sOOPS!!! There is nothing in the list, yet!%n", Duke.INDENT);
            return;
        } else {
            System.out.printf("%sHere are the tasks in your list:%n", Duke.INDENT);
        }
        IntStream.range(0, taskList.size())
                .forEach(i ->
                        System.out.printf("%s%d.%s%n", Duke.INDENT, i + 1, taskList.get(i)));
    }

    public void deleteTask(int index) throws DukeException {
        if (index >= taskList.size() || index < 0) {
            String str = String.format("%sOOPS!!! There is no task %d to delete",
                    Duke.INDENT, index + 1);
            listTask();
            throw new DukeException(str);
        }
        Task removedTask = taskList.remove(index);
        System.out.printf("%sNoted. I've removed this task:%n" +
                        "%s  %s%n" +
                        "%sNow you have %d tasks in the list.%n",
                Duke.INDENT, Duke.INDENT, removedTask, Duke.INDENT, taskList.size());
    }

    public void markTask(int index, boolean mark) throws DukeException {
        if (index >= taskList.size() || index < 0) {
            String str = String.format("%sOOPS!!! There is no task %d to %s",
                    Duke.INDENT, index + 1, mark ? "mark" : "unmark");
            listTask();
            throw new DukeException(str);
        }
        String task = taskList.get(index).mark(mark);
        String message = mark ? "Nice! I've marked this task as done:"
                              : "OK, I've marked this task as not done yet:";
        System.out.printf("%s%s%n%s  %s%n", Duke.INDENT, message, Duke.INDENT, task);
    }

    public void manipulateAllTask(Keyword key) throws DukeException {
        if (taskList.isEmpty()) {
            String str = String.format("%sOOPS!!! There are no tasks to %s.",
                    Duke.INDENT, key.getKeyword());
            throw new DukeException(str);
        }
        if (key.equals(Keyword.DELETE)) {
            taskList.clear();
        } else {
            taskList.forEach(t -> t.mark(key.equals(Keyword.MARK)));
        }
        System.out.printf("%sNoted. I will %s all tasks.%n", Duke.INDENT, key.getKeyword());
    }
}
