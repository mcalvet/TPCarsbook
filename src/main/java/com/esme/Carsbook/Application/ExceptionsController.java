package com.esme.Carsbook.Application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v2")

public class ExceptionsController {
    @RequestMapping(value="/marques", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getMarques() throws Exception {
        throw new Exception("Internal server error");
    }


    @RequestMapping(value = "/marques", method = RequestMethod.POST)
    public ResponseEntity<String> createMarques() throws Exception {
        throw new Exception("Internal server error");
    }

    @RequestMapping(value = "/marques/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> replaceMarques() throws Exception {
        throw new Exception("Internal server error");
    }

    @RequestMapping(value = "/marques/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMarques() throws Exception {
        throw new Exception("Internal server error");
    }

}
