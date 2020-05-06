package com.esme.Carsbook.Infrastructure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarqueRepository extends CrudRepository <MarqueEntity, Long>{
}
