package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    @Override
    public int getCarCount(List<Car> carList) {
        return carList.size();
    }
}
