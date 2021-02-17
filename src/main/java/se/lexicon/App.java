package se.lexicon;


import se.lexicon.dao.CityDao;
import se.lexicon.dao.CityDaoIml;
import se.lexicon.model.City;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        CityDao dao = new CityDaoIml();

        //City city = dao.findById(11);
        //System.out.println("city = " + city);

        //List<City> foundByCode = dao.findByCode("SWE");
        //foundByCode.forEach(System.out::println);

        List<City> foundByName = dao.findByName("Los Angeles");
        foundByName.forEach(System.out::println);

        //List<City> findAll= dao.findAll();
        //findAll.forEach(System.out::println);

    }
}
