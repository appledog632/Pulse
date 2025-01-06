package com.user.service;

import com.user.dao.UserDAO;
import com.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserService userService;
    private UserDAO userDAO; // Mocked dependency

    @BeforeEach
    void setUp() {
        // Mock the DAO
        userDAO = mock(UserDAO.class);
        userService = new UserService();
        userService.userDAO = userDAO; // Inject the mocked DAO
    }

    @Test
    void testAddUser_ValidUser() {
        // Arrange
        User user = new User(1, "John Doe", "john.doe@example.com", "USA", "password123");

        // Act
        userService.addUser(user);

        // Assert
        verify(userDAO, times(1)).insertUser(user);
    }

    @Test
    void testAddUser_InvalidUser() {
        // Arrange
        User invalidUser = new User(0, null, null, "USA", "password");

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userService.addUser(invalidUser));
        assertEquals("User details cannot be null", exception.getMessage());
    }

    @Test
    void testGetUserById_ValidId() {
        // Arrange
        User user = new User(1, "Jane Doe", "jane.doe@example.com", "Canada", "password456");
        when(userDAO.selectUser(1)).thenReturn(user);

        // Act
        User result = userService.getUserById(1);

        // Assert
        assertNotNull(result);
        assertEquals("Jane Doe", result.getName());
        verify(userDAO, times(1)).selectUser(1);
    }

    @Test
    void testGetUserById_InvalidId() {
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userService.getUserById(-1));
        assertEquals("ID must be greater than 0", exception.getMessage());
    }

    @Test
    void testGetAllUsers() {
        // Arrange
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Alice", "alice@example.com", "USA", "password"));
        users.add(new User(2, "Bob", "bob@example.com", "UK", "password"));
        when(userDAO.selectAllUsers()).thenReturn(users);

        // Act
        List<User> result = userService.getAllUsers();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(userDAO, times(1)).selectAllUsers();
    }

    @Test
    void testDeleteUserById_ValidId() {
        // Arrange
        when(userDAO.deleteUser(1)).thenReturn(true);

        // Act
        boolean isDeleted = userService.deleteUserById(1);

        // Assert
        assertTrue(isDeleted);
        verify(userDAO, times(1)).deleteUser(1);
    }

    @Test
    void testDeleteUserById_InvalidId() {
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userService.deleteUserById(-1));
        assertEquals("ID must be greater than 0", exception.getMessage());
    }
}
