package model;

import lombok.Data;

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

    public City(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "City{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
