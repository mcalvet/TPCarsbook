package com.sudria.demo.infrastructure;

import com.sudria.demo.domain.Car;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CarDao {

  private GarageRepository garageRepository;

  public CarDao(GarageRepository garageRepository) {
    this.garageRepository = garageRepository;
  }

  public List<Car> findCars() {
    return StreamSupport.stream(garageRepository.findAll().spliterator(), false)
        .map(carEntitie -> buildCar(carEntitie))
        .collect(Collectors.toList());
  }

  public Car findCars(Long id) throws NotFoundException {
    return buildCar(garageRepository.findById(id).orElseThrow(NotFoundException::new));
  }

  public Car createCars(Car car) {
    return buildCar(garageRepository.save(buildEntity(car)));
  }

  public void deleteCars(Long id) {
    garageRepository.delete(garageRepository.findById(id).get());
  }

  public void updateCar(Car car) {
    garageRepository.save(buildEntity(car));
  }

  public Car replaceCar(Car car) {
    return buildCar(garageRepository.save(buildEntity(car)));
  }

  private CarEntity buildEntity(Car car) {
    return CarEntity
        .builder()
        .id(car.getId())
        .marque(car.getMarque())
        .modele(car.getModele())
        .categorie(car.getCategorie())
        .superviseur(car.getSuperviseur())
        .build();
  }

  private Car buildCar(CarEntity carEntity) {
    return Car.builder()
        .id(carEntity.getId())
        .marque(carEntity.getMarque())
        .modele(carEntity.getModele())
        .categorie(carEntity.getCategorie())
        .superviseur(carEntity.getSuperviseur())
        .build();
  }


}
