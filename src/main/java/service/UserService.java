package service;



import dao.UserDAO;
import model.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(String name) {
        int newId = userDAO.getAllUsers().size() + 1;
        User user = new User(newId, name);
        userDAO.addUser(user);
        System.out.println("Пользователь " + name + " зарегистрирован.");
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
