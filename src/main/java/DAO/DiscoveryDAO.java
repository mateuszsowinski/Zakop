package DAO;

import config.DbUtil;
import domain.Discovery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscoveryDAO {

    private static final String FIND_ALL_DISCOVERY = "SELECT * FROM discovery ORDER BY date DESC";
    private static final String FIND_ID_DISCOVERY = "SELECT * FROM discovery WHERE category_id = ? ORDER BY date DESC";

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
                    System.out.println(discoveryList);
                }
                return discoveryList;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
