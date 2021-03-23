package DAO;

import config.DbUtil;
import domain.Discovery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiscoveryDAO {

    private static final String FIND_ALL_DISCOVERY = "SELECT * FROM discovery ORDER BY date DESC";
    private static final String FIND_ID_DISCOVERY = "SELECT * FROM discovery WHERE category_id = ? ORDER BY date DESC";
    private static final String ADD_DISCOVERY = "INSERT INTO discovery (title, url, description, date, category_id, user_id) VALUES (?,?,?,?,?,?)";

    public List<Discovery> findAll() {
        List<Discovery> discoveryAll = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_DISCOVERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Discovery discovery = new Discovery();
                discovery.setId(resultSet.getInt(1));
                discovery.setTitle(resultSet.getString(2));
                discovery.setUrl(resultSet.getString(3));
                discovery.setDescription(resultSet.getString(4));
                discovery.setDateTime(resultSet.getTimestamp(5).toLocalDateTime());
                discovery.setCategoryId(resultSet.getInt(6));
                discoveryAll.add(discovery);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return discoveryAll;
    }

    public List<Discovery> findId(int categoryId) {
        List<Discovery> discoveryList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID_DISCOVERY)) {
            preparedStatement.setInt(1, categoryId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Discovery discovery = new Discovery();
                    discovery.setId(resultSet.getInt(1));
                    discovery.setTitle(resultSet.getString(2));
                    discovery.setUrl(resultSet.getString(3));
                    discovery.setDescription(resultSet.getString(4));
                    discovery.setDateTime(resultSet.getTimestamp(5).toLocalDateTime());
                    discovery.setCategoryId(resultSet.getInt(6));
                    discoveryList.add(discovery);
                }
                return discoveryList;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Discovery create(Discovery discovery) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_DISCOVERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, discovery.getTitle());
            preparedStatement.setString(2, discovery.getUrl());
            preparedStatement.setString(3, discovery.getDescription());
            preparedStatement.setObject(4, discovery.getDateTime());
            preparedStatement.setInt(5, discovery.getCategoryId());
            preparedStatement.setInt(6, discovery.getUserId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                discovery.setId(1);
            }
            return discovery;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
