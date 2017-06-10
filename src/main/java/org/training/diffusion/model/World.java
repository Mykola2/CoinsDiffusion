package org.training.diffusion.model;

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
    List<City> allCities = new ArrayList<>();

    public void addCountry(Country country) {
        countries.add(country);
    }

    public void createRoutes() {
        allCities = countries.stream()
                .flatMap(country -> country.getCities().stream())
                .collect(Collectors.toList());

        for (City city : allCities) {
            for (City otherCity : allCities)
                city.createRouteWithOtherCity(otherCity);
        }

    }

    public void simulate() {
        while (true) {
            countries.forEach(c -> c.startSimulator(countries));
            if (checkIfSumulateComplete()) {
                break;
            }
        }
        countries.forEach(country -> System.out.println(country.getName() + ":" + country.getDays()));
        System.out.println();
    }

    private Boolean checkIfSumulateComplete() {
        return countries.stream().allMatch(Country::getIsComplete);
    }

}
