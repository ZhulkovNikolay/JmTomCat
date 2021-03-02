package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
public class CarsController {

    @Autowired
    private CarServiceImp carServiceImp;

    @GetMapping(value = "/cars")
    public String carList(@RequestParam(value = "count", required = false) Integer count,
                          Model model) {
        model.addAttribute("carCount", "Car count = " + count);

        carServiceImp.initCars();

        Stream<Car> streamOfCars = carServiceImp.getCars().stream();
        List<Car> limitedCarList = streamOfCars.limit(count).collect(Collectors.toList());
        if (count <= 5) {
            model.addAttribute("carsList", limitedCarList);
        } else {
            model.addAttribute("carsList", carServiceImp.getCars());
        }
        return "cars";
    }


}
