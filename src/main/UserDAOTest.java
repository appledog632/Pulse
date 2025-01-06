import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JdbcTest
class UserDAOTest {

    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        userDAO = new UserDAO();
    }

    @Test
    void testInsertUser() {
        // Arrange
        User user = new User(1, "John Doe", "john.doe@example.com", "USA", "password123");

        // Act
        userDAO.insertUser(user);

        // Assert
        User fetchedUser = userDAO.selectUser(1);
        assertNotNull(fetchedUser);
        assertEquals("John Doe", fetchedUser.getName());
    }

    @Test
    void testSelectUser_Found() {
        // Arrange
        User user = new User(2, "Jane Doe", "jane.doe@example.com", "Canada", "password456");
        userDAO.insertUser(user);

        // Act
        User result = userDAO.selectUser(2);

        // Assert
        assertNotNull(result);
        assertEquals("Jane Doe", result.getName());
        assertEquals("Canada", result.getCountry());
    }

    @Test
    void testSelectUser_NotFound() {
        // Act
        User result = userDAO.selectUser(99);

        // Assert
        assertNull(result);
    }

    @Test
    void testSelectAllUsers() {
        // Arrange
        User user1 = new User(1, "Alice", "alice@example.com", "USA", "password");
        User user2 = new User(2, "Bob", "bob@example.com", "UK", "password");
        userDAO.insertUser(user1);
        userDAO.insertUser(user2);

        // Act
        List<User> users = userDAO.selectAllUsers();

        // Assert
        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    void testDeleteUser() {
        // Arrange
        User user = new User(1, "Charlie", "charlie@example.com", "India", "password");
        userDAO.insertUser(user);

        // Act
        boolean isDeleted = userDAO.deleteUser(1);

        // Assert
        assertTrue(isDeleted);
        assertNull(userDAO.selectUser(1));
    }
}
