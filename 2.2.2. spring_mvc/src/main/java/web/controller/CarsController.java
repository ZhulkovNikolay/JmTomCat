package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String carList(@RequestParam(value = "count", required = false) String count,
                          Model model) {
        model.addAttribute("carCount", "Car count = " + count);

        int number = Integer.parseInt(count);

        List<Car> cars = new ArrayList<>();
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

        Stream<Car> streamOfCars = cars.stream();
        List<Car> limitedCarList = streamOfCars.limit(number).collect(Collectors.toList());
        if (number <= 5) {
            model.addAttribute("carsList", limitedCarList);
        } else {
            model.addAttribute("carsList", cars);
        }
        return "cars";
    }


}
