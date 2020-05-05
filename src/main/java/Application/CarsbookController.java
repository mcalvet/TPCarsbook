package Application;

import org.hibernate.sql.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Patch;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class CarsbookController {
    @RequestMapping(value="/marques", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getMarques(){
        List<String> strings = Arrays.asList("xxx","yyy","zzz");
        return new ResponseEntity<List<String>>(strings, HttpStatus.OK);
    }

    Post http://localhost:8080/api/v1/marques.addmarque(Log ressource created)
    Delete http://localhost:8080/api/v1/marques.deletemarque(Log ressource deleted)
    Put http://localhost:8080/api/v1/marques.putmarque(Log ressource modified)
    Patch http://localhost:8080/api/v1/marques.patchmarque(Log ressource partially modified)
}
