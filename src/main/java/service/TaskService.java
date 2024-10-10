package service;



import dao.TaskDAO;
import model.Category;
import model.Task;

import java.util.List;

public class TaskService {
    private TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public void createTask(String title, String description, Category category) {
        int newId = taskDAO.getAllTasks().size() + 1;
        Task task = new Task(newId, title, description, category);
        taskDAO.addTask(task);
        System.out.println("Задача \"" + title + "\" создана.");
    }

    public List<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }
}
