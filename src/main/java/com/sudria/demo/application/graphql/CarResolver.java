package com.sudria.demo.application.graphql;

import com.sudria.demo.domain.Car;
import com.sudria.demo.domain.CarService;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarResolver {
    private CarService carService;

    public CarResolver(CarService carService) {
        this.carService = carService;
    }

    public CarService getCarService() {
        return carService;
    }

    @GraphQLQuery

    public List<Car> getCars (){
        return carService.getCars();
    }
}
