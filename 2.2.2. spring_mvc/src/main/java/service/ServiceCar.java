package service;

import model.Car;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceCar {


    Car car1 = new Car("BMW", "3", 2000);
    Car car2 = new Car("Volvo", "S40", 2004);
    Car car3 = new Car("Nissan", "Juke", 2014);
    Car car4 = new Car("Renault", "Duster", 2018);
    Car car5 = new Car("Toyota", "Camry", 2019);


    public List<Car> getCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        return carList;
    }

    public List<Car> getCarOfNumber(int count) {
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        if (count < 1 || count >= 5) {
            return carList;
        } else
            return carList.stream().limit(count).collect(Collectors.toList());
    }


    public String getCarCountOfModelMap(Integer count, ModelMap modelMap) {
        if (count != null) {
            List<Car> cars = getCarOfNumber(count);
            modelMap.addAttribute("cars", cars);
            return "cars";
        } else modelMap.addAttribute("cars", getCarList());
        return "cars";


    }
}
