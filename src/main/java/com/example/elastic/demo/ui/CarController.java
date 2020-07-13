package com.example.elastic.demo.ui;

import com.example.elastic.demo.indices.Car;
import com.example.elastic.demo.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

    private CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/")
    public String indexPage (Model model){
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("carCount", carRepository.count());
        return "home";
    }

    @PostMapping("/search")
    public String findByMake (@RequestParam(value="make") String make, Model model){

        Page<Car> carSearchList = carRepository.findByMakeContaining(make, PageRequest.of(0, 100));

        model.addAttribute("cars", carSearchList.iterator());
        model.addAttribute("carCount", carSearchList.getTotalElements());
        return "home";
    }
}
