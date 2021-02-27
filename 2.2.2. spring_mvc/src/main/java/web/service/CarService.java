package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    //void add(Car car);
    //User getUserForCarModelAndSeries(String model, int series);
    //List<User> listUsers();

    int getCarCount(List<Car> carList);

}
