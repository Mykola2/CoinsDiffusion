import model.Country;
import model.World;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        World world = new World();
        world.addCountry(new Country("France", 1, 4, 4, 6));
        world.addCountry(new Country("Spain", 3, 1, 6, 3));
        world.addCountry(new Country("Portigal", 1, 1, 2, 2));
        world.createRoutes();
        System.out.println(world);

    }
}
