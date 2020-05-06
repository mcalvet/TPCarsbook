package com.esme.Carsbook.Application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1")

public class CarsbookController {
    @RequestMapping(value="/marques", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getMarques(){
        List<String> strings = Arrays.asList("xxx","yyy","zzz");
        return new ResponseEntity<List<String>>(strings, HttpStatus.OK);
    }


    @RequestMapping(value = "/marques", method = RequestMethod.POST)
    public ResponseEntity<String> createMarques(
            @RequestBody String marqueName) {
        log.info("brand created :" + marqueName);
        return new ResponseEntity<>(marqueName, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/marques/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> replaceMarques(
            @PathVariable(value = "id") Long id,
            @RequestBody String marqueName) {
        log.info("brand with id :" + id + " is now :" + marqueName);
        return new ResponseEntity<>(marqueName, HttpStatus.OK);
    }

    @RequestMapping(value = "/marques/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMarques(@PathVariable(value = "id") Long id) {
        log.info("brand with id :" + id + " is deleted");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
