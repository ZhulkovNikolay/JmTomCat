package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class CarServiceImp implements CarService {

    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public CarServiceImp() {
        cars = new ArrayList<>();
        cars.add(new Car(1, "T-90", 60));
        cars.add(new Car(2, "T-80", 60));
        cars.add(new Car(3, "T-72", 65));
        cars.add(new Car(4, "T-14", 51));
        cars.add(new Car(5, "T-95", 75));
        cars.add(new Car(6, "T-64", 37));
        cars.add(new Car(7, "T-60", 25));
        cars.add(new Car(8, "T-55", 27));
        cars.add(new Car(9, "T-50", 28));
        cars.add(new Car(10, "T-34", 36));
    }

    @Override
    public List<Car> getLimitCarList(int requestNuberOfCars) {
        return cars.stream().limit(requestNuberOfCars).collect(Collectors.toList());
    }
}
