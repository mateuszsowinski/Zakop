package DAO;

import config.DbUtil;
import domain.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDAO {

    private static final String FIND_ALL_CATEGORY = "SELECT * FROM category";
    private static final String FIND_ID_CATEGORY = "SELECT * FROM category WHERE id = ?";

    public List<Category> findAll() {
        List<Category> categories = new ArrayList();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CATEGORY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));
                category.setDescription(resultSet.getString(3));
                categories.add(category);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categories;
    }

//    public Optional<Category> read(int categoryId) {
//        try (Connection connection = DbUtil.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID_CATEGORY)) {
//            preparedStatement.setInt(1, categoryId);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                Category category = new Category();
//                category.setId(resultSet.getInt("id"));
//                category.setName(resultSet.getString("name"));
//                category.setDescription(resultSet.getString("description"));
//                return Optional.of(category);
//            }
//        } catch (SQLException e) {
//            System.out.println("błąd");
//        }
//    return Optional.empty();
//    }


    public Category findID (int categoryId) {
        Category category = new Category();
        try (Connection connection = DbUtil.getConnection()){
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID_CATEGORY);
             preparedStatement.setInt(1,categoryId);
             ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setDescription(resultSet.getString("description"));
                System.out.println(category.toString());
                return category;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}




