package com.sudria.demo.domain;

import com.sudria.demo.infrastructure.CarDao;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarService {

  private CarDao carDao;

  public CarService(CarDao carDao) {
    this.carDao = carDao;
  }

  public List<Car> getCars() {
    return carDao.findCars();
  }

  @Cacheable("cars")
  public Car getCars(Long id) throws NotFoundException {
    log.info("**************inside of the CarService getCars by id***************** ");
    return carDao.findCars(id);
  }

  public Car addCar(Car car) {
    return carDao.createCars(car);
  }

  public void deleteCars(Long id) {
    carDao.deleteCars(id);
  }

  public void patchCars(Car car) {
    carDao.updateCar(car);
  }

  public Car findCar(Long id) throws NotFoundException {
    return carDao.findCars(id);
  }

  public Car replaceCar(Car car) {
    return carDao.replaceCar(car);
  }
}
