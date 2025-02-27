package dao;


import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getTask(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
}
