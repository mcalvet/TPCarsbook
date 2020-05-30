package com.sudria.demo.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.sudria.demo.domain.Car;

import java.util.List;

import com.sudria.demo.domain.CarService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@Api("API gestion de voiture")

public class Controller {

  private CarService carService;
  private ObjectMapper objectMapper;

  public Controller(CarService carService, ObjectMapper objectMapper) {
    this.carService = carService;
    this.objectMapper = objectMapper;
  }
  @ApiOperation(value = "View a list of available animals", response = List.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "The resource you were trying toreach is not found")
  })
  @ApiParam(value = "car object store in database table", required = true)

  @RequestMapping(value = "/cars", method = RequestMethod.GET)
  public ResponseEntity<List<Car>> getCars() {
    return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
  }

  @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
  public ResponseEntity<Car> getCarsById( @PathVariable(value = "id") Long id) {
    try {
      log.info("********************** inside the controller ****************************");
      return new ResponseEntity<>(carService.getCars(id), HttpStatus.OK);
    } catch (NotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car Not Found", e);
    }
  }

  @RequestMapping(value = "/cars", method = RequestMethod.POST)
  public ResponseEntity<Car> createCars(
      @RequestBody Car car) {
    carService.addCar(car);
    car = carService.addCar(car);
    return new ResponseEntity<>(car, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/cars/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Car> replaceCars(
      @PathVariable(value = "id") Long id,
      @RequestBody Car car) {
    car.setId(id);
    carService.replaceCar(car);
    return new ResponseEntity<>(car, HttpStatus.OK);
  }


  @RequestMapping(value = "/cars/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Car> deleteCars(@PathVariable(value = "id") Long id) {
    carService.deleteCars(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping(value = "/cars/{id}", method = RequestMethod.PATCH, consumes = "application/json-patch+json")
  public ResponseEntity<String> patchCars(
      @PathVariable(value = "id") Long id,
      @RequestBody JsonPatch patch)  {
    try {
      carService.patchCars(applyPatchToCustomer(patch, carService.findCar(id)));
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (NotFoundException e) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    } catch (JsonPatchException | JsonProcessingException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  private Car applyPatchToCustomer(JsonPatch patch, Car targetCar)
      throws JsonPatchException, JsonProcessingException {
    JsonNode patched = patch.apply(objectMapper.convertValue(targetCar, JsonNode.class));
    return objectMapper.treeToValue(patched, Car.class);
  }
}
