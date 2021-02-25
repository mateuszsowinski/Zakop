package DAO;

import config.DbUtil;
import domain.User;

import java.sql.*;

public class UserDAO {

    private static final String ADD_USER = "INSERT INTO user (username, password, email, registration_date) VALUES (?,?,?,?)";
    private static final String ROLE_USER = "INSERT INTO user_role (username) VALUES (?)";

    public void addUserPermission(User user) {
        addUser(user);
        addRole(user);
    }

    private void addUser(User user) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setObject(4, user.getRegistrationDate());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void addRole(User user) {

        try(Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ROLE_USER)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
