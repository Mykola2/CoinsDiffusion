package org.training.diffusion.model;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 5/8/2017.
 */

@Data
public class City {
    private Integer x;
    private Integer y;
    private City westN;
    private City eastN;
    private City southN;
    private City northN;
    private Country country;
    private Boolean isComplete;
    Map<String, Integer> coins = new HashMap<>();

    public City(Integer x, Integer y, Country country) {
        this.x = x;
        this.y = y;
        this.country = country;
        coins.put(country.getName(), 1000000);
        isComplete = false;
    }

    @Override
    public String toString() {
        return "City{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void dailyTransfer(List<Country> countryList) {
        coins.keySet().forEach(this::distribute);
        if (coins.size() == countryList.size())
            isComplete = true;

    }

    private void distribute(String country) {
        int countryCoins = coins.get(country);
        int coinsToTransfer = countryCoins / 1000;
        if (westN != null) {
            westN.takeTransfer(country, coinsToTransfer);
            coins.put(country, coins.get(country) - coinsToTransfer);
        }
        if (eastN != null) {
            eastN.takeTransfer(country, coinsToTransfer);
            coins.put(country, coins.get(country) - coinsToTransfer);
        }
        if (northN != null) {
            northN.takeTransfer(country, coinsToTransfer);
            coins.put(country, coins.get(country) - coinsToTransfer);
        }
        if (southN != null) {
            southN.takeTransfer(country, coinsToTransfer);
            coins.put(country, coins.get(country) - coinsToTransfer);
        }
    }


    public void takeTransfer(String country, Integer amount) {
        if (amount != 0) {
            coins.put(country, coins.containsKey(country) ? (coins.get(country) + amount) : amount);
        }
    }

    public void createRouteWithOtherCity(City anotherCity) {
        if (checkWest(anotherCity)) {
            this.setWestN(anotherCity);
        }
        if (checkEast(anotherCity)) {
            this.setEastN(anotherCity);
        }
        if (checkNorth(anotherCity)) {
            this.setNorthN(anotherCity);
        }
        if (checkSouth(anotherCity)) {
            this.setSouthN(anotherCity);
        }
    }

    private boolean checkSouth(City anotherCity) {
        return (this.getX() == anotherCity.getX()) && (this.getY() - 1 == anotherCity.getY());
    }

    private boolean checkNorth(City anotherCity) {
        return (this.getX() == anotherCity.getX()) && (this.getY() + 1 == anotherCity.getY());
    }

    private boolean checkEast(City anotherCity) {
        return (this.getX() + 1 == anotherCity.getX()) && (this.getY() == anotherCity.getY());
    }

    private boolean checkWest(City anotherCity) {
        return (this.getX() - 1 == anotherCity.getX()) && (this.getY() == anotherCity.getY());
    }
}
