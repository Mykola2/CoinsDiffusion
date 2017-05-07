package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 5/8/2017.
 */
@Data
public class Country {
    private String name;
    private List<City> cities;

   public Country(String name, int lX, int lY, int hX, int hY) {
        this.name = name;
        populate(lX, lY, hX, hY);
    }

    private void populate(int lX, int lY, int hX, int hY) {
       cities = new ArrayList<>();
        for (int i = lY; i <= hY; i++) {
            for (int j = lX; j <= hX; j++) {
                cities.add(new City(j, i));
            }
        }
    }

    @Override
    public String toString() {
        return "\nCountry{" +
                "name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }
}
