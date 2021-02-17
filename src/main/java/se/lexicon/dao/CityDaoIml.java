package se.lexicon.dao;

import se.lexicon.dao.db.MySqlConnection;
import se.lexicon.model.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDaoIml implements CityDao {

    /*Find city information by id from database 'world.city'
    * */
    @Override
    public City findById(int id) {
        String query = "select * from city where id = ?"; //mySQL query statement
        City city = new City();
        try (
                PreparedStatement preparedStatement =
                        MySqlConnection.getConnection().prepareStatement(query); //Use this statement when using parameters in query
        ) {
            preparedStatement.setInt(1, id);    //Set id in question mark in query, parameter 1
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                city.setId(resultSet.getInt(1));
                city.setName(resultSet.getString(2));
                city.setCountryCode(resultSet.getString(3));
                city.setDistrict(resultSet.getString(4));
                city.setPopulation(resultSet.getInt(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    /*Find list of cities information by country code
    * */
    @Override
    public List<City> findByCode(String code) {
        String query = "select * from city where CountryCode = ?";
        List<City> cityList = new ArrayList<>();
        try(
                PreparedStatement preparedStatement =
                        MySqlConnection.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setString(1,code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                cityList.add(new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @Override
    public List<City> findByName(String name) {
        return null;
    }

    /*Find all city information from database
    * */
    @Override
    public List<City> findAll() {
        String query = "select * from city";    //mySQL query statement
        List<City> cityList= new ArrayList<>();
        try {
            Statement statement = MySqlConnection.getConnection().createStatement(); //No parameters in query
            ResultSet resultSet= statement.executeQuery(query);
            while (resultSet.next()){
                cityList.add(new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @Override
    public City add(City city) {
        // todo: pass Statement.RETURN_GENERATED_KEYS to PreparedStatement when we want to execute query
        // Statement.RETURN_GENERATED_KEYS
        return null;
    }

    @Override
    public City update(City city) {
        return null;
    }

    @Override
    public int delete(City city) {
        return 0;
    }
}
