package com.esme.Carsbook.Application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v3")

public class ReturnCodeController {
    @RequestMapping(value="/marques", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getMarques(){
        List<String> strings = Arrays.asList("V3xxx","V3yyy","V3zzz");
        return new ResponseEntity<>(strings, HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/marques", method = RequestMethod.POST)
    public ResponseEntity<String> createMarques(
            @RequestBody String marque) {
        log.info("brand created :" + marque);
        return new ResponseEntity<>(marque, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/marques/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> replaceMarques(
            @PathVariable(value = "id") Long id,
            @RequestBody String marque) {
        log.info("brand with id :" + id + " is now :" + marque);
        return new ResponseEntity<>(marque, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/marques/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMarques(@PathVariable(value = "id") Long id) {
        log.info("brand with id :" + id + " is deleted");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
