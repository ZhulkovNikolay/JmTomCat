package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImp;



@Controller
public class CarsController {

    @Autowired
    private CarServiceImp carServiceImp;

    @GetMapping(value = "/cars")
    public String carList(@RequestParam(value = "count", required = false) Integer count,
                          Model model) {

        model.addAttribute("carCount", "Car count = " + count);

        if (count <= 5) {
            model.addAttribute("carsList", carServiceImp.getLimitCarList(count));
        } else {
            model.addAttribute("carsList", carServiceImp.getCars());
        }

        return "cars";

    }

}
