package com.esme.Carsbook.Application.Rappels;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service

public class MarqueService {
    public static void printMarque(){
        log.info(
                Marque
                        .builder()
                        .ID(1)
                        .nom("Audi")
                        .prix(40000)
                        .taille(5.12f)
                        .modèle('A')
                        .toString()
        );

    }

}
