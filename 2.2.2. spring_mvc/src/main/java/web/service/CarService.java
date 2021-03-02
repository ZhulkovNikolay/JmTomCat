package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {

    List<Car> initCars();
    int getCarCount(List<Car> carList);

}
