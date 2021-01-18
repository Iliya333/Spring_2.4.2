package controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ServiceCar;

import java.util.List;

@Controller
public class CarController {

    public CarController() {
    }

    private ServiceCar serviceCar;

    @Autowired
    public CarController(ServiceCar serviceCar) {
        this.serviceCar = serviceCar;
    }

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam("count") Integer count, ModelMap modelMap) {
        return serviceCar.getCarCountOfModelMap(count, modelMap);
    }
}
