package DAO;

import config.DbUtil;
import domain.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class UserDAO {

    private static final String ADD_USER = "INSERT INTO user (username, password, email, registration_date) VALUES (?,?,?,?)";
    private static final String ROLE_USER = "INSERT INTO user_role (username) VALUES (?)";
    private static final String SELECT_USERNAME = "SELECT * FROM user WHERE username = ?";

    public void addUserPermission(User user) {
        create(user);
        addRole(user);
    }

    private void create(User user) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, hashPassword(user.getPassword()));
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setObject(4, user.getRegistrationDate());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addRole(User user) {

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ROLE_USER)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public User findIdByName(String user) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERNAME)) {
            preparedStatement.setString(1, user);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User userId = new User();
                userId.setId(resultSet.getInt(1));
                return userId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User login(String userName, String password) {
        User user = new User();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERNAME)) {
            preparedStatement.setString(1, userName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user.setId(resultSet.getInt(1));
                    user.setUsername(resultSet.getString(2));
                    user.setPassword(resultSet.getString(3));
                    user.setEmail(resultSet.getString(4));
                }
                if (BCrypt.checkpw(password, user.getPassword())) {
                    return user;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
