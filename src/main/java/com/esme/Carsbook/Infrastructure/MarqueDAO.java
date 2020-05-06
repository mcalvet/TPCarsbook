package com.esme.Carsbook.Infrastructure;

import org.springframework.stereotype.Service;



@Service

public class MarqueDAO {

    private MarqueRepository marqueRepository;

    public MarqueDAO(MarqueRepository marqueReository){
        this.marqueRepository = marqueRepository;
    }

    public List<Marque> getMarques(){

    }

}
