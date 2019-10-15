package pl.szewczyk.thymeleafhelloworld;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    List<Car> cars;


    public CarController() {

        Car car1 = new Car("Opel", "Astra");
        Car car2 = new Car("BMW", "i8");
        Car car3 = new Car("fiat", "126p");
        Car car4 = new Car("Opel", "corsa");
        cars=new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

    }

    @GetMapping("/car")
    public String getCars(Model model){

        model.addAttribute("cars",cars);
        model.addAttribute("name","Ania");

        model.addAttribute("newCar",new Car()); //tworze pusty obiekt aby móc dodawać nowe

        return "car";
    }

    //@ModelAttribute  - thymeleaf, przekazywanie z widoku do klasy POJO

    @PostMapping("/add")
    public String addCar(@ModelAttribute  Car car){
        System.out.println(car);
        cars.add(car);
        return "redirect:/car"; //przenosi do metody a nie szablonu
    }

}
