package model;

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

    public void dailyTrarnsfer(List<Country> countryList) {
        coins.keySet().forEach(this::distribute);
        if (coins.size() == countryList.size())
            isComplete = true;

    }

    private void distribute(String country) {
        int countryCoins = coins.get(country);
        int coinsToTranfer = countryCoins / 1000;
        if (westN != null) {
            westN.takeTransfer(country, coinsToTranfer);
            coins.put(country, coins.get(country) - coinsToTranfer);
        }
        if (eastN != null) {
            eastN.takeTransfer(country, coinsToTranfer);
            coins.put(country, coins.get(country) - coinsToTranfer);
        }
        if (northN != null) {
            northN.takeTransfer(country, coinsToTranfer);
            coins.put(country, coins.get(country) - coinsToTranfer);
        }
        if (southN != null) {
            southN.takeTransfer(country, coinsToTranfer);
            coins.put(country, coins.get(country) - coinsToTranfer);
        }
    }


    public void takeTransfer(String country, Integer amount) {
        if (amount != 0) {
            if (coins.containsKey(country)) {
                coins.put(country, coins.get(country) + amount);
            } else
                coins.put(country, amount);
        }
    }
}
