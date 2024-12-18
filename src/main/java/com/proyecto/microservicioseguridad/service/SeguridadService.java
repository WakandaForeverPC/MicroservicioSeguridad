package com.proyecto.microservicioseguridad.service;

import com.proyecto.microservicioseguridad.model.PoliceCar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SeguridadService {
    private List<PoliceCar> cars;
    private final int GRID_WIDTH = 9;
    private final int GRID_HEIGHT = 7;

    public SeguridadService() {
        cars = new ArrayList<>();
        cars.add(new PoliceCar("PC1", 1, -1, "SOUTH"));
        cars.add(new PoliceCar("PC2", 7, 7, "NORTH"));
    }

    public void moveCars() {
        Random rd = new Random();
        List<PoliceCar> newCars = new ArrayList<>();
        List<PoliceCar> carsToRemove = new ArrayList<>();

        for (PoliceCar car : cars) {
            switch (car.getDirection()) {
                case "EAST":
                    int nextXEast = car.getX() + 1;
                    if (isRoad(nextXEast, car.getY())) {
                        car.setX(nextXEast);
                    }
                    if (isIntersection(nextXEast, car.getY()) && rd.nextBoolean()) {
                        car.setDirection("NORTH");
                    }
                    if (car.getX() >= GRID_WIDTH) {
                        carsToRemove.add(car);
                        newCars.add(createNewCar("EAST", 0, car.getY()));
                    }
                    break;

                case "WEST":
                    int nextXWest = car.getX() - 1;
                    if (isRoad(nextXWest, car.getY())) {
                        car.setX(nextXWest);
                    }
                    if (isIntersection(nextXWest, car.getY()) && rd.nextBoolean()) {
                        car.setDirection("SOUTH");
                    }
                    if (car.getX() < 0) {
                        carsToRemove.add(car);
                        newCars.add(createNewCar("WEST", GRID_WIDTH - 1, car.getY()));
                    }
                    break;

                case "NORTH":
                    int nextYNorth = car.getY() - 1;
                    if (isRoad(car.getX(), nextYNorth)) {
                        car.setY(nextYNorth);
                    }
                    if (isIntersection(car.getX(), nextYNorth) && rd.nextBoolean()) {
                        car.setDirection("WEST");
                    }
                    if (car.getY() < 0) {
                        carsToRemove.add(car);
                        newCars.add(createNewCar("NORTH", car.getX(), GRID_HEIGHT - 1));
                    }
                    break;

                case "SOUTH":
                    int nextYSouth = car.getY() + 1;
                    if (isRoad(car.getX(), nextYSouth)) {
                        car.setY(nextYSouth);
                    }
                    if (isIntersection(car.getX(), nextYSouth) && rd.nextBoolean()) {
                        car.setDirection("EAST");
                    }
                    if (car.getY() >= GRID_HEIGHT) {
                        carsToRemove.add(car);
                        newCars.add(createNewCar("SOUTH", car.getX(), 0));
                    }
                    break;
            }
        }

        cars.removeAll(carsToRemove);
        cars.addAll(newCars);
    }

    private PoliceCar createNewCar(String direction, int x, int y) {
        return new PoliceCar("car" + (cars.size() + 1), x, y, direction);
    }

    private boolean isRoad(int x, int y) {
        return y == 3 || x % 2 == 1;
    }

    private boolean isIntersection(int x, int y) {
        return y == 3 && x % 2 == 1;
    }

    public List<PoliceCar> getCars() {
        return cars;
    }
}