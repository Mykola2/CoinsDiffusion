package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 5/8/2017.
 */
@Data
public class World {
    List<Country> countries = new ArrayList<>();

    public void addCountry(Country country) {
        countries.add(country);
    }

    public void createRoutes() {
        List<City> allCities = countries.stream()
                .flatMap(country -> country.getCities().stream())
                .collect(Collectors.toList());


        //non-optimized n^2 traverse
        //todo: optimize
        for (City city : allCities) {
            for (City anotherCity: allCities) {
                if ((city.getX() - 1 == anotherCity.getX()) && (city.getY()  == anotherCity.getY())){
                    city.setWestN(anotherCity);
                }
                if ((city.getX() + 1 == anotherCity.getX()) && (city.getY()  == anotherCity.getY())){
                    city.setEastN(anotherCity);
                }
                if ((city.getX() == anotherCity.getX()) && (city.getY() + 1  == anotherCity.getY())){
                    city.setNorthN(anotherCity);
                }
                if ((city.getX()  == anotherCity.getX()) && (city.getY() - 1  == anotherCity.getY())){
                    city.setSouthN(anotherCity);
                }
            }
        }

    }
}
