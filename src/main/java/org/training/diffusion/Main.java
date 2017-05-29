package org.training.diffusion;

import org.training.diffusion.model.Country;
import org.training.diffusion.model.World;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String FILENAME = "countries.txt";

    public static void main(String[] args) {
        int testCaseCount = 0;
        for (World world : createWorld(FILENAME)) {
            testCaseCount++;
            System.out.println("Case #" + testCaseCount);
            world.simulate();
        }
    }

    private static List<World> createWorld(String fileName) {
        List<World> testCases = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while (!"0".equals(line = br.readLine())) {
                int countryNum = Integer.parseInt(line);
                World world = new World();
                for (int i = 0; i < countryNum; i++) {
                    line = br.readLine();
                    String[] params = line.split(" ");
                    String name = params[0];
                    int lX = Integer.parseInt(params[1]);
                    int lY = Integer.parseInt(params[2]);
                    int hX = Integer.parseInt(params[3]);
                    int hY = Integer.parseInt(params[4]);
                    world.addCountry(new Country(name, lX, lY, hX, hY));
                }
                world.createRoutes();
                testCases.add(world);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return testCases;
    }
}
