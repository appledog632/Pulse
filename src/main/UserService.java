package com.user.service;

import com.user.dao.UserDAO;
import com.user.model.User;

import java.util.List;

public class UserService {

    private UserDAO userDAO;

    // Constructor to initialize UserDAO
    public UserService() {
        this.userDAO = new UserDAO();
    }

    /**
     * Add a new user to the database.
     * @param user The user to be added.
     */
    public void addUser(User user) {
        if (user != null && user.getName() != null && user.getEmail() != null) {
            userDAO.insertUser(user);
        } else {
            throw new IllegalArgumentException("User details cannot be null");
        }
    }

    /**
     * Retrieve a user by their ID.
     * @param id The user's ID.
     * @return The user with the given ID or null if not found.
     */
    public User getUserById(int id) {
        if (id > 0) {
            return userDAO.selectUser(id);
        } else {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
    }

    /**
     * Retrieve all users from the database.
     * @return A list of all users.
     */
    public List<User> getAllUsers() {
        return userDAO.selectAllUsers();
    }

    /**
     * Delete a user by their ID.
     * @param id The user's ID.
     * @return True if the user was deleted, false otherwise.
     */
    public boolean deleteUserById(int id) {
        if (id > 0) {
            return userDAO.deleteUser(id);
        } else {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
    }
}
