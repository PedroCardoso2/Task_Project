package Services.UseCases;

import Entities.Task;

import java.util.List;

public interface TaskFactory {
    List<Task> getTask(String email);
    Task createTask(String email, String description);
}
