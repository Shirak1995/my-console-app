import dao.CategoryDAO;
import dao.TaskDAO;
import dao.UserDAO;
import model.Category;
import service.CategoryService;
import service.TaskService;
import service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserDAO userDAO = new UserDAO();
        TaskDAO taskDAO = new TaskDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        UserService userService = new UserService(userDAO);
        TaskService taskService = new TaskService(taskDAO);
        CategoryService categoryService = new CategoryService(categoryDAO);

        while (true) {
            System.out.println("1. Добавить пользователя");
            System.out.println("2. Добавить задачу");
            System.out.println("3. Добавить категорию");
            System.out.println("4. Вывести всех пользователей");
            System.out.println("5. Вывести все задачи");
            System.out.println("6. Вывести все категории");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Чистим входной буфер

            switch (choice) {
                case 1:
                    System.out.print("Введите имя пользователя: ");
                    String userName = scanner.nextLine();
                    userService.registerUser(userName);
                    break;

                case 2:
                    System.out.print("Введите название задачи: ");
                    String taskTitle = scanner.nextLine();
                    System.out.print("Введите описание задачи: ");
                    String taskDescription = scanner.nextLine();
                    System.out.print("Введите ID категории: ");
                    int categoryId = scanner.nextInt();
                    Category category = categoryDAO.getAllCategories().stream()
                            .filter(cat -> cat.getId() == categoryId)
                            .findFirst()
                            .orElse(null);
                    if (category != null) {
                        taskService.createTask(taskTitle, taskDescription, category);
                    } else {
                        System.out.println("Категория не найдена.");
                    }
                    break;

                case 3:
                    System.out.print("Введите название категории: ");
                    String categoryName = scanner.nextLine();
                    categoryService.createCategory(categoryName);
                    break;

                case 4:
                    userService.getAllUsers().forEach(user ->
                            System.out.println("Пользователь: " + user.getName()));
                    break;

                case 5:
                    taskService.getAllTasks().forEach(task ->
                            System.out.println("Задача: " + task.getTitle() + " | Описание: " + task.getDescription()));
                    break;

                case 6:
                    categoryService.getAllCategories().forEach(cat ->
                            System.out.println("Категория: " + cat.getName() + " | ID категории: " + cat.getId()));
                    break;

                case 0:
                    System.out.println("Выход из программы.");
                    return;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                    break;
            }
        }
    }
}
