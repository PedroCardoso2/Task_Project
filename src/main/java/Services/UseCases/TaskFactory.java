package Services.UseCases;

import Entities.Task;

import java.util.List;

public interface TaskFactory {
    List<Task> getTask(int ident, String email);
    void addTask(Task task);
    void deleteTask(int id);
}
